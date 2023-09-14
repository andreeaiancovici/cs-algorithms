# CS Algorithms Cheat Sheet

- [Bit operations](#bit-operations)
  - [Operators](#operators)
  - [Truth table](#truth-table)
  - [Shifting](#shifting)
  - [Tips & Tricks](#tips--tricks)
  - [Computing a number using bit positions](#computing-a-number-using-bit-positions)
  - [Convert Integer into Hexadecimal](#convert-integer-into-hexadecimal)
  - [Two's Complement (OPTIONAL)](#twos-complement-optional)
  - [Base 2 Conversion](#base-2-conversion)
  - [Base -2 Conversion (OPTIONAL)](#base--2-conversion-optional)
  - [Adding numbers in base -2 (OPTIONAL)](#adding-numbers-in-base--2-optional)
  - [Bit operations Algorithms](#bit-operations-algorithms)

[comment]: <> (- [Arrays]&#40;#arrays&#41;)

[comment]: <> (  - [Sliding Window]&#40;#sliding-window&#41;)

[comment]: <> (  - [Two Pointers]&#40;#two-pointers&#41;)

[comment]: <> (  - [Fast & Slow Pointers &#40;also check linked list section&#41;]&#40;#fast--slow-pointers-also-check-linked-list-section&#41;)

[comment]: <> (  - [Merge Intervals]&#40;#merge-intervals&#41;)

[comment]: <> (- [Linked Lists]&#40;#linked-lists&#41;)

[comment]: <> (  - [Fast & Slow Pointers]&#40;#fast--slow-pointers&#41;)

[comment]: <> (- [Binary Search]&#40;#binary-search&#41;)

[comment]: <> (- [Algorithms]&#40;#algorithms&#41;)

[comment]: <> (  - [Floyd's Cycle-Finding algorithm]&#40;#floyds-cycle-finding-algorithm&#41;)
  
---

## Bit operations

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
01010 << 1 -> 010100

// Signed right shifting (preserves current number sign)
01010 >> 1 -> 001010
11010 >> 1 -> 111010

// Unsigned right shifting (doesn't preseve current number sign, always fills with 0)
01010 >>> 1 -> 001010
11010 >>> 1 -> 011010
``` 

### Tips & Tricks

```
// Divide by 2
x >> 1

// Multiply by 2
x << 1

// Interesting aspects of XORing
x ^ x == 0
x ^ y != 0, where x != y

// Flip bit
x = 1 -> x ^ 1 = 0
x = 0 -> x ^ 1 = 1

// Setting k-th bit
x | (1 << k)

// Toggle k-th bit
x ^ (1 << k)

// Extract k-th bit
(x >> k) & 1

Check if power of 2
n & (n - 1) == 0

// Extract lowest bit (OPTIONAL)

// Extract lowest set bit
x & ~(x - 1)
x & -x // Using two's complement

// Extract lowest unset bit
~x & (x + 1)

// Clear lowest set bit (OPTIONAL)
x & (x - 1)
```

### Computing a number using bit positions
The following example shows how you can use `|` operator to compute a number in multiple steps, by combining multiple bit positions.
```
// Computing x = 1111
x = (1 << 4) | (1 << 3) | (1 << 2) | 1
```

### Convert Integer into Hexadecimal

```
char[] hexMap = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

// Keep a map with indexes from 0 to 15, for hex base characters
// Isolate last 4 bits, applying a mask of 15 (1111 as binary)

while(num != 0) {
    // Extract hex character using hexMap[num & 15]
    num = num >>> 4;
}

```

### Two's Complement (OPTIONAL)

The two's complement of an n-bit number is defined as its complement with respect to 2<sup>n</sup>; the sum of a number
and its two's complement is 2<sup>n</sup>. The two's complement is used for representing negative numbers from decimal
base in binary form.

```
x = 11101010

// Reverse bits
00010101

// Add 1
00010110
```

#### Subtract 17 from 23, as a computer would, using binary code

Given a register of size 6, 23 – 17 = 23 + (-17) becomes 0001 0111 + 1110 1111 = 10000 0110.\
Since this result has 9 bits, which is too large for the register chosen, the leftmost bit is truncated, resulting in
the binary representation of the positive (it starts with a 0) integer 0000 0110.\
When this is changed to a decimal number, note that 4 + 2 = 6 which is the answer expected.

**NOTE**: A register of size n will be able to represent decimal integers between -2<sup>(n-1)</sup> and +2<sup>(
n-1)</sup>.

**To-do**: Update after finishing `Computer systems; A programmer's perspective`

### Base 2 Conversion

**Decimal to binary**

```
StringBuilder sb = new StringBuilder();
int base = 2;

while(n != 0) {
  int bit = n % base;
  n /= base;
  
  sb.append(bit);
}

sb.reverse();
```

**Binary to decimal**

```
String binary = "10110011";
int base = 2;
int n = 0;

for(char c : binary.toCharArray()) {
  n = base * n + (c - '0');
}
```

### Base -2 Conversion (OPTIONAL)

```
StringBuilder sb = new StringBuilder();
int base = -2;

while(n != 0) {
  int bit = n % base;
  n /= base;

  if(bit < 0) {
	bit += (-base);
    n += 1;
  }

  sb.append(bit);
}

sb.reverse();
```

### Adding numbers in base -2 (OPTIONAL)

```
Carry              -1   -1
Number 1         1  1 1  1 1
Number 2              1  0 1
                 -----------
Result           1  0 2  0 2
Binary Result    1  0 0  0 0

Carry           -1  1 -1 
Number 1         1  1  0 1
Number 2                 1
                 ---------
Result           0  2 -1 0
Binary Result    0  0  1 0

RULES:
- 1 < sum of digits -> carry = -1
- sum of digits < 1 -> carry = 1
- other -> carry = 0
```

### Bit operations Algorithms

Finding missing / duplicate number(s) are usually solved using XOR properties.\
We can also include additional sum computation (Gauss sum) or XORing intervals (from 1 to n).

- Remove duplicates from array using **x ^ x =
  0** ([Find a single number](/src/main/java/bitoperations/SingleNumber.java))
- Split array into 2 subgroups where **x ^ y != 0** bit is
  different ([Find two single numbers](/src/main/java/bitoperations/TwoSingleNumbers.java))

Bitmasks are very useful for computing memoization state when n is small.

- Using bitmask in dynamic programming
  memoization ([Beautiful Arrangement](/src/main/java/bitoperations/BeautifulArrangement.java))

Finding the complement of a number can be computed using XOR.

- Extracting complement of a
  number ([ComplementOfBase10Number](/src/main/java/bitoperations/ComplementOfBase10Number.java))

[comment]: <> (## Arrays)

[comment]: <> (### Sliding Window)

[comment]: <> (Input:)

[comment]: <> (- array)

[comment]: <> (- linked list)

[comment]: <> (- string)

[comment]: <> (Window size:)

[comment]: <> (- fixed, of size k)

[comment]: <> (  - find a computed value from a sub-array of size k -> average, maximum sum etc.)

[comment]: <> (  - existence of sub-arrays of size k with condition:)

[comment]: <> (    - no repeated characters / numbers)

[comment]: <> (    - matching a permutation)

[comment]: <> (  - no. of sub-arrays of size k matching some condition)

[comment]: <> (      - average )

[comment]: <> (      - sum equals)

[comment]: <> (      - no repeated characters / numbers)

[comment]: <> (      - matching permutation)

[comment]: <> (- dynamic, which implies resizing the sub-array as needed)

[comment]: <> (  - find the smallest / longest length for sub-array fulfilling some condition)

[comment]: <> (  - no. of sub-arrays fulfilling some condition)

[comment]: <> (**NOTE**: Usually, in order to keep track of element frequencies, we should use a map, because most
inputs include repeating elements.\)

[comment]: <> (**NOTE**: Dynamic size may include character replacements in order to increase / decrease window size.)

[comment]: <> (```)

[comment]: <> (int windowStart = 0;)

[comment]: <> (for&#40;int windowEnd = 0; windowEnd < arraySize; windowEnd++&#41; {)

[comment]: <> (	while&#40;/*condition if window is still valid*/&#41; {)

[comment]: <> (		windowStart++;)

[comment]: <> (	})

[comment]: <> (})

[comment]: <> (```)

[comment]: <> (Cases when it may not be applicable:)

[comment]: <> (- negative numbers when sum is required)

[comment]: <> (##### Problems:)

[comment]: <> (- [AverageOfSubArraysOfSizeK]&#40;/src/main/java/arrays/slidingwindow/AverageOfSubArraysOfSizeK.java&#41;)

[comment]: <> (- [MaximumSumSubArrayOfSizeK]&#40;/src/main/java/arrays/slidingwindow/MaximumSumSubArrayOfSizeK.java&#41;)

[comment]: <> (- [SmallestSubArrayWithGivenSum]&#40;/src/main/java/arrays/slidingwindow/SmallestSubArrayWithGivenSum.java&#41;)

[comment]: <> (- [LongestSubstringWithKDistinctCharacters]&#40;/src/main/java/arrays/slidingwindow/LongestSubstringWithKDistinctCharacters.java&#41;)

[comment]: <> (- [FruitsIntoBaskets]&#40;/src/main/java/arrays/slidingwindow/FruitsIntoBaskets.java&#41;)

[comment]: <> (- [NoRepeatSubstring]&#40;/src/main/java/arrays/slidingwindow/NoRepeatSubstring.java&#41;)

[comment]: <> (- [LongestSubstringWithSameLettersAfterReplacement]&#40;/src/main/java/arrays/slidingwindow/LongestSubstringWithSameLettersAfterReplacement.java&#41;)

[comment]: <> (- [LongestSubArrayWithOnesAfterReplacement]&#40;/src/main/java/arrays/slidingwindow/LongestSubArrayWithOnesAfterReplacement.java&#41;)

[comment]: <> (- [PermutationInAString]&#40;/src/main/java/arrays/slidingwindow/PermutationInAString.java&#41;)

[comment]: <> (- [StringAnagrams]&#40;/src/main/java/arrays/slidingwindow/StringAnagrams.java&#41;)

[comment]: <> (- [SmallestWindowContainingSubstring]&#40;/src/main/java/arrays/slidingwindow/SmallestWindowContainingSubstring.java&#41;)

[comment]: <> (- [TBD][WordsConcatenation]&#40;/src/main/java/arrays/slidingwindow/WordsConcatenation.java&#41;)

[comment]: <> (##### LeetCode)

[comment]: <> (https://leetcode.com/problemset/all/?topicSlugs=sliding-window \)

[comment]: <> ([TBD] - Medium + Hard)

[comment]: <> (---)

[comment]: <> (### Two Pointers)

[comment]: <> (Input:)

[comment]: <> (- sorted array)

[comment]: <> (- sorted linked list)

[comment]: <> (Patterns:)

[comment]: <> (- find n elements to fulfill a property &#40;e.g. their sum equals target&#41;)

[comment]: <> (- palindrome)

[comment]: <> (- compare 2 strings  )

[comment]: <> (- in-place sorting)

[comment]: <> (- in-place elements removal)

[comment]: <> (- in-place reverse)

[comment]: <> (##### Problems:)

[comment]: <> (- [PairWithTargetSum]&#40;/src/main/java/arrays/twopointers/PairWithTargetSum.java&#41;)

[comment]: <> (- [RemoveDuplicates]&#40;/src/main/java/arrays/twopointers/RemoveDuplicates.java&#41;)

[comment]: <> (- [RemoveAllKey]&#40;/src/main/java/arrays/twopointers/RemoveAllKey.java&#41;)

[comment]: <> (- [SquaringASortedArray]&#40;/src/main/java/arrays/twopointers/SquaringASortedArray.java&#41;)

[comment]: <> (- [TripletSumToZero]&#40;/src/main/java/arrays/twopointers/TripletSumToZero.java&#41;)

[comment]: <> (- [TripletSumCloseToTarget]&#40;/src/main/java/arrays/twopointers/TripletSumCloseToTarget.java&#41;)

[comment]: <> (- [TripletsWithSmallerSum]&#40;/src/main/java/arrays/twopointers/TripletsWithSmallerSum.java&#41;)

[comment]: <> (- [TripletsWithSmallerSumReturnList]&#40;/src/main/java/arrays/twopointers/TripletsWithSmallerSumReturnList.java&#41;)

[comment]: <> (- [SubArraysWithProductLessThanATarget]&#40;/src/main/java/arrays/twopointers/SubArraysWithProductLessThanATarget.java&#41; -> Sliding Window technique also)

[comment]: <> (- [DutchNationalFlagProblem]&#40;/src/main/java/arrays/twopointers/DutchNationalFlagProblem.java&#41;)

[comment]: <> (- [QuadrupleSumToTarget]&#40;/src/main/java/arrays/twopointers/QuadrupleSumToTarget.java&#41;)

[comment]: <> (- [ComparingStringsContainingBackspaces]&#40;/src/main/java/arrays/twopointers/ComparingStringsContainingBackspaces.java&#41;)

[comment]: <> (- [MinimumWindowSort]&#40;/src/main/java/arrays/twopointers/MinimumWindowSort.java&#41;)

[comment]: <> (##### LeetCode)

[comment]: <> (https://leetcode.com/problemset/all/?&topicSlugs=two-pointers \)

[comment]: <> ([TBD] - Medium + Hard)

[comment]: <> (---)

[comment]: <> (### Fast & Slow Pointers &#40;also check linked list section&#41;)

[comment]: <> (Input:)

[comment]: <> (- an array designated to have a cycle)

[comment]: <> ([Floyd's Cycle-Finding algorithm]&#40;#floyds-cycle-finding-algorithm&#41;)

[comment]: <> (Patterns:)

[comment]: <> (- detect a cycle)

[comment]: <> (##### Problems:)

[comment]: <> (- [HappyNumber]&#40;/src/main/java/arrays/fastslowpointers/HappyNumber.java&#41;)

[comment]: <> (- [TBD][CycleInACircularArray]&#40;/src/main/java/arrays/fastslowpointers/CycleInACircularArray.java&#41;)

[comment]: <> (---)

[comment]: <> (### Merge Intervals)

[comment]: <> (##### Problems:)

[comment]: <> (- [MergeIntervals]&#40;/src/main/java/arrays/mergeintervals/MergeIntervals.java&#41;)

[comment]: <> (- [CheckOverlappingIntervals]&#40;/src/main/java/arrays/mergeintervals/CheckOverlappingIntervals.java&#41;)

[comment]: <> (- [InsertInterval]&#40;/src/main/java/arrays/mergeintervals/InsertInterval.java&#41;)

[comment]: <> (- [IntervalsIntersection]&#40;/src/main/java/arrays/mergeintervals/IntervalsIntersection.java&#41;)

[comment]: <> (- [ConflictingAppointments]&#40;/src/main/java/arrays/mergeintervals/ConflictingAppointments.java&#41;)

[comment]: <> (- [TBD][MinimumMeetingRooms]&#40;/src/main/java/arrays/mergeintervals/MinimumMeetingRooms.java&#41;)

[comment]: <> (- [TBD][MaximumCPULoad]&#40;/src/main/java/arrays/mergeintervals/MaximumCPULoad.java&#41;)

[comment]: <> (- [TBD][EmployeeFreeTime]&#40;/src/main/java/arrays/mergeintervals/EmployeeFreeTime.java&#41;)

[comment]: <> (---)

[comment]: <> (## Linked Lists)

[comment]: <> (### Fast & Slow Pointers)

[comment]: <> (Input:)

[comment]: <> (- linked list with cycle)

[comment]: <> ([Floyd's Cycle-Finding algorithm]&#40;#floyds-cycle-finding-algorithm&#41;)

[comment]: <> (Patterns:)

[comment]: <> (- detect a cycle)

[comment]: <> (- find size of a cycle)

[comment]: <> (- find entry point of cycle)

[comment]: <> (- find middle of linked list)

[comment]: <> (```)

[comment]: <> (ListNode slow = head, fast = head;)

[comment]: <> (while&#40;fast != null && fast.next != null&#41; {)

[comment]: <> (  slow = slow.next;)

[comment]: <> (  fast = fast.next.next;)

[comment]: <> (})

[comment]: <> (```)

[comment]: <> (##### Problems:)

[comment]: <> (- [LinkedListCycle]&#40;/grokking/fastslowpointers/LinkedListCycle.java&#41;)

[comment]: <> (- [LengthOfLinkedListCycle]&#40;/grokking/fastslowpointers/LengthOfLinkedListCycle.java&#41;)

[comment]: <> (- [StartOfLinkedListCycle]&#40;/grokking/fastslowpointers/StartOfLinkedListCycle.java&#41;)

[comment]: <> (- [MiddleOfLinkedList]&#40;/grokking/fastslowpointers/MiddleOfLinkedList.java&#41;)

[comment]: <> (- [PalindromeLinkedList]&#40;/grokking/fastslowpointers/PalindromeLinkedList.java&#41;)

[comment]: <> (- [RearrangeALinkedList]&#40;/grokking/fastslowpointers/RearrangeALinkedList.java&#41;)

[comment]: <> (---)

[comment]: <> (## Binary Search)

[comment]: <> (**Time Complexity:** O&#40;log&#40;n&#41;&#41;)

[comment]: <> (**Space Complexity:** O&#40;1&#41;)

[comment]: <> (**How to recognize:**)

[comment]: <> (- given input already sorted array)

[comment]: <> (- given input is an array which can be transformed in a sorted array by applying prefix sum)

[comment]: <> (- given scenario where we have to test all discrete values in an interval)

[comment]: <> (- given input is a sorted matrix)

[comment]: <> (**Templates:** \)

[comment]: <> (Find leftmost value which evaluates condition to TRUE &#40;condition = function giving results in the following form)

[comment]: <> (FFFFFTTTTT&#41;)

[comment]: <> (```)

[comment]: <> (int binarySearch&#40;int[] nums, int target&#41;{)

[comment]: <> (  int left = 0, right = nums.length - 1;)

[comment]: <> (  while &#40;left < right&#41;{)

[comment]: <> (    int mid = &#40;right - left&#41; / 2 + left;)

[comment]: <> (    if &#40;target <= nums[mid]&#41; right = mid;)

[comment]: <> (    else left = mid + 1;)

[comment]: <> (  })

[comment]: <> (  // check if left evaluates condition to TRUE)

[comment]: <> (  if &#40;target <= nums[left]&#41; return left;)

[comment]: <> (  return -1;)

[comment]: <> (})

[comment]: <> (```)

[comment]: <> (Find rightmost value which evaluates condition to TRUE &#40;condition = function giving results in the following form)

[comment]: <> (TTTTTFFFFF&#41;)

[comment]: <> (```)

[comment]: <> (int binarySearch&#40;int[] nums, int target&#41; {)

[comment]: <> (  int left = 0, right = nums.length - 1;)

[comment]: <> (  while &#40;left < right&#41;{)

[comment]: <> (    int mid = &#40;right - left + 1&#41; / 2 + left;)

[comment]: <> (    if &#40;target <= nums[mid&#41; left = mid;)

[comment]: <> (    else right = mid - 1;)

[comment]: <> (  })

[comment]: <> (  // check if left evaluates condition to TRUE)

[comment]: <> (  if &#40;target <= nums[left]&#41; return left;)

[comment]: <> (  return -1;)

[comment]: <> (})

[comment]: <> (```)

[comment]: <> (### Problems:)

[comment]: <> (- [OrderAgnosticBinarySearch]&#40;/src/main/java/binarysearch/OrderAgnosticBinarySearch.java&#41;)

[comment]: <> (- [CeilingOfANumber]&#40;/src/main/java/binarysearch/CeilingOfANumber.java&#41;)

[comment]: <> (- [FloorOfANumber]&#40;/src/main/java/binarysearch/FloorOfANumber.java&#41;)

[comment]: <> (- [NextLetter]&#40;/src/main/java/binarysearch/NextLetter.java&#41;)

[comment]: <> (- [NumberRange]&#40;/src/main/java/binarysearch/NumberRange.java&#41;)

[comment]: <> (- [SearchInASortedInfiniteArray]&#40;/src/main/java/binarysearch/SearchInASortedInfiniteArray.java&#41;)

[comment]: <> (- [MinimumDifferenceElement]&#40;/src/main/java/binarysearch/MinimumDifferenceElement.java&#41;)

[comment]: <> (- [BitonicArrayMaximum]&#40;/src/main/java/binarysearch/BitonicArrayMaximum.java&#41;)

[comment]: <> (- [SearchBitonicArray]&#40;/src/main/java/binarysearch/SearchBitonicArray.java&#41;)

[comment]: <> (- [SearchInRotatedArray]&#40;/src/main/java/binarysearch/SearchInRotatedArray.java&#41;)

[comment]: <> (- [SearchInRotatedArrayWithDuplicates]&#40;/src/main/java/binarysearch/SearchInRotatedArrayWithDuplicates.java&#41;)

[comment]: <> (- [RotationCount]&#40;/src/main/java/binarysearch/RotationCount.java&#41;)

[comment]: <> (- [RotationCountWithDuplicates]&#40;/src/main/java/binarysearch/RotationCountWithDuplicates.java&#41;)

[comment]: <> (### LeetCode)

[comment]: <> (https://leetcode.com/problemset/all/?topicSlugs=binary-search \)

[comment]: <> ([TBD] - Hard)

[comment]: <> (---)

[comment]: <> (## LeetCode)

[comment]: <> (https://leetcode.com/problem-list/top-interview-questions/ \)

[comment]: <> (https://seanprashad.com/leetcode-patterns/)

[comment]: <> (---)

[comment]: <> (## Algorithms)

[comment]: <> (### Floyd's Cycle-Finding algorithm)

[comment]: <> (Finds an infinite cycle in a linked list, or a type problem which asks for cycle detection. \)

[comment]: <> (Uses 2 pointers, which iterate by one and two steps. At some point, if there is a cycle, the 2 pointers will meet.)
