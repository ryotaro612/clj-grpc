(defproject pedestal-grpc "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Apache License 2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0"
            :year 2022
            :key "apache-2.0"}
  :dependencies [[org.clojure/clojure "1.11.3"]
                 [io.pedestal/pedestal.service "0.6.3"]

                 ;; -- PROTOC-GEN-CLOJURE --
                 [io.github.protojure/grpc-server "2.8.2"]
                 [io.github.protojure/google.protobuf "2.0.1"]

                 [ch.qos.logback/logback-classic "1.5.6"]
                 [org.slf4j/jul-to-slf4j "2.0.13"]
                 [org.slf4j/jcl-over-slf4j "2.0.13"]
                 [org.slf4j/log4j-over-slf4j "2.0.13"]]
  :min-lein-version "2.0.0"
  :resource-paths ["config", "resources"]
  :source-paths ["src", "gen"]
  :profiles {:dev {:aliases {"run-dev" ["trampoline" "run" "-m" "pedestal-grpc.server/run-dev"]}
                   :resource-paths ["dev/resources"]
                   :source-paths ["dev/src"]
                   :dependencies [[io.pedestal/pedestal.service-tools "0.6.3"]]}
             :uberjar {:aot [pedestal-grpc.server]}}
  :plugins [["lein-ancient" "0.7.0"]]
  :main ^{:skip-aot true} pedestal-grpc.server)
