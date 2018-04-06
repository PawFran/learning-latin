import Dictionary.dict
import grammar.terms._
import grammar.types.NounTerms

import scala.io.StdIn.readLine
import scala.util.{Success, Try}

object StartingPoint extends App {

  var proceed = true

  while(proceed) {
    val noun = RandomWordGenerator.noun

    println(noun.word)

    Try(getUsersAnswerFromKeyboard) match {
      case Success(usersAnswer) =>
        val outcome = Dictionary.value(usersAnswer) match {
          case Some(answer) =>
            if (answer == noun.word) "correct"
            else s"""wrong.
                    |your answer: $usersAnswer
                    |correct answer is: ${noun.terms}""".stripMargin
          case None => s"could not find your combination in the dictionary: $usersAnswer"
        }

        println(s"$outcome\n")
      case _ =>
        println("\nexiting application..")
        proceed = false
    }
  }

  def getUsersAnswerFromKeyboard: NounTerms = {
    val declension = Declension.fromString(readLine("which declension (nr with optional variant) ? "))
    val genus = Genus.fromString(readLine("which genus (m / f / n ? "))
    val number = Number.fromString(readLine("sing or pl ? "))
    val `case` = Case.fromString(readLine("which case ? "))

    NounTerms(declension, genus, number, `case`)
  }

}