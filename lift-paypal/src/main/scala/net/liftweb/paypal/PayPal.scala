package net.liftweb.paypal

import net.liftweb.util.Helpers
import Helpers._
import net.liftweb.util._
import org.apache.commons.httpclient._
import org.apache.commons.httpclient.methods._
import java.io.{InputStream,BufferedReader,InputStreamReader}

/**
 * sealed abstract type PaypalMode so we can cast to the super
 * class in our method declerations. Cannot be subclasses outside
 * of this source file.
 */
sealed abstract class PaypalMode
case object PaypalSandbox extends PaypalMode {
  override def toString = "www.sandbox.paypal.com"
}
case object PaypalLive extends PaypalMode {
  override def toString = "www.paypal.com"
}

/**
 * Represents the type of connection that can be made
 * to paypal, irrespecitve of the mode of connection
 */
sealed abstract class PaypalConnection {
  def port = 80
}
case object PaypalHTTP extends PaypalConnection {
  override def toString = "http"
  override def port: Int = 80
}
case object PaypalSSL extends PaypalConnection {
  override def toString = "https"
  override def port: Int = 443
}


object HttpClientFactory {
  def apply(url: String, port: Int, connection: String): HttpClient = {
    var c: HttpClient = new HttpClient()
    c.getHostConfiguration().setHost(url, port, connection)
    return c
  }
}
object PostMethodFactory {
  def apply(url: String, paramaters: Array[NameValuePair]): PostMethod = {
    var p: PostMethod = new PostMethod(url)
    p.setRequestBody(paramaters)
    return p
  }
}

sealed abstract class PaypalHttpOperation {
  def wasSuccessful(code: Int): Boolean = code match {
    case 200 => true
    case _ => false
  }
}
case class PaypalRequest(client: HttpClient, post: PostMethod) extends PaypalHttpOperation {
  def withClient(in: HttpClient) = PaypalRequest(in, post)
  def withPost(in: PostMethod) = PaypalRequest(client, in)
  def execute: PostMethod = {
    /*BufferedReader in = new BufferedReader(
    new InputStreamReader(uc.getInputStream()));
    String res = in.readLine();
    in.close();*/
    val result: Int = tryo(client.executeMethod(post)).openOr(500)
    post
  }
}
sealed abstract class PaypalResponse extends PaypalHttpOperation {
  //protected def openResponseStream(post: PostMethod): Can[String] = {
    /*in = new BufferedReader(
        new InputStreamReader(uc.getInputStream()));
        String res = in.readLine();
        in.close();
        
        
        tryo(post.getResponseBodyAsStream())*/
  //}
}
case class PaypalDataTransferReponse() extends PaypalResponse {
  // handle the response here, in a pdt specific way.
  // were looking for "SUCSESS"
}

/**
 * Common functionality for paypal PDT and IPN
 */
abstract class Paypal(val mode: PaypalMode, val connection: PaypalConnection){
  val client: HttpClient = HttpClientFactory(mode.toString, connection.port, connection.toString)
}


/**
 * If you need to get data from paypal PDT, simply instansiate this class 
 * (through one of the factory objects)
 */
case class PaypalDataTransfer(authToken: String, transactionToken: String, override val mode: PaypalMode, override val connection: PaypalConnection) extends Paypal(mode: PaypalMode, connection: PaypalConnection) {
  /**
   * payloadArray is the array of the post body we'll be sending.
   * As the payload body is different in PDT vs IPN
   */
  val payloadArray: Array[NameValuePair] = Array(
    new NameValuePair("cmd", "_notify-synch"),
    new NameValuePair("tx", transactionToken),
    new NameValuePair("at", authToken)
  )
  /**
  * @param in set the endpoint for the connection. Must be a subclass of PaypalMode.
  */
  def withMode(in: PaypalMode): PaypalDataTransfer = PaypalDataTransfer(authToken, transactionToken, in, connection)
  /**
   * @param in set weather or not the connection should be made over SSL/443/https or not.
   */
  def withConnection(in: PaypalConnection): PaypalDataTransfer = PaypalDataTransfer(authToken, transactionToken, mode, in)
  
  def execute: PaypalRequest = PaypalRequest(client,PostMethodFactory("/cgi-bin/webscr",payloadArray))
}
object PaypalDataTransfer {
  def apply(authToken: String, transactionToken: String): PaypalDataTransfer = PaypalDataTransfer(authToken, transactionToken, PaypalSandbox, PaypalHTTP)
}



