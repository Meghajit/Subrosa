(ns subrosa.encryption.aes.core-test
  (:require [clojure.test :refer :all]
            [subrosa.encryption.aes.core :refer :all])
  (:import (java.nio.charset StandardCharsets)
           (java.io File)))

(deftest aes256-algorithm
  (testing "able to encrypt and decrypt plaintext using keyset and passphrase"
    (let [plain-text-string "Lorem Ipsum is simply dummy text of the printing and typesetting industry.Lorem Ipsum has
    been the industry's standard dummy text ever since the 1500s"
          plain-text-bytes-array (.getBytes plain-text-string)
          passphrase "This is the secret passphrase"
          passphrase-bytes-array (.getBytes passphrase)
          keyset-file (File. "test/resources/subrosa_keyset.json")
          encrypted-text-bytes-array (encrypt plain-text-bytes-array passphrase-bytes-array keyset-file)
          decrypted-text-bytes-array (decrypt encrypted-text-bytes-array passphrase-bytes-array keyset-file)
          decrypted-text (String. decrypted-text-bytes-array StandardCharsets/UTF_8)]
      (is (= plain-text-string decrypted-text)))))