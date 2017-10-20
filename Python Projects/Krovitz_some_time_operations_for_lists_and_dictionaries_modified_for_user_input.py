""" ===============================================================================================================
                                                Program Summary
===================================================================================================================
Programmer: Jeremy Krovitz
Class: Computer Science 221-01
Professor: Shilad Sen
Program Summary: This program will analyze the performance of add and delete operations on dictionaries.
It will also compare the performance of adding and removing to the front, back, and middle of a list.
My parameters and function calls are below my functions. The operation to remove from a dictionary is not
currently working as Python has been updated since the time that I completed this project. I plan on revising
this in the near future so that removing from a dictionary executes properly. 
===================================================================================================================
                                             The Program Itself
================================================================================================================"""
import time
import random


"""=================================         Program Introduction       ========================================"""

print("This program will give the average time complexity for ten trials of adding or removing from a dictionary "
      "\nas well as adding or removing from the front, back, and middle of a list given an input/output that will"
      "\nbe specified by you, the user. Be careful what size inputs you entered. Inputs that are too large"
      "\nfor some data structure (probably about one million and above) may be to large and if so will cause "
      "\nthe rest of the program to stop running.")

""" ===============================================================================================================
                                    Some operations on Dictionaries
================================================================================================================"""

"""============================         Adding to the dictionary         ======================================="""

add_to_dict_ui = int(input("\n"+"Please enter the size that your dictionary should grow to (input must be an "
                                "integer greater than 0 and less than one million): "
                                "" + "\n"))


def add_to_dictionary(n):
    """This function takes in (n, the_val), which is a key, value pair in a dictionary and
    prints the average time performance of adding an entry to a dictionary n times."""
    duration_list = []
    for p in range(10):
        a_dictionary = {}
        time0 = time.time()
        for i in range(n):
            a_dictionary[i] = random.random()
            # if n >= 1000000:
            #     print("Please enter a smaller number.")
            #     return
        time1 = time.time()
        duration = time1 - time0
        dur_per_op = duration / n
        duration_list.append(dur_per_op)
    the_average = float(sum(duration_list) / len(duration_list))
    print("\nThe average time performance per operation for adding to a dictionary to grow "
          "it from size 0 to size " + str(add_to_dict_ui) + ": " + str(the_average) + "." + "\n")


add_to_dictionary(add_to_dict_ui)


"""===============================       Removing from the dictionary       ==================================="""


# some_val = (random.random())
# remove_from_dict_ui = (input("\n" + "Please enter the initial size of the dictionary before keys are removed "
#
#                                         "from it (input must be an integer): " + "\n"))

# aDictionary = (dict.fromkeys(remove_from_dict_ui))
#
#
# def remove_from_dictionary(a_dictionary, the_val):
#     """This function takes in (n, the_val), which is a key, value pair in a dictionary and
#     prints the average time performance of deleting an entry from a dictionary k times."""
#     duration_list = []
#     for p in range(10):
#         key_list = list(a_dictionary.keys())
#         time0 = time.time()
#         for k in key_list:
#             del (a_dictionary[k])
#         time1 = time.time()
#         duration = time1 - time0
#         dur_per_op = duration / the_val
#         duration_list.insert(0, dur_per_op)
#     the_average = float(sum(duration_list) / len(duration_list))
#     print("The average time performance per operation for removing from a dictionary to shrink it from "
#           "size " + str(remove_from_dict_ui) + " to size 0" + ": " + str(the_average) + "." + "\n")
#
# remove_from_dictionary(aDictionary, some_val)

""" ===============================================================================================================
                                    Some operations on Lists
================================================================================================================"""

"""===============================       Adding to the front of the list       ================================="""


add_to_front_of_list_ui = int(input("\n"+"Please enter the size that your list should grow to as values are "
                                         "added to the front of it (input must be an integer): " + "\n"))


def add_to_front_of_list(n):
    """This function takes in n and prints the time performance of adding to the
    front of the list n times."""
    duration_list = []
    for p in range(10):
        a_list = []
        time0 = time.time()
        for i in range(n):
            a_list.insert(0, random.random())
            # if n >= 100000:
            #     print("Please enter a smaller number.")
            #     return
        time1 = time.time()
        duration = time1 - time0
        dur_per_op = duration / n
        duration_list.append(dur_per_op)
    the_average = float(sum(duration_list) / len(duration_list))
    print("The average time performance per operation for adding to the front of a list to grow it from "
          "size 0 to size " + str(add_to_front_of_list_ui) + ": " + str(the_average) + "." + "\n")


add_to_front_of_list(add_to_front_of_list_ui)


"""===============================       Removing from the front of the list       ==============================="""


remove_from_front_of_list_ui = int(input("\n"+"Please enter the initial size of the list before values are "
                                              "removed from the front of it (input must be an integer): " + "\n"))


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
          "size " + str(remove_from_front_of_list_ui) + " to size 0: " + str(the_average) + "." + "\n")


remove_from_front_of_list(remove_from_front_of_list_ui)

"""===============================       Adding to the middle of the list       ================================="""


add_to_middle_of_list_ui = int(input("\n"+"Please enter the size that your list should grow to as values are "
                                           "added to the middle of it (input must be an integer): " + "\n"))


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
            # if n >= 100000:
            #     print("Please enter a smaller number.")
            #     return
        time1 = time.time()
        duration = time1 - time0
        dur_per_op = duration / n
        duration_list.append(dur_per_op)
    the_average = float(sum(duration_list) / len(duration_list))
    print("The average time performance per operation for adding to the middle of a list to grow it from "
          "size 0 to size " + str(add_to_middle_of_list_ui) + ": " + str(the_average) + "." + "\n")


add_to_middle_of_list(add_to_middle_of_list_ui)


"""===============================       Removing from the middle of the list       ==============================="""


remove_from_middle_of_list_ui = int(input("\n"+"Please enter the initial size of the list before "
                                               "values are removed from the middle of it (input must be an integer): " + "\n"))


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
          " size " + str(remove_from_middle_of_list_ui) + " to size 0: " + str(the_average) + "." + "\n")


remove_from_middle_of_list(remove_from_middle_of_list_ui)


"""===============================       Adding to the back of the list       ================================="""


add_to_back_of_list_ui = int(input("\n"+"Please enter the size that your list should grow to as "
                                        "values are added to the back of it (input must be an integer): " + "\n"))


def add_to_back_of_list(n):
    """This function takes in n and prints the time performance of adding to the
    back of the list n times."""
    duration_list = []
    for p in range(10):
        a_list = []
        time0 = time.time()
        for i in range(n):
            a_list.append(random.random())
            # if n >= 100000:
            #     print("Please enter a smaller number.")
            #     return
        time1 = time.time()
        duration = time1 - time0
        dur_per_op = duration / n
        duration_list.append(dur_per_op)
    the_average = float(sum(duration_list) / len(duration_list))
    print("The average time performance per operation for adding to the back of a list to grow it from "
          "size 0 to size " + str(add_to_back_of_list_ui) + ": " + str(the_average) + "." + "\n")


add_to_back_of_list(add_to_back_of_list_ui)


"""===============================       Removing from the back of the list       ==============================="""


remove_from_back_of_list_ui = int(input("\n"+"Please enter the initial size of the list before values are "
                                              "removed from the back of it (input must be an integer): " + "\n"))


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
          "size " + str(remove_from_back_of_list_ui) + " to size 0: " + str(the_average) + "." + "\n")


remove_from_back_of_list(remove_from_back_of_list_ui)
