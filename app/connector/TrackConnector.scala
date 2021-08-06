package connector

import data.StubData._
import models.TrackModel
import play.api.libs.json.Json

class TrackConnector {

  // the connector gets the tracks and converts the Json into a model. it then searches for the tracks based off the id and returns either a TrackModel
  // which corresponds to the Id, or a "Not found"

  def retrieveById(searchId: String): Either[String, TrackModel] = {
    tracks.get(searchId) match {
      case Some(value) => Right(value.as[TrackModel])
      case _ => Left("Not Found")

    }

  }

  def saveId(track: TrackModel) = {
    var newTrack = Map(track.id -> Json.toJson(track))
    newTrack += tracks
  }

  // functionality not working completely, but the idea is to call a method in the connector which saves the track.

}
