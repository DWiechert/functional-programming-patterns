package com.github.dwiechert.scala.tinyweb

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import com.github.dwiechert.scala.tinyweb.example.TinyWebExample

@RunWith(classOf[JUnitRunner])
class TinyWebTest extends FunSuite {
  test("test") {
    val tinyWebExample = new TinyWebExample

    def tinyWeb = new TinyWeb(Map("/greeting" -> tinyWebExample.greetingController), List(tinyWebExample.loggingFilter))
    def request = HttpRequest(body = "Mike,Joe,John,Steve", path = "/greeting", headers = null)

    val response = tinyWeb.handleRequest(request).get
    val responseCode = response.responseCode
    val responseBody = response.body

    println(s"resposneCode: $responseCode")
    println(s"resposneBody:\n$responseBody")

    assert(200 === responseCode)
    assert(responseBody.startsWith("<h1>Friendly Greetings:</h1>"))
    assert(5 === responseBody.split("\n").length)
  }
}