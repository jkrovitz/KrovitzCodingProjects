""" ===============================================================================================================
                                                Program Summary
===================================================================================================================
Program Title: Find The Maximum Contiguous Sum
Programmer: Jeremy Krovitz
Class: Computer Science 221-01
Professor: Shilad Sen

Program Summary: This program finds the maximum sum of contiguous numbers in the passed-in array. The maximum sum
may occur in the first half of the array, the second half of the array, or it may span the halves of the array.
The program assumes that if all of the numbers in the input array are negative, that the empty array will be
greater, and thus 0 will be returned.
===================================================================================================================
                                             The Program Itself
================================================================================================================"""


def find_max_sum_sub_array_recurse(the_array, lo, hi):
    if all(lo < 0 for lo in the_array):  # If all items in the_array are negative, 0 is returned.
        return 0
    if hi == lo:
        return the_array[0]
    else:
        mid = (lo + hi) // 2
        return max(find_max_sum_sub_array_recurse(the_array, lo, mid),
                   find_max_sum_sub_array_recurse(the_array, mid+1, hi),
                   find_max_sum_whole_array(the_array, lo, mid, hi))


def find_max_sum_whole_array(the_array, lo, mid, hi):
    sum = 0
    left_sum = float("-inf")
    for i in range(mid, lo-1, -1):
        sum += the_array[i]
        if sum > left_sum:
            left_sum = sum
    right_sum = float("-inf")
    sum = 0
    for j in range(mid+1, hi):
        sum += the_array[j]
        if sum > right_sum:
            right_sum = sum
    whole_sum = left_sum + right_sum
    if left_sum >= right_sum and left_sum >= whole_sum:
        return left_sum
    elif right_sum >= left_sum and right_sum >= whole_sum:
        return right_sum
    else:
        return whole_sum


def find_max_sum_sub_array(the_array):
    """This is a wrapper function for find_max_sum_sub_array_recurse. This makes it so one does not need to input
    values for lo and hi each time and can just input the array."""
    return find_max_sum_sub_array_recurse(the_array, lo = 0, hi = len(the_array))
""" ===============================================================================================================
                                                       Test
================================================================================================================"""


def test_find_max_sum_sub_array():
    assert find_max_sum_sub_array([-1, -2, 3, 4, -5, 6]) == 8
    assert find_max_sum_sub_array([90]) == 90
    assert find_max_sum_sub_array([90, -2]) == 90
    assert find_max_sum_sub_array([-30, -2, -7, -9, -12]) == 0  # If list is all negative, 0 is returned.
    assert find_max_sum_sub_array([-30, 2]) == 2
    assert find_max_sum_sub_array([-2,1,-3,4,-1,2,1,-5,4]) == 6
    assert find_max_sum_sub_array([ 2, 4, -30]) == 6
    assert find_max_sum_sub_array([-39, 2, 4]) == 6
    assert find_max_sum_sub_array([-14, -39, 2, 4]) == 6
    assert find_max_sum_sub_array([-14, -39, -2, -4, 10]) == 10
    assert find_max_sum_sub_array([]) == 0  # If list is empty, 0 is returned.
    assert find_max_sum_sub_array([8, 6, 7]) == 21
    assert find_max_sum_sub_array([3,  -6,  1,  0,  9,  -4,  2,  1,  -2,  6,  -4]) == 13
    assert find_max_sum_sub_array([-1000]) == 0
    assert find_max_sum_sub_array([0]) == 0
    assert find_max_sum_sub_array([0,5,0,5,0]) == 10
    assert find_max_sum_sub_array([-2, -3, 4, -1, -2, 1, 5, -3]) == 7
    assert find_max_sum_sub_array([31, -41, 59, 26, -53, 58, 97, -93, -23, 84]) == 187
    assert find_max_sum_sub_array([30, 20, -6, -5, -2]) == 50  # The max sum in left sub array.
    assert find_max_sum_sub_array([-2, -3, -4, 30, 70]) == 100 # The max sum in right sub array.
    assert find_max_sum_sub_array([-2, 30, 70, -2]) == 100  # The max sum in middle of whole array.
    assert find_max_sum_sub_array([-2, 30, 70, -2]) == 100  # The max sum in middle of whole array.


""" ===============================================================================================================
                                                Time Complexity
===================================================================================================================
Running time of find_max_sum_whole_array:
We can take the for loop of lines 33 - 36 and find that it makes mid - low - 1 + 1 ⟶ mid - low iterations and the
for loop of lines 39 - 42 makes high - mid + 1 iterations, and so the total number of iterations is
(mid - low) + (high - mid + 1) ⟶ high - low + 1 = n.

Running time of find_max_sum_sub_array_recurse:
We denote by T(n) the running time of find_max_sum_sub_array_recurse on a sub-array of n elements. The base case
when n =1 in line 22 takes constant time so T(1) = ϴ(1). Lines 21, 23, and 24 also take a constant amount of time.
Each of the sub-problems solved in lines 25 and 26 is on a sub-array of n/2 elements, and so we spend T(n/2) time
solving each of them. Because we have to solve two sub-problems for the left sub-array and for the right sub-array,
the contribution to the running time from lines 25 and 26 comes to 2T(n/2). The call to find_max_sum_whole_array in
line 27 takes ϴ(n) time, like I demonstrated above. In line 19 checking whether every integer is negative is an
O(n) operation.

Running time of the overall program:
T(n) = ϴ(1) + 2T(n/2) + ϴ(n) +  ϴ(n)  + ϴ(1) ⟶ T(n) =  ϴ(1) + 2T(n/2) + ϴ(2n)  + ϴ(1) ⟶ T(n) = 2T(n/2) + ϴ(n)
⟶ T(n) = ϴ (n log n).
================================================================================================================"""
