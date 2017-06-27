package models

import javax.inject.Inject

import scala.io.Source

/**
  * Created by vasilisck on 6/26/17.
  */


class ESIClient {

  private val buffer = Source.fromFile("ESISettings")
  private val source = buffer.getLines()
  val clientID: String = source.next()
  val securityKey: String = source.next()
  buffer.close()

}
