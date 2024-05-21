package de.lovessushi.vegify

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform