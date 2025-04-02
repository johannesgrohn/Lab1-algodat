package main

import scala.collection.mutable.Set

case class Node(val value: String):

    var neighbours: Set[Node] = Set.empty
    
    var visited: Boolean = false

    var pred: Option[Node] = None
