package qubit

import spire.math.Complex

case class Qubit(alpha: Complex[Double], beta: Complex[Double]) {
  require(alpha.norm * alpha.norm + beta.norm * beta.norm == 1)

  def <|>(rhs: Qubit): Complex[Double] =
    (this.alpha * rhs.alpha) + (this.beta * rhs.beta)

  def measure(): Qucbit = ???
}

object Qubit {
  val Zero = Qubit(1, 0)
  val One = Qubit(0, 1)
}