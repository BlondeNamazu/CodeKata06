// TODO
// 1. print out all the combination of anagrams
// 2. find longest words that are anagrams
// 3. find the set of anagrams containing the most words

import java.io.File

val dictionary = File("dictionary.txt").readLines()

fun convertWordToWordKey(word: String): String {
  return word.toCharArray().sorted().joinToString("")
}

val wordList = File("dictionary.txt")
  .readLines()

val anagramMap = mutableMapOf<String, Set<String>>()
wordList.forEach { word ->
  val wordKey = convertWordToWordKey(word)
  anagramMap[wordKey] = (anagramMap[wordKey] ?: emptySet<String>()) + word
}

val anagramList = anagramMap
  .toList()
  .filter { it.second.size >= 2 }

println("=====================================")
println("all anagrams are:")
anagramList
  .map { it.second }
  .forEach(::println)
println("(The number of anagrams is ${anagramList.size})")
println("=====================================")
println("longest words that are anagrams:")
val longestWordAnagram = anagramList
  .maxBy{ it.first.length }
println("${ longestWordAnagram.second }")
println("(its length is: ${ longestWordAnagram.first.length })")
println("=====================================")
println("The set of anagrams containing the most words is:")
val mostWordAnagram = anagramList.maxBy{ it.second.size }
println("${ mostWordAnagram.second }")
println("(its size is:${ mostWordAnagram.second.size })")

