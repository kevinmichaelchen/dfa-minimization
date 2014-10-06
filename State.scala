class State(n: Symbol) {

  def this(n: String) {
    this(Symbol(n))
  }

  def this(n: Char) {
    this(n.toString)
  }

  val name: Symbol = n

  override def toString = "State " + name.toString

  override def equals(other: Any): Boolean = 
    other match {
      case that: State => that.name equals this.name
      case _ => false
    }
}
