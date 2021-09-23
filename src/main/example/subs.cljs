(ns example.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
 :counter
 (fn [db _]
   (:counter db)))

(reg-sub
 :counter-tappable?
 (fn [db _]
   (:counter-tappable? db)))

(comment
  (require '[clojure.string :as string])
  )