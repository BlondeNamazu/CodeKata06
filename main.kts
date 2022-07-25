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
println(convertWordToMap("hoge").toString())
