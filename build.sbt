name := "db"

version := "1.0"

lazy val `db` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(javaJpa, cache, javaWs)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"

libraryDependencies += "com.oracle" % "ojdbc6" % "12.1.0.1-atlassian-hosted"

libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final"


unmanagedResourceDirectories in Test <+= baseDirectory(_ / "target/web/public/test")

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

routesGenerator := InjectedRoutesGenerator