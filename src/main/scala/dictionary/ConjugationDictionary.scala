package dictionary

import grammar.terms._
import grammar.types.VerbDescription

import scala.util.{Success, Try}

object ConjugationDictionary {

  type ConjugationDictionary = Map[Conjugation, Map[Mood, Map[Tense, Map[Voice, Map[Number, Map[Person, String]]]]]]

  def value(verb: VerbDescription): Option[String] =
    Try(dict(verb.conjugation)(verb.mood)(verb.tense)(verb.voice)(verb.number)(verb.person)) match {
      case Success(word) => Some(word)
      case _ => None
    }

  implicit val dict: ConjugationDictionary = Map(
    FirstConjugation -> Map(
      Indicativus -> Map(
        Praesens -> Map(
          Activus -> Map(
            Singularis -> Map(
              FirstPerson -> "amo",
              SecondPerson -> "amas",
              ThirdPerson -> "amat"
            ),
            Pluralis -> Map(
              FirstPerson -> "amamus",
              SecondPerson -> "amatis",
              ThirdPerson -> "amant"
            )
          )
        )
      )
    )
  )

}
