package main

import scala.collection.mutable.Set

case class Node(val value: String):
    var neighbours: Set[Node] = Set.empty