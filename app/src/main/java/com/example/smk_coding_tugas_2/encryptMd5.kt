package com.example.smk_coding_tugas_2

import java.security.MessageDigest

object encryptMd5 {
    @Throws(Exception::class)
    fun encryptMD5(data: ByteArray?): ByteArray {
        val md5 = MessageDigest.getInstance("MD5")
        md5.update(data)
        return md5.digest()
    }
}