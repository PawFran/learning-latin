import Dictionary.dict
import grammar.terms._
import grammar.types.NounDescription

import scala.io.StdIn.readLine
import scala.util.{Success, Try}

object StartingPoint extends App {

  var proceed = true

  while(proceed) {
    val generatedNoun = RandomWordGenerator.noun

    println(generatedNoun.word)

    Try(getUsersAnswerFromKeyboard) match {
      case Success(usersAnswer) =>
        val outcome = Dictionary.value(usersAnswer) match {
          case Some(answer) =>
            if (answer == generatedNoun.word) "correct"
            else s"""wrong.
                    |your answer: $usersAnswer
                    |correct answer is: ${generatedNoun.description}""".stripMargin
          case None => s"could not find your combination in the dictionary: $usersAnswer"
        }

        println(s"$outcome\n")
      case _ =>
        println("\n\nexiting application..")
        proceed = false
    }
  }

  def getUsersAnswerFromKeyboard: NounDescription = {
    val declension = Declension.fromString(readLine("which declension (nr with optional variant) ? "))
    val genus = Genus.fromString(readLine("which genus (m / f / n ? "))
    val number = Number.fromString(readLine("sing or pl ? "))
    val `case` = Case.fromString(readLine("which case ? "))

    NounDescription(declension, genus, number, `case`)
  }

}