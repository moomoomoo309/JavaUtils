# JavaUtils
A few utility classes I wrote for my Java class in High School, updated since I got better at Java.

Classes:

In - Performs user input operations, returning a desired type. Takes a varargs string parameter specifying what should be promprted each time. Can also take an IRange as a parameter.

IRange - An interface all ranges should implement.

Range - Represents a range of numbers, can return a number within the range, or if a given number is within the range. Implements IRange.

MultiRange - Represents multiple, possibly non-continuous ranges. Implements IRange.

SimpleMenu - Prompts the user for a boolean, or creates a numbered menu, returning the number the user picked.
