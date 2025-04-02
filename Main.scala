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

    val words: Set[String] = readWords(noWords)

    val nodes: Set[Node] = makeNodes(words)
    findandSetNeighbours(nodes)

    val bfs: BFS = BFS(nodes) 
    
    val queries: ArrayBuffer[(Node, Node)] = readQueries(noQueries)

    queries.foreach(q => bfs.findShortestPath(q._1, q._2))

def readWords(noWords: Int): Set[String] = 
    val words: Set[String] = Set.empty 
    for i <- 0 until noWords do
        words.add(readLine())
    words

def readQueries(noQueries: Int): ArrayBuffer[(Node, Node)] =
    val queries: ArrayBuffer[(Node, Node)] = ArrayBuffer.empty
    for i <- 0 until noQueries do 
        val pair: Array[String] = readLine().split(" ")
        queries.append(wordNodeRelations(pair(0)) -> wordNodeRelations(pair(1)))
    queries

def makeNodes(words: Set[String]): Set[Node] = 
    val nodes: Set[Node] = Set.empty 
    words.foreach(word => 
        val createdNode: Node = Node(word)
        nodes.add(createdNode)
        wordNodeRelations(word) = createdNode
    )
    nodes

def findandSetNeighbours(nodes: Set[Node]): Unit =
    for node <- nodes do 
        val neighbours: Set[Node] = Set.empty
        for potentialNeighbour <- nodes do
            val fulfillsNeighbouringCondition: Boolean = node.value.substring(1).intersect(potentialNeighbour.value) == node.value.substring(1)
            if node != potentialNeighbour && fulfillsNeighbouringCondition then
                neighbours.add(potentialNeighbour)
            
        node.neighbours = neighbours
