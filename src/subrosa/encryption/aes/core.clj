(ns subrosa.encryption.aes.core
  (:import (com.google.crypto.tink Aead CleartextKeysetHandle JsonKeysetReader)
           (com.google.crypto.tink.aead AeadConfig)))

(AeadConfig/register)

(defn encrypt [plain-text passphrase keyset-file]
  (let [keyset-handle (CleartextKeysetHandle/read (JsonKeysetReader/withFile keyset-file))
        aead (.getPrimitive keyset-handle Aead)]
    (.encrypt aead plain-text passphrase)))

(defn decrypt [encrypted-text passphrase keyset-file]
  (let [keyset-handle (CleartextKeysetHandle/read (JsonKeysetReader/withFile keyset-file))
        aead (.getPrimitive keyset-handle Aead)]
    (.decrypt aead encrypted-text passphrase)))