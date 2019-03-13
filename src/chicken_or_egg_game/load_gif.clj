(ns chicken-or-egg-game.load-gif
  (:import (javax.swing JFrame ImageIcon JLabel)))



(def frame (doto (JFrame. "Hello Frame")
             (.setSize 1280 800)
             (.setVisible true)))

(defn insert-gif []
  (let [screen1 (JLabel. (ImageIcon. (clojure.java.io/resource "screen1.gif")))]
    (.setBounds screen1 0, 0, 1200, 800 )
    (.add (.getContentPane frame) screen1 )))

(insert-gif)