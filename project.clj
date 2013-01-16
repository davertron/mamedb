(defproject mamedb "0.1.0-SNAPSHOT"
  :description "Read in mame xml file and output ini with game names and titles"
  :url "http://github.com/davertron/mamedb"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/data.zip "0.1.1"]]
  :jvm-opts ["-Xms256m" "-Xmx2048m"])
