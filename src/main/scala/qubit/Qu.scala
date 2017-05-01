package qubit

import spire.math.Complex
import scala.util.Random
import spire.implicits._

trait Qu {
  var alpha: Complex[Double]
  var beta: Complex[Double]

  def +(rhs: Qu): Qu =
    Qu(this.alpha + rhs.alpha, this.beta  + rhs.beta)

  def *(rhs: Double): Qu =
    Qu(this.alpha * rhs, this.beta * rhs)

  def <|>(rhs: Qu): Complex[Double] =
    (this.alpha * rhs.alpha) + (this.beta * rhs.beta)

  def norm: Complex[Double] =
    this <|> this

  def p(qc: Qucbit): Double = {
    val t = (qc <|> this).abs
    t * t
  }

  def measure(qs: (Qucbit, Qucbit)): Qucbit = {
    require((qs._1 <|> qs._2).abs == 0)

    val p0 = this.p(qs._1)
    val p1 = this.p(qs._2)

    val r = new Random().nextDouble()

    if (r < p0) {
      this.alpha = qs._1.alpha
      this.beta  = qs._1.beta
      qs._1
    } else {
      this.alpha = qs._2.alpha
      this.beta  = qs._2.beta
      qs._2
    }
  }

  override def toString: String = {
    s"""
       |${alpha.toString()}
       |${beta.toString()}
     """.stripMargin
  }
}

object Qu {
  def apply(a: Complex[Double], b: Complex[Double]): Qu = {
    require(a.abs * a.abs + b.abs * b.abs == 1)

    new Qu {
      var alpha: Complex[Double] = a
      var beta: Complex[Double] = b
    }
  }
}