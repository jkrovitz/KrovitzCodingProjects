""" ===============================================================================================================
                                                Program Summary
===================================================================================================================
Program Title: Find The Peak
Programmer: Jeremy Krovitz
Class: Computer Science 221-01
Professor: Shilad Sen

Program Summary: This program finds the peak entry in a unimodal array with n numbers in it. Edge cases included
within this program include checking to see whether the list is empty, only has one element, if the numbers only
increase and never decrease, and if the numbers only decrease and never increase. An additional edge case was
checking to see whether the input is unimodal being that this is supposed to find the peak of a unimodal array.
===================================================================================================================
                                             The Program Itself
================================================================================================================"""


def find_peak_recurse(num_array, lo, hi, offset):
    n = len(num_array)
    half_len = (lo + hi) // 2
    if n == 0:
        return None  # Returns None if the array is empty.
    if n == 1:
        return offset  # Returns 0 if only one element in array.
    if num_array[0] > num_array[1] and num_array[n-1] > num_array[n-2] or \
                    num_array[half_len] == num_array[half_len-1]:  # Returns None if the array is not unimodal.
        return None
    if num_array[0] > num_array[1]:
        return offset  # Returns offset if array values only decrease.
    if num_array[n-1] > num_array[n-2]:
        return offset + (n-1)  # Returns last index position if array values only increase.
    if n > 2:
        if (num_array[half_len] < num_array[half_len-1] and
                    num_array[half_len] < num_array[half_len+1]) or \
                (num_array[half_len] == num_array[half_len+1]):  # Returns None if the array is not unimodal.
            return None
        else:
            if num_array[half_len-1] <= num_array[half_len] >= num_array[half_len+1]:
                offset = half_len
                return offset
            elif num_array[half_len-1] > num_array[half_len]:
                offset+=offset
                return find_peak_recurse(num_array, lo, half_len, offset)
            elif num_array[half_len] < num_array[half_len+1]:
                offset += half_len
                return find_peak_recurse(num_array, half_len+1, hi, offset)


def find_peak(num_array):
    """This is a wrapper function for find_peak_array_recurse. This makes it so one does not need to input
    values for lo, hi, and offset for each call and will only need to input the array."""
    return find_peak_recurse(num_array, lo=0, hi=len(num_array), offset=0)

""" ===============================================================================================================
                                                       Test
================================================================================================================"""


def test_find_peak():

    assert find_peak([None]) == 0
    assert find_peak([1]) == 0
    assert find_peak([3, 2]) == 0
    assert find_peak([32, 16, 8, 4, 2, 1, 0]) == 0
    assert find_peak([2, 4]) == 1
    assert find_peak([10, 20, 30, 40, 50, 60, 70, 90, 100]) == 8
    assert find_peak([2, 3, 4, 5, 6, 5, 3, 2, 1]) == 4
    assert find_peak([1, 2, 3, 4, 5, 6, 7, 8, 1]) == 7
    assert find_peak([1, 10, 8, 7, 6, 5, 4, 3]) == 1
    assert find_peak([ 2,3,4,3,2,3,4,3,2]) == None
    assert find_peak([2, 3, 4, 3, 2, 3, 4, 5, 2]) == None
    assert find_peak([2, 3, 5, 3, 2, 3, 4, 3, 2]) == None
    assert find_peak([8,7,6,5,4,3,2,3,4,5]) == None
    assert find_peak([8, 7, 6, 5, 4, 5, 6, 7, 8, 3, 2, 3, 4, 5]) == None

""" ===============================================================================================================
                                                Time Complexity
===================================================================================================================
The recurrence relation for find_peak_recurse is T(n) = T(n/2) + ϴ(1) ⟶ T(n) = n^(Log_(2)1) ⟶ n^0 = 1 * Log n 
⟶ Log n according to the Master Theorem. Therefore, the solution to  this recurrence relation is ϴ(Log n).
================================================================================================================"""
