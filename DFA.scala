class DFA(
  states: Set[State],
  alphabet: Set[Symbol],
  transition: Map[(State, Symbol), State],
  start: State,
  accepts: Set[State]
) {

  println(states)

}
