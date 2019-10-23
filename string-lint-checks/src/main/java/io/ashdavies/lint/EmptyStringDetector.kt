package io.ashdavies.lint

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.SourceCodeScanner
import org.jetbrains.uast.UElement
import org.jetbrains.uast.ULiteralExpression
import java.util.EnumSet

internal class EmptyStringDetector : Detector(), SourceCodeScanner {

  override fun getApplicableUastTypes(): List<Class<out UElement>> = listOf(ULiteralExpression::class.java)

  override fun createUastHandler(context: JavaContext): UElementHandler = EmptyStringHandler(context)

  private class EmptyStringHandler(private val context: JavaContext) : UElementHandler() {

    private val ULiteralExpression.text get() = value as String

    override fun visitLiteralExpression(node: ULiteralExpression) {
      if (node.isString && node.text.isEmpty()) {
        context.report(ISSUE, node, context.getLocation(node), "String expressions should not be empty.")
      }
    }
  }

  companion object {

    val ISSUE = Issue.Companion.create(
        id = "EmptyString",
        briefDescription = "Empty string expressions are a source of code smell.",
        explanation = """
          Providing an empty string expression indicates an invalid view state as it may be accidental,
           or provided as empty to create an empty state object when instead null should be used
           to indicate the absence of a value. Should an empty string be the correct and expected
           value, then suppress this warning, or use emptyString()
        """.trimIndent(),
        implementation = Implementation(
            EmptyStringDetector::class.java,
            EnumSet.of(Scope.JAVA_FILE)
        )
    )
  }
}
