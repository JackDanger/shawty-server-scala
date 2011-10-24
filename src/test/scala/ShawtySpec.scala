package edu.jack

import org.scalatra._
import edu.jack._
import org.scalatra.test.scalatest._
import org.scalatest.matchers._

class ShawtySpec extends ScalatraFunSuite with ShouldMatchers {
  addServlet(classOf[Shawty], "/*")

  test("GET / main page content") {
    get("/") {
      status should equal (200)
      body should include ("to save a url")
    }
  }

  test("GET /:short") {
    get("/abc123") {
      status should equal (301)
      response.getHeader("Location") should equal ("http://example.com/page.html")
    }
  }

  test("POST /:url for the first time") {
    post("/http://example.com/page.html") {
      status should equal (201)
      response.getHeader("Location") should equal ("http://example.com/page.html")
    }
  }

  test("POST /:url for an existing URL") {
    post("/http://example.com/page.html") {
      status should equal (201)
      response.getHeader("Location") should equal ("http://example.com/page.html")
    }
  }

  test("GET /:missing_short") {
    get("/missing") {
      status should equal (404)
    }
  }

}
