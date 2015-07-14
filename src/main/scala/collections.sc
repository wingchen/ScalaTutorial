// first, scala's lambda

def noParam = () => 1 + 1
noParam()

def oneParam = (param: Int) => param + 3
oneParam(11)

def twoParams = (param1: Int, param2: Int) => param1 + param2
twoParams(15, 11)

// well, you got the idea

// before diving in, let's take a look at scala's
// collection type hierarchy:
// http://docs.scala-lang.org/overviews/collections/overview.html

// Let's try some of python's Built-in Functions
val list = List(1, 2, 3, 4, 5)

list.take(3)
list.tail

// the following 3 results are identical
list.map(oneParam)
list.map(param => param + 3)
list.map(_ + 3)

// python's filter()
list.filter(_ >= 3) // list.map(param => param >= 3)

// python's reduce()
list.foldLeft(0)((x, y) => x - y)
// ((((0 - 1) - 2 - 3) - 4) -5)

// not python's reduce
list.foldRight(0)((x, y) => x - y)
// (5 - (4 - (3 - (2 - (1 - 0)))))

// python's zip()
list.zip(Seq(-1, -2, -3, -4, -5))

// python's reverse()
list.reverse

// now, something more than python
// foreach loop makes looping a joy
list.foreach(print(_))
list.foreach(item => {
  val deepLearnedItem = item * 2
  print(deepLearnedItem)
})

// deduping
val anotherList = List(1, 3, 3, 3, 5, 6)
anotherList.distinct

// diff
list.diff(anotherList)

// flapMap() for nested data structures
def nestedData(y: Int): List[Int] = List(y, y * y, y * y * y)
list.map(nestedData(_))
list.flatMap(nestedData(_)) // list.map(nestedData(_)).flatten

// let's do an old-school word count then
val text =
  """
    William Shakespeare – 23 April 1616)[nb 1] was an English poet, playwright, and actor, widely regarded as the greatest writer in the English language and the world's pre-eminent dramatist.[2] He is often called England's national poet and the "Bard of Avon".[3][nb 2] His extant works, including some collaborations, consist of around 38 plays,[nb 3] 154 sonnets, two long narrative poems, and a few other verses, of which the authorship of some is uncertain. His plays have been translated into every major living language and are performed more often than those of any other playwright.[4]
    Shakespeare was born and brought up in Stratford-upon-Avon, Warwickshire. At the age of 18, he married Anne Hathaway, with whom he had three children: Susanna, and twins Hamnet and Judith. Between 1585 and 1592, he began a successful career in London as an actor, writer, and part-owner of a playing company called the Lord Chamberlain's Men, later known as the King's Men. He appears to have retired to Stratford around 1613 at age 49, where he died three years later. Few records of Shakespeare's private life survive, and there has been considerable speculation about such matters as his physical appearance, sexuality, religious beliefs, and whether the works attributed to him were written by others.
  """

text.split("[\\W\\s]")
    .filter(_.nonEmpty)
    .map(w => (w.toLowerCase, 1))
    .groupBy(_._1)
    .map(i => (i._1, i._2.size))
    .toSeq.sortBy(i => i._2).reverse

// more interesting scala operations:
// http://www.deadcoderising.com/scala-collections-the-basics/
// http://www.deadcoderising.com/scala-collections-part-2-operations/
// http://www.deadcoderising.com/scala-collections-part-3-exploring-more-operations/

// or the official doc directly
// exp: List -> http://www.scala-lang.org/api/2.11.5/index.html#scala.collection.immutable.List