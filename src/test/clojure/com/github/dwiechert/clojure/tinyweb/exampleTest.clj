(ns com.github.dwiechert.clojure.tinyweb.exampleTest
	(:require [clojure.test :refer :all])
  (:require [com.github.dwiechert.clojure.tinyweb.core :refer :all])
  (:require [com.github.dwiechert.clojure.tinyweb.example :refer :all]))

(def request {:path "/greeting" :body "Mike,Joe,John,Steve"})

(defn makeRequest [] 
  (tinyweb-instance request))

(deftest test
  (testing "Tinyweb"
    (is (= 200 (tinyweb-instance request)))))