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

(reg-sub
 :textinput-text
 (fn [db _]
   (:textinput-text db)))

(reg-sub
 :cloud-text
 (fn [db _]
   (:cloud-text db)))

(reg-sub
 :all-words
 (fn [db _]
   (:all-words db)))

(reg-sub
 :cloud-words
 (fn [db _]
   (:cloud-words db)))

(comment
  (require '[clojure.string :as string])
  @(re-frame.core/subscribe [:textinput-text])
  (-> @(re-frame.core/subscribe [:textinput-text])
      (string/split #"\s+"))

  @(re-frame.core/subscribe [:cloud-words])
  (string/split nil #"\s+"))