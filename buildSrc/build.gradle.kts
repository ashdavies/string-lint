apply(from = "${rootProject.projectDir}/../repositories.gradle.kts")

buildscript {
  repositories {
    google()
  }

  dependencies {
    classpath("com.android.tools.build:gradle:4.0.0-alpha01")
  }
}

plugins {
  `kotlin-dsl`
}

dependencies {
  implementation("com.android.tools.build:gradle:4.0.0-alpha01")
}
