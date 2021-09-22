(ns example.subs
  (:require [re-frame.core :refer [reg-sub]]
            [example.fizz-buzz :refer [fizz-buzz]]))

(reg-sub
 :get-counter
 (fn [db _]
   (:counter db)))

(reg-sub
 :fb-counter
 (fn [db _]
   (fizz-buzz (:counter db))))

(reg-sub
 :counter-tappable?
 (fn [db _]
   (:counter-tappable? db)))