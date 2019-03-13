(ns chicken-or-egg-game.buttons
  (:require [clojure.java.io :as io]
            [chicken-or-egg-game.vars :refer :all])
  (:import (javax.swing JPanel JButton ImageIcon JOptionPane)
           (javax.imageio ImageIO)
           (java.io File)
           (java.awt Dimension)
           (java.awt.event ActionListener)))



(def button1
  (JButton.))

(def button2
  (JButton.))


(def button-panel
  (JPanel.))


(defn image-button
  [button path]
  (let [img (try
              (ImageIO/read (File. path))
              (catch Exception _ nil))]
    (.setIcon button (ImageIcon. img))))

(image-button button1 "/Users/meybeisaron/IdeaProjects/chicken-or-egg-game/resources/chicken-btn-static.png")
(image-button button2 "/Users/meybeisaron/IdeaProjects/chicken-or-egg-game/resources/egg-btn-static.png")


(defn show-msg-dialog []
  (let [img-icon (ImageIcon. (io/resource "screen2.gif"))]
    (JOptionPane/showMessageDialog
      nil "" "The Answer!"
      JOptionPane/INFORMATION_MESSAGE
       img-icon)))


(def act (proxy [ActionListener] []
           (actionPerformed [event] (show-msg-dialog))))

(.addActionListener button1 act)
(.addActionListener button2 act)


(doto button-panel
  (.setMaximumSize (Dimension. *width* (- *window-height* *height*)))
  (.add button1)
  (.add button2))

