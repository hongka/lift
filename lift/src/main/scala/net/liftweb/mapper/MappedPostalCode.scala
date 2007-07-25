package net.liftweb.mapper

import scala.xml.{NodeSeq}
import net.liftweb.http.S
import net.liftweb.http.S._
import net.liftweb.util._

object Countries extends Enumeration {
  val C1 = Value(1, "United States")
  val USA = C1
  val C2 = Value(2, "Afghanistan")
  val C3 = Value(3, "Albania")
  val C4 = Value(4, "Algeria")
  val C5 = Value(5, "Andorra")
  val C6 = Value(6, "Angola")
  val C7 = Value(7, "Antigua and Barbuda")
  val C8 = Value(8, "Argentina")
  val C9 = Value(9, "Armenia")
  val C10 = Value(10, "Australia")
  val C11 = Value(11, "Austria")
  val C12 = Value(12, "Azerbaijan")
  val C13 = Value(13, "Bahamas, The")
  val C14 = Value(14, "Bahrain")
  val C15 = Value(15, "Bangladesh")
  val C16 = Value(16, "Barbados")
  val C17 = Value(17, "Belarus")
  val C18 = Value(18, "Belgium")
  val C19 = Value(19, "Belize")
  val C20 = Value(20, "Benin")
  val C21 = Value(21, "Bhutan")
  val C22 = Value(22, "Bolivia")
  val C23 = Value(23, "Bosnia and Herzegovina")
  val C24 = Value(24, "Botswana")
  val C25 = Value(25, "Brazil")
  val C26 = Value(26, "Brunei")
  val C27 = Value(27, "Bulgaria")
  val C28 = Value(28, "Burkina Faso")
  val C29 = Value(29, "Burundi")
  val C30 = Value(30, "Cambodia")
  val C31 = Value(31, "Cameroon")
  val C32 = Value(32, "Canada")
  val C33 = Value(33, "Cape Verde")
  val C34 = Value(34, "Central African Republic")
  val C35 = Value(35, "Chad")
  val C36 = Value(36, "Chile")
  val C37 = Value(37, "China, People's Republic of")
  val C38 = Value(38, "Colombia")
  val C39 = Value(39, "Comoros")
  val C40 = Value(40, "Congo, Democratic Republic of the (Congo Kinshasa)")
  val C41 = Value(41, "Congo, Republic of the (Congo Brazzaville)")
  val C42 = Value(42, "Costa Rica")
  val C43 = Value(43, "Cote d'Ivoire (Ivory Coast)")
  val C44 = Value(44, "Croatia")
  val C45 = Value(45, "Cuba")
  val C46 = Value(46, "Cyprus")
  val C47 = Value(47, "Czech Republic")
  val C48 = Value(48, "Denmark")
  val C49 = Value(49, "Djibouti")
  val C50 = Value(50, "Dominica")
  val C51 = Value(51, "Dominican Republic")
  val C52 = Value(52, "Ecuador")
  val C53 = Value(53, "Egypt")
  val C54 = Value(54, "El Salvador")
  val C55 = Value(55, "Equatorial Guinea")
  val C56 = Value(56, "Eritrea")
  val C57 = Value(57, "Estonia")
  val C58 = Value(58, "Ethiopia")
  val C59 = Value(59, "Fiji")
  val C60 = Value(60, "Finland")
  val C61 = Value(61, "France")
  val C62 = Value(62, "Gabon")
  val C63 = Value(63, "Gambia, The")
  val C64 = Value(64, "Georgia")
  val C65 = Value(65, "Germany")
  val C66 = Value(66, "Ghana")
  val C67 = Value(67, "Greece")
  val C68 = Value(68, "Grenada")
  val C69 = Value(69, "Guatemala")
  val C70 = Value(70, "Guinea")
  val C71 = Value(71, "Guinea-Bissau")
  val C72 = Value(72, "Guyana")
  val C73 = Value(73, "Haiti")
  val C74 = Value(74, "Honduras")
  val C75 = Value(75, "Hungary")
  val C76 = Value(76, "Iceland")
  val C77 = Value(77, "India")
  val C78 = Value(78, "Indonesia")
  val C79 = Value(79, "Iran")
  val C80 = Value(80, "Iraq")
  val C81 = Value(81, "Ireland")
  val C82 = Value(82, "Israel")
  val C83 = Value(83, "Italy")
  val C84 = Value(84, "Jamaica")
  val C85 = Value(85, "Japan")
  val C86 = Value(86, "Jordan")
  val C87 = Value(87, "Kazakhstan")
  val C88 = Value(88, "Kenya")
  val C89 = Value(89, "Kiribati")
  val C90 = Value(90, "Korea, Democratic People's Republic of (North Korea)")
  val C91 = Value(91, "Korea, Republic of  (South Korea)")
  val C92 = Value(92, "Kuwait")
  val C93 = Value(93, "Kyrgyzstan")
  val C94 = Value(94, "Laos")
  val C95 = Value(95, "Latvia")
  val C96 = Value(96, "Lebanon")
  val C97 = Value(97, "Lesotho")
  val C98 = Value(98, "Liberia")
  val C99 = Value(99, "Libya")
  val C100 = Value(100, "Liechtenstein")
  val C101 = Value(101, "Lithuania")
  val C102 = Value(102, "Luxembourg")
  val C103 = Value(103, "Macedonia")
  val C104 = Value(104, "Madagascar")
  val C105 = Value(105, "Malawi")
  val C106 = Value(106, "Malaysia")
  val C107 = Value(107, "Maldives")
  val C108 = Value(108, "Mali")
  val C109 = Value(109, "Malta")
  val C110 = Value(110, "Marshall Islands")
  val C111 = Value(111, "Mauritania")
  val C112 = Value(112, "Mauritius")
  val C113 = Value(113, "Mexico")
  val C114 = Value(114, "Micronesia")
  val C115 = Value(115, "Moldova")
  val C116 = Value(116, "Monaco")
  val C117 = Value(117, "Mongolia")
  val C118 = Value(118, "Montenegro")
  val C119 = Value(119, "Morocco")
  val C120 = Value(120, "Mozambique")
  val C121 = Value(121, "Myanmar (Burma)")
  val C122 = Value(122, "Namibia")
  val C123 = Value(123, "Nauru")
  val C124 = Value(124, "Nepal")
  val C125 = Value(125, "Netherlands")
  val C126 = Value(126, "New Zealand")
  val C127 = Value(127, "Nicaragua")
  val C128 = Value(128, "Niger")
  val C129 = Value(129, "Nigeria")
  val C130 = Value(130, "Norway")
  val C131 = Value(131, "Oman")
  val C132 = Value(132, "Pakistan")
  val C133 = Value(133, "Palau")
  val C134 = Value(134, "Panama")
  val C135 = Value(135, "Papua New Guinea")
  val C136 = Value(136, "Paraguay")
  val C137 = Value(137, "Peru")
  val C138 = Value(138, "Philippines")
  val C139 = Value(139, "Poland")
  val C140 = Value(140, "Portugal")
  val C141 = Value(141, "Qatar")
  val C142 = Value(142, "Romania")
  val C143 = Value(143, "Russia")
  val C144 = Value(144, "Rwanda")
  val C145 = Value(145, "Saint Kitts and Nevis")
  val C146 = Value(146, "Saint Lucia")
  val C147 = Value(147, "Saint Vincent and the Grenadines")
  val C148 = Value(148, "Samoa")
  val C149 = Value(149, "San Marino")
  val C150 = Value(150, "Sao Tome and Principe")
  val C151 = Value(151, "Saudi Arabia")
  val C152 = Value(152, "Senegal")
  val C153 = Value(153, "Serbia")
  val C154 = Value(154, "Seychelles")
  val C155 = Value(155, "Sierra Leone")
  val C156 = Value(156, "Singapore")
  val C157 = Value(157, "Slovakia")
  val C158 = Value(158, "Slovenia")
  val C159 = Value(159, "Solomon Islands")
  val C160 = Value(160, "Somalia")
  val C161 = Value(161, "South Africa")
  val C162 = Value(162, "Spain")
  val C163 = Value(163, "Sri Lanka")
  val C164 = Value(164, "Sudan")
  val C165 = Value(165, "Suriname")
  val C166 = Value(166, "Swaziland")
  val C167 = Value(167, "Sweden")
  val C168 = Value(168, "Switzerland")
  val C169 = Value(169, "Syria")
  val C170 = Value(170, "Tajikistan")
  val C171 = Value(171, "Tanzania")
  val C172 = Value(172, "Thailand")
  val C173 = Value(173, "Timor-Leste (East Timor)")
  val C174 = Value(174, "Togo")
  val C175 = Value(175, "Tonga")
  val C176 = Value(176, "Trinidad and Tobago")
  val C177 = Value(177, "Tunisia")
  val C178 = Value(178, "Turkey")
  val C179 = Value(179, "Turkmenistan")
  val C180 = Value(180, "Tuvalu")
  val C181 = Value(181, "Uganda")
  val C182 = Value(182, "Ukraine")
  val C183 = Value(183, "United Arab Emirates")
  val C184 = Value(184, "United Kingdom")
  val C185 = Value(185, "Uruguay")
  val C186 = Value(186, "Uzbekistan")
  val C187 = Value(187, "Vanuatu")
  val C188 = Value(188, "Vatican City")
  val C189 = Value(189, "Venezuela")
  val C190 = Value(190, "Vietnam")
  val C191 = Value(191, "Yemen")
  val C192 = Value(192, "Zambia")
  val C193 = Value(193, "Zimbabwe")
  val C194 = Value(194, "Abkhazia")
  val C195 = Value(195, "China, Republic of (Taiwan)")
  val C196 = Value(196, "Nagorno-Karabakh")
  val C197 = Value(197, "Northern Cyprus")
  val C198 = Value(198, "Pridnestrovie (Transnistria)")
  val C199 = Value(199, "Somaliland")
  val C200 = Value(200, "South Ossetia")
  val C201 = Value(201, "Ashmore and Cartier Islands")
  val C202 = Value(202, "Christmas Island")
  val C203 = Value(203, "Cocos (Keeling) Islands")
  val C204 = Value(204, "Coral Sea Islands")
  val C205 = Value(205, "Heard Island and McDonald Islands")
  val C206 = Value(206, "Norfolk Island")
  val C207 = Value(207, "New Caledonia")
  val C208 = Value(208, "French Polynesia")
  val C209 = Value(209, "Mayotte")
  val C210 = Value(210, "Saint Barthelemy")
  val C211 = Value(211, "Saint Martin")
  val C212 = Value(212, "Saint Pierre and Miquelon")
  val C213 = Value(213, "Wallis and Futuna")
  val C214 = Value(214, "French Southern and Antarctic Lands")
  val C215 = Value(215, "Clipperton Island")
  val C216 = Value(216, "Bouvet Island")
  val C217 = Value(217, "Cook Islands")
  val C218 = Value(218, "Niue")
  val C219 = Value(219, "Tokelau")
  val C220 = Value(220, "Guernsey")
  val C221 = Value(221, "Isle of Man")
  val C222 = Value(222, "Jersey")
  val C223 = Value(223, "Anguilla")
  val C224 = Value(224, "Bermuda")
  val C225 = Value(225, "British Indian Ocean Territory")
  val C226 = Value(226, "British Sovereign Base Areas")
  val C227 = Value(227, "British Virgin Islands")
  val C228 = Value(228, "Cayman Islands")
  val C229 = Value(229, "Falkland Islands (Islas Malvinas)")
  val C230 = Value(230, "Gibraltar")
  val C231 = Value(231, "Montserrat")
  val C232 = Value(232, "Pitcairn Islands")
  val C233 = Value(233, "Saint Helena")
  val C234 = Value(234, "South Georgia and the South Sandwich Islands")
  val C235 = Value(235, "Turks and Caicos Islands")
  val C236 = Value(236, "Northern Mariana Islands")
  val C237 = Value(237, "Puerto Rico")
  val C238 = Value(238, "American Samoa")
  val C239 = Value(239, "Baker Island")
  val C240 = Value(240, "Guam")
  val C241 = Value(241, "Howland Island")
  val C242 = Value(242, "Jarvis Island")
  val C243 = Value(243, "Johnston Atoll")
  val C244 = Value(244, "Kingman Reef")
  val C245 = Value(245, "Midway Islands")
  val C246 = Value(246, "Navassa Island")
  val C247 = Value(247, "Palmyra Atoll")
  val C248 = Value(248, "U.S. Virgin Islands")
  val C249 = Value(249, "Wake Island")
  val C250 = Value(250, "Hong Kong")
  val C251 = Value(251, "Macau")
  val C252 = Value(252, "Faroe Islands")
  val C253 = Value(253, "Greenland")
  val C254 = Value(254, "French Guiana")
  val C255 = Value(255, "Guadeloupe")
  val C256 = Value(256, "Martinique")
  val C257 = Value(257, "Reunion")
  val C258 = Value(258, "Aland")
  val C259 = Value(259, "Aruba")
  val C260 = Value(260, "Netherlands Antilles")
  val C261 = Value(261, "Svalbard")
  val C262 = Value(262, "Ascension")
  val C263 = Value(263, "Tristan da Cunha")
  val C264 = Value(264, "Antarctica")
  val C265 = Value(265, "Kosovo")
  val C266 = Value(266, "Palestinian Territories (Gaza Strip and West Bank)")
  val C267 = Value(267, "Western Sahara")
  val C268 = Value(268, "Australian Antarctic Territory")
  val C269 = Value(269, "Ross Dependency")
  val C270 = Value(270, "Peter I Island")
  val C271 = Value(271, "Queen Maud Land")
  val C272 = Value(272, "British Antarctic Territory")
}

class MappedPostalCode[T<:Mapper[T]](owner : T, country: MappedEnum[T, Countries.type]) extends MappedString[T](owner, 32) {
  override def setFilter = notNull _ :: toUpper _ :: trim _ :: super.setFilter
  
  private def genericCheck(zip: String): List[ValidationIssue] = {
    zip match {
      case null => List(ValidationIssue(this, "Invalid Postal Code"))
      case s if s.length < 3 => List(ValidationIssue(this, "Invalid Postal Code"))
      case _ => Nil
    }
  }
  
  override def validations = country.get match {
    case Countries.USA =>  valRegex(java.util.regex.Pattern.compile("[0-9]{5}(\\-[0-9]{4})?"), "Invalid ZIP code") _ :: super.validations
    case _ => genericCheck _ :: super.validations
  }
}
