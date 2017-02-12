package edu.knoldus

abstract class ReaderAndWriter {
  def read(inputUri: String): List[(String, List[String])]
  def write(outputUri: String, name: String, text: List[String]): List[Boolean]
}
