package grammar.terms

sealed trait Conjugation extends Product with Serializable

case object FirstConjugation extends Conjugation {
  override val toString = "First conjugation"
}

case object SecondConjugation extends Conjugation {
  override val toString = "Second conjugation"
}

case object ThirdConjugation extends Conjugation {
  override val toString = "Third conjugation"
}

case object FourthConjugation extends Conjugation {
  override val toString = "Fourth conjugation"
}

case object UnspecifiedConjugation extends Conjugation {
  override val toString = "Unspecified conjugation"
}

object Conjugation {
  def fromString(s: String): Conjugation = s.toLowerCase.stripLineEnd match {
    case "1" | "one" | "first" => FirstConjugation
    case "2" | "two" | "second" => SecondConjugation
    case "3" | "three" | "third" => ThirdConjugation
    case "4" | "four" | "fourth" => FourthConjugation
    case _ => UnspecifiedConjugation
  }
}