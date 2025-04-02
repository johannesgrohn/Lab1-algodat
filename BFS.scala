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
            node.setUnvisited()
        start.setVisited()

        while !queue.isEmpty do
            val current: Node = queue.dequeue()

            if current == end then
                found = true
            if !found then
                for neighbour <- current.neighbours do 
                    if !neighbour.visited then
                        neighbour.setVisited()
                        queue.enqueue(neighbour)
                        neighbour.pred = Some(current)


        
        if found && start != end then 
            var level: Int = 0 
            var current: Option[Node] = Some(end)
            while !current.get.pred.isEmpty do
                current = current.get.pred
                level += 1
            println(level)
        else if found && start == end then
            println(0)    
        else 
            println("Impossible")
    // def findShortestPath(firstWord: Node, secondWord: Node): Unit =
    //     val visited: Set[Node] = Set.empty
    //     val queue: Queue[Node] = Queue(firstWord)

    //     var found: Boolean = false 
    //     var level: Int = 0
    //     if firstWord == secondWord then 
    //         found = true
            
    //     for nodes <- visited do 
    //         visited.add(firstWord)
    //         while !found && !queue.isEmpty do
    //             level += 1
    //             val current: Node = queue.dequeue()
    //             val neighbours: Set[Node] = current.neighbours
    //             for neighbour <- neighbours do
    //                 if !visited.contains(neighbour) then
    //                     visited.add(neighbour)
    //                     queue.enqueue(neighbour)
    //                     //pred(neighbour) <- current
    //                     if neighbour == secondWord then
    //                         found = true
                        
    //     if found then println(level) else println("Impossible")

    