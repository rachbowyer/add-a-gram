(ns add-a-gram.core
  (:gen-class)
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn- add-to-bag [bag element]
  (update bag element #(inc (or % 0))))

(defn- remove-from-bag [bag element]
  (if (= (bag element) 1)
    (dissoc bag element)
    (update bag element dec)))

(defn- bag-element-count [bag]
  (->> bag vals (reduce +)))

(defn- word->bag
  [word]
  (reduce add-to-bag {} word))

(defn- load-words []
  (-> "WORD.LST" io/resource slurp (str/split #"\n")))

(defn- create-dictionary [words]
  (reduce (fn [acc word]
            (update acc (word->bag word) #(conj (or % #{}) word))) {} words))

(defn- get-add-a-gram [dict word-bag word-list]
  (if (= (bag-element-count word-bag) 3)
    word-list
    (loop [[f & r] (keys word-bag)]
      (when (some? f)
        (let [new-word-bag (remove-from-bag word-bag f)
              anagrams     (dict new-word-bag)]
          (if (seq anagrams)
            (if-let [result
                     (get-add-a-gram dict new-word-bag (cons [f (first anagrams)] word-list))]
              result
              (recur r))
            (recur r)))))))

(defn- get-longest-add-a-gram []
  (let [word-list         (load-words)
        dict              (create-dictionary word-list)
        sorted-word-list  (sort-by (comp - count) word-list)]
    (loop [[f & r] sorted-word-list]
      (when (some? f)
        (if-let [result (get-add-a-gram dict (word->bag f) (list [nil f]))]
          result
          (recur r))))))

(defn -main [& _args]
  (get-longest-add-a-gram))

