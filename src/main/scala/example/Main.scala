package example

import spire.math._
import qubit.{Qubit, Qucbit}

object Main {
  def main(args: Array[String]): Unit = {
    val z = Qucbit.Zero

    println(z.measure(Qucbit.Base))

    val plus = Qubit(1 / sqrt(2), 1 / sqrt(2))
    println(plus.measure(Qucbit.Base))
  }
}
