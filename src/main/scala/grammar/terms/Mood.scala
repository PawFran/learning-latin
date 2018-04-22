package grammar.terms

sealed trait Mood extends Product with Serializable

case object Indicativus extends Mood

case object Imperativus extends Mood

case object UnspecifiedMood extends Mood

object Mood {
  def fromString(s: String): Mood = s.toLowerCase match {
    case "indicativus" | "ind" => Indicativus
    case "imperativus" | "imp" => Imperativus
    case _ => UnspecifiedMood
  }
}