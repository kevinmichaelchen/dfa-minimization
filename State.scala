class State(n: Symbol) {

  val name = n

  override def toString = "State " + name.toString

  override def equals(other: Any): Boolean = 
    other match {
      case that: State => that.name equals this.name
      case _ => false
    }
}
