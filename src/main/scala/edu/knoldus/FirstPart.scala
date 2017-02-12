package edu.knoldus

import java.io.File

class FirstPart(folderReaderAndWriter: ReaderAndWriter) extends Assignment3(folderReaderAndWriter) {
  def action(inputFolderPath: String, outputFolderPath: String) =
    capitalize(inputFolderPath, outputFolderPath)

  private def capitalize(inputFolderPath: String, outputFolderPath: String) = {
    val listOfFilesWithText = folderReaderAndWriter.read(inputFolderPath)

    new File(outputFolderPath).mkdir()

    val tasksCompleted = listOfFilesWithText.flatMap {
      case (fileName, text) =>
        folderReaderAndWriter.write(outputFolderPath, fileName, text.map(_.toUpperCase))
    }

    tasksCompleted.filterNot(identity).isEmpty
  }
}
