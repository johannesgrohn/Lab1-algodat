package main

import scala.collection.mutable.Set

case class Node(val value: String):
    val neighbours: Set[Node] = Set.empty