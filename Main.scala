package main

import scala.collection.mutable.Set
import scala.io.StdIn.readLine

@main def run(): Unit =
    val numbers: Array[Int] = readLine().split(" ").map(_.toInt)
    val noWords: Int = numbers(0)
    val noQueries: Int = numbers(1)

    val words: Set[String] = Set.empty
    val queries: Set[(String, String)] = Set.empty

    for i <- 0 until noWords do
        words.add(readLine())

    for i <- 0 until noQueries do 
        val pair: Array[String] = readLine().split(" ")
        queries.add(pair(0) -> pair(1))

    words.foreach(println)
    queries.foreach(println)


    val nodes: Set[Node] = makeNodes(words)
    findandSetNeighbours(nodes)

    nodes.foreach(node => println(node.toString() + " " + node.neighbours.toString()))




def makeNodes(words: Set[String]): Set[Node] = 
    val nodes: Set[Node] = Set.empty 
    words.foreach(word => nodes.add(Node(word)))
    nodes

    
    
def findandSetNeighbours(nodes: Set[Node]): Unit =
    //nodes.foreach(node => )
    for node <- nodes do 
        val neighbours: Set[Node] = Set.empty
        for potentialNeighbour <- nodes do
            val fulfillsNeighbouringCondition: Boolean = node.value.substring(1).forall(char => potentialNeighbour.value.contains(char))
            if node != potentialNeighbour && fulfillsNeighbouringCondition then
                neighbours.add(potentialNeighbour)
            
        node.neighbours = neighbours
