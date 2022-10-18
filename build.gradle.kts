plugins {
    kotlin("jvm") version "1.7.20"
	id("maven-publish")
}

group = "com.github.chereshnyabtw"
version = "1.0-rc2"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}
