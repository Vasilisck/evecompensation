package models

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
  * Created by vasilisck on 6/26/17.
  */
class ESIClientSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "ESI Client" should {


    "read client id and security key properly" ignore {
      val eSIClient = inject[ESIClient]
      assertResult("client id here")(eSIClient.clientID)
      assertResult("security key here")(eSIClient.securityKey)
    }

    "get killmails" in {
      val eSIClient = inject[ESIClient]
      val result = Await.result(eSIClient.getKillmailByIdAndHash("63042503", "952d9b640424d10a2d2ef4ca57588ea6434c9a3c"), Duration.Inf)
      assertResult(38)(result.attackers.size)
    }
  }

}
