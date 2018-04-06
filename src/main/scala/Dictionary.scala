import grammar.terms.{Ablativus, Accusativus, Case, Dativus, Declension, Femininum, FirstDeclension, Genetivus, Genus, Masculinum, Neutrum, Nominativus, Number, Pluralis, SecondDeclension, Singularis, Vocativus}
import grammar.types.NounTerms

import scala.util.{Success, Try}

object Dictionary {

  type Dictionary = Map[Declension, Map[Genus, Map[Number, Map[Case, String]]]]

  def value(noun: NounTerms): Option[String] =
    Try(dict(noun.declension)(noun.genus)(noun.number)(noun.`case`)) match {
      case Success(word) => Some(word)
      case _ => None
    }

  implicit val dict: Dictionary = Map(
    FirstDeclension -> Map(
      Femininum -> Map(
        Singularis -> Map(
          Nominativus -> "ancilla",
          Genetivus -> "ancillae",
          Dativus -> "ancillae",
          Accusativus -> "ancillam",
          Ablativus -> "ancilla",
          Vocativus -> "ancilla"
        ),
        Pluralis -> Map(
          Nominativus -> "ancillae",
          Genetivus -> "ancillarum",
          Dativus -> "ancillis",
          Accusativus -> "ancillas",
          Ablativus -> "ancillis",
          Vocativus -> "ancillae"
        )
      )
    ),
    SecondDeclension -> Map(
      Masculinum -> Map(
        Singularis -> Map(
          Nominativus -> "servus",
          Genetivus -> "servi",
          Dativus -> "servo",
          Accusativus -> "servum",
          Ablativus -> "servo",
          Vocativus -> "serve"
        ),
        Pluralis -> Map(
          Nominativus -> "servi",
          Genetivus -> "servorum",
          Dativus -> "servis",
          Accusativus -> "servos",
          Ablativus -> "servis",
          Vocativus -> "servi"
        )
      ),
      Neutrum -> Map(
        Singularis -> Map(
          Nominativus -> "oppidum",
          Genetivus -> "oppidi",
          Dativus -> "oppido",
          Accusativus -> "oppidum",
          Ablativus -> "oppido",
          Vocativus -> "oppidum"
        ),
        Pluralis -> Map(
          Nominativus -> "oppida",
          Genetivus -> "oppidorum",
          Dativus -> "oppidis",
          Accusativus -> "oppida",
          Ablativus -> "oppidis",
          Vocativus -> "oppida"
        )
      )
    )
  )

}
