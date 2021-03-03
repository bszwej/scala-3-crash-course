/**
 * Chapter 1: New syntax
 * 
 * More on that: https://contributors.scala-lang.org/t/feedback-sought-optional-braces/4702
 */

object BracelessSyntaxExamples {
    /**
     * Example 1: New braceless syntax for traits, classes & objects
     */
    trait Foo {
        def bar(input: String): Unit
    }

    class Bar extends Foo {
        override def bar(input: String) = ???
    }

    object Foo {
        def fromString(input: String): Foo = ???
    }

    /**
     * Example 2: Braceless pattern matching.
     */
    "something" match {
        case "something" => ???
        case _ => ???
    }

    /**
     * Example 3: Braceless conditionals.
     */
    if(42 > 42) {
        val x = 10
        val y = 20
        x
    } else {
        val a = 10
        val b = 20
        b
    }

    /**
     * Example 4: Braceless methods.
     */
    def m = {
        val x = 10
        val y = 20
        x + y
    }
    /**
     * Example 5: Braceless for comprehensions.
     */
    for {
        x <- Some(1)
        y <- Some(2)
    } yield x + y

    /**
     * Example 6: The "end" syntax.
     */
    if 42 == 42 then
        val x = 10
        val y = 20
        x
    else
        val a = 10
        val b = 20
        b
    
    def mm =
        val x = 10
        val y = 20
        x + y

    class Test:
        val x = "hello"

    /**
     * Example 7: The new @main annotation.
     */
}

/**
 * Exercises
 */

//
// Exercise 1: Convert the following code to the new Scala 3 braceless syntax.
//
object BracelessSyntaxExercise {

    sealed trait PaymentMethod
    case object CreditCard extends PaymentMethod
    case object Paypal extends PaymentMethod
    object PaymentMethod {
        def fromString(input: String): Option[PaymentMethod] = input match {
            case "credit_card" => Some(CreditCard)
            case "paypal" => Some(CreditCard)
            case _ => None
           }
    }

    trait PaymentService {
        def authorize(amount: BigDecimal, method: PaymentMethod): Unit
    }
    class PaymentServiceImpl extends PaymentService {
        def authorize(amount: BigDecimal, method: PaymentMethod): Unit = {
            println("Authorizing a payment.")
            for {
                _ <- validate(amount, method)
                _ <- callStripe(amount, method)
            } yield ()
        }
        
        private def validate(amount: BigDecimal, method: PaymentMethod): Either[String, Unit] =
            if(amount > 0) {
                ???
            }
            else {
                ???
            }

        private def callStripe(amount: BigDecimal, method: PaymentMethod): Either[String, Unit] = ???
    }
}