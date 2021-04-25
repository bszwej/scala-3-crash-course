package solutions

/**
 * Chapter 5: Union and intersection types
 */

object UnionTypes:
  /**
   * Example 1: Basics
   * [x] Union type
   * [x] Commutativity
   * [x] Union types vs either
   */

  // definition
  val x: Boolean | Int = true

  // usage
  def f(in: Boolean | Int): String = in match {
    case _: Boolean => "bool"
    case _: Int     => "int"
  }

  // How many values does type `Either[Boolean, Boolean]` have? 4
  // How many values does type `Boolean | Boolean` have? 2

  /**
   * Example 2: What type will be inferred?
   * [x] Can we improve inference with union types?
   */
  val what: String | Int = if (1 == 1) "a" else 10

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

  val value: Either[FooError | BarError, Unit] =
    for
      _ <- error1
      _ <- error2
    yield ()

//
// Exercise 1: Model a PaymentAuthorizationError ADT from Chapter 2 (enums) using a union type.
// What pros/cons do you see when you use a union type vs enums in modeling ADTs?
//
case class IllegalPaymentStatus(existingPaymentId: String, existingPaymentStatus: String)
case class IllegalRequestData(reason: String)
case class CustomerUnknown(unknownCustomerId: String)
case class InvalidToken(invalidToken: String)
type PaymentAuthorizationError = IllegalPaymentStatus | IllegalRequestData | CustomerUnknown | InvalidToken

object IntersectionTypes:
  /**
   * Example 1: Basics
   * [x] Example
   * [x] Subtyping
   * [x] Variance
   */
  object Example1:
    trait A:
      def foo: String

    trait B:
      def bar: Int

    // example
    val ab: A & B = ???
    ab.foo
    ab.bar

    // subtyping
    val a: A = ab
    val b: B = ab

    // variance - the following property is valid only for covariant types
    def x: List[A] & List[B] = ???
    def y: List[A & B] = x

  /**
   * Example 2: Conflicting members
   * [x] Same name different type
   * [x] Same name same type
   */
  object Example21:
    trait A:
      def foo: String
    trait B:
      def foo: Int

    val x: A & B = ???
    x.foo // String & Int

  object Example22:
    trait A:
      def f: Boolean

    trait B:
      def f: Boolean

    val x: A & B = ???
    x.f // Boolean, but which one?

    class X extends A, B:
      // It's the caller that decides!
      override def f: Boolean = true

    val y: A & B = new X

  /**
   * Example 3: Intersection types vs compound types (a.k.a. `with` types from Scala 2)
   * [x] With vs &
   * [x] Commutativity
   */
  trait Foo:
    def f: AnyVal
  trait A extends Foo:
    override def f: Boolean
  trait B extends Foo:
    override def f: AnyVal

// `with` is implemented using & in Scala 3.

// In Scala 2
// :type (???: A with B).f - Boolean
// :type (???: B with A).f - AnyVal

// In Scala 3
// :type (???: A & B).f - Boolean & AnyVal
// :type (???: B & A).f - AnyVal & Boolean
