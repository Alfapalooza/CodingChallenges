name := "CodingChallenges"

version := "1"

scalaVersion := "2.12.8"

libraryDependencies ++=
  Seq(
    "org.scalactic"  %% "scalactic"      % "3.0.8",
    "org.scalatest"  %% "scalatest"      % "3.0.8"  % Test,
    "org.scalacheck" %% "scalacheck"     % "1.14.0" % Test,
  )