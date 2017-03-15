""" ===============================================================================================================
                                                Program Summary
===================================================================================================================
Programmer: Jeremy Krovitz
Class: Computer Science 221-01
Professor: Shilad Sen
Program Summary: This program will analyze the performance of add and delete operations on dictionaries.
It will also compare the performance of adding and removing to the front, back, and middle of a list.
My parameters and function calls are below my functions.
===================================================================================================================
                                             The Program Itself
================================================================================================================"""
import time 
import random


"""============================         Operations on dictionaries       ======================================="""


def add_to_dictionary(n, the_val):
    """This function takes in (n, the_val), which is a key, value pair in a dictionary and
    prints the average time performance of adding an entry to a dictionary n times."""
    duration_list = []
    for p in range(10):
        a_dictionary = {}
        time0 = time.time()
        for i in range(n):
            a_dictionary[i] = random.random()
        time1 = time.time()
        duration = time1 - time0
        dur_per_op = duration / the_val
        duration_list.append(dur_per_op)
    the_average = float(sum(duration_list) / len(duration_list))
    print("\n" + "The average time performance per operation for adding to a dictionary to grow it from "
          "size 0 to size n: " + str(the_average) + "." + "\n")


def remove_from_dictionary(n, the_val):
    """This function takes in (n, the_val), which is a key, value pair in a dictionary and
    prints the average time performance of deleting an entry from a dictionary k times."""
    duration_list = []
    for p in range(10):
        key_list = list(n.keys())
        time0 = time.time()
        for k in key_list:
            del (n[k])
        time1 = time.time()
        duration = time1 - time0
        dur_per_op = duration / the_val
        duration_list.insert(0, dur_per_op)
    the_average = float(sum(duration_list) / len(duration_list))
    print("The average time performance per operation for removing from a dictionary to shrink it from "
          "size n to size 0: " + str(the_average) + "." + "\n")


"""==============================           Operations on lists         ========================================"""


def add_to_front_of_list(n):
    """This function takes in n and prints the time performance of adding to the
    front of the list n times."""
    duration_list = []
    for p in range(10):
        a_list = []
        time0 = time.time()
        for i in range(n):
            a_list.insert(0, random.random())
        time1 = time.time()
        duration = time1 - time0
        dur_per_op = duration / n
        duration_list.append(dur_per_op)
    the_average = float(sum(duration_list) / len(duration_list))
    print("The average time performance per operation for adding to the front of a list to grow it from "
          "size 0 to size n: " + str(the_average) + "." + "\n")


def remove_from_front_of_list(n):
    """This function takes in n and prints the time performance of removing from the
    front of the list n times."""
    duration_list = []
    for p in range(10):
        a_list = [random.random() for i in range(n)]
        time0 = time.time()
        for i in range(n):
            a_list.pop(0)
        time1 = time.time()
        duration = time1 - time0
        dur_per_op = duration / n
        duration_list.append(dur_per_op)
    the_average = float(sum(duration_list) / len(duration_list))
    print("The average time performance per operation for removing from the front of a list to shrink it from "
          "size n to size 0: " + str(the_average) + "." + "\n")


def add_to_middle_of_list(n):
    """This function takes in n and prints the time performance of adding to the
    middle of the list n times."""
    duration_list = []
    for p in range(10):
        a_list = []
        time0 = time.time()
        for i in range(n):
            len_of_list = len(a_list)
            middle_of_list = len_of_list // 2
            a_list.insert(len_of_list - middle_of_list, random.random())
        time1 = time.time()
        duration = time1 - time0
        dur_per_op = duration / n
        duration_list.append(dur_per_op)
    the_average = float(sum(duration_list) / len(duration_list))
    print("The average time performance per operation for adding to the middle of a list to grow it from "
          "size 0 to size n: " + str(the_average) + "." + "\n")


def remove_from_middle_of_list(n):
    """This function takes in n and prints the time performance of removing from the
    middle of the list n times."""
    duration_list = []
    for p in range(10):
        a_list = [random.random() for i in range(n)]
        time0 = time.time()
        for i in range(n):
            middle_of_list = len(a_list) // 2
            a_list.pop(middle_of_list)
        time1 = time.time()
        duration = time1 - time0
        dur_per_op = duration / n
        duration_list.append(dur_per_op)
    the_average = float(sum(duration_list) / len(duration_list))
    print("The average time performance per operation for removing from the middle of a list to shrink it from"
          " size n to size 0: " + str(the_average) + "." + "\n")


def add_to_back_of_list(n):
    """This function takes in n and prints the time performance of adding to the
    back of the list n times."""
    duration_list = []
    for p in range(10):
        a_list = []
        time0 = time.time()
        for i in range(n):
            a_list.append(random.random())
        time1 = time.time()
        duration = time1 - time0
        dur_per_op = duration / n
        duration_list.append(dur_per_op)
    the_average = float(sum(duration_list) / len(duration_list))
    print("The average time performance per operation for adding to the back of a list to grow it from "
          "size 0 to size n: " + str(the_average) + "." + "\n")


def remove_from_back_of_list(n):
    """This function takes in n and prints the time performance of removing from the
    back of the list n times."""
    duration_list = []
    for p in range(10):
        a_list = [random.random() for i in range(n)]
        time0 = time.time()
        for i in range(n):
            size_of_list = len(a_list)
            a_list.pop(size_of_list - 1)
        time1 = time.time()
        duration = time1 - time0
        dur_per_op = duration / n
        duration_list.append(dur_per_op)
    the_average = float(sum(duration_list)/len(duration_list))
    print("The average time performance per operation for removing from the back of a list to shrink it from "
          "size n to size 0: " + str(the_average) + "." + "\n")

""" ===============================================================================================================
                                        Some Parameters and Function Calls
================================================================================================================"""

some_val = random.random()

add_to_dictionary(int(1), some_val)

aDictionary = dict.fromkeys((range(1), some_val))
remove_from_dictionary(aDictionary, some_val)

add_to_front_of_list(int(1))
add_to_middle_of_list(int(1))
add_to_back_of_list(int(1))
remove_from_front_of_list(int(1))
remove_from_middle_of_list(int(1))
remove_from_back_of_list(int(1))
