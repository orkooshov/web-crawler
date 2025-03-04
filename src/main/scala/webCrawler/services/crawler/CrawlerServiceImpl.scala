package webCrawler.services.crawler

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import webCrawler.models.WebPageInfo
import zio.{Task, ZIO}

class CrawlerServiceImpl extends CrawlerService {
  private val browser = JsoupBrowser()

  override def getWebPageInfo(url: String): Task[WebPageInfo] = {
    for {
      title <- ZIO.attempt(browser.get(url).title)
    } yield WebPageInfo(url, title)
  }
}
