(ns poc.controllers.documents
  (:use compojure.core)
  (:use cheshire.core)
  (:use ring.util.response)
  (:require [clojure.java.jdbc :as sql]
            [poc.database :as db]))

(defn uuid [] (str (java.util.UUID/randomUUID)))

(defn get-all-documents []
  (response
   (sql/query db/spec ["select * from documents"])))

(defn get-document [id]
  (let [results (into [] (sql/query db/spec ["select * from documents where id = ?" id]))]
    (cond
      (empty? results) {:status 404}
      :else (response (first results)))))

(defn create-new-document [doc]
  (let [id (uuid)]
    (let [document (assoc doc "id" id)]
      (sql/insert! db/spec :documents document))
    (get-document id)))

(defn update-document [id doc]
  (let [document (assoc doc "id" id)]
    (sql/update! db/spec :documents ["id=?" id] document))
  (get-document id))

(defn delete-document [id]
  (sql/delete! db/spec :documents ["id=?" id])
  {:status 204})