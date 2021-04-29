/**
 * Chapter 5: Union and intersection types
 */

object UnionTypes:
  /**
   * Example 1: Basics
   * [] Union type
   * [] Commutativity
   * [] Variance
   * [] Union types vs either
   */

  // definition
  val x: Boolean = true

  // usage
  def f(in: Boolean): String = ???

  // How many values does type `Either[Boolean, Boolean]` have?
  // How many values does type `Boolean | Boolean` have?

  /**
   * Example 2: What type will be inferred?
   * [] Can we improve inference with union types?
   */
  val what = if (1 == 1) "a" else 10

  /**
   * Example 3: Possible use case: union types and eithers
   */
  enum FooError:
    case FooError1
    case FooError2

  enum BarError:
    case BarError1
    case BarError2

  val error1: Either[FooError, String] = Left(FooError.FooError1)
  val error2: Either[BarError, String] = Left(BarError.BarError1)

  val value =
    for
      _ <- error1
      _ <- error2
    yield ()

//
// Exercise 1: Model a PaymentAuthorizationError ADT from Chapter 3 (enums) using a union type.
// What pros/cons do you see when you use a union type vs enums in modeling ADTs?
//

object IntersectionTypes:
  /**
   * Example 1: Basics
   * [] Example
   * [] Subtyping
   * [] Variance
   * [] Definition
   */
  object Example1:
    trait A:
      def foo: String

    trait B:
      def bar: Int

    def x: A & B = ???

  /**
   * Example 2: Conflicting members
   * [] Same name different type
   * [] Same name same type
   */
  object Example21:
    trait A:
      def foo: String
    trait B:
      def foo: Int

    def x: A & B = ???

  object Example22:
    trait A:
      def foo: Boolean
    trait B:
      def foo: Boolean

    def x: A & B = ???

  /**
   * Example 3: Intersection types vs compound types (a.k.a. `with` types from Scala 2)
   * [] With vs &
   * [] Commutativity
   */
  trait Foo:
    def f: AnyVal
  trait A extends Foo:
    override def f: Boolean
  trait B extends Foo:
    override def f: AnyVal

// btw. there's a nice talk by Dean Wampler that thoroughly explains
// all the properties of union and intersection types: https://youtu.be/8H9KPlGSBnM?t=1270
