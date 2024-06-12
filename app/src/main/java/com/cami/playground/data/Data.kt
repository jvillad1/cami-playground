package com.cami.playground.data

import kotlinx.serialization.Serializable

@Serializable
data class Data(val a: Int, val b: String)

fun stuff() {
    val data = Data.serializer()
    println(data)
}
