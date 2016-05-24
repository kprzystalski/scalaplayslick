import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification {

  "The 'Hello world' string" should {
    "contain 11 characters" in {
      "Hello world" must have size(11)
    }
    "start with 'Hello'" in {
      "Hello world" must startWith("Hello")
    }
    "end with 'world'" in {
      "Hello world" must endWith("world")
    }
  }

  "Application" should {

    "render the index page" in new WithApplication{
      val home = route(FakeRequest(GET, "/")).get
      //val fakeRequest = FakeRequest(Helpers.POST, controllers.routes.Application.createproduct().url, FakeHeaders(), """ {"name": "New Group", "collabs": ["foo", "asdf"]} """)

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain ("My first e-commerce in Play framework")
    }

    "render the index page" in new WithApplication{
      val home = route(FakeRequest(GET, "/createproduct")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain ("Add new product:")
    }

  }
}
