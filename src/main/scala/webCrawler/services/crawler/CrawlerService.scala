package webCrawler.services.crawler

import webCrawler.models.WebPageInfo
import zio.{Task, ULayer, ZIO, ZLayer}

trait CrawlerService {
  def getWebPageInfo(url: String): Task[WebPageInfo]
}

object CrawlerService {
  def live: ULayer[CrawlerService] = ZLayer {
    ZIO.succeed(new CrawlerServiceImpl)
  }
}