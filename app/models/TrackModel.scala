package models

import play.api.libs.json._

case class TrackModel(`type`: String, id: String, urn: String, titles: Titles, availability: Availability)

object TrackModel {

  implicit val format: Format[TrackModel] = Json.format[TrackModel]


}

case class Titles(primary: String, secondary: String, tertiary: Option[String])


object Titles {

  implicit val format: Format[Titles] = Json.format[Titles]


}

case class Availability(from: String, to: String, label: String)


object Availability {

  implicit val format: Format[Availability] = Json.format[Availability]


}