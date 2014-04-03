class BootStrap {
  def brokerMessagingTemplate
  def auditListener

  def init = { servletContext ->
    auditListener.brokerMessagingTemplate = brokerMessagingTemplate
  }
  def destroy = {
  }
}
