(ns example.app
  (:require [example.events]
            [example.subs]
            [example.widgets :refer [button]]
            [expo.root :as expo-root]
            ["expo-status-bar" :refer [StatusBar]]
            [re-frame.core :as rf]
            ["react-native" :as rn]
            [reagent.core :as r]))

(def shadow-splash (js/require "../assets/shadow-cljs.png"))
(def cljs-splash (js/require "../assets/cljs.png"))

(defn root []
  (let [counter @(rf/subscribe [:counter])
        tap-enabled? @(rf/subscribe [:counter-tappable?])]
    [:> rn/SafeAreaView {:style {:flex 1
                                 :flex-direction :column
                                 :justify-content :space-between
                                 :background-color :white}}
     [:> rn/View {:style {:flex 1
                          :align-items :center}}
      [:> rn/Text {:style {:font-weight   :bold
                           :font-size     72
                           :color         :blue
                           :margin-bottom 20}} counter]
      [button {:on-press (fn [_e]
                           (rf/dispatch [:inc-counter]))
               :disabled? (not tap-enabled?)
               :style {:background-color :blue}}
       "Tap me, I'll count"]]
     [:> rn/View {:style {:flex 1
                          :justify-content :flex-end}}
      [:> rn/View {:style {:flex 1
                           :flex-direction :row
                           :align-items :flex-end
                           :justify-content :space-around
                           :margin-bottom 15}}
       [:> rn/View {:style {:margin 0}}
        [:> rn/Image {:style {:width  180
                              :height 180}
                      :source cljs-splash}]]
       [:> rn/View {:style {:margin 0}}
        [:> rn/Image {:style {:width  180
                              :height 180}
                      :source shadow-splash}]]]
      [:> rn/Text {:style {:align-self :center
                           :font-weight :normal
                           :font-size   19.3
                           :color       :blue}}
       "Using: shadow-cljs+expo+reagent+re-frame"]]
     [:> StatusBar {:style "auto"}]]))

(comment
  (rf/dispatch [:set-counter-tapable false])
  (rf/dispatch [:set-counter-tapable true])
  )

(defn start
  {:dev/after-load true}
  []
  (expo-root/render-root (r/as-element [#'root])))

(defn init []
  (rf/dispatch-sync [:initialize-db])
  (start))