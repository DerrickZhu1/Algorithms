Arithmetic progression AP is set of numbers in which difference between any two consecutive
numbers is constant. For example, 1,4,7,10,13 form a arithmetic 
progression with each consecutive number differing from previous by 3.

Assumption of below solutions is that the array given is already sorted. If input array is not sorted, 
do sorting before solving it 
for longest AP. This step costs us additional O(n log n) complexity.

A[i], A[j] and A[k] form an AP if 2* A[j] = A[i] + A[k] where k>j and i<j.
In a given array, check for each index j and if there are index i and k satisfying above condition, 
mark it as an arithmetic progression.

The idea is to create a 2D table L[n][n]. An entry L[i][j] in this table stores LLAP with set[i] and set[j] 
as first two elements of AP and j > i. 
The last column of the table is always 2 (Why – see the meaning of L[i][j]). Rest of the table is filled from bottom right to top left. 
To fill rest of the table, j (second element in AP) is first fixed. i and k are searched for a fixed j. 
If i and k are found such that i, j, k form an AP, then the value of L[i][j] is set as L[j][k] + 1. 
Note that the value of L[j][k] must have been filled before as the loop traverses from right to left columns.

for (int i = 0; i < n; i++)
       L[i][n-1] = 2;
// Consider every element as second element of AP
[n-2, 1]
for (int j = n-2; j >= 1; j--) {
    // Search for i and k for j
    int i = j-1, k = j+1;
    while (i >= 0 && k <= n-1) {
        if (set[i] + set[k] < 2*set[j])
            k++;
 
        // Before changing i, set L[i][j] as 2
        else if (set[i] + set[k] > 2*set[j]) {   
        	L[i][j] = 2, i--;   
        } else {
        // Found i and k for j, LLAP with i and j as first two
        // elements is equal to LLAP with j and k as first two
        // elements plus 1. L[j][k] must have been filled
        // before as we run the loop from right side
        L[i][j] = L[j][k] + 1;
        // first two numbers
 
        // Update overall LLAP, if needed
        llap = Math.max(llap, L[i][j]);
 
        // Change i and k to fill more L[i][j] values for
        // current j
        i--; k++;
        }
    }
}
