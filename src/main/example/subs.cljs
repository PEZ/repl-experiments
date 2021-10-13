(ns example.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
 :counter
 (fn [db _]
   (:counter db)))

(rf/reg-sub
 :counter-tappable?
 (fn [db _]
   (:counter-tappable? db)))

(comment
  @(rf/subscribe [:counter])
  (require '[clojure.string :as string])
  )