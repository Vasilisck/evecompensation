package models

import org.scalatestplus.play.PlaySpec

/**
  * Created by vasilisck on 6/26/17.
  */
class ESIClientSpec extends PlaySpec {

  "ESI Client" should {

    "read key properly" ignore {
      val eSIClient = new ESIClient()
      assertResult("client id here")(eSIClient.clientID)
      assertResult("security key here")(eSIClient.securityKey)
    }
  }

}
