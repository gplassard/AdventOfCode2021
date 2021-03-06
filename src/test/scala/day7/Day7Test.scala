package fr.gplassard.adventofcode2021
package day7

import day4.Day4.Board

import fr.gplassard.adventofcode2021.day6.Day6.{FishesOfAge, State}
import org.scalatest.*
import org.scalatest.matchers.should.*
import org.scalatest.wordspec.AnyWordSpec

import java.nio.file.{Files, Paths}
import scala.io.Source
import scala.jdk.StreamConverters.*

class Day7Test extends AnyWordSpec with Matchers {

  "optimalPosition" should {
    "work for single element" in {
      val result = Day7.optimalPosition(List(1))
      result should equal(1)
    }
    "work for two elements" in {
      // 1 => 0 + 3 = 3
      // 2 => 1 + 2 = 3
      // 3 => 2 + 1 = 3
      // 4 => 3 + 0 = 3
      val result = Day7.optimalPosition(List(1, 4))
      result should be >= 1
      result should be <= 4
    }
    "work for three elements" in {
      // 2 => 1 + 0 + 4 = 5
      // 3 => 2 + 1 + 3 = 6
      val result = Day7.optimalPosition(List(1, 2, 6))
      result should equal(2)
    }
    "work for for elements" in {
      // 2 => 1 + 0 + 4 + 4 = 9
      // 3 => 2 + 1 + 3 + 3 = 9
      // 4 => 3 + 2 + 2 + 2 = 9
      // 5 => 4 + 3 + 1 + 1 = 9
      // 6 => 5 + 4 + 0 + 0 = 9
      val result = Day7.optimalPosition(List(1, 2, 6, 6))
      result should be >= 2
      result should be <= 6
    }
    "work for sample" in {
      val result = Day7.optimalPosition(List(16, 1, 2, 0, 4, 2, 7, 1, 2, 14))
      result should equal(2)
    }
  }

  "part1" should {
    "work for sample" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day7/sample.txt")).toScala(List)
      Day7.part1(inputs) should equal(37)
    }
    "work for input" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day7/input.txt")).toScala(List)
      Day7.part1(inputs) should equal(344297)
    }
  }


  "optimalPositionPart2" should {
    "work for single element" in {
      val result = Day7.optimalPositionPart2(List(1))
      result should equal(List(0, 1, 2))
    }
    "work for two elements" in {
      // 1 => 0 + (1 + 2 + 3) = 6
      // 2 => 1 + (1 + 2) = 4
      // 3 => (1 + 2) + 1 = 4
      // 4 => (1 + 2 + 3) + 0 = 6
      val result = Day7.optimalPositionPart2(List(1, 4))
      result should equal(List(2, 3, 4))
    }
    "work for three elements" in {
      // 2 => 1 + 0 + (1 + 2 + 3 + 4) = 11
      // 3 => (1 + 2) + 1 + (1 + 2 + 3) = 10
      // 4 => (1 + 2 + 3) + (1 + 2) + (1 + 2) = 12
      val result = Day7.optimalPositionPart2(List(1, 2, 6))
      result should equal(List(2, 3, 4))
    }
    "work for sample" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day7/sample.txt")).toScala(List).flatMap(_.split(",")).map(_.toInt)

      val result = Day7.optimalPositionPart2(inputs)
      result should equal(List(4, 5, 6))
    }
    "work for input" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day7/input.txt")).toScala(List).flatMap(_.split(",")).map(_.toInt)
      val result = Day7.optimalPositionPart2(inputs)
      result should equal(List(465, 466, 467))
    }
  }

  "costPart2" should {
    "be 0 for distance 0" in {
      Day7.costPart2(0) should equal(0)
    }
    "be 1 for distance 1" in {
      Day7.costPart2(1) should equal(1)
    }
    "be 3 for distance 2" in {
      Day7.costPart2(2) should equal(3)
    }
    "be 6 for distance 3" in {
      Day7.costPart2(3) should equal(6)
    }
  }

  "part2" should {
    "work for sample" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day7/sample.txt")).toScala(List)
      Day7.part2(inputs) should equal(168)
    }
    "work for input" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day7/input.txt")).toScala(List)
      Day7.part2(inputs) should equal(97164301)
    }
  }

}
