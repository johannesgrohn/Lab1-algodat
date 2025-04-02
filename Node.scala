package main

import scala.collection.mutable.Set

case class Node(val value: String, var visited: Boolean = false):
    var neighbours: Set[Node] = Set.empty
    var pred: Option[Node] = None

    def setVisited(): Unit = 
        visited = true 

    def setUnvisited(): Unit = 
        visited = false