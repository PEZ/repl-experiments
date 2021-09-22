(ns example.subs
  (:require [re-frame.core :refer [reg-sub]]
            [example.fizz-buzz :refer [fizz-buzz]]
            [example.some-data :as some-data]
            [clojure.string :as string]))

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

(defn words-and-frequencies [words]
  (->> words
       (frequencies)))

(defn grab-words [text]
  (->> (string/split text #"\s+")
       (map (fn [w] (string/replace w #"[-\W]" "")))
       ;(map (fn [w] (string/replace w #"[’']s" "")))
       (map string/lower-case)
       (remove some-data/common-words)))

(reg-sub
 :words
 :<- [:cloud-text]
 (fn [text _]
   (-> text
       (grab-words)
       (words-and-frequencies))))

(comment
  @(re-frame.core/subscribe [:textinput-text])
  (-> @(re-frame.core/subscribe [:cloud-text])
      (string/split #"\s+"))

  (-> (grab-words @(re-frame.core/subscribe [:textinput-text]))
      words-and-frequencies)

  @(re-frame.core/subscribe [:words])
  (string/split nil #"\s+")
  )