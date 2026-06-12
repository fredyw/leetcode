plugins {
    java
    kotlin("jvm") version "2.3.0"
    application
    id("com.diffplug.spotless") version "8.6.0"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

kotlin {
    jvmToolchain(25)
}

application {
    mainClass.set(project.provider {
        val mc = project.findProperty("mainClass") as? String
        mc?.let { if (it.contains(".")) it else "leetcode.$it" }
    })
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

spotless {
    java {
        googleJavaFormat("1.35.0").aosp()
    }
    kotlin {
        ktfmt().kotlinlangStyle()
    }
}
