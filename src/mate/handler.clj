(ns mate.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.core :as hiccup]))

(def mates
  {:clubmate {:img "club_mate.png" :name "Club mate" :description "The classic mate."}
   :miomiomate {:img "mio_mate.jpeg" :name "mio mio mate" :description "The classic mate."}
   :fritzmate {:img "fritz_mate.png" :name "fritz mate" :description "The classic mate."}
   :floramate {:img "flora_mate.png" :name "flora mate" :description "The classic mate."}
   :charitea {:img "charitea.jpg" :name "charitea mate" :description "The classic mate."}
   })

(defn random-mate []
  (rand-nth (vals mates)))

(defn get-mate-image []
  (let [select-mate (random-mate)]
    (hiccup/html [:img {:src (:img select-mate)}])))

(defn draw-button-wrong-mate [] "")

(defn handle-request [req]
  (hiccup/html [:h1 "mate 4 you"]
     (get-mate-image)
     (draw-button-wrong-mate)))

(defroutes app-routes
  (GET "/" [] handle-request)
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
