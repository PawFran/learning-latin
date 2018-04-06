package grammar.terms

sealed trait Case extends Product with Serializable

case object Nominativus extends Case

case object Genetivus extends Case

case object Dativus extends Case

case object Accusativus extends Case

case object Ablativus extends Case

case object Vocativus extends Case

case object UnspecifiedCase extends Case {
  override val toString = "Unspecified case"
}

object Case {
  def fromString(s: String): Case = s.toLowerCase.stripLineEnd match {
    case "nom" | "nominativus" | "nominative" => Nominativus
    case "gen" | "genetivus" | "genetive" => Genetivus
    case "dat" | "dativus" | "dative" => Dativus
    case "acc" | "accusativus" | "acusativus" | "accusative" | "acusative" => Accusativus
    case "abl" | "ablativus" | "ablative" => Ablativus
    case "voc" | "vocativus" | "vocative" => Vocativus
    case _ => UnspecifiedCase
  }
}