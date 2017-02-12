package edu.knoldus

import java.io.File

class SecondPart(folderReaderAndWriter: ReaderAndWriter) extends Assignment3(folderReaderAndWriter) {
  def action(inputUri: String, outputUri: String) = wordCount(inputUri, outputUri)

  private def wordCount(inputFolderPath: String, outputFolderPath: String) = {
    val listOfFilesWithText = folderReaderAndWriter.read(inputFolderPath)

    val outputDir = new File(outputFolderPath)
    outputDir.mkdir()

    val tasksCompleted = listOfFilesWithText.flatMap {
      case (fileName, text) =>
        val wordCount = text.flatMap(_.split("\\W+")).map(_.toLowerCase.replaceAll("[^a-z0-9]", "")).foldLeft(Map.empty[String, Int]) { (count, word) =>
          count + (word -> (count.getOrElse(word, 0) + 1))
        }

        folderReaderAndWriter.write(outputFolderPath, fileName, wordCount.map(_.toString()).toList)
    }

    tasksCompleted.filterNot(identity).isEmpty
  }
}
