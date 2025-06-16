package dev.leotoloza.marvelkmmapp.util

import dev.leotoloza.marvelkmmapp.BuildConfig

actual fun String.md5(): String {
    return java.security.MessageDigest.getInstance("MD5")
        .digest(this.toByteArray())
        .joinToString("") { "%02x".format(it) }
}

actual fun getMarvelPublicKey(): String = BuildConfig.MARVEL_PUBLIC_KEY

actual fun getMarvelPrivateKey(): String = BuildConfig.MARVEL_PRIVATE_KEY