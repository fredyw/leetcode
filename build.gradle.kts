plugins {
    java
    kotlin("jvm") version "2.1.10"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}
