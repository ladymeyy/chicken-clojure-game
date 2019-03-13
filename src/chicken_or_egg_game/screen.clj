(ns chicken-or-egg-game.screen
  (:require [chicken-or-egg-game.vars :refer :all])
  (:import (java.awt.image BufferedImage)
           (javax.imageio ImageIO)
           (java.io File)
           (javax.swing JPanel ImageIcon)
           (java.awt Color)))


(def *screen1* "/Users/meybeisaron/IdeaProjects/chicken-or-egg-game/resources/screen1.png")


(def *img-buf*
  (ref {:buf (BufferedImage.
               *width*
               *height*
               BufferedImage/TYPE_BYTE_BINARY)}))




(defn read-image-from-file [path]
  (try
    (ImageIO/read (File. path))
    (catch Exception _ nil)))



(defn render [g2d img]
  (.drawImage g2d img 0 0 nil))

(defn create-panel []
  (proxy [JPanel] []
    (paint [g2d]
      (do
        (.setColor g2d Color/WHITE)
        (.fillRect g2d 0 0 *width* *height*)
        (render g2d (@*img-buf* :buf))))))



(defn set-img-buf [img]
  (dosync (ref-set *img-buf* (assoc @*img-buf* :buf img))))

(defn set-image [panel img]
  (let [g2d (.getGraphics panel)]
    (do
      (.setColor g2d Color/WHITE)
      (.fillRect g2d 0 0 *width* *height*)
      (render g2d img)
      (set-img-buf img)
      (.dispose g2d))))



(def image-panel
  (create-panel))


(doto image-panel
  (.setSize *width* *height*))




