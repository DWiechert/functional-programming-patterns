package main

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class HelloWorldScalaTest extends FunSuite {
	test("pass") {
		assert(true)
	}
	
	test("fail") {
		assert(1 === 2)
	}
}