import edu.knoldus.{FirstPart, FolderReaderAndWriter}

object RunFirstPart {
  def main(args: Array[String]): Unit = {
    if (args.length < 2) {
      println("Please provide input and output directory path")
    } else {
      new FirstPart(FolderReaderAndWriter).action(args(0), args(1))
    }
  }
}
