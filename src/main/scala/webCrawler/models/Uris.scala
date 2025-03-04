package webCrawler.models

import zio.json._

case class Uris(uris: List[String])

object Uris {
  implicit val decoder: JsonDecoder[Uris] = DeriveJsonDecoder.gen[Uris]
  implicit val encoder: JsonEncoder[Uris] = DeriveJsonEncoder.gen[Uris]
}
