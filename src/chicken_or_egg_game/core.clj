(ns chicken_or_egg_game.core
  (:require [chicken-or-egg-game.buttons :refer :all]
            [chicken-or-egg-game.screen :refer :all]
            [chicken-or-egg-game.vars :refer :all]
            [clojure.java.io :as io])
  (:import (javax.swing JFrame BoxLayout JPanel ImageIcon JLabel)))





(def layout-panel
  (JPanel.))


(def frame
  (JFrame.))



(doto layout-panel
  (.setLayout (BoxLayout. layout-panel BoxLayout/Y_AXIS))
  (.add image-panel)
  (.add button-panel))

(doto frame
  (.setDefaultCloseOperation
    javax.swing.WindowConstants/EXIT_ON_CLOSE)
  (.add layout-panel)
  (.setSize *width* *window-height*)
  (.setResizable false)
  (.setVisible true))





(set-image image-panel (read-image-from-file *screen1*))
