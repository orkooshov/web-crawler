ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.16"

import Dependency.*

lazy val root = (project in file("."))
  .settings(
    name := "web-crawler",
    libraryDependencies ++= scraper ++ logging ++ zio
  )
