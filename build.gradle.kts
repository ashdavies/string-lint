buildscript {
  repositories {
    google()
    jcenter()
  }

  dependencies {
    classpath("com.android.tools.build:gradle:4.0.0-alpha01")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.50")
  }
}

allprojects {
  apply(from = "${rootProject.projectDir}/repositories.gradle.kts")
}
