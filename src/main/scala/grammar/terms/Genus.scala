package grammar.terms

sealed trait Genus extends Product with Serializable

case object Femininum extends Genus

case object Masculinum extends Genus

case object Neutrum extends Genus

case object UnspecifiedGenus extends Genus {
  override val toString = "Unspecified genus"
}

object Genus {
  def fromString(s: String): Genus = s.toLowerCase.stripLineEnd match {
    case "f" | "fem" | "femininum" | "female" | "she" => Femininum
    case "m" | "masc" | "masculinum" | "male" | "he" => Masculinum
    case "n" | "neutr" | "neutrum|" | "it" => Neutrum
    case _ => UnspecifiedGenus
  }
}