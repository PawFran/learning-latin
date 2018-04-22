package grammar.terms

sealed trait Tense extends Product with Serializable

case object Praesens extends Tense

case object UnspecifiedTense extends Tense

object Tense {
  def fromString(s: String): Tense = s.toLowerCase match {
    case "praesens" | "present" | "praesentis" => Praesens
    case _ => UnspecifiedTense
  }
}