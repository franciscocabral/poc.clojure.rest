(ns poc.routes
  (:use compojure.core)
  (:require [compojure.route :as route]
            [poc.controllers.documents :as docs]))

(defroutes app-routes
  (GET "/" [] "ok")
  (context "/documents" []  (defroutes documents-routes)
    (GET "/" [] (docs/get-all-documents))
    (POST "/" {body :body} (docs/create-new-document body))
    (context "/:id" [id] (defroutes document-routes)
      (GET "/" [] (docs/get-document id))
      (PUT "/" {body :body} (docs/update-document id body))
      (DELETE "/" [] (docs/delete-document id))))
  (route/not-found "Not Found"))
