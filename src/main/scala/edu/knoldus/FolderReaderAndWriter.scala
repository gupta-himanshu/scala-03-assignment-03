package edu.knoldus

import java.io.{BufferedWriter, File, FileWriter, IOException}

import scala.io.Source

object FolderReaderAndWriter extends ReaderAndWriter {
  def read(inputFolderPath: String): List[(String, List[String])] = {
    var inputDir: File = null

    try {
      inputDir = new File(inputFolderPath)

      val textFiles = inputDir.listFiles().filter(_.getName.endsWith(".txt")).toList
      textFiles.map(textFile => (textFile.getName, Source.fromFile(textFile.getAbsolutePath).getLines().toList))
    } catch {
      case exception: NullPointerException =>
        println("Input directory does not exist !!!")
        Nil
    }
  }

  def write(outputFolderPath: String, fileName: String, text: List[String]): List[Boolean] = {
    val outputTextFile = new File(outputFolderPath + File.separator + fileName)
    val bufferedWriter = new BufferedWriter(new FileWriter(outputTextFile))

    try {
      text.map { line =>
        bufferedWriter.write(line)
        bufferedWriter.write("\n")
        true
      }
    } catch {
      case exception: IOException =>
        println("Got exception while writing text to output file : " + exception.getMessage)
        List(false)
    } finally {
      bufferedWriter.close()
    }
  }
}
