package io.ashdavies.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue

@Suppress("UnstableApiUsage")
internal class StringIssueRegistry : IssueRegistry() {

  override val issues: List<Issue> = listOf(EmptyStringDetector.ISSUE)
}
