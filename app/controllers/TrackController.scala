package controllers

import connector.TrackConnector
import javax.inject._
import models.TrackModel
import play.api.libs.json.{JsError, Json}
import play.api.mvc._

@Singleton
class TrackController @Inject()(val controllerComponents: ControllerComponents,
                                trackConnector: TrackConnector) extends BaseController {

  //the controller contains the function which is called in the routes file, it does a match to either return the track or a bad request.

  def getTrack(id: String) = Action { implicit request: Request[AnyContent] =>
    trackConnector.retrieveById(id) match {
      case Right(value) => Ok(Json.toJson(value))
      case Left(error) => BadRequest(error)
    }
  }

  def postTrack() = Action(parse.json) { implicit request =>

    val result = request.body.validate[TrackModel]
    result.fold(
      errors => {
        BadRequest(Json.obj("Not Found" -> JsError.toJson(errors)))
      },
      track => {
        trackConnector.saveId(track)
        Ok(Json.obj("Success" -> ("id '" + track.id + "' saved.")))
      }
    )


// post method returns either an error or a success and will call a method in the connector to store the data

}
