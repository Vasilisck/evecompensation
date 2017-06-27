package models

import javax.inject.Inject

import play.api.libs.json.{Json, Reads}
import play.api.libs.ws.{WSClient, WSRequest}

import scala.concurrent.{ExecutionContext, Future}
import scala.io.Source

/**
  * Created by vasilisck on 6/26/17.
  */


class ESIClient @Inject()(ws: WSClient)(implicit context: ExecutionContext) {


  //Implicit readers for Json to case class
  private implicit val attackerReads: Reads[Attacker] = Json.reads[Attacker]
  private implicit val itemReads: Reads[Item] = Json.reads[Item]
  private implicit val positionReads: Reads[Position] = Json.reads[Position]
  private implicit val victimReads: Reads[Victim] = Json.reads[Victim]
  private implicit val killmailReads: Reads[Killmail] = Json.reads[Killmail]

  //start init
  private val buffer = Source.fromFile("ESISettings")
  private val source = buffer.getLines()

  val clientID: String = source.next()
  val securityKey: String = source.next()
  private val killmailUrl: String = "https://esi.tech.ccp.is/latest/killmails"

  buffer.close()
  //end init

  def getKillmailByIdAndHash(killmailId: String, killmailHash: String): Future[Killmail] = {
    val request: WSRequest = ws
      .url(s"$killmailUrl/$killmailId/$killmailHash")
      .withQueryStringParameters(("datasource", "tranquility"))
      .withHttpHeaders(("Accept", "application/json"))
    val result = request.get().map(response => {
      if(response.status == 200) {
        val json = response.json
        json.as[Killmail]
      } else {
        throw new Exception(s"code ${response.status}, ${response.body}")
      }
    })
    result
  }
}
