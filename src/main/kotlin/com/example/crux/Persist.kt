package com.example.crux

interface Persist {
    fun upsert(data : Map<String, Any?>)
}