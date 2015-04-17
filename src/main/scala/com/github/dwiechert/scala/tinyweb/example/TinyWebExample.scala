package com.github.dwiechert.scala.tinyweb.example

import com.github.dwiechert.scala.tinyweb.FunctionView
import com.github.dwiechert.scala.tinyweb.FunctionController
import com.github.dwiechert.scala.tinyweb.HttpRequest
import scala.util.Random
import com.github.dwiechert.scala.tinyweb.TinyWeb
import com.github.dwiechert.scala.tinyweb.FunctionController

class TinyWebExample {
  def greetingViewRenderer(model: Map[String, List[String]]) =
    "<h1>Friendly Greetings:</h1>\n%s".format(
      model
        getOrElse ("greetings", List[String]())
        map (renderGreeting)
        mkString "\n")

  private def renderGreeting(greeting: String) = s"<h2>$greeting</h2>"

  def greetingView = new FunctionView(greetingViewRenderer)

  def handleGreetingRequest(request: HttpRequest) = Map("greetings" -> request.body.split(",").toList.map(makeGreeting))

  private def random = new Random()
  private def greetings = Vector("Hello", "Greetings", "Saluations", "Hola")
  private def makeGreeting(name: String) = "%s, %s".format(greetings(random.nextInt(greetings.size)), name)

  def greetingController = new FunctionController(greetingView, handleGreetingRequest)
  
  def loggingFilter(request: HttpRequest) = {
    val path = request.path
    println(s"In Logging Filter - request for path: $path")
    request
  }
}