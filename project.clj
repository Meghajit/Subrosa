(defproject subrosa "1.0.0:UNRELEASED"
  :description "Subrosa securely stores your passwords by encryption and retrieves them upon request"
  :url "https://github.com/Meghajit/Subrosa"
  :license {:name "MIT License"
            :url "https://github.com/Meghajit/Subrosa/blob/master/LICENSE"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main ^:skip-aot subrosa.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
