package qasm

import qubit.{Qubit, Qucbit}
import spire.math.Real

sealed trait Op

case class H(q: Qubit) extends Op
case class X(q: Qubit) extends Op
case class Z(q: Qubit) extends Op
case class Rot(q: Qubit, r: Real) extends Op
case class S(q: Qubit) extends Op
case class V(q: Qubit, qc: Qucbit, r: Real) extends Op
case class Swap(q1: Qubit, q2: Qubit) extends Op
case class Toffoli()