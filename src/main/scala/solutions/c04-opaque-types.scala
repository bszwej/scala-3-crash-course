package solutions

/**
 * Chapter 4: Opaque types
 */

object AnyValDrawbacks:
    object ValueClasses:
        case class PaymentId(id: String) extends AnyVal
        val paymentId = PaymentId("abc")
        def printName(paymentId: PaymentId) = println(paymentId.id)
        // val somePaymentId: Option[PaymentId] = Some(PaymentId("abc")) // this will box :(
    // More on that: https://failex.blogspot.com/2017/04/the-high-cost-of-anyval-subclasses.html

object OpaqueTypes:
    /**
     * Example 1: From value classes to Opaque Types.
     */
    opaque type FirstName = String

    /**
     * Example 2: Defining companion object with constructors and extensions.
     */
    object FirstName:
        def fromString(str: String): FirstName = str

    extension (firstName: FirstName) def value: String = firstName

    /**
     * Example 3: Type bounds.
     */
    opaque type MiddleName >: String = String // LOWER type bound. MiddleName is a supertype of String.
    opaque type LastName <: String = String // UPPER type bound. LastName is a subtype of String.
    object LastName:
        def fromString(str: String): LastName = str

object OpaqueTypesUsage:
    import OpaqueTypes._
    // val firstName: FirstName = "name" // does not compile as types do not match
    val middleName: MiddleName = "middle name" // works, because String is a subtype of MiddleName
    val lastName: String = LastName.fromString("last name") // works, because LastName is a subtype of String

/**
 * Exercises
 */

//
// Exercise 1: Use Opaque types.
//
object OpaqueTypeExercises:
    import java.util.Locale

    opaque type Country = String
    object Country:
        private val validCodes = Locale.getISOCountries
        
        def fromIso2CountryCode(code: String): Option[Country] = Some(code).filter(validCodes.contains).map(_ => code)
        
        def unsafeFromIso2CountryCode(code: String): Country = fromIso2CountryCode(code)
            .getOrElse(throw new IllegalStateException(s"Cannot parse country from String. Expected country code. Got '$code'."))
        
        val Germany: Country       = "DE"
        val UnitedKingdom: Country = "GB"
    
    extension (country: Country) def code: String = country

@main def opaqueTypeExercisesMain =
    import OpaqueTypeExercises._
    val country: Option[Country] = Country.fromIso2CountryCode("DE")
    println(country)
    println(country.map(_.code))
