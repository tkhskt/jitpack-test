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
                groupId = LibraryInfo.group
                group = LibraryInfo.group
                artifactId = LibraryInfo.artifactId
                version = LibraryInfo.version

                pom {
                    name.set(LibraryInfo.artifactId)
                    description.set(LibraryInfo.description)
                    url.set(LibraryInfo.url)

                    scm {
                        connection.set("scm:git@github.com:tkhskt/jitpack-test.git")
                        developerConnection.set("scm:git@github.com:tkhskt/jitpack-test.git")
                        url.set(LibraryInfo.url)
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
    version = LibraryInfo.version
}

object LibraryInfo {
    const val artifactId = "jitpack-test"
    const val description = "Jitpack Test"
    const val displayName = "Jitpack Test"
    const val group = "com.tkhskt.jitpacktest"
    const val url = "https://github.com/tkhskt/jitpack-test"
    const val version = "1.0.0"
}