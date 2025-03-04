package webCrawler.models

import zio.json._

case class WebPageInfo(uri: String, title: String)

object WebPageInfo {
  implicit val decoder: JsonDecoder[WebPageInfo] = DeriveJsonDecoder.gen[WebPageInfo]
  implicit val encoder: JsonEncoder[WebPageInfo] = DeriveJsonEncoder.gen[WebPageInfo]
}