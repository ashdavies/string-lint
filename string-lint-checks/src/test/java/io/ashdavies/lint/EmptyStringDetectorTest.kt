package io.ashdavies.lint

import com.android.tools.lint.checks.infrastructure.LintDetectorTest
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Issue

@Suppress("UnstableApiUsage")
internal class EmptyStringDetectorTest : LintDetectorTest() {

  override fun getDetector(): Detector = EmptyStringDetector()

  override fun getIssues(): List<Issue> = listOf(EmptyStringDetector.ISSUE)

  fun testDetectEmptyJavaString() {
    val file: TestFile = java(
        """
          package io.ashdavies.lint;
          
          public class EmptyStringTest {
          
            EmptyStringTest() {
              System.out.println("");
            }
          }
          """.trimIndent()
    )

    val expectation: String = """
      src/io/ashdavies/lint/EmptyStringTest.java:6: Warning: String expressions should not be empty. [EmptyString]
        System.out.println("");
                           ~~
      0 errors, 1 warnings
      """.trimIndent()

    lint()
        .files(file)
        .run()
        .expect(expectation)
  }

  fun testDetectEmptyKotlinString() {
    val file: TestFile = kotlin(
        """
          package io.ashdavies.lint
          
          class EmptyStringTest {
          
            init {
              println("")
            }
          }
          """.trimIndent()
    )

    val expectation: String = """
      src/io/ashdavies/lint/EmptyStringTest.kt:6: Warning: String expressions should not be empty. [EmptyString]
        println("")
                ~~
      0 errors, 1 warnings
      """.trimIndent()

    lint()
        .files(file)
        .run()
        .expect(expectation);
  }
}
