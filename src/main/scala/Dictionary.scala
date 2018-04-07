import grammar.terms.{Ablativus, Accusativus, Case, Dativus, Declension, Femininum, FirstDeclension, FourthDeclension, Genetivus, Genus, Masculinum, Neutrum, Nominativus, Number, Pluralis, SecondDeclension, Singularis, ThirdDeclensionConsonantVariant, ThirdDeclensionMixedVariant, ThirdDeclensionVowelVariant, Vocativus}
import grammar.types.NounDescription

import scala.util.{Success, Try}

object Dictionary {

  type Dictionary = Map[Declension, Map[Genus, Map[Number, Map[Case, String]]]]

  def value(noun: NounDescription): Option[String] =
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
    ),
    ThirdDeclensionConsonantVariant -> Map(
      Masculinum -> Map(
        Singularis -> Map(
          Nominativus -> "imperator",
          Genetivus -> "imperatoris",
          Dativus -> "imperatori",
          Accusativus -> "imperatorem",
          Ablativus -> "imperatore",
          Vocativus -> "imperator"
        ),
        Pluralis -> Map(
          Nominativus -> "imperatores",
          Genetivus -> "imperatorum",
          Dativus -> "imperatoribus",
          Accusativus -> "imperatores",
          Ablativus -> "imperatoribus",
          Vocativus -> "imperatores"
        )
      ),
      Femininum -> Map(
        Singularis -> Map(
          Nominativus -> "lex",
          Genetivus -> "legis",
          Dativus -> "legi",
          Accusativus -> "legem",
          Ablativus -> "lege",
          Vocativus -> "lex"
        ),
        Pluralis -> Map(
          Nominativus -> "leges",
          Genetivus -> "legum",
          Dativus -> "legibus",
          Accusativus -> "leges",
          Ablativus -> "legibus",
          Vocativus -> "leges"
        )
      ),
      Neutrum -> Map(
        Singularis -> Map(
          Nominativus -> "nomen",
          Genetivus -> "nominis",
          Dativus -> "nomini",
          Accusativus -> "nomen",
          Ablativus -> "nomine",
          Vocativus -> "nomen"
        ),
        Pluralis -> Map(
          Nominativus -> "nomina",
          Genetivus -> "nominum",
          Dativus -> "nominibus",
          Accusativus -> "nomina",
          Ablativus -> "nominibus",
          Vocativus -> "nomina"
        )
      )
    ),
    ThirdDeclensionVowelVariant -> Map(
      Neutrum -> Map(
        Singularis -> Map(
          Nominativus -> "vectigal",
          Genetivus -> "vectigalis",
          Dativus -> "vectigali",
          Accusativus -> "vectigal",
          Ablativus -> "vectigali",
          Vocativus -> "vectigal"
        ),
        Pluralis -> Map(
          Nominativus -> "vectigalia",
          Genetivus -> "vectigalium",
          Dativus -> "vectigalibus",
          Accusativus -> "vectigalia",
          Ablativus -> "vectigalibus",
          Vocativus -> "vectigalia"
        )
      )
    ),
    ThirdDeclensionMixedVariant -> Map(
      Femininum -> Map(
        Singularis -> Map(
          Nominativus -> "urbs",
          Genetivus -> "urbis",
          Dativus -> "urbi",
          Accusativus -> "urbem",
          Ablativus -> "urbe",
          Vocativus -> "urbs"
        ),
        Pluralis -> Map(
          Nominativus -> "urbes",
          Genetivus -> "urbium",
          Dativus -> "urbibus",
          Accusativus -> "urbes",
          Ablativus -> "urbibus",
          Vocativus -> "urbes"
        )
      )
    ),
    FourthDeclension -> Map(
      Masculinum -> Map(
        Singularis -> Map(
          Nominativus -> "exercitus",
          Genetivus -> "exercitus",
          Dativus -> "exercitui",
          Accusativus -> "exercitum",
          Ablativus -> "exercitu",
          Vocativus -> "exercitus"
        ),
        Pluralis -> Map(
          Nominativus -> "exercitus",
          Genetivus -> "exercituum",
          Dativus -> "exercitibus",
          Accusativus -> "exercitus",
          Ablativus -> "exercitibus",
          Vocativus -> "exercitus"
        )
      ),
      Neutrum -> Map(
        Singularis -> Map(
          Nominativus -> "cornu",
          Genetivus -> "cornus",
          Dativus -> "cornu",
          Accusativus -> "cornu",
          Ablativus -> "cornu",
          Vocativus -> "cornu"
        ),
        Pluralis -> Map(
          Nominativus -> "cornua",
          Genetivus -> "cornuum",
          Dativus -> "cornibus",
          Accusativus -> "cornua",
          Ablativus -> "cornibus",
          Vocativus -> "cornua"
        )
      )
    )
  )

}
