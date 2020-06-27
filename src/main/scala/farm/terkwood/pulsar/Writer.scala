package farm.terkwood.pulsar

import farm.terkwood.model.{
  Events,
  ProductPurchased,
  ProductShipped,
  ShipmentArrived
}
import org.apache.pulsar.client.api.{Producer, PulsarClient}

object Writer {
  def apply(client: PulsarClient): Writer = {
    val purchased = mkProd(client, "product-purchased")
    val shipped = mkProd(client, "product-shipped")
    val arrived = mkProd(client, "shipment-arrived")
    new Writer({
      case ProductPurchased(productId, eventDate)            => purchased
      case ProductShipped(productId, locationId, eventDate)  => shipped
      case ShipmentArrived(productId, locationId, eventDate) => arrived
    })
  }

  private def mkProd(client: PulsarClient, topic: String) =
    client.newProducer().topic(topic).create()
}

class Writer(pickProducer: Events => Producer[Array[Byte]]) {
  def send[T](events: Events): Unit = {
    pickProducer(events).send("Hello".getBytes())
  }
}
