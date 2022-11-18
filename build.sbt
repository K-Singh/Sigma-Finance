ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.10"

lazy val root = (project in file("."))
  .settings(
    name := "SigmaBonds",
    idePackagePrefix := Some("io.github-K-Singh.sigmabonds")
  )
