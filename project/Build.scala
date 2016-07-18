import sbt._
import Keys._

object ProjectBuild extends Build {

  lazy val root = Project(
    id = "activator-akka-tracing",
    base = file("."),
    settings =
      Seq (
        name := "activator-akka-tracing",
        organization := "com.github.levkhomich",
        version := "0.4",

        homepage := Some(url("https://github.com/levkhomich/akka-tracing")),
        licenses := Seq("Apache Public License 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),

        scalaVersion := "2.11.4",
        crossScalaVersions := Seq("2.10.4", "2.11.4"),
        scalacOptions in GlobalScope ++= Seq("-Xcheckinit", "-Xlint", "-deprecation", "-unchecked", "-feature", "-language:_"),
        scalacOptions in Test ++= Seq("-Yrangepos"),

        publish := (),

        resolvers += "Maven Central Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
        libraryDependencies ++=
          Seq(
            "com.github.levkhomich" %% "akka-tracing-core" % "0.5",
            "com.github.levkhomich" %% "akka-tracing-spray" % "0.5",
            "io.spray" %% "spray-can" % "1.3.2",
            "io.spray" %% "spray-client" % "1.3.2",
            "com.typesafe" % "config" % "1.2.1",
            "com.typesafe.akka" %% "akka-actor" % "2.3.14",
            "com.typesafe.akka" %% "akka-slf4j" % "2.3.14",
            "ch.qos.logback"      %  "logback-classic"     % "1.1.3"
          ) ++ (
            if (scalaVersion.value == "2.11.4")
              Seq("org.scala-lang.modules" %% "scala-xml" % "1.0.3")
            else
              Seq.empty
          )
      )
  )
}