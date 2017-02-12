package edu.knoldus

import org.mockito.Mockito.when
import org.scalatest.FunSuite
import org.scalatest.mock.MockitoSugar

class FirstPartTest extends FunSuite with MockitoSugar {
  val folderReaderAndWriter: ReaderAndWriter = mock[ReaderAndWriter]
  val firstPart = new FirstPart(folderReaderAndWriter)

  test("capitalize should write capitalized content of files in input directory to output directory") {
    val inputDir = "src/test/resources/input"
    val outputDir = "src/test/resources/output"

    when(folderReaderAndWriter.read(inputDir)).thenReturn(Nil)
    when(folderReaderAndWriter.write(outputDir, "", Nil)).thenReturn(Nil)

    assert(firstPart.action(inputDir, outputDir))
  }
}
