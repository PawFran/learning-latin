package grammar.types

import grammar.terms.{Case, Declension, Genus, Number}

case class Noun(override val word: String, override val description: NounDescription) extends AbstractWord(word, description)

case class NounDescription(declension: Declension, genus: Genus, number: Number, `case`: Case) extends AbstractWordDescription {
  override val toString: String = s"$declension, $genus, $number, ${`case`}"
}