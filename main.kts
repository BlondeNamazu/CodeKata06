// TODO
// 1. print out all the combination of anagrams
// 2. find longest words that are anagrams
// 3. find the set of anagrams containing the most words

import java.io.File

val dictionary = File("dictionary.txt").readLines()

fun toLowercaseOnlyWord(originalWord: String): String {
  var convertedWord = ""
  originalWord.forEach { char ->
    when {
      'a' <= char && char <= 'z' -> convertedWord += char
      'A' <= char && char <= 'Z' -> convertedWord += 'a' + (char - 'A')
    }
  }
  return convertedWord
}

fun convertWordToMap(word: String): Map<Char, Int> {
  var charCountMap = mutableMapOf<Char, Int>()
  ('a'..'z').map{ char ->
    charCountMap[char] = 0
  }
  word.forEach { char -> 
    charCountMap[char] = (charCountMap[char] ?: 0) + 1
  }
  return charCountMap
}

val wordList = File("dictionary.txt")
  .readLines()
  .map { original -> toLowercaseOnlyWord(original) }

println(toLowercaseOnlyWord("hoge").toString())
println(toLowercaseOnlyWord("HOGE").toString())
println(toLowercaseOnlyWord("h'oge").toString())
println(convertWordToMap("hoge").toString())


