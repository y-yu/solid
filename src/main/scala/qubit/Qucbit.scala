package qubit

import cbit.Cbit
import spire.math.Complex

case class Qucbit(v: Cbit) extends Qu {
  var alpha: Complex[Double] = if (v.v) 0 else 1
  var beta: Complex[Double]  = if (v.v) 1 else 0
}

object Qucbit {
  val Zero = Qucbit(Cbit(false))
  val One  = Qucbit(Cbit(true))

  val Base = (Zero, One)
}