package com.example

import clojure.lang.Keyword
import crux.api.Crux


val cruxTxPut = Keyword.intern("crux.tx/put")
val cruxDbId = Keyword.intern("crux.db/id")
val name = Keyword.intern("name")
val lastName = Keyword.intern("last-name")


fun main(args: Array<String>) {
    println("starting...")

    val node = Crux.startNode(memDB())
    println(node)

    println(node.status())

    // submit some docs
    val id = "bart_simpson"
    println("Submitting do with id $id")
    val doc = mapOf (cruxDbId to Keyword.intern(id),
            name to "Bart",
            lastName to "Simpson")
    val txResult = node.submitTx(listOf(listOf(cruxTxPut, doc)))
    println(txResult)
}


fun rocksDB(): Map<Keyword, Any> {
    return mapOf<Keyword, Any>(Keyword.intern("crux.node/topology") to Keyword.intern("crux.standalone/topology"),
            Keyword.intern("crux.node/kv-store") to "crux.kv.rocksdb/kv",
            Keyword.intern("crux.kv/db-dir") to "data/db-dir-1",
            Keyword.intern("crux.standalone/event-log-dir") to "data/eventlog-1")
}


fun memDB(): Map<Keyword, Any> {
    return mapOf(Keyword.intern("crux.node/topology") to Keyword.intern("crux.standalone/topology"),
            Keyword.intern("crux.node/kv-store") to "crux.kv.memdb/kv",
            Keyword.intern("crux.kv/db-dir") to "data/db-dir-1",
            Keyword.intern("crux.standalone/event-log-dir") to "data/eventlog-1",
            Keyword.intern("crux.standalone/event-log-kv-store") to "crux.kv.memdb/kv"
    )
}