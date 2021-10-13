(ns sandbox)

(def foo :foo)

(def bar (range 20))

(comment
  (def colt-express
    {:name "Colt Express"
     :categories ["Family"
                  "Strategy"]
     :play-time 40
     :ratings {:pez 5.0
               :kat 5.0
               :wiw 5.0
               :vig 3.0
               :rex 5.0
               :lun 4.0}})

  (defn average [coll]
    (/ (apply + coll) (count coll)))

  (->> colt-express
       :ratings
       vals
       average)
  )

(comment
  (defn bar
    [n]
    (cond (> n 40) (+ n 20)
          (> n 20) (- (first n) 20)
          :else 0))

  (bar 2)
  (bar 24)
  )