package farm.terkwood

import java.time.{Instant, ZoneId, ZonedDateTime}
import java.util.UUID

package object model {
  case class Product(id: UUID, description: String)
  case class Location(
      id: UUID = UUID.randomUUID(),
      dungeonLevel: Int,
      officeNo: Int,
      generalConsensus: String = "not worth visiting"
  )

  sealed trait Events
  case class ProductPurchased(
      productId: UUID = UUID.randomUUID(),
      eventDate: ZonedDateTime = UtcNow()
  ) extends Events
  case class ProductShipped(
      productId: UUID = UUID.randomUUID(),
      locationId: UUID = UUID.randomUUID(),
      eventDate: ZonedDateTime = UtcNow()
  ) extends Events
  case class ShipmentArrived(
      productId: UUID,
      locationId: UUID,
      eventDate: ZonedDateTime = UtcNow()
  ) extends Events
}

object UtcNow {
  def apply(): ZonedDateTime =
    ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("UTC"))
}
