plugins {
    `maven-publish`
    id("kotlin")
}

dependencies {
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("com.google.truth:truth:1.1.3")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("mavenPub") {
                group = PluginInfo.group
                artifactId = PluginInfo.artifactId
                version = PluginInfo.version

                pom {
                    name.set(PluginInfo.artifactId)
                    description.set(PluginInfo.description)
                    url.set(PluginInfo.url)

                    scm {
                        connection.set("scm:git@github.com:tkhskt/jitpack-test.git")
                        developerConnection.set("scm:git@github.com:tkhskt/jitpack-test.git")
                        url.set(PluginInfo.url)
                    }

                    developers {
                        developer {
                            id.set("tkhskt")
                            name.set("Keita Takahashi")
                        }
                    }
                }
            }
        }
    }
}

project(":lib") {
    version = PluginInfo.version
}

object PluginInfo {
    const val artifactId = "jitpack-test"
    const val description = "Jitpack Test"
    const val displayName = "Jitpack Test"
    const val group = "com.tkhskt.jitpacktest"
    const val url = "https://github.com/tkhskt/jitpack-test"
    const val version = "1.0.0"
}