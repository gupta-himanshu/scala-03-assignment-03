package edu.knoldus

import java.io.File

import org.scalatest.FunSuite
import org.scalatest.mock.MockitoSugar

import scala.io.Source

class FolderReaderAndWriterTest extends FunSuite with MockitoSugar {
  val folderReaderAndWriter = FolderReaderAndWriter

  test("read folder should return the list of files in a folder") {
    val inputDir = "src/test/resources/input"
    val result = folderReaderAndWriter.read(inputDir)

    assert(!result.isEmpty)
  }

  test("read folder should not return the list of files in a folder which does not exist") {
    val inputDir = "input"
    val result = folderReaderAndWriter.read(inputDir)

    assert(result.isEmpty)
  }

  test("writeText should write the contents of files in a folder") {
    val inputDir = "src/test/resources/input"
    val outputDir = "src/test/resources/output"
    val listFiles = new File(inputDir).listFiles().toList
    val lines = listFiles.map(file => (file.getName, Source.fromFile(file.getAbsolutePath).getLines().toList))
    val result = folderReaderAndWriter.write(outputDir, lines(0)._1, lines(1)._2)

    assert(!result.isEmpty)
  }
}
