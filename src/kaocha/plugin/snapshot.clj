(ns kaocha.plugin.snapshot
  (:require
   [kaocha.plugin :refer [defplugin]]
   [kaocha.plugin.snapshot.assert :as assert]
   [kaocha.testable :as testable]))

(def default-path
  "dev-resources/snapshots")

(defplugin kaocha.plugin/snapshot
  (config [config]
    (update config ::base-path #(or % default-path)))
  (wrap-run [run _test-plan]
    (fn [testable test-plan]
      (let [id        (:kaocha.testable/id testable)
            base-path (::base-path testable/*config*)]
        (assert/with-context id base-path
          (run testable test-plan))))))
