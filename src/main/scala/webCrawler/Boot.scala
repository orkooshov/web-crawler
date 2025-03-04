package webCrawler

import webCrawler.api.Endpoints
import webCrawler.services.crawler.CrawlerService
import zio.http.Server
import zio.{ExitCode, Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object Boot extends ZIOAppDefault {

  private def program: ZIO[Server with CrawlerService, Nothing, ExitCode] = {
    for {
      crawler <- ZIO.service[CrawlerService]
      endpoints = new Endpoints(crawler)
      _ <- Server.serve(endpoints.routes)
    } yield ExitCode.success
  }

  def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = {
    program.provide(Server.defaultWithPort(80), CrawlerService.live)
  }
}
