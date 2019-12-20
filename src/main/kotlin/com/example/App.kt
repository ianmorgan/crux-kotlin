package com.example

import clojure.lang.Keyword
import crux.api.Crux

fun main(args: Array<String>) {
    println("starting...")

    val node = Crux.startNode(rocksDB())
    println(node)

    println(node.status())
}


fun rocksDB(): Map<Keyword, Any> {
    return mapOf<Keyword, Any>(Keyword.intern("crux.node/topology") to Keyword.intern("crux.standalone/topology"),
            Keyword.intern("crux.node/kv-store") to "crux.kv.rocksdb/kv",
            Keyword.intern("crux.kv/db-dir") to "data/db-dir-1",
            Keyword.intern("crux.standalone/event-log-dir") to "data/eventlog-1")
}


fun memDB(): Map<Keyword, Any> {
    return mapOf(Keyword.intern("crux.node/topology") to Keyword.intern("crux.standalone/topology"),
            Keyword.intern("crux.node/kv-store") to "crux.kv.mendb/kv",
            Keyword.intern("crux.kv/db-dir") to "data/db-dir-1",
            Keyword.intern("crux.standalone/event-log-dir") to "data/eventlog-1",
            Keyword.intern("crux.standalone/event-log-kv-store") to "crux.kv.memdb/kv"
    )
}