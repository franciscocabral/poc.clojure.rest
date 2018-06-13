(ns poc.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clojure-rest.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "ok"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))

(deftest test-create-new-document
  (testing "Create new document"
    (let [response (app (-> (mock/request :post "/documents")
                            (mock/json-body {:title "doc1" :text "text1"})))]
      (is (= (:status response) 201)))))