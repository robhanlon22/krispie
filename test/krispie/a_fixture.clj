(ns krispie.a-fixture
  (:require
   [clojure.test :as t :refer [deftest is]]
   [krispie]))

(deftest success-test
  (is (match-snapshot? {:foo "bar"})))

(deftest failure-test
  (is (match-snapshot? {:squid "ink"} "No squid ink :(")))
