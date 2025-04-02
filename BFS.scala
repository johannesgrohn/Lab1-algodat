package main

import scala.collection.mutable.Queue
import scala.collection.mutable.Set
import scala.compiletime.ops.double
import scala.collection.mutable.ArrayBuffer

case class BFS(val nodes: Set[Node]):
    
    def findShortestPath(firstWord: Node, secondWord: Node): Unit =
        val visited: Set[Node] = Set.empty
        val queue: Queue[Node] = Queue(firstWord)

        var found: Boolean = false 
        var level: Int = 0
        if firstWord == secondWord then 
            found = true
            
        for nodes <- visited do 
            visited.add(firstWord)
            while !found && !queue.isEmpty do
                level += 1
                val current: Node = queue.dequeue()
                val neighbours: Set[Node] = current.neighbours
                for neighbour <- neighbours do
                    if !visited.contains(neighbour) then
                        visited.add(neighbour)
                        queue.enqueue(neighbour)
                        //pred(neighbour) <- current
                        if neighbour == secondWord then
                            found = true
                        
        if found then println(level) else println("Impossible")

                
                        







    