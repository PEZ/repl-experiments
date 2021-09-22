(ns example.widgets
  (:require ["react-native" :as rn]))


(defn button [{:keys [style text-style on-press
                       disabled? disabled-style disabled-text-style]
                :or {on-press #()}} text]
  [:> rn/TouchableOpacity {:style (cond-> {:font-weight      :bold
                                           :font-size        18
                                           :background-color :blue
                                           :border-radius    999}
                                    :always (merge style)
                                    disabled? (merge {:background-color "#aaaaaa"}
                                                     disabled-style))
                           :on-press on-press
                           :disabled disabled?}
   [:> rn/Text {:style (cond-> {:padding-horizontal 12
                                :padding-vertical 6
                                :font-weight   :bold
                                :font-size     18
                                :color         :white}
                         :always (merge text-style)
                         disabled? (merge {:color :white}
                                          disabled-text-style))}
    text]])