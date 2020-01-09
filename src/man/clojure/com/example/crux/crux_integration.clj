(ns com.exmaple.crux
    (:require [clojure.java.io :as io]
              [clojure.string :as str]
              ))



(defn str->keyword
   "Converts string to a keyword"
  [s] ( -> s (str/replace #"^:" "") keyword))