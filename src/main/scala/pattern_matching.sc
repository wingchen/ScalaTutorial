import scala.util.Random

val random = new Random

// just like another switch statement in c or java
val dice = random.nextInt(5)

dice match {
  case 1 => "This is one!"
  case 2 => "This is two"
  case n: Int if n >= 4 => "Big number!!"
  case _ => "This is a dangerous zone"
}

// it goes by types too
class QuidPlatform(env: String) {
  def getEnv = env
}

class Classic(en: String) extends QuidPlatform(en)
class NewVis(en: String) extends QuidPlatform(en)

val currentVersion: QuidPlatform = new NewVis("production")

currentVersion match {
  case c: Classic => "newvis deploy went wrong: " + c.getEnv
  case n: NewVis => "That's what I am talking about: " + n.getEnv
  case _ => "This should never happen."
}

// played with case class too
abstract class CaseQuidPlatform(since: Int)

case class CaseClassic(since: Int) extends CaseQuidPlatform(since)
case class CaseNewVis(since: Int) extends CaseQuidPlatform(since)

val newCurrentVersion: CaseQuidPlatform = CaseClassic(3)

newCurrentVersion match {
  case CaseClassic(0) => "CaseClassic should not be initialized with 'since' as 0."
  case CaseClassic(e) if e < 0 => "CaseClassic should not be initialized with 'since' less than 0."
  case CaseClassic(e) => "CaseClassic has been living since " + e + " days ago"
  case CaseNewVis(_) => "Using CaseNewVis now!!"
  case _ => "This should never happen."
}

// you can even pattern match collections
val joeArray = Array("something before", "", "something after")
joeArray match {
  case Array(_, "", _*) => "second is empty"
  case _ => "default"
}

// and it goes with regular expression too
val date = """(\d\d\d\d)-(\d\d)-(\d\d)""".r
"2004-01-20" match {
  case date(year, month, day) => s"$year was a good year for PLs."
  case _ => "it does not match"
}

// introducing Option, no more NPE
var optionalString:Option[String] =
  if (random.nextInt(2) == 1) Some("I have value")
  else None

optionalString match {
  case Some(value) => value
  case _ => "Nothing there"
}

// pattern matching can turn a lot of ugly if/else statement into a simple
// `match` statement, more concise and more readable