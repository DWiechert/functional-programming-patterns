(ns main.HelloWorldClojureTest
	(:require [clojure.test :refer :all]))
	
(deftest pass
	(testing "Pass"
		(is (= 1 1))))
		
;; (deftest fail
;;	(testing "Fail"
;;		(is (= 1 2))))