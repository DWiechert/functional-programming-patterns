package com.github.dwiechert.scala.tinyweb

trait View {
  def render(model: Map[String, List[String]]): String
}

class FunctionView(viewRenderer: (Map[String, List[String]]) => String) extends View {
  def render(model: Map[String, List[String]]) =
    try {
      viewRenderer(model)
    } catch {
      case e: Exception => throw new RenderingException(e)
    }
}