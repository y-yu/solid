package qubit

import cbit.Cbit

case class Qucbit(v: Cbit) extends Qubit(if (v.v) 0 else 1, if (v.v) 1 else 0)

object Qucbit {
  val Zero = Qucbit(Cbit(false))
  val One = Qucbit(Cbit(true))
}