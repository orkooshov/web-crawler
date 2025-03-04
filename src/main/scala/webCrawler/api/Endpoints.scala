package webCrawler.api

import webCrawler.models.Uris
import webCrawler.services.crawler.CrawlerService
import zio._
import zio.http._
import zio.json._

class Endpoints(crawlerService: CrawlerService) {

  private def handleGetTitles(request: Request): ZIO[Any, Response, Response] = {
    for {
      bodyStr <- request.body.asString
      body <- ZIO.fromEither(bodyStr.fromJson[Uris])
        .mapError(e => new IllegalArgumentException(s"Invalid JSON: $e"))
      pageInfoList <- ZIO.foreach(body.uris)(crawlerService.getWebPageInfo)
      response = pageInfoList.toJson
    } yield Response.json(response)
  }.catchAll(err => ZIO.succeed(Response.text(err.getMessage).status(Status.BadRequest)))

  val routes: Routes[Any, Response] = Routes {
    Method.POST / "titles" -> handler { req: Request =>
      handleGetTitles(req)
    }
  }
}
