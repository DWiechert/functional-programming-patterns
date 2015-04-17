package com.github.dwiechert.scala.tinyweb

case class HttpRequest(headers: Map[String, String], body: String, path: String)
case class HttpResponse(body: String, responseCode: Int)