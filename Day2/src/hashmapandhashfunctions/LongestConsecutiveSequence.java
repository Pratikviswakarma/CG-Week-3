package hashmapandhashfunctions;

import java.util.*;

public class LongestConsecutiveSequence {
    static int findLongestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);  // Store all elements in HashSet
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Check if `num` is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence Length: " + findLongestConsecutive(arr));
        // Output: 4 (Sequence: 1, 2, 3, 4)
    }
}

