package main

import scala.collection.mutable.Queue
import scala.collection.mutable.Set
import scala.compiletime.ops.double
import scala.collection.mutable.ArrayBuffer

case class Graph(val nodes: Set[Node]):
    
    

    // def pairwisePermutations(): Vector[Vector[String]] =
    //     words.combinations(2)
    //     .toVector
    //     .map(_.permutations.toVector)
    //     .flatten

    
    // Map
    
    // for (word1 <- words) yield
    //     val neighbours: Set[String] = Set()
    //     for (word2 <- words) do
    //         if word1 != word2 && word1.substring(1).intersect(word2) == word1.substring(1) then
    //             neighbours.add(word2)
        
    // //words.combinations(2).foreach(pair => if pair(0).substring(1).forall(char => pair(1).contains(char)) then ) 
    
    
    
    // def findShortestPath(firstWord: Node, secondWord: Node): Unit =
    //     val visited: Set[Node] = Set(firstWord)
    //     val queue: Queue[Node] = Queue(firstWord)

    //     var found: Boolean = false 

    //     while !found || !queue.isEmpty do
    //         val current: Node = queue.dequeue()

    //         val neighbours: Set[Node] = current.neighbours
    //         for neighbour <- neighbours do
    //             if !visited.contains(neighbour) then
    //                 visited.add(neighbour)
    //                 queue.enqueue(neighbour)
    //                 //pred(neighbour) <- current
    //                 if neighbour.equals(secondWord) then
    //                     found = true
    //                     queue.clear()
                        
    //     if found then println(level) else println("Impossible")

                
                        







    