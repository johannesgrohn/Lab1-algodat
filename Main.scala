package main

import scala.collection.mutable.Set
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine

val wordNodeRelations: HashMap[String, Node] = HashMap.empty

@main def run(): Unit =
    val numbers: Array[Int] = readLine().split(" ").map(_.toInt)
    val noWords: Int = numbers(0)
    val noQueries: Int = numbers(1)

    val words: Set[String] = Set.empty
    
    for i <- 0 until noWords do
        words.add(readLine())

    val nodes: Set[Node] = makeNodes(words)
    findandSetNeighbours(nodes)

    //nodes.foreach(node => println(node.toString() + " " + node.neighbours.toString() + "\n" + "\n"))

    val bfs: BFS = BFS(nodes) 
    
    val queries: ArrayBuffer[(Node, Node)] = ArrayBuffer.empty
    for i <- 0 until noQueries do 
        val pair: Array[String] = readLine().split(" ")
        queries.append(wordNodeRelations(pair(0)) -> wordNodeRelations(pair(1)))

    queries.foreach(q => bfs.findShortestPath(q._1, q._2))



def makeNodes(words: Set[String]): Set[Node] = 
    val nodes: Set[Node] = Set.empty 
    words.foreach(word => 
        val createdNode: Node = Node(word)
        nodes.add(createdNode)
        wordNodeRelations(word) = createdNode
    )
    nodes

    
    
def findandSetNeighbours(nodes: Set[Node]): Unit =
    //nodes.foreach(node => )
    for node <- nodes do 
        val neighbours: Set[Node] = Set.empty
        for potentialNeighbour <- nodes do
            val fulfillsNeighbouringCondition: Boolean = node.value.substring(1).intersect(potentialNeighbour.value) == node.value.substring(1)
            if node != potentialNeighbour && fulfillsNeighbouringCondition then
                neighbours.add(potentialNeighbour)
            
        node.neighbours = neighbours
