organization := "Lift"

name := "Lift-Template"

version := "0.1"

scalaVersion := "2.9.1"

seq(webSettings :_*)

//run with ~container:start using a context path localhost:8080/test to make sure noting breaks 
//env in Compile :=  Some(file(".") / "jetty-env.xml" asFile) 
 
// If using JRebel
scanDirectories in Compile := Nil

logLevel := Level.Info
//Level.Info.Debug

// I don't know how to make these three more compact...
resolvers += "Sonatype OSS Snapshot Repository" at "https://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Sonatype scala-tools repo" at "https://oss.sonatype.org/content/groups/scala-tools/"

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

transitiveClassifiers := Seq("sources","javadocs")

libraryDependencies ++= {
  val liftVersion = "2.5-SNAPSHOT" // Put the current/latest lift version here
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-wizard" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-testkit" % liftVersion % "compile->default"
    )
}

// Customize any further dependencies as desired
libraryDependencies ++= Seq(
  "org.mortbay.jetty" % "jetty" % "6.1.26" % "test,container",
  "ch.qos.logback" % "logback-classic" % "0.9.26" % "compile->default",
  "junit" % "junit" % "4.8" % "test->default", 
  "org.scala-tools.testing" %% "specs" % "1.6.9" % "test",
  "org.specs2" %% "specs2" % "1.6.1" % "test",
  "com.h2database" % "h2" % "1.2.147"
//  "org.eclipse.jetty" % "jetty-webapp" % "8.0.3.v20111011" % "container",
//  "org.eclipse.jetty" % "jetty-plus" % "8.0.3.v20111011" % "container", 
//  "javax.servlet" % "servlet-api" % "2.5" % "provided->default",
//  "org.slf4j" % "slf4j-log4j12" % "1.6.1" % "compile->default", // Logging
//  "commons-lang" % "commons-lang" % "2.0" % "compile->default",
//  "com.jolbox" % "bonecp" % "0.7.1.RELEASE" % "compile->default"  
)