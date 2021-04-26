/**
 * Chapter 6: The small bits - minor changes you'll likely use
 */

/**
 * Example 1: New case class private constructor behavior
 */
case class Person private (name: String)

// The following won't compile as apply and copy are now private.
// They can only be used in the companion object.

// val person: Person = Person("name")
// val newPerson = person.copy(name = "other")

/**
 * Example 2: Top level definitions
 * [] They replace package objects
 * [] Compiler generates a synthetic object for those (srcfilename$package)
 */
def topLevelDefinitions =
  ???

/**
 * Example 3: Trait parameters
 * [] They can be used instead of early initializers that were dropped
 */
object EarlyInitializers:
  trait Name {
    val name: String
    val size: Int = name.size
  }
  class MyName extends Name {
    override val name: String = "name"
  }
  new MyName() // NullPointerException, because super constructors are called first.

// Solution to NPE in Scala 2 was to use early initializers:
// class MyName extends { override val name: String = "name" } with Name {}

// In Scala 3 we use trait parameters instead:
object TraitParams:
  trait Name(name: String) {
    val size: Int = name.size
  }
  class MyName extends Name("name")
  new MyName() // Works fine

/**
 * Example 4: 22 limit is dropped
 * [] In Scala 3 it compiles
 * [] In Scala 2: error: too many elements for tuple: 30, allowed: 22
 */
type twentyFiveIntTuple = (
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int
)
type fOftwentyFiveArity = (
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int
) => Unit
