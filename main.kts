import java.io.File

val dictionary = File("dictionary.txt").readLines()

// define word key by sorted char array extracted from original word
// ex.) word key of "hoge" is "egho"
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

// NOTE: when Map is converted to List, each element is represented as (key, value) pair.
// (key, value).first extracts key 
// (key, value).second extracts value
// here, "key" is word key and "value" is set of anagrams

val anagramList = anagramMap
  .toList()
  .filter { (_, value) -> value.size >= 2 }

println("\n=====================================")
println("all anagrams are:")
anagramList
  .map { (_, value) -> value }
  .forEach(::println)
println("(The number of anagrams is ${anagramList.size})")

println("\n=====================================")
println("longest words that are anagrams:")
val longestWordAnagram = anagramList
  .maxBy{ (key, _) -> key.length }
println("${ longestWordAnagram.second }")
println("(its length is: ${ longestWordAnagram.first.length })")

println("\n=====================================")
println("The set of anagrams containing the most words is:")
val mostWordAnagram = anagramList
  .maxBy{ (_, value) -> value.size }
println("${ mostWordAnagram.second }")
println("(its size is:${ mostWordAnagram.second.size })")

