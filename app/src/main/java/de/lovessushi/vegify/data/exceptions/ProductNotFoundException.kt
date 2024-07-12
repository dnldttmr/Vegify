package de.lovessushi.vegify.data.exceptions

class ProductNotFoundException(val code: String) : Exception() {

    override val message: String
        get() = "Product not found. Code $code"
}