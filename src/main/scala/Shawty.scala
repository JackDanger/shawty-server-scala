package edu.jack

import org.scalatra._
import java.net.URL

class Shawty extends ScalatraServlet {

  val top = """<body style='line-height: 1.8em; font-family: Archer, Museo, Helvetica, Georgia; font-size 25px; text-align: center; padding-top: 20%;'> 
    Post to '/' to save a url and receive a plaintext short url in response. Example: \
    <pre style='font-family: Iconsolata, monospace;background-color:#EEE'>curl -X POST http://"""
  val bottom = """/http://some.url/at.someplace</pre> \
    <br /> \
     <form action=/ method=POST onsubmit='if(\"\"==this.url.value)return false;else{this.action=\"/\"+this.url.value}'> \
       <input type=text name='url' /> \
       <input type=submit value='Get Shawty' /> \
     </form> \
     <small>Also, try <a href='http://github.com/JackDanger/shawty-client'>the official Ruby client</a></small> \
  </body>"""

  get("/") {
    var host = if(null != request.getRemoteHost)
                request.getRemoteHost
              else
                "localhost"
    println(host)
    top + host + bottom
  }
}
