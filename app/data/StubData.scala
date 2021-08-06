package data

import models.TrackModel
import play.api.libs.json.{JsValue, Json}

object StubData {

  // file containing tracks in Json format

   var tracks: Map[String, JsValue] =
    Map(track1.as[TrackModel].id -> track1,
        track2.as[TrackModel].id -> track2)


  val track1: JsValue = Json.parse(
    """{
      |"type": "track",
      |"id": "nznx3r",
      |"urn": "urn:bbc:sounds:track:nznx3r",
      |"titles": {
      |       "primary": "AC/DC",
      |       "secondary": "Highway to Hell",
      |       "tertiary": null },
      |"availability": {
      |       "from": "2019-02-13T11:03:05Z",
      |       "to": "2019-03-15T11:00:00Z",
      |       "label": "Available for 29 days"
      |        }
      |   }
      |""".stripMargin
  )

  val track2: JsValue = Json.parse(
    """{
      |"type": "track",
      |"id": "n123456",
      |"urn": "urn:bbc:sounds:track:n123456",
      |"titles": {
      |       "primary": "Flume",
      |       "secondary": "Rushing Back",
      |       "tertiary": null },
      |"availability": {
      |       "from": "2019-02-13T11:03:05Z",
      |       "to": "2019-03-15T11:00:00Z",
      |       "label": "Available for 29 days"
      |        }
      |   }
      |""".stripMargin
  )

}
