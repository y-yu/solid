package qubit

import spire.math.Complex

case class Qubit(var alpha: Complex[Double], var beta: Complex[Double]) extends Qu

object Qubit {
  val Zero = Qubit(1, 0)
  val One = Qubit(0, 1)
}