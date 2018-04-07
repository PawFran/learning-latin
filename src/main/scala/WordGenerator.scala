import Dictionary.Dictionary
import grammar.types.{Noun, NounDescription}

object WordGenerator {
  import scala.util.Random

  private val generator = new Random()
  private def int(size: Int): Int = generator.nextInt(size)

  def randomNoun(implicit dict: Dictionary): Noun = {
    val declension = dict.keys.toVector(int(dict.size))
    val genus = dict(declension).keys.toVector(int(dict(declension).size))
    val number = dict(declension)(genus).keys.toVector(int(dict(declension)(genus).size))
    val `case` = dict(declension)(genus)(number).keys.toVector(int(dict(declension)(genus)(number).size))

    val terms = NounDescription(declension, genus, number, `case`)

    val word = dict(declension)(genus)(number)(`case`)

    Noun(word, terms)
  }
}