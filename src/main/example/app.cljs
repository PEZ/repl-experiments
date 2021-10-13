(ns example.app
  (:require [example.events]
            [example.subs]
            [example.widgets :refer [button]]
            [example.some-data :as some-data]
            [expo.root :as expo-root]
            ["expo-status-bar" :refer [StatusBar]]
            [re-frame.core :as rf]
            ["react-native" :as rn]
            [reagent.core :as r]))

(def shadow-splash (js/require "../assets/shadow-cljs.png"))
(def cljs-splash (js/require "../assets/cljs.png"))

(defonce words-atom (r/atom nil))

(defn input-widget [{:keys [style]}]
  (let [text @(rf/subscribe [:textinput-text])]
    [:> rn/View {:style style}
     [:> rn/View {:style {:flex 4
                          :align-items :stretch}}
      [:> rn/TextInput {:multiline true
                        :scroll-enabled true
                        :value text
                        :on-change-text (fn [t]
                                          (rf/dispatch-sync [:set-textinput-text t])
                                          (r/flush))
                        :style {:flex 1
                                :margin 10
                                :padding 5
                                :font-size 14
                                :color :blue
                                :border-width 1}}]]
     [:> rn/View {:style {:flex 1
                          :align-self :center
                          :justify-content :center}}
      [button {:on-press (fn [_e]
                           (rf/dispatch-sync [:update-cloud-text text])
                           (reset! words-atom (-> @(rf/subscribe [:cloud-words])
                                                  (shuffle))))
               :style {:background-color :blue}}
       "Work!"]]]))

(defn most-frequent [words]
  (->> words
       (sort-by second)
       (last)
       (second)))

(def largest-font-size 48)
(def smallest-font-size 10)

(defn font-size [freq highest]
  (let [multiplier (/ (- largest-font-size smallest-font-size) highest)]
    (+ smallest-font-size (* multiplier freq))))

(comment
  (def largest-font-size 48)
  (def smallest-font-size 10)
  (def highest 12)
  (def freq 1)
  (def multiplier (/ (- largest-font-size smallest-font-size) highest))
  (+ smallest-font-size (* multiplier freq))
  (-> 0
      ((fn font-size [freq highest]
         (let [multiplier (/ (- largest-font-size smallest-font-size) highest)]
           (+ smallest-font-size (* multiplier freq))))
       (most-frequent @(rf/subscribe [:words]))))
  )

(defn word-cloud [{:keys [style]}]
  (let [all-words @(rf/subscribe [:all-words])
        highest-freq (most-frequent all-words)]
    [:> rn/View style
     [:> rn/ScrollView {:style {:flex 1
                                :padding 10}}
      (into
       [:> rn/View {:style {:flex 1
                            :flex-direction :row
                            :justify-content :center
                            :align-items :center
                            :margin 10
                            :flex-wrap :wrap}}]
       (map-indexed (fn [i [word freq]]
                      [:> rn/Text {:key i
                                   :style {:font-size (font-size freq highest-freq)
                                           :padding-horizontal 4
                                           :margin-vertical 1
                                           :margin-horizontal 2
                                           :border-radius 3}}
                       word])
                    @words-atom))]]))

(defn new-root []
  [:> rn/SafeAreaView {:style {:flex 1
                               :justify-content :space-between
                               :background-color :white}}
   [input-widget {:style {:flex 5}}]
   [word-cloud {:style {:flex 8}}]
   [:> StatusBar {:style "auto"}]])

(defn root []
  (let [counter @(rf/subscribe [:fizz-buzz])
        tap-enabled? @(rf/subscribe [:counter-tappable?])]
    [:> rn/View {:style {:flex 1
                         :padding-vertical 50
                         :justify-content :space-between
                         :align-items :center
                         :background-color :white}}
     [:> rn/View {:style {:align-items :center}}
      [:> rn/Text {:style {:font-weight   :bold
                           :font-size     72
                           :color         :blue
                           :margin-bottom 20}} counter]
      [button {:on-press #(rf/dispatch [:inc-counter])
               :disabled? (not tap-enabled?)
               :style {:background-color :blue}}
       "Tap me, I'll count"]]
     [:> rn/View
      [:> rn/View {:style {:flex-direction :row
                           :align-items :center
                           :margin-bottom 20}}
       [:> rn/Image {:style {:width  160
                             :height 160}
                     :source cljs-splash}]
       [:> rn/Image {:style {:width  160
                             :height 160}
                     :source shadow-splash}]]
      [:> rn/Text {:style {:font-weight :normal
                           :font-size   15
                           :color       :blue}}
       "Using: shadow-cljs+expo+reagent+re-frame"]]
     [:> StatusBar {:style "auto"}]]))

(comment
  (rf/dispatch [:set-counter-tapable false])
  (rf/dispatch [:set-counter-tapable true])
  (rf/dispatch [:set-textinput-text some-data/some-text]))

(defn start
  {:dev/after-load true}
  []
  (expo-root/render-root (r/as-element [new-root])))

(defn init []
  (rf/dispatch-sync [:initialize-db])
  (start))