plugins {
    kotlin("jvm") version "1.7.20"
	id("maven-publish")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

publishing {
	publications {
		create<MavenPublication>("maven") {
			groupId = "com.github.chereshnyabtw"
			artifactId = "bitrix24-api"
			version = "1.0-rc4"

			from(components["kotlin"])
		}
	}
}
