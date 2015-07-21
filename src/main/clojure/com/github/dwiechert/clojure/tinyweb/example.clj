(ns com.github.dwiechert.clojure.tinyweb.example
  (:require [clojure.string :as str])
  (:require [com.github.dwiechert.clojure.tinyweb.core :refer :all]))

(defn make-greeting [name]
  (let [greetings ["Hello" "Greetings" "Salutations" "Hola"]
        greeting-count (count greetings)]
    (str (greetings (rand-int greeting-count)) ", " name)))

(defn handle-greeting [http-request]
  {:greetings (map make-greeting (str/split (:body http-request) #","))})

(defn render-greeting [greeting]
  (str "<h2>"greeting"</h2>"))

(defn greeting-view [model]
  (let [render-greetings (str/join " " (map render-greeting (:greetings model)))]
    (str "<h1>Friendly Greetings</h1> " render-greetings)))

(defn logging-filter [http-request]
  (println (str "In Logging Filter - request for path: " (:path http-request)))
  http-request)

(def request-handlers
  {"/greetings" {:controller handle-greeting :view greeting-view}})

(def filters [logging-filter])

(def tinyweb-instance (tinyweb request-handlers filters))