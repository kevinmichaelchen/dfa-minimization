import scala.io.Source

object Main {

  def main(args: Array[String]) {

    if (args.length != 1) {
      println("Thou shalt provide the name of a file containing an adjacency matrix describing the DFA.")
      println("""
For example:
3,4
_,0,1,_,_,_
0,_,_,1,_,_
_,_,_,_,0,1
_,_,_,_,0,1
_,_,_,_,0,1
_,_,_,_,_,01
""")
      println("The first line of the file indicates the accept states. In this case, state/row 3 and state/row 4. States/rows are 1-indexed.")
      println("There are 6 states as indicated by the number of rows (or columns)")
      println("The first state/row of the matrix is the start state (state 1)")
      println("When multiple symbols lead to the same state, we simply concatenate them (which isn't a problem since symbols are 1 char long anyway).")
      println("Row 1 indicates all the states that State 1 can get to. If a state cannot get to another state, we use an underscore.")

      System.exit(1)
    }

    val lines = Source.fromFile(args(0)).getLines.toArray
    for (i <- 0 until lines.length) {
      println(lines(i))
    }
    
  }

}
