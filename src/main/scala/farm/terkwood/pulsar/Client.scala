package farm.terkwood.pulsar

import org.apache.pulsar.client.api.PulsarClient

object Client {
  def create(): PulsarClient =
    PulsarClient
      .builder()
      .serviceUrl(Config.protocolUrl)
      .build()
}
