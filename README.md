## Today I learned...
This is a collection of things I learned each day.

20160321
[Binary Tree in an Array] (https://en.wikipedia.org/wiki/Binary_tree#Arrays): You can represent a binary tree in a single array. One benefit is that the array naturally represents the tree in a breadth-first order.

20160322
[Fuzz Testing] (https://en.wikipedia.org/wiki/Fuzz_testing): Create a program that will make random test programs that look like other test programs. Run the random test programs. If/when your program crashes, you can find bugs that you couldn't catch before.

20160323
Functions as Objects in Scala: In Scala, a function is an object that can be assigned to a variable (function object). If a function happens to be defined as a member of a different object, it is called method. Because of this, you can even pass a function as a parameter to another function, higher-order function.

20160324
[Python's Built-in XML parser] (http://effbot.org/zone/element-index.htm): Python has a built-in xml parser, called ElementTree. This is a great tool for doing xml tree traversal.
[`collections.deque`] (https://docs.python.org/2/library/collections.html#collections.deque): Python has a data type called `deque`, which stores data in (kind-of) doubly-linked list. It is [much faster] (https://wiki.python.org/moin/TimeComplexity) to do many operations on `deque` than on a `list`, including `pop`.

20160325
It is impossible to create a `scikit-learn` RandomForestClassifier without training data. When you build a model, `scikit-learn` allocates the data in the memory. Then it creates a `numpy.array` of the location of left child, right child, and etc., based on the memory location of the left child, right child, and etc.. This is all done in CPython in `scikit-learn`.

20160328
`matplotlib` has an option to draw xkcd-style plots!

20160329
Tail-recursion in scala: Tail-recursive function ends by calling itself. [Finding nth Fibonacci number with tail-recursion in scala] (./scala/nth_Fibonacci.scala)

20160330
Polymorphic functions in scala: Polymorphic function is a so called generic function. It doesn't rely on parameters of with specific types. [Checking if an array is sorted in scala] (./scala/is_sorted.scala)
