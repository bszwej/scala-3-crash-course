/**
 * Chapter 2: Enums
 */

// Enums in Scala 2 emulated with sealed traits/abstract classes
// and a combination of case objects with case classes.
sealed trait ShipmentStatus
case object InPreparation extends ShipmentStatus
case object Dispatched extends ShipmentStatus
case object InTransit  extends ShipmentStatus
case object Delivered extends ShipmentStatus

/**
 * Example 1: Simple enums
 * [] usage, compiler errors, api (values, valueOf, ordinal, fromOrdinal)
 * [] multiline enums
 * [] enum methods/companion object
 */

/**
 * Example 2: ADTs
 * [] syntax sugar
 * [] type widening
 * [] type params
 */
sealed abstract class Customer(val priority: Int) 
object Customer {
    case class Standard(name: String) extends Customer(priority = 3)
    case class Premium(name: String) extends Customer(priority = 1)
    case class Business(companyName: String, vatId: String) extends Customer(priority = 2)
}

/**
 * Exercises
 */
object enumsExercises:
    //
    // Exercise 1: Convert to Scala 3 enum syntax.
    //
    sealed trait OrderStatus {
        final def isLegalSuccessorOf(status: OrderStatus): Boolean =
            OrderStatus.legalSuccessors.getOrElse(status, Set.empty).contains(this)
    }
    object OrderStatus {
        case object Initiated extends OrderStatus
        case object Cancelled extends OrderStatus
        case object Confirmed extends OrderStatus
        case object Fulfilled extends OrderStatus
        case object Refunded extends OrderStatus
        case object Failed extends OrderStatus

        private val legalSuccessors: Map[OrderStatus, Set[OrderStatus]] = Map(
            Initiated -> Set(Confirmed, Cancelled),
            Confirmed -> Set(Fulfilled, Failed),
            Fulfilled -> Set(Refunded, Failed)
        )
    }

    //
    // Exercise 2: Implement the following ADT using the new Scala 3 enum sytanx.
    //
    sealed abstract class PaymentAuthorizationError(retriable: Boolean)
    case class IllegalPaymentStatus(existingPaymentId: PaymentId, existingPaymentStatus: PaymentStatus) extends PaymentAuthorizationError(retriable = false)
    case class IllegalRequestData(reason: String) extends PaymentAuthorizationError(retriable = false)
    case class CustomerUnknown(unknownCustomerId: CustomerId) extends PaymentAuthorizationError(retriable = false)
    case class InvalidToken(invalidToken: Token) extends PaymentAuthorizationError(retriable = true)


    // Some type aliases to make the exercise compile... 
    // We'll later see how to replace type aliases the new kind of types in Scala 3
    // called *opaque types* for better type safety.
    type PaymentId = String
    type PaymentStatus = String
    type CustomerId = String
    type Token = String
