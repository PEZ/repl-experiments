(ns example.events
  (:require
   [re-frame.core :refer [reg-event-db]]
   [example.db :as db :refer [app-db]]))

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

(reg-event-db
 :set-cloud-text
 (fn [db [_ text]]
   (assoc db :cloud-text text)))