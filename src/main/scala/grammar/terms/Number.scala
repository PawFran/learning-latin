package grammar.terms

sealed trait Number extends Product with Serializable

case object Singularis extends Number

case object Pluralis extends Number

case object UnspecifiedNumber extends Number {
  override val toString = "Unspecified number"
}

object Number {
  def fromString(s: String): Number = s.toLowerCase.stripLineEnd match {
    case "s" | "sing" | "single" | "singular" | "singularis" => Singularis
    case "pl" | "plural" | "pluralis" => Pluralis
    case _ => UnspecifiedNumber
  }
}
