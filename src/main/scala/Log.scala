import grammar.types.{AbstractWord, AbstractWordDescription}

/**
  * Logging messages displayed in the console
  */
object Log {

  val correct: String = "\ncorrect"

  def cannotFind(generatedWord: AbstractWord, usersAnswer: AbstractWordDescription): String = {
    s"""could not find your combination in the dictionary: $usersAnswer
       |possible answer: ${generatedWord.description}""".stripMargin
  }

  def wrongAnswer(generatedWord: AbstractWord, usersAnswer: AbstractWordDescription): String = {
    s"""wrong.
       |your answer: $usersAnswer
       |correct answer is: ${generatedWord.description}""".stripMargin
  }

  val exiting = "\n\nexiting application.."

}
