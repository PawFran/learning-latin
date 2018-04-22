import Log._
import dictionary.{ConjugationDictionary, DeclensionDictionary}
import grammar.terms._
import grammar.types._

import scala.io.StdIn.readLine
import scala.util.{Success, Try}

object StartingPoint extends App {

  private var proceed = true

  while (proceed) {
    val generatedWord = WordGenerator.randomWord

    println(generatedWord.word)

    if (generatedWord.isInstanceOf[Verb]) {
      Try(getUsersAnswerFromKeyboardVerbCase) match {
        case Success(usersAnswer) =>
          val outcome = ConjugationDictionary.value(usersAnswer) match {
            case Some(answer) =>
              if (answer == generatedWord.word) correct
              else wrongAnswer(generatedWord, usersAnswer)
            case None => cannotFind(generatedWord, usersAnswer)

          }

          println(s"$outcome\n")
        case _ =>
          println(exiting)
          proceed = false
      }
    }
    else {
      Try(getUsersAnswerFromKeyboardNounCase) match {
        case Success(usersAnswer) =>
          val outcome = DeclensionDictionary.value(usersAnswer) match {
            case Some(answer) =>
              if (answer == generatedWord.word) correct
              else wrongAnswer(generatedWord, usersAnswer)
            case None => cannotFind(generatedWord, usersAnswer)
          }

          println(s"$outcome\n")
        case _ =>
          println(exiting)
          proceed = false
      }
    }
  }

  private def getUsersAnswerFromKeyboardVerbCase: VerbDescription = {
    val conjugation = Conjugation.fromString(readLine("which conjugation ? "))
    val mood = Mood.fromString(readLine("which mood (ind or imp) ? "))
    val tense = Tense.fromString(readLine("which tense ? "))
    val voice = Voice.fromString(readLine("which voice (act or pass) ? "))
    val number = Number.fromString(readLine("sing or pl ? "))
    val person = Person.fromString(readLine("which person (1 or 2 or 3) ? "))

    VerbDescription(conjugation, mood, tense, voice, number, person)
  }

  private def getUsersAnswerFromKeyboardNounCase: NounDescription = {
    val declension = Declension.fromString(readLine("which declension (nr with optional variant) ? "))
    val genus = Genus.fromString(readLine("which genus (m / f / n ? "))
    val number = Number.fromString(readLine("sing or pl ? "))
    val `case` = Case.fromString(readLine("which case (nom, gen, dat, acc, abl, voc) ? "))

    NounDescription(declension, genus, number, `case`)
  }

}