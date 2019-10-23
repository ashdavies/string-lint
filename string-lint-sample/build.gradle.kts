plugins {
  id("com.android.library")
  kotlin("android")
}

android {
  compileSdkVersion(29)

  defaultConfig {
    compileOptions {
      sourceCompatibility = JavaVersion.VERSION_1_8
      targetCompatibility = JavaVersion.VERSION_1_8
    }

    minSdkVersion(14)
    targetSdkVersion(29)
  }

  sourceSets {
    mainSrcDirs("src/main/kotlin")
    testSrcDirs("src/test/kotlin")
  }
}

dependencies {
  implementation(project(":string-lint-api"))

  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.50")
  lintChecks(project(":string-lint-checks"))
}
