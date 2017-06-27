package controllers

import javax.inject.Inject

import models.ESIClient
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}

/**
  * Created by vasilisck on 6/26/17.
  */
class KillmailController @Inject()(cc: ControllerComponents, eSIClient: ESIClient) extends AbstractController(cc) {

  def post(killmail_url: String) = Action { implicit request: Request[AnyContent] =>

    Ok(views.html.main("asdasdf")(views.html.index()))
  }

}
