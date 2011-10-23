package edu.jack

import org.scalatra._
import java.net.URL
import scalate.ScalateSupport

class Shawty extends ScalatraServlet with ScalateSupport {

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        it's <a href="hello-scalate">playtime!</a>.
      </body>
    </html>
  }

  notFound {
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound() 
  }
}
