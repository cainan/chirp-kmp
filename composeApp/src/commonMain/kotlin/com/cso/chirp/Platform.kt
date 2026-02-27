package com.cso.chirp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform