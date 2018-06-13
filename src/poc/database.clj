(ns poc.database
  (:require [clojure.java.jdbc :as sql]))

(def spec
  {:dbtype "h2:mem"
   :dbname "mydb"})

(def create-table
  (sql/create-table-ddl :documents
                        [[:id "varchar(256)" :primary :key]
                         [:title "varchar(256)"]
                         [:text :varchar]]))

(defn init [] (sql/db-do-commands spec [create-table]))

