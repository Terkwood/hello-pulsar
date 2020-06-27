package farm.terkwood

object Hello extends Greeting with App {
  println(greeting)
}

trait Greeting {
  lazy val greeting: String = "\uD83D\uDC1B"
}
