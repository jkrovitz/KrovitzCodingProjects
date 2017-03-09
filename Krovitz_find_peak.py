""" ===============================================================================================================
                                                Program Summary
===================================================================================================================
Program Title: Find The Peak
Programmer: Jeremy Krovitz
Class: Computer Science 221-01
Professor: Shilad Sen

Program Summary: This program finds the peak entry in a unimodal array. This array has n numbers in it. I'm
assuming that any list input will contain at least one number. Therefore, I do not check for an empty list.
===================================================================================================================
                                             The Program Itself
================================================================================================================"""
import sys


def find_peak(some_list, offset):
    n = len(some_list)
    half_len = n // 2
    right = half_len + 1
    left = half_len -1

    if n ==0:
        print("This is an empty list.")
        sys.exit()
    if n == 1:
        return offset
    if some_list[0] > some_list[1]:
        return offset
    if some_list[n-1] > some_list[n-2]:
        return offset + (n-1)

    if n > 2:
        if some_list[half_len] > some_list[left] and some_list[half_len] > some_list[right]:
            offset = half_len
            return offset
        if some_list[right] > some_list[half_len]:
            offset += half_len
            return find_peak(some_list[half_len: n-1], offset)
        if some_list[left] > some_list[half_len]:
            offset += offset
            return find_peak(some_list[0: half_len], offset)

""" ===============================================================================================================
                                                       Test
================================================================================================================"""


def test_find_peak():
    assert find_peak([None], 0) == 0
    assert find_peak([1],0) == 0
    assert find_peak([3, 2],0) == 0
    assert find_peak([32, 16, 8, 4, 2, 1, 0],0) == 0
    assert find_peak([2, 4],0) == 1
    assert find_peak([10, 20, 30, 40, 50, 60, 70, 90, 100],0) == 8
    assert find_peak([2, 3, 4, 5, 6, 5, 3, 2, 1], 0) == 4
    assert find_peak([1, 2, 3, 4, 5, 6, 7, 8, 1],0) == 7
    assert find_peak([1, 10, 8, 7, 6, 5, 4, 3], 0) == 1

""" ===============================================================================================================
                                                Time Complexity
===================================================================================================================
The recurrence relation for find peak is T(n) = T(n/2) + ϴ(1) ⟶ T(n) = n^(Log_(2)1) ⟶ n^0 = 1 * Log n ⟶ Log n
according to the Master Theorem. Therefore, the solution to  this recurrence relation is ϴ(Log n).
================================================================================================================"""
