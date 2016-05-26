(ns guestbook.test.handler
  (:import [org.openqa.selenium JavascriptExecutor By OutputType WebDriver WebElement WebDriverException NoAlertPresentException])
  (:import [org.openqa.selenium.chrome ChromeDriver])
  (:import [org.openqa.selenium.firefox FirefoxDriver FirefoxBinary FirefoxProfile])
  ;(:import [org.openqa.selenium.htmlunit HtmlUnitDriver])
  (:import [org.openqa.selenium.support.ui Select])
  (:import [org.openqa.selenium.interactions Actions Action])
  (:import [org.openqa.selenium.remote DesiredCapabilities RemoteWebDriver])
  (:import [org.openqa.selenium.support.ui ExpectedCondition WebDriverWait])
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer :all]
            [guestbook.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response ((app) (request :get "/"))]
      (is (= 200 (:status response)))))

  (testing "not-found route"
    (let [response ((app) (request :get "/invalid"))]
      (is (= 404 (:status response))))))

(deftest is-broken
  (testing "that this gets triggered"
   (is (= 25 25))))

(defn firefox [] (new FirefoxDriver))

(deftest a-test
  (testing "FIXME, I fail."
    (let [fd (firefox)]
      (.get fd "http://localhost:3000")
      (is (= "Welcome to guestbook" (.getTitle fd)))
      (Thread/sleep 2000)
      (.quit fd))))