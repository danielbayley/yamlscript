;; Copyright 2023 Ingy dot Net
;; This code is licensed under MIT license (See License for details)

(ns yamlscript.ast
  (:use yamlscript.debug)
  (:refer-clojure :exclude [Long]))

(defn List [list] {:List (vec list)})

(defn Vec [list] {:Vec (vec list)})

(defn Map [list]
  (if (even? (count list))
    {:Map (->> list
            (apply array-map)
            (mapcat seq)
            vec
            #__)}
    (throw (Exception. "Odd number of elements in map"))))

(defn True [] :True)
(defn False [] :False)
(defn Nil [] :Nil)

(defn Sym [s] {:Sym (symbol s)})

(defn Char [s] {:Char (symbol s)})

(defn LNum [s] {:LNum (parse-long s)})

(defn Str [s] {:Str (str s)})

(defn Key [s] {:Key (keyword s)})

nil
