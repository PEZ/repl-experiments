(ns example.fizz-buzz
  (:require [re-frame.core :as rf]))

(defn multiple-of? [n d]
  (zero? (mod n d)))

(defn fizz-buzz [n]
  (cond
    (multiple-of? n (* 3 5)) "FizzBuzz"
    (multiple-of? n 3) "Fizz"
    (multiple-of? n 5) "Buzz"
    :else n))

(comment

  (def nums (range 1 100))
  
  (->> nums
       (map fizz-buzz))

  (-> @(rf/subscribe [:get-counter])
      (mod 3)
      (zero?))
  
  (->> nums
       (map (fn [n] (multiple-of? n 2))))
  )