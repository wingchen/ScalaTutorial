import scala.collection.mutable.ArrayBuffer
// first singleton
// don't write weird static classes anymore, use singleton
object KickAss {
  var stuff = new ArrayBuffer[Int]()

  def iDoCoolShit = "Here is some cool shit!!"
  def addMoreStuff(stuf: Int): Unit = {
    stuff += stuf
  }

  def getStuff = stuff

}

KickAss.iDoCoolShit

KickAss.addMoreStuff(121)

KickAss.getStuff



// abstract classes, just like the java ones
abstract class AbsSomething(param: String) {
  def doSomething:String // I don't do anything yet
}

class Something(param: String) extends AbsSomething(param) {
  def doSomething:String = "Now I am doing something: " + param

  // please notice the constructors here at param
  def this(param: String, otherParam: Int) = this(param)
}

val something = new Something("para")
something.doSomething




// Traits are akin to Java interfaces, but are allowed to have method implementations.
// Traits are supposed to be very minimal and focus on one responsibility. This way multiple traits can be stacked together.
// composition over inheritance, like java, not c++

trait Boldable {
  def bold(text: String): String = s"**$text**"
}

trait Italicizable {
  def italicize(text: String): String = s"*$text*"
}

object MarkdownWrapper extends Boldable with Italicizable {
  def boldAndItalic(text: String): String = bold(italicize(text))
}

MarkdownWrapper.boldAndItalic("Scala rocks!")




// finally, you can add apply function into an object
// we will be able to use this object as a function, as well as an object

object Foo {
  var y = 5
  def apply (x: Int) = x + y
}


Foo(1) // using Foo object in function notation
// this is similar to java's factory methods: Fooactory.newInstance(1).

// now you can update the y
Foo.y = 1000
Foo(2) // returns a different value




// companion object, to separate singleton functions away from class methods
//
// The companion object basically provides a place where one can put 'static' methods.
// Further more, a companion object, or companion module, has full access to the class members,
// including private ones.
//
// Companion Objects are great for encapsulating things like factory methods.
// Instead of having to have Animal and AnimalFactory everywhere,
// you can have a class with a companion object take on the factory responsibilities.
trait Animal {
  def speak: String
}

object Animal {

  private class Dog extends Animal {
    override def speak: String = "woof"
  }

  private class Cat extends Animal {
    override def speak: String = "meow"
  }

  def apply(s: String): Animal = {
    if (s == "dog") new Dog
    else new Cat
  }

}

val cat = Animal("cat")
val dog = Animal("dog")
