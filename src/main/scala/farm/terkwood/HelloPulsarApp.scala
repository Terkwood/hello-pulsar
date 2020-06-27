package farm.terkwood

import model.{ProductPurchased, ProductShipped, ShipmentArrived}
import pulsar.{Client, Writer}

object HelloPulsarApp extends Greeting with App {
  println(greeting)

  val client = Client.create()
  val writer = Writer(client)

  val firstPurchase = ProductPurchased()
  val firstShipment = ProductShipped(productId = firstPurchase.productId)
  val firstArrival = ShipmentArrived(
    productId = firstPurchase.productId,
    locationId = firstShipment.locationId
  )
  writer.send(firstPurchase)
  writer.send(firstShipment)
  writer.send(firstArrival)
}

trait Greeting {
  lazy val greeting: String = "\uD83D\uDC1B  OK hello"
}
