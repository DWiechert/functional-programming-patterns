(ns com.github.dwiechert.clojure.tinyweb.stepone
  (:import (com.github.dwiechert.java.tinyweb HttpRequest HttpRequest$Builder)))

(defn test-controller [http-request]
  {:name (.getBody http-request)})

(def test-builder (HttpRequest$Builder/newBuilder))

(def test-http-request (.. test-builder (body "Mike") (path "/say-hello") build))

(defn test-controller-with-map [http-request]
  {:name (http-request :body)})