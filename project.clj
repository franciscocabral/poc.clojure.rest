(defproject clojure-rest "0.1.0-SNAPSHOT"
  :description "Just a POC of a RESTAPI in clojure"
  :url "http://github.com/franciscocabral"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-json "0.4.0"]
                 [c3p0/c3p0 "0.9.1.2"]
                 [org.clojure/java.jdbc "0.7.6"]
                 [com.h2database/h2 "1.4.197"]
                 [cheshire "5.8.0"]]
  :plugins [[lein-ring "0.9.7"]
            [lein-cljfmt "0.5.7"]]
  :ring {:handler poc.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
