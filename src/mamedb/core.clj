; Read in a mame xml file (generated from "mame.exe -listxml") and output an
; .ini file that maps filename to title
(ns mamedb.core,
  (:use [clojure.data.zip.xml :only (attr text xml->)])
  (:require [clojure.xml :as xml]
            [clojure.zip :as zip]))

(defn get-name-and-description [zipped-xml]
  (map list
       (xml-> zipped-xml :game (attr :name))
       (xml-> zipped-xml :game :description text)))

(defn write-names-to-file [game-list out-file]
  (spit out-file 
        (reduce (fn [a b] (str a b "\n"))
                ""
                (map (fn [[game-name game-title]] (str game-name "=" game-title)) 
                     game-list))))

(defn -main[]
  (def xml (xml/parse "../../Desktop/ddc_all_games.xml"))
  (def zipped (zip/xml-zip xml))
  (write-names-to-file (get-name-and-description zipped) "names-to-title.ini"))
