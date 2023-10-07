(defproject yamlscript/libyamlscript "0.1.0"
  :description "Shared Library for YAMLScript"
  :url "https://yamlscript.org"

  :license
  {:name "MIT"
   :url "https://opensource.org/license/mit/"}

  :scm
  {:name "git"
   :url "https://github.com/yaml/yamlscript"
   :tag "clojure"
   :dir ".."}

  :dependencies
  [[org.clojure/clojure "1.11.1"]
   [org.babashka/sci "0.8.40"]
   [org.clojure/data.json "2.4.0"]
   [yamlscript/core "0.1.0"]]

  :java-source-paths ["src"]
  :prep-tasks [["compile"] ["javac"]]
  :profiles
  {:uberjar
   {:aot [libyamlscript.core]
    :main libyamlscript.core
    :global-vars
    {*assert* false
     *warn-on-reflection* true}
    :jvm-opts
    ["-Dclojure.compiler.direct-linking=true"
     "-Dclojure.spec.skip-macros=true"]}}

  :plugins [[lein-exec "0.3.7"]]
  :repositories [["public-github" {:url "git://github.com"}]]
  :repl-options {:init-ns libyamlscript.core}
  :global-vars {*warn-on-reflection*
                (some? (System/getenv "WARN_ON_REFLECTION"))})