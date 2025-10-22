package org.rekdev.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

  /**
   * 127. Word Ladder
   * https://leetcode.com/problems/word-ladder/description/?envType=study-plan-v2&envId=top-interview-150
   * <p>
   * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a
   * sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:<br/>
   * - Every adjacent pair of words differs by a single letter.<br/>
   * - Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in
   * wordList.<br/>
   * - sk == endWord<br/>
   * </p>
   * <p>
   * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words
   * in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence
   * exists.
   * </p>
   * <p>
   * Example 1:<br/>
   * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]<br/>
   * Output: 5<br/>
   * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog",
   * which is 5 words long.<br/>
   * </p>
   * <p>
   * Example 2:<br/>
   * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]<br/>
   * Output: 0<br/>
   * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation
   * sequence.<br/>
   * </p>
   * <p>
   * Constraints:<br/>
   * - 1 <= beginWord.length <= 10<br/>
   * - endWord.length == beginWord.length<br/>
   * - 1 <= wordList.length <= 5000<br/>
   * - wordList[i].length == beginWord.length<br/>
   * - beginWord, endWord, and wordList[i] consist of lowercase English letters.<br/>
   * - beginWord != endWord<br/>
   * - All the words in wordList are unique.<br/>
   * </p>
   *
   * @param beginWord
   * @param endWord
   * @param wordList
   * @return
   */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    final Set<String> dictionary = new HashSet<>(wordList);
    if (!dictionary.contains(endWord)) {
      return 0;
    }

    // Deque for BFS
    final Deque<String> queue = new ArrayDeque<>();
    queue.offer(beginWord);

    final Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    int level = 1;
    // BFS Loop: Level-by-Level Traversal
    while (!queue.isEmpty()) {
      int size = queue.size();
      level++; // Increment level for the words in the next layer

      // Process all words at the current level
      for (int i = 0; i < size; i++) {
        String currentWord = queue.poll();

        char[] charArray = currentWord.toCharArray();
        // Iterate through every character position in the word
        for (int j = 0; j < charArray.length; j++) {
          char originalChar = charArray[j];
          /*
           * This is the gold; generate all combinations of the current word. If any are the
           * endWord, we are done. Otherwise, if it's in the dictionary queue that guy up to be
           * explored next unless we've already visited it.
           */
          for (char c = 'a'; c <= 'z'; c++) {
            if (c == originalChar) {
              continue; // Skip the original letter
            }
            charArray[j] = c;
            String nextWord = new String(charArray);
            if (nextWord.equals(endWord)) {
              return level; // Found the shortest path!
            }
            if (dictionary.contains(nextWord) && !visited.contains(nextWord)) {
              queue.offer(nextWord);
              visited.add(nextWord);
            }
          }
          charArray[j] = originalChar;
        }
      }
    }
    return 0;
  }
}
