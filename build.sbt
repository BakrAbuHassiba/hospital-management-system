import sbt.Keys.libraryDependencies

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.6.16"
)

lazy val root = (project in file("."))
  .settings(
    name := "Hospital"

  )
//libraryDependencies +=
//  "com.typesafe.akka" %% "akka-actor" % "2.3.8"