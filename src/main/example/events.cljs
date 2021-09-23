(ns example.events
  (:require
   [re-frame.core :refer [reg-event-db]]
   [example.db :as db :refer [app-db]]
   [clojure.string :as string]
   [example.some-data :as some-data]))

(reg-event-db
 :initialize-db
 (fn [_ _]
   app-db))

(reg-event-db
 :inc-counter
 (fn [db [_ _]]
   (update db :counter inc)))

(reg-event-db
 :set-counter-tapable
 (fn [db [_ v]]
   (assoc db :counter-tappable? v)))

(reg-event-db
 :set-textinput-text
 (fn [db [_ text]]
   (assoc db :textinput-text text)))

(defn extract-words-counted [text]
  (->> (string/split text #"\s+")
       (map (fn [w] (string/replace w #"[-\W]" "")))
       (map string/lower-case)
       (remove some-data/common-words)
       (frequencies)))

(defn choose-cloud-words [all-words]
  (->> all-words
       (sort-by second)
       (take-last 100)
       (shuffle)))

(reg-event-db
 :update-cloud
 (fn [db [_ text]]
   (let [all-words (extract-words-counted text)
         cloud-words (choose-cloud-words all-words)]
     (assoc db 
            :all-words all-words
            :cloud-words cloud-words))))