val scala3Version = "3.2.0"

// module definition
lazy val helloWorld = project
    .in(file("."))
    .enablePlugins(NativeImagePlugin)
    .settings(
        scalaVersion := scala3Version,
        Compile/mainClass := Some("helloWorld"),

        // native-image config
        nativeImageVersion := "22.3.3",
        nativeImageJvm := "graalvm-java17",
        nativeImageOptions ++= Seq(
            "-H:+TraceNativeToolUsage"
        ),
    )

libraryDependencies += "com.google.cloud" % "google-cloud-compute" % "1.34.0"