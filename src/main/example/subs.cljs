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
 :all-words
 (fn [db _]
   (:all-words db)))

(defn choose-cloud-words [all-words]
  (->> all-words
       (sort-by second)
       (take-last 100)))

(reg-sub
 :cloud-words
 :<- [:all-words]
 (fn [all-words _]
   (choose-cloud-words all-words)))

(comment
  (require '[clojure.string :as string])
  @(re-frame.core/subscribe [:textinput-text])
  (-> @(re-frame.core/subscribe [:textinput-text])
      (string/split #"\s+"))

  @(re-frame.core/subscribe [:cloud-words])
  (string/split nil #"\s+"))