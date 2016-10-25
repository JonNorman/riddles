scalaSource in Compile := baseDirectory.value / "src/models"
scalaSource in Test := baseDirectory.value / "src/test"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"

logBuffered in Test := false
