package edu.knoldus

abstract class Assignment3(readerAndWriter: ReaderAndWriter) {
  def action(inputUri: String, outputUri: String): Boolean
}
