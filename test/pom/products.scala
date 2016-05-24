package pom

import play.api.test.TestBrowser

/**
  * Created by kprzystalski on 23/05/16.
  */
trait ProducListPage {

  def getProductsCount(browser :TestBrowser): Int = {
    //browser.$("#add").click()
    browser.find(".product").size()
  }

  def getProductName(browser: TestBrowser, product_id: Int): String = {
    "test"
  }

  def addProduct(browser: TestBrowser, name: String, description: String, price: Int): Boolean\ {



  }



}
