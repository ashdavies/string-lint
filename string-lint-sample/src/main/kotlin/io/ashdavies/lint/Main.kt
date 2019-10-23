package io.ashdavies.lint

internal class Main {

  private val state = State("")

  init {
    val valid: String = emptyString()
    val empty: String = ""

    val other: State = State.create(empty)
  }

  class State(private val name: String) {

    companion object {

      fun create(name: String) = State(name)
    }
  }
}
