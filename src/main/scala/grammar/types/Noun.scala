package grammar.types

import grammar.terms.{Case, Declension, Genus, Number}

case class Noun(word: String, description: NounDescription)

case class NounDescription(declension: Declension, genus: Genus, number: Number, `case`: Case) {
  override def toString: String = s"$declension, $genus, $number, ${`case`}"
}