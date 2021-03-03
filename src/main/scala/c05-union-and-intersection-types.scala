/**
 * Chapter 5: Union and intersection types
 */

object UnionTypes:
    /**
     * Example 1: Basics
     * [] Union type
     * [] Commutativity
     * [] Union types vs either
     */
    val x: Boolean = true

    def f(in: Boolean): String = in match {
        case _: Boolean => "bool"
    }

    // How many values does type `Either[Boolean, Boolean]` have?
    // How many values does type `Boolean | Boolean` have?

    /**
     * Example 2: What type will be inferred?
     */
    val what = if(1==1) "a" else 10

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

    val value = for 
        _ <- error1
        _ <- error2
    yield ()

// object IntersectionTypes:
//     tbd
