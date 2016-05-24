import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import pom.Products

/**
 * add your integration spec here.
 * An integration test will fire up a whole play application in a real (or headless) browser
 */
@RunWith(classOf[JUnitRunner])
class IntegrationSpec extends Specification with Products {


  "Application" should {

    "has products on the list" in new WithBrowser {

      browser.goTo("http://localhost:9001/")
      val numberOfProducts = getProductsCount(browser)
      numberOfProducts must equalTo(1)
    }
  }

  "Application" should {

    "work from within a browser" in new WithBrowser {
      browser.goTo("http://localhost:" + port)

      //browser.pageSource must contain("Your new application is ready.")

    }
  }


}