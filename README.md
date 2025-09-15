# CS 1342 — Principles of Computer Science II

**Fall 2025**

# Assignment 3

**Due:** at or before midnight on **Sep 25, 2025 (Thursday)**

---

## Intro

In this assignment, you’ll practice **recursion** and string processing in Java.  
Two strings are anagrams if the alphabetic characters of one can be rearranged to form the other (ignoring case and non‑letters). Classic examples include:

* “Eleven plus two” ⇄ “Twelve PLUS one”
* “Rats and mice” ⇄ “In cat’s dream”

Your program reads **two non‑empty strings** and determines whether they are anagrams. You will implement both a **non‑recursive** and a **recursive** check over frequency counts of letters.

---

## Submission (GitHub only)

1. Work in **GitHub Classroom**. Commit and push your changes regularly. Each push triggers the GitHub autograder.
2. Use autograder feedback, run tests on your machine to receive helpful error messages, and keep pushing until all required checks pass.
3. Provide **comments** for all classes and methods to receive full credit.

> **Notes**
> * Pushing to GitHub is part of submission; autograder results determine your base logic grade.
> * Do **not** include compiled files or IDE metadata (anything in .idea) — source files only.

---

## Late submission policies

* Submitted **0–2 days** after the due date: **20%** penalty
* Submitted **2–4 days** after the due date: **40%** penalty
* Submitted **4–7 days** after the due date: **60%** penalty
* **No credit** if submitted **seven days** after the due date

---

## General instructions

* Include **comments** at the beginning of the program.
* Use **proper indentation** as shown in class notes.
* Use **meaningful names** for variables and classes.

Points will be deducted for not following the above.

---

## Problem

Write a Java program that reads two **non‑empty** strings from input and determines whether they are **anagrams**. Treat only **alphabetic characters** (‘a’–‘z’) when counting, and **ignore case**. Non‑alphabetic characters (spaces, punctuation, digits, etc.) should be ignored for the anagram check.

---

## Programming Requirements

Create a class named **`AnagramChecking`**, which will run your **`main`**.

### In `main`:

1. **Read two non‑empty strings** from standard input. If the user enters an empty string, **prompt again** until a non‑empty string is provided.
2. **Normalize case** (convert each characters to all lower or all upper) for both strings.
3. **Declare two integer arrays of size 26** (initialized to zero) to hold counts of each letters for each string (‘a’..‘z’ for all lower, and 'A'..'Z' for all upper).
4. **Call** `getCountsOfAlphabets(String str, int[] count)` for each string s, and to fill the arrays in place.
5. **Call** `nonRecursiveCountCheck(int[] count1, int[] count2)` and **print** the boolean result.
6. **Call** `recursiveCountCheck(int[] count1, int[] count2, int char_index)` and **print** the boolean result. (Use an extra parameter such as `char_index` for the current comparison position.)

### Required methods

* `void getCountsOfAlphabets(String str, int[] count)`  
  Populate `count[i]` with the number of occurrences of the letter corresponding to `i` (`0 -> 'a'`, `1 -> 'b'`, …, `25 -> 'z'`) found in `s`. Ignore all non‑alphabetic characters.

* `boolean nonRecursiveCountCheck(int[] count1, int[] count2)`  
  Return `true` iff the arrays are the **same length** and contain the **same value at every index**.

* `boolean recursiveCountCheck(int[] count1, int[] count2, int char_index)`  
  Return `true` iff the arrays are the **same length** and contain the **same value at every index**, implemented **recursively**.  
  *Suggested shape:* base case when `char_index` has reached the array length; otherwise compare at `char_index` and recurse to `char_index + 1`.

---

## I/O Contract

* **Input:** Two non‑empty lines, each a string. Your program must reprompt until both lines are non‑empty.
* **Output:** Two lines (or clearly labeled lines) printing the boolean results from `nonRecursiveCountCheck` and `recursiveCountCheck`.

> You may format your prompts and outputs clearly for the grader; consistency matters more than exact wording.


