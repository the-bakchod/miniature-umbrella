pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "NotesApp"

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
