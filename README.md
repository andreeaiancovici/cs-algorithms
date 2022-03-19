# CS Interview Preparation Cheat Sheet

##Bitwise operations
###Operators
```
AND                   &
OR                    |
NOT                   ~
XOR                   ^
Left shift            <<
Signed right shift    >>
Unsigned right shift  >>>
```

###Truth table
```
AND       OR        NOT     XOR  
0 0 | 0   0 0 | 0   0 | 1   0 0 | 0
0 1 | 0   0 1 | 1   1 | 0   0 1 | 1
1 0 | 0   1 0 | 1           1 0 | 1
1 1 | 1   1 1 | 1           1 1 | 0
```

###Shifting
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

####Subtract 17 from 23, as a computer would, using binary code
Given a register of size 6, 23 – 17 = 23 + (-17) becomes 0001 0111 + 1110 1111 = 10000 0110.\
Since this result has 9 bits, which is too large for the register chosen, the leftmost bit is truncated, resulting in the binary representation of the positive (it starts with a 0) integer 0000 0110.\
When this is changed to a decimal number, note that 4 + 2 = 6 which is the answer expected.

**NOTE**:
A register of size N will be able to represent decimal integers between -2^(N-1) and +2^(N-1).  
**To-do**: Update after finishing `Computer systems; A programmer's perspective`







