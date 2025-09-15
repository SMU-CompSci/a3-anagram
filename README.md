# CS 1342 — Principles of Computer Science II

**Fall 2025**

# Assignment 3 

**Due:** at or before midnight on **Sep 25, 2025 (Thursday)**

---

## Intro

In this assignment, you’ll practice **recursion** and string processing in Java.

Two strings are anagrams if the alphabetic characters of one can be rearranged to form the other (ignoring case and non-letters).

* “Eleven plus two” ⇄ “Twelve PLUS one”
* “Rats and mice” ⇄ “In cat’s dream”

Your program reads **two non-empty strings** and determines whether they are anagrams. You will implement both a **non-recursive** and a **recursive** check over frequency counts of letters.

---

## Submission (GitHub only)

1. Work in **GitHub Classroom**. Commit and push your changes regularly. Each push triggers the autograder.
2. Use autograder feedback, and run the tests locally to get helpful error messages and hints, and keep pushing until all required checks pass.
3. Provide **comments** for all classes and methods to receive full credit.

> **Notes**
>
> * Pushing to GitHub is part of submission; autograder results determine your base logic grade.
> * Do **not** include compiled files or IDE metadata (.ideas directory) — source files only.

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

Write a Java program that reads two **non-empty** strings from input and determines whether they are **anagrams**. Treat only **alphabetic characters** (‘a’–‘z’) when counting, and **ignore case**. Non-alphabetic characters (spaces, punctuation, digits, etc.) should be ignored for the anagram check.

The solution must include at least **one recursive method**.

---

## Programming Requirements

Create a class named **`AnagramChecking`**, which runs your **`main`** method.

### In `main`:

1. **Read two non-empty strings** from standard input. If the user enters an empty string, **prompt again** until a non-empty string is provided.
2. **Normalize case** (convert to all lower or all upper) for both strings.
3. **Declare two integer arrays of size 26** (initialized to zero) to hold counts of letters ‘a’..‘z’ for each string.
4. **Call** `getCountsOfAlphabets (String str, int[] count)` for each string to fill an array.
5. **Call** `nonRecursiveCountCheck (int[] count1, int[] count2)` and **print** the boolean result.
6. **Call** `recursiveCountCheck (int[] count1, int[] count2, int char_index)` and **print** the boolean result. (Use an extra parameter such as `char_index` for the current comparison position.)

### Required methods

* `public static void getCountsOfAlphabets (String str, int[] count)`
  Populate `counts[i]` with the number of occurrences of the letter corresponding to `i` (`0 -> 'a'`, `1 -> 'b'`, …, `25 -> 'z'`) found in `s`. Ignore all non-alphabetic characters.

* `public static boolean nonRecursiveCountCheck (int[] count1, int[] count2) `
  Return `true` iff (if-and-only-if) the arrays are the **same length** and contain the **same value at every index**.

* `public static boolean recursiveCountCheck (int[] count1, int[] count2, int char_index) `
  Return `true` iff the arrays are the **same length** and contain the **same value at every index**, implemented **recursively**.
  *Suggested shape:* base case when `char_index` has reached the array length; otherwise compare at `char_index` and recurse to `char_index + 1`.

---

## I/O Contract

* **Input:** Two non-empty lines, each a string. Your program must reprompt until both lines are non-empty.
* **Output:** Two lines (or clearly labeled lines) printing the boolean results from `nonRecursiveCountCheck` and `recursiveCountCheck`.

> You may format your prompts and outputs clearly for the grader; consistency matters more than exact wording.

---

## Examples

We will use the following examples throughout the assignment.

### Example 1

**Sample Input**

```text
 Enter the first string: Eleven plus two
 Enter the second string: Twelve PLUS one
```

**Sample Output**

```text
Non-recursive count check: Are the two strings anagrams? true
Recursive count check: Are the two strings anagrams? true
```

**Explanation**

* **Letter Array :** `[a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z]`
* **Count Array 1:** `[0,0,0,0,3,0,0,0,0,0,0,2,0,1,1,1,0,0,1,1,1,1,1,0,0,0]`
* **Count Array 2:** `[0,0,0,0,3,0,0,0,0,0,0,2,0,1,1,1,0,0,1,1,1,1,1,0,0,0]`
* Both count arrays have the same length, and match the same value at each index

---

### Example 2

**Sample Input**

```text
Enter the first string: Rats and mice
Enter the second string: In cat’s dream
```

**Sample Output**

```text
Non-recursive count check: Are the two strings anagrams? true
Recursive count check: Are the two strings anagrams? true
```

**Explanation**

* **Letter Array :** `[a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z]`
* **Count Array 1:** `[2,0,1,1,1,0,0,0,1,0,0,0,1,1,0,0,0,1,1,1,0,0,0,0,0,0]`
* **Count Array 2:** `[2,0,1,1,1,0,0,0,1,0,0,0,1,1,0,0,0,1,1,1,0,0,0,0,0,0]`
* Both count arrays have the same length, and match the same value at each index


---

## Implementation Hints

* Use `Character.isLetter(c)` and `Character.toLowerCase(c)`.
* Map letters to indices with `int idx = c - 'a'` after lowercasing.
* Initialize count arrays to zero; increment while scanning each string.
* Start recursion with `recursiveCountCheck(count_1, count_2, 0)`.

---

### Evaluation (what we look for)

To earn full credit, make sure your submission satisfies all of the following expectations.

* **Compiles cleanly** Your code must build with no errors or missing files. Submissions that do not compile may be returned for corrections on a short timeline.
* **Runs without crashes** for reasonable inputs.
* **Program structure matches the spec** Provide the classes and methods exactly as described.
* **No hard-coded tests** from the example—your program should work for arbitrary inputs.
* **Documentation quality**: meaningful class/method comments; clear variable names.
* **Readable output**: prompts and test result prints are clear and easy to follow.
