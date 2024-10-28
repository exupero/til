(ns build-readme
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn tils []
  (sequence
    (comp
      (remove #(.isDirectory %))
      (filter #(re-find #"\.md$" (.getName %)))
      (keep (fn [f]
              (let [parent (.getParent f)]
                (when (< 1 (count parent))
                  (let [category (subs parent 2)
                        nm (.getName f)
                        title (subs nm 0 (- (count nm) 3))]
                    {:category category
                     :title title
                     :path (str "https://github.com/exupero/til/blob/main/"
                                category "/"
                                (str/replace title " " "%20") ".md")}))))))
    (file-seq (io/file "."))))

(defn listing [files]
  (->> files
       (group-by :category)
       (sort-by first)
       (map (fn [[category files]]
              (str "## " category "\n"
                   (->> files
                        (sort-by :title)
                        (map-indexed (fn [i {:keys [title path]}]
                                       (str (inc i) ". [" title "](" path ")")))
                        (transduce (interpose "\n") str)))))
       (transduce (interpose "\n\n") str)))

(defn readme [files]
  (str
    "# TIL - Today I Learned\n\n"
    "A collection of concise write-ups on small things I learn day to day across a variety of languages and technologies. Inspired by [jbranchaud/til](https://github.com/jbranchaud/til) and [simonw/til](https://github.com/simonw/til).\n\n"
    (count files) " TILs\n\n---\n\n"
    (listing files)))

(when (= *file* (System/getProperty "babashka.file"))
  (print (readme (tils))))
