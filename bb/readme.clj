(ns readme
  (:require [clojure.java.io :as io]))

(defn read-title-from-file [f]
  (with-open [rdr (io/reader f)]
    (-> rdr line-seq first (subs 2))))

(defn tils []
  (sequence
    (comp
      (remove #(.isDirectory %))
      (filter #(re-find #"\.md$" (.getName %)))
      (keep (fn [f]
              (let [parent (.getParent f)]
                (when (< 1 (count parent))
                  (let [category (subs parent 2)
                        nm (.getName f)]
                    {:category category
                     :title (read-title-from-file f)
                     :path (str "https://github.com/exupero/til/blob/main/" category "/" nm)}))))))
    (file-seq (io/file "."))))

(def neovim-heading
  (str "## (Neo)Vim\n"
       "I've only tested these in [Neovim](https://neovim.io/), but some of them also apply to Vim.\n"))

(defn listing [files]
  (->> files
       (group-by :category)
       (sort-by first)
       (map (fn [[category files]]
              (str (condp = category
                     "Neovim" neovim-heading
                     (str "## " category "\n"))
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

(defn generate []
  (print (readme (tils))))
