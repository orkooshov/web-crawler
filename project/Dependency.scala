import sbt.*

object Dependency {
  lazy val scraper: Seq[ModuleID] = Seq("net.ruippeixotog" %% "scala-scraper" % "3.1.2")

  lazy val logging: Seq[ModuleID] = {
    val V = "2.0.17"
    Seq(
      "org.slf4j"      % "slf4j-api"        % V,
      "ch.qos.logback" % "logback-classic"  % "1.5.17"
    )
  }

  lazy val zio: Seq[ModuleID] = {
    val coreV = "2.1.16"
    Seq(
      "dev.zio" %% "zio" % coreV,
      "dev.zio" %% "zio-http" % "3.0.1",
      "dev.zio" %% "zio-json" % "0.7.37"
    )
  }
}
