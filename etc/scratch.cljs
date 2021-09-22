(ns scratch)

(comment
  [:> rn/SafeAreaView {:style {:flex 1
                               :justify-content :space-between
                               :background-color :white}}
   [:> rn/View {:style {:flex 4
                        :align-items :stretch}}
    [:> rn/TextInput {:multiline true
                      :scroll-enabled true
                      :style {:flex 1
                              :margin 10
                              :padding 5
                              :font-size 14
                              :color :blue
                              :border-width 1}}]]
   [:> rn/View {:style {:flex 1
                        :align-self :center
                        :justify-content :center}}
    [button {:on-press #()
             :style {:background-color :blue}}
     "Work!"]]
   [:> rn/View {:style {:flex 8}}
    [:> rn/ScrollView {:style {:flex 1
                               :padding 10}}
     [:> rn/View {:style {:flex 1
                          :flex-direction :row
                          :justify-content :center
                          :margin 10
                          :flex-wrap :wrap}}
      [:> rn/Text {:style {:font-size 14
                           :padding-horizontal 4
                           :padding-vertical 1
                           :margin-vertical 3
                           :margin-horizontal 2
                           :border-width 0.5
                           :border-radius 3}}
       "foo"]]]]
   [:> StatusBar {:style "auto"}]]
  )