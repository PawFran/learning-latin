import dictionary.ConjugationDictionary.ConjugationDictionary
import dictionary.DeclensionDictionary.DeclensionDictionary
import dictionary.{ConjugationDictionary, DeclensionDictionary}
import grammar.types._

object WordGenerator {
  import scala.util.Random

  private val generator = new Random()
  private def int(size: Int): Int = generator.nextInt(size)

  def randomWord: AbstractWord = {
    val possibleTypes = List(Verb, Noun)
    possibleTypes(int(possibleTypes.length)) match {
      case Verb => randomVerb(ConjugationDictionary.dict)
      case Noun => randomNoun(DeclensionDictionary.dict)
    }
  }

  def randomVerb(implicit dict: ConjugationDictionary): Verb = {
    val conjugation = dict.keys.toVector(int(dict.size))
    val mood = dict(conjugation).keys.toVector(int(dict(conjugation).size))
    val tense = dict(conjugation)(mood).keys.toVector(int(dict(conjugation)(mood).size))
    val voice = dict(conjugation)(mood)(tense).keys.toVector(int(dict(conjugation)(mood)(tense).size))
    val number = dict(conjugation)(mood)(tense)(voice).keys.toVector(int(dict(conjugation)(mood)(tense)(voice).size))
    val person = dict(conjugation)(mood)(tense)(voice)(number).keys.toVector(int(dict(conjugation)(mood)(tense)(voice)(number).size))

    val terms = VerbDescription(conjugation, mood, tense, voice, number, person)

    val word = dict(conjugation)(mood)(tense)(voice)(number)(person)

    Verb(word, terms)
  }

  def randomNoun(implicit dict: DeclensionDictionary): Noun = {
    val declension = dict.keys.toVector(int(dict.size))
    val genus = dict(declension).keys.toVector(int(dict(declension).size))
    val number = dict(declension)(genus).keys.toVector(int(dict(declension)(genus).size))
    val `case` = dict(declension)(genus)(number).keys.toVector(int(dict(declension)(genus)(number).size))

    val terms = NounDescription(declension, genus, number, `case`)

    val word = dict(declension)(genus)(number)(`case`)

    Noun(word, terms)
  }
}