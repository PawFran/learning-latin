package grammar.terms

sealed trait Declension extends Product with Serializable

case object FirstDeclension extends Declension {
  override val toString = "First declension"
}

case object SecondDeclension extends Declension {
  override val toString = "Second declension"
}

case object ThirdDeclensionConsonantVariant extends Declension {
  override val toString = "Third declension (consonant variant)"
}

case object ThirdDeclensionVowelVariant extends Declension {
  override val toString = "Third declension (vowel variant)"
}

case object ThirdDeclensionMixedVariant extends Declension {
  override val toString = "Third declension (mixed variant)"
}

case object FourthDeclension extends Declension {
  override val toString = "Fourth declension"
}

case object UnspecifiedDeclension extends Declension {
  override val toString: String = "Unspecified declension"
}

object Declension {
  def fromString(s: String): Declension = s.toLowerCase.stripLineEnd match {
    case "1" | "one" | "first" => FirstDeclension
    case "2" | "two" | "second" => SecondDeclension
    case "3c" => ThirdDeclensionConsonantVariant
    case "3v" => ThirdDeclensionVowelVariant
    case "3m" => ThirdDeclensionMixedVariant
    case "4" | "four" | "fourth" => FourthDeclension
    case _ => UnspecifiedDeclension
  }
}