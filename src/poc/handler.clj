(ns poc.handler
  (:use compojure.core)

  (:require [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [poc.routes :as routes]
            [poc.database :as db]))

(db/init)

(def app
  (-> (handler/api routes/app-routes)
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)))