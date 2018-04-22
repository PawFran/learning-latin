package grammar.terms

sealed trait Person extends Product with Serializable

case object FirstPerson extends Person

case object SecondPerson extends Person

case object ThirdPerson extends Person

case object UnspecifiedPerson extends Person

object Person {
  def fromString(s: String): Person = s.toLowerCase.stripLineEnd match {
    case "one" | "first" | "1" => FirstPerson
    case "two" | "second" | "2" => SecondPerson
    case "three" | "third" | "3" => ThirdPerson
    case _ => UnspecifiedPerson
  }
}

