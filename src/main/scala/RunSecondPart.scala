import edu.knoldus.{FolderReaderAndWriter, SecondPart}

object RunSecondPart {
  def main(args: Array[String]): Unit = {
    if (args.length < 2) {
      println("Please provide input and output directory path")
    } else {
      new SecondPart(FolderReaderAndWriter).action(args(0), args(1))
    }
  }
}
