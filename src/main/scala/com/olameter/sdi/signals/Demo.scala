object Demo {
  def main(args: Array[String]): Unit = {
    val mainThread = Thread.currentThread()

    // Make sure keepRunning will be updated accross Threads with @volatile
    @volatile var keepRunning = true

    // We register a Thread to be execte
    Runtime.getRuntime.addShutdownHook(new Thread() {
      override def run(): Unit = {
        println("say good bye. Inside addShutDownHook handler")
        keepRunning = false
        mainThread.join()
      }
    })

    //  Executing our main actions until keepRunning change.
    while (keepRunning)(println("Hello, world"))

    println("Goodbye!")
  }
}
