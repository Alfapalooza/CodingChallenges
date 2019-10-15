package coding

trait TestPrinterSupport {
  def tracingEnabled: Boolean

  def trace[T](traced: T): Unit =
    if (tracingEnabled) println(traced)
}
