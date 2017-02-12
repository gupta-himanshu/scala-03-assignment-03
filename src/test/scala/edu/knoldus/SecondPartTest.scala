package edu.knoldus

import org.mockito.Mockito.when
import org.scalatest.FunSuite
import org.scalatest.mock.MockitoSugar

class SecondPartTest extends FunSuite with MockitoSugar {
  val folderReaderAndWriter = mock[ReaderAndWriter]
  val secondPart = new SecondPart(folderReaderAndWriter)

  test("word count should write word count of content of files in input directory to output directory") {
    val inputDir = "src/test/resources/input"
    val outputDir = "src/test/resources/output"

    when(folderReaderAndWriter.read(inputDir)).thenReturn(Nil)
    when(folderReaderAndWriter.write(outputDir, "", Nil)).thenReturn(Nil)

    assert(secondPart.action(inputDir, outputDir))
  }
}
