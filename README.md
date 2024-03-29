# Project #3 : Hash Table Implementations

Author: Bryce Kratzer

Class: CS321 Section

Semester: Spring 2024

## Overview

This project consists of Java implementations of hash tables using linear probing and double hashing techniques. The hash tables are designed to store HashObject instances, which encapsulate a key along with frequency and probe count attributes. The project also includes a TwinPrimeGenerator class to find twin prime numbers within a specified range.

## Reflection

Implementing hash tables provided valuable insights into data structure design and algorithm optimization. Working on this project helped solidify my understanding of hash functions and collision resolution strategies. One challenging aspect was debugging the hash table insertion and search algorithms, especially ensuring correct probe counts and handling collisions effectively. However, overcoming these challenges enhanced my problem-solving skills and understanding of Java collections.

## Compiling and Using

To compile the code, ensure you have the necessary Java development environment set up. Compile all Java files in the project using the javac command. To use the hash table implementations, create instances of LinearProbing or DoubleHashing classes with the desired capacity and load factor. Then, use the Hashinsert method to insert elements into the hash table and Hashsearch method to search for elements. Additionally, the TwinPrimeGenerator class can be used to find twin prime numbers within a specified range by calling the generateTwinPrime method.

## Results

The project's results include the functionality of the implemented hash tables and the ability to find twin prime numbers efficiently. Experimentation with different load factors and input data sizes could yield insights into the performance characteristics of the hash table implementations.

## Results

| Input                | Loadfactor | Collision Resolution | Hash Table Size | Total Insertions | Duplicate Insertions | Avg. Probes/Insertion |
|----------------------|------------|----------------------|-----------------|------------------|----------------------|-----------------------|
| Date Objects         | 0.5        | Linear Probing       | 47896           | 47896            | 0                    | 1.08                  |
|                      |            | Double Hashing       | 47896           | 47896            | 0                    | 1.12                  |
| Date Objects         | 0.6        | Linear Probing       | 57475           | 57475            | 0                    | 1.08                  |
|                      |            | Double Hashing       | 57475           | 57475            | 0                    | 1.14                  |
| Date Objects         | 0.7        | Linear Probing       | 67054           | 67054            | 0                    | 1.10                  |
|                      |            | Double Hashing       | 67054           | 67054            | 0                    | 1.19                  |
| Date Objects         | 0.8        | Linear Probing       | 76633           | 76633            | 0                    | 1.22                  |
|                      |            | Double Hashing       | 76633           | 76633            | 0                    | 1.39                  |
| Date Objects         | 0.9        | Linear Probing       | 86212           | 86212            | 0                    | 1.76                  |
|                      |            | Double Hashing       | 86212           | 86212            | 0                    | 2.04                  |
| Date Objects         | 0.95       | Linear Probing       | 91002           | 91002            | 0                    | 2.18                  |
|                      |            | Double Hashing       | 91002           | 91002            | 0                    | 2.70                  |
| Date Objects         | 0.99       | Linear Probing       | 94834           | 94834            | 0                    | 3.71                  |
|                      |            | Double Hashing       | 94834           | 94834            | 0                    | 4.38                  |
| Random Integers      | 0.5        | Linear Probing       | 47896           | 47897            | 1                    | 0.00                  |
|                      |            | Double Hashing       | 47896           | 47897            | 1                    | 0.00                  |
| Random Integers      | 0.6        | Linear Probing       | 57475           | 57475            | 0                    | 0.00                  |
|                      |            | Double Hashing       | 57475           | 57475            | 0                    | 0.00                  |
| Random Integers      | 0.7        | Linear Probing       | 67054           | 67054            | 0                    | 0.00                  |
|                      |            | Double Hashing       | 67054           | 67054            | 0                    | 0.00                  |
| Random Integers      | 0.8        | Linear Probing       | 76633           | 76634            | 1                    | 0.00                  |
|                      |            | Double Hashing       | 76633           | 76634            | 1                    | 0.00                  |
| Random Integers      | 0.9        | Linear Probing       | 86212           | 86213            | 1                    | 0.00                  |
|                      |            | Double Hashing       | 86212           | 86213            | 1                    | 0.00                  |
| Random Integers      | 0.95       | Linear Probing       | 91002           | 91004            | 2                    | 0.00                  |
|                      |            | Double Hashing       | 91002           | 91004            | 2                    | 0.00                  |
| Random Integers      | 0.99       | Linear Probing       | 94834           | 94834            | 0                    | 0.00                  |
|                      |            | Double Hashing       | 94834           | 94834            | 0                    | 0.00                  |
| Words from word-list| 0.5        | Linear Probing       | 47896           | 1305930          | 1258034              | 1.60                  |
|                      |            | Double Hashing       | 47896           | 1305930          | 1258034              | 1.39                  |
| Words from word-list| 0.6        | Linear Probing       | 57475           | 1587659          | 1530184              | 2.15                  |
|                      |            | Double Hashing       | 57475           | 1587659          | 1530184              | 1.53                  |
| Words from word-list| 0.7        | Linear Probing       | 67054           | 1869206          | 1802152              | 3.60                  |
|                      |            | Double Hashing       | 67054           | 1869206          | 1802152              | 1.72                  |
| Words from word-list| 0.8        | Linear Probing       | 76633           | 2147748          | 2071115              | 6.71                  |
|                      |            | Double Hashing       | 76633           | 2147748          | 2071115              | 2.02                  |
| Words from word-list| 0.9        | Linear Probing       | 86212           | 2840050          | 2753838              | 19.81                 |
|                      |            | Double Hashing       | 86212           | 2840050          | 2753838              | 2.57                  |
| Words from word-list| 0.95       | Linear Probing       | 91002           | 3013622          | 2922620              | 110.59                |
|                      |            | Double Hashing       | 91002           | 3013622          | 2922620              | 3.19                  |
| Words from word-list| 0.99       | Linear Probing       | 94834           | 3024134          | 2929300              | 471.67                |
|                      |            | Double Hashing       | 94834           | 3024134          | 2929300              | 4.70                  |
## Sources used

No external sources were used for this project.
