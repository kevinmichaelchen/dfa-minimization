import scala.io.Source

object Main {

  val Instructions = """
Thou shalt provide the name of a file containing an adjacency matrix describing the DFA.

For example:
_,0,1,_,_,_
0,_,_,1,_,_
_,_,_,_,0,1*
_,_,_,_,0,1*
_,_,_,_,0,1
_,_,_,_,_,01
  
- Number of rows indicates number of states.
- States are 1-indexed.
- State 1 is the start state.
- If Row i ends in an asterisk, State i is an accept state.
- Row i indicates the adjacent states.
  - If Row i, Column j has an UNDERSCORE, there is no arc from State i to State j.
  - There can be multiple arcs from State i to State j.
    - e.g., State 6 has two arcs (1 and 0) to itself.
  """

  def main(args: Array[String]) {

    if (args.length != 1) {
      println(Instructions)
      System.exit(1)
    }

    var states = Set[State]()
    var acceptStates = Set[State]()
    var transitions = Map[(State, Symbol), State]()

    val lines = Source.fromFile(args(0)).getLines.toArray
    for (i <- 0 until lines.length) {
      
      val line: String = lines(i)
      val state: State = new State(Symbol(i+""))
      states += state
      if (line endsWith "*") acceptStates += state

      val cols: Array[String] = line split ','
      for (j <- 0 until cols.length) {
	val to: State = new State(Symbol(j+""))
	val arcs: Array[Char] = cols(j).toCharArray

	for (arc <- arcs; 
	     if ( !(arc equals '_') && !(arc equals '*') )
	   ) yield {
	  transitions += ((state, Symbol(arc.toString)) -> to)
	}

      }
      
    }

    println("States:")
    println(states)

    println("Accept States:")
    println(acceptStates)

    println("Transitions:")
    transitions.foreach { case ((s0,c), s1) => println(s0 + " sees a " + c + " and goes to " + s1) }
    
  }

}
