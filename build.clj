(ns build
  (:require [clojure.tools.build.api :as b]
            [deps-deploy.deps-deploy :as deps-deploy]))

(def lib 'org.clojars.qrthey/clerk-tap)
(def version "1.0.0")
(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))
(def jar-file (format "target/%s-%s.jar" (name lib) version))

(defn clean [_]
  (b/delete {:path "target"}))

(defn jar [_]
  (clean nil)
  (b/write-pom {:class-dir class-dir
                :lib lib
                :version version
                :basis basis
                :src-dirs ["src"]})
  (b/copy-dir {:src-dirs ["src"]
               :target-dir class-dir})
  (b/jar {:class-dir class-dir
          :jar-file jar-file}))

(defn install-local [_]
  (jar nil)
  (b/install {:basis basis
              :lib lib
              :version version
              :jar-file jar-file
              :class-dir class-dir}))

(defn deploy [_]
  (jar nil)
  (deps-deploy/deploy {:artifact jar-file
                       :installer :remote
                       :pom-file (b/pom-path {:lib lib :class-dir class-dir})
                       :sign-release? false}))
