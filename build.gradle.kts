plugins {
    `java-library`
    `maven-publish`
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_4
    targetCompatibility = JavaVersion.VERSION_1_4
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            pom {
                name.set("HACBS Test Simple Gradle JDK8")
                description.set("Test data for HACBS JVM build service (Gradle version)")
                url.set("https://github.com/dwalluck/hacbs-test-simple-gradle-jdk8")
                properties.set(mapOf(
                    "maven.compiler.source" to "1.4",
                    "maven.compiler.target" to "1.4"
                ))
                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("dwalluck")
                        name.set("David Walluck")
                        email.set("dwalluck@redhat.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/dwalluck/hacbs-test-simple-gradle-jdk8.git")
                    developerConnection.set("scm:git:ssh://github.com/dwalluck/hacbs-test-simple-gradle-jdk8.git")
                    url.set("http://github.com/dwalluck/hacbs-test-simple-gradle-jdk8/")
                }
            }
        }
    }
}

nexusPublishing {
    repositories {
        sonatype()
    }
}
