(ns com.github.dwiechert.clojure.tinyweb.exampleTest
	(:require [clojure.test :refer :all])
  (:require [com.github.dwiechert.clojure.tinyweb.core :refer :all])
  (:require [com.github.dwiechert.clojure.tinyweb.example :refer :all]))

(def request {:path "/greetings" :body "Mike,Joe,John,Steve"})

(defn makeRequest [] 
  (tinyweb-instance request))

(deftest test
  (testing "Tinyweb"
     (let [response (makeRequest)]
       (is (= 200 (response :status-code)))
       (not (= "" (response :body))))))