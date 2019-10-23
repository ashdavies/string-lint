plugins {
  id("java-library")
  kotlin("jvm")
}

dependencies {
  implementation("com.android.tools.lint:lint-api:27.0.0-alpha01")
  implementation("com.android.tools.lint:lint-checks:27.0.0-alpha01")
  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.50")

  testImplementation("com.android.tools.lint:lint-tests:27.0.0-alpha01")
  testImplementation("com.android.tools:testutils:27.0.0-alpha01")
}
