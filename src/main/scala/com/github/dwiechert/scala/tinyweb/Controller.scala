package com.github.dwiechert.scala.tinyweb

trait Controller {
  def handleRequest(request: HttpRequest): HttpResponse
}

class FunctionController(view: View, doRequest: (HttpRequest) => Map[String, List[String]]) extends Controller {
  def handleRequest(request: HttpRequest): HttpResponse = {
    try {
      val model = doRequest(request)
      val responseBody = view.render(model)
      HttpResponse(responseBody, 200)
    } catch {
      case e: ControllerException =>
        HttpResponse("", e.statusCode)
      case e: RenderingException =>
        HttpResponse("Exception while rendering.", 500)
      case e: Exception =>
        HttpResponse("", 500)
    }
  }
}