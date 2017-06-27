package controllers

import javax.inject.Inject

import models.ESIClient
import play.api.mvc._

import scala.concurrent.ExecutionContext

/**
  * Created by vasilisck on 6/26/17.
  */
class KillmailController @Inject()(cc: ControllerComponents, eSIClient: ESIClient)(implicit context: ExecutionContext) extends AbstractController(cc) {

  def post(killmail_url: String): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    val (killmailID, killmailHash) = eSIClient.getkillmailIdAndHashFromUrl(killmail_url)
    val killmail = eSIClient.getKillmailByIdAndHash(killmailID, killmailHash)
    killmail.map(killmail => {
      Ok(views.html.main(s"${killmail.victim.character_id} sucks")(views.html.index()))
    })
  }
}
