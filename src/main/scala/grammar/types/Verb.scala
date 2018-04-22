package grammar.types

import grammar.terms._

case class Verb(override val word: String, override val description: VerbDescription) extends AbstractWord(word, description)

case class VerbDescription(conjugation: Conjugation, mood: Mood, tense: Tense, voice: Voice, number: Number, person: Person) extends AbstractWordDescription {
  override val toString: String = s"$conjugation, $mood, $tense, $voice, $number, $person"
}