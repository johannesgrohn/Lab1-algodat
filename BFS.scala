package main

import scala.collection.mutable.Queue
import scala.collection.mutable.Set
import scala.compiletime.ops.double
import scala.collection.mutable.ArrayBuffer

case class BFS(val nodes: Set[Node]):

    def findShortestPath(start: Node, end: Node): Unit =
        val queue: Queue[Node] = Queue.empty
        queue.enqueue(start)

        var found: Boolean = false 

        for node <- nodes do
            node.pred = None
            node.visited = false
        start.visited = true

        while !queue.isEmpty do
            val current: Node = queue.dequeue()

            if current == end then
                found = true
            if !found then
                for neighbour <- current.neighbours do 
                    if !neighbour.visited then
                        neighbour.visited = true
                        queue.enqueue(neighbour)
                        neighbour.pred = Some(current)

        if found then 
            var level: Int = 0 
            var current: Option[Node] = Some(end)
            while !current.get.pred.isEmpty do
                current = current.get.pred
                level += 1
            println(level)
        else 
            println("Impossible")
    