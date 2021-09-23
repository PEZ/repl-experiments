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
