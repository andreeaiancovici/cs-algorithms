# CS Algorithms Cheat Sheet

## Bitwise operations
### Operators
```
AND                   &
OR                    |
NOT                   ~
XOR                   ^
Left shift            <<
Signed right shift    >>
Unsigned right shift  >>>
```

### Truth table
```
AND       OR        NOT     XOR  
0 0 | 0   0 0 | 0   0 | 1   0 0 | 0
0 1 | 0   0 1 | 1   1 | 0   0 1 | 1
1 0 | 0   1 0 | 1           1 0 | 1
1 1 | 1   1 1 | 1           1 1 | 0
```

### Shifting
```
// Left shifting (always fills with 0)
01010 << 1 => 010100

// Signed right shifting (preserves current number sign)
01010 >> 1 => 001010
11010 >> 1 => 111010

// Unsigned right shifting (doesn't preseve current number sign, always fills with 0)
01010 >>> 1 => 001010
11010 >>> 1 => 011010
``` 

### Tips & Tricks
```
// Flip bit
x ^ 1 = 0 // x = 1
x ^ 1 = 1 // x = 0

// Setting n-th bit
x | (1 << n) //set n-th bit to 1
x & ~(1 << n) // set n-th bit to 0

// Extracting n-th bit
(x >> n) & 1

// Toggle n-th bit
x ^ (1 << n)

// Extracting lowest bit
x & ~(x - 1) //extracts lowest set bit
x & -x //extracts lowest set bit using two's complement
~x & (x + 1) //extract lowest unset bit

// Clear lowest bit
x & (x - 1)
```

### Computing a number using bit positions
The following example shows how you can use `|` operator to compute a number in multiple steps, by combining multiple bit positions.
```
// Computing x = 1111
x = (1 << 4) | (1 << 3) | (1 << 2) | 1
```

### Convert Integer to Hexadecimal
```
char[] hexMap = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

// Keep a map with indexes from 0 to 15, for hex base characters
// Isolate last 4 bits, applying a mask of 15 (1111 as binary)
while(num != 0) {
    // Extract hex character using hexMap[num & 15]
    num = num >>> 4;
}
```

### Two's Complement
The two's complement of an N-bit number is defined as its complement with respect to 2^N; the sum of a number and its two's complement is 2^N.
The two's complement is used for representing negative numbers from decimal base in binary form.

```
x = 11101010

// Reverse bits
00010101

// Add 1
00010110
```

#### Subtract 17 from 23, as a computer would, using binary code
Given a register of size 6, 23 – 17 = 23 + (-17) becomes 0001 0111 + 1110 1111 = 10000 0110.\
Since this result has 9 bits, which is too large for the register chosen, the leftmost bit is truncated, resulting in the binary representation of the positive (it starts with a 0) integer 0000 0110.\
When this is changed to a decimal number, note that 4 + 2 = 6 which is the answer expected.

**NOTE**:
A register of size N will be able to represent decimal integers between -2^(N-1) and +2^(N-1).  
**To-do**: Update after finishing `Computer systems; A programmer's perspective`

### Problem solving patterns

#### XOR
- returns zero if we take XOR of two same numbers; 
- returns the same number if we XOR with zero.

##### Problems:
- [FindMissingNumber](/src/main/java/bitwise/FindMissingNumber.java)
- [SingleNumber](/src/main/java/bitwise/SingleNumber.java)
- [TwoSingleNumbers](/src/main/java/bitwise/TwoSingleNumbers.java)
- [ComplementOfBase10Number](/src/main/java/bitwise/ComplementOfBase10Number.java)
- [FlipMatrix](/src/main/java/bitwise/FlipMatrix.java)

##### LeetCode
https://leetcode.com/problemset/all/?topicSlugs=bit-manipulation \
https://leetcode.com/problemset/all/?topicSlugs=bitmask

## Arrays

### Sliding Window

Input:
- array
- linked list
- string

Window size:
- fixed, of size k
  - find a computed value from a sub-array of size k -> average, maximum sum etc.
  - existence of sub-arrays of size k with condition:
    - no repeated characters / numbers
    - matching a permutation
  - no. of sub-arrays of size k matching some condition
      - average 
      - sum equals
      - no repeated characters / numbers
      - matching permutation
- dynamic, which implies resizing the sub-array as needed
  - find the smallest / longest length for sub-array fulfilling some condition
  - no. of sub-arrays fulfilling some condition
  
**NOTE**: Usually, in order to keep track of element frequencies, we should use a map, because most inputs include repeating elements.\
**NOTE**: Dynamic size may include character replacements in order to increase / decrease window size.
    
```
int windowStart = 0;
for(int windowEnd = 0; windowEnd < arraySize; windowEnd++) {
    
	while(/*condition if window is still valid*/) {
		windowStart++;
	}
}
```

Cases when it may not be applicable:
- negative numbers when sum is required

##### Problems:
- [AverageOfSubArraysOfSizeK](/src/main/java/arrays/slidingwindow/AverageOfSubArraysOfSizeK.java)
- [MaximumSumSubArrayOfSizeK](/src/main/java/arrays/slidingwindow/MaximumSumSubArrayOfSizeK.java)
- [SmallestSubArrayWithGivenSum](/src/main/java/arrays/slidingwindow/SmallestSubArrayWithGivenSum.java)
- [LongestSubstringWithKDistinctCharacters](/src/main/java/arrays/slidingwindow/LongestSubstringWithKDistinctCharacters.java)
- [FruitsIntoBaskets](/src/main/java/arrays/slidingwindow/FruitsIntoBaskets.java)
- [NoRepeatSubstring](/src/main/java/arrays/slidingwindow/NoRepeatSubstring.java)
- [LongestSubstringWithSameLettersAfterReplacement](/src/main/java/arrays/slidingwindow/LongestSubstringWithSameLettersAfterReplacement.java)
- [LongestSubArrayWithOnesAfterReplacement](/src/main/java/arrays/slidingwindow/LongestSubArrayWithOnesAfterReplacement.java)
- [PermutationInAString](/src/main/java/arrays/slidingwindow/PermutationInAString.java)
- [StringAnagrams](/src/main/java/arrays/slidingwindow/StringAnagrams.java)
- [SmallestWindowContainingSubstring](/src/main/java/arrays/slidingwindow/SmallestWindowContainingSubstring.java)
- [TBD][WordsConcatenation](/src/main/java/arrays/slidingwindow/WordsConcatenation.java)

##### LeetCode
https://leetcode.com/problemset/all/?topicSlugs=sliding-window \
[TBD] - Medium + Hard

### Two Pointers

Input:
- sorted array
- sorted linked list

##### Problems:
- [PairWithTargetSum](/src/main/java/arrays/twopointers/PairWithTargetSum.java)
- [RemoveDuplicates](/src/main/java/arrays/twopointers/RemoveDuplicates.java)
- [RemoveAllKey](/src/main/java/arrays/twopointers/RemoveAllKey.java)
- [SquaringASortedArray](/src/main/java/arrays/twopointers/SquaringASortedArray.java)
- [TripletSumToZero](/src/main/java/arrays/twopointers/TripletSumToZero.java)
- [TripletSumCloseToTarget](/src/main/java/arrays/twopointers/TripletSumCloseToTarget.java)
- [TripletsWithSmallerSum](/src/main/java/arrays/twopointers/TripletsWithSmallerSum.java)
- [TripletsWithSmallerSumReturnList](/src/main/java/arrays/twopointers/TripletsWithSmallerSumReturnList.java)
- [SubArraysWithProductLessThanATarget](/src/main/java/arrays/twopointers/SubArraysWithProductLessThanATarget.java) -> Sliding Window technique also
- [DutchNationalFlagProblem](/src/main/java/arrays/twopointers/DutchNationalFlagProblem.java)

##### LeetCode
https://leetcode.com/problemset/all/?&topicSlugs=two-pointers \
[TBD] - Easy + Medium + Hard

## LeetCode

https://leetcode.com/problem-list/top-interview-questions/ \
https://seanprashad.com/leetcode-patterns/
