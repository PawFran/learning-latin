package grammar.terms

sealed trait Voice extends Product with Serializable

case object Passivus extends Voice

case object Activus extends Voice

case object UnspecifiedVoice extends Voice

object Voice {
  def fromString(s: String): Voice = s.toLowerCase.stripLineEnd match {
    case "passive" | "passivus" | "passivi" | "pass" => Passivus
    case "active" | "activus" | "activi" | "act" => Activus
    case _ => UnspecifiedVoice
  }
}
