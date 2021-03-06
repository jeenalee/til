## Today I learned...
This is a collection of things I learned each day.

20160321
[Binary Tree in an Array](https://en.wikipedia.org/wiki/Binary_tree#Arrays): You can represent a binary tree in a single array. One benefit is that the array naturally represents the tree in a breadth-first order.

20160322
[Fuzz Testing](https://en.wikipedia.org/wiki/Fuzz_testing): Create a program that will make random test programs that look like other test programs. Run the random test programs. If/when your program crashes, you can find bugs that you couldn't catch before.

20160323
Functions as Objects in Scala: In Scala, a function is an object that can be assigned to a variable (function object). If a function happens to be defined as a member of a different object, it is called method. Because of this, you can even pass a function as a parameter to another function, higher-order function.

20160324
[Python's Built-in XML parser](http://effbot.org/zone/element-index.htm): Python has a built-in xml parser, called ElementTree. This is a great tool for doing xml tree traversal.
[`collections.deque`](https://docs.python.org/2/library/collections.html#collections.deque): Python has a data type called `deque`, which stores data in (kind-of) doubly-linked list. It is [much faster](https://wiki.python.org/moin/TimeComplexity) to do many operations on `deque` than on a `list`, including `pop`.

20160325
It is impossible to create a `scikit-learn` RandomForestClassifier without training data. When you build a model, `scikit-learn` allocates the data in the memory. Then it creates a `numpy.array` of the location of left child, right child, and etc., based on the memory location of the left child, right child, and etc.. This is all done in CPython in `scikit-learn`.

20160328
`matplotlib` has an option to draw xkcd-style plots!

20160329
Tail-recursion in scala: Tail-recursive function ends by calling itself. [Finding nth Fibonacci number with tail-recursion in scala](./scala/nth_Fibonacci.scala)

20160330
Parametric polymorphic functions in scala: Polymorphic function is a so called generic function. It doesn't rely on parameters of with specific types. [Checking if an array is sorted in scala](./scala/is_sorted.scala)

20160331
[Currying](https://en.wikipedia.org/wiki/Currying): The way I understood currying is that you transform a function that takes > 1 parameters `f(a, b) = c` to a series of functions with only one parameter: `g(f(a)) = c, where f(a) = b`. The advantage is that each function becomes highly specialized, which can be reused in other situations, allowing the programmer to mix-and-match functions more easily. [This](http://stackoverflow.com/questions/36314/what-is-currying) is another good explanation. [This](./scala/currying_implementation.scala) is the implementation of concepts related to currying in scala.

20160404
[Django Girls Tutorial](http://tutorial.djangogirls.org/en/): Today, I finished the Django Girls Tutotrial. Django is pretty awesome! I thought it was really cool how everything (i.e. `blog_post`) becomes an object with attributes (i.e. `blog_post.author`). I can't wait to make more webapps based on Django.

20160405
[Django's Django Tutorial](https://docs.djangoproject.com/en/1.9/intro/tutorial01/): After this exercise, I think I have a better understanding of the 4 components of Django - `models`, `views`, `urls`, and `templates`. I probably am oversimplifying things, but below is how I understood.
- `models`: Defines classes that will be used to represent your data. This will automatically generate the schema for storing the data in the database.
- `views`: Defines whatever action you want to do on the models (or data). It is like Python functions for models. This can be retrieving data, presenting data, or modifying data. It also gives the appropriate html page (template) for each view.
- `urls`: Stores which url each view is linked to. This is kind of like an address book keeps the resulting url of a view, sort of like an address and a person's name.
- `templates`: Stores the html pages. If `urls` gave you the address, `templates` describes what the house looks like for a given address, so to speak.

20160406
[Rust: Ownership,](http://doc.rust-lang.org/stable/book/ownership.html)[ Borrowing, and Lifetimes](http://doc.rust-lang.org/stable/book/references-and-borrowing.html): I attended a Rust Meetup on Rust's unique feature for memory safety. Before the meetup, I learned the basic [syntax of Rust](http://rust-from-a-scripting-background.readthedocs.org/en/latest/). This was my first time learning about memory safety, and it was fun to think about something that I haven't spent much time worrying when programming.

[Anonymous function in Scala using the underscore notation](./scala/list_practice_anon_func.scala): I wrote comments on the code so that I can remember how the parameters are passed around in anonymous functions.

20160407
Scala's underscore syntax can be confusing, especially in anonymous functions. I commented heavily on [my code](./scala/foldLeft.scala), explaining what the underscores are. Sometimes the first part of a function (i.e. `(h, t)` of `((h, t) => Cons(h, t))` can be omitted if using underscores and anonymous function, and just write the result of the function (i.e. `Cons(_, _)`).

20160411
[interactive-pretty-stuff](https://github.com/jeenalee/interactive-pretty-stuff/): [fitzgen](https://github.com/fitzgen) and I paired up for making some interactive pretty stuff. We have a list of things we want to add to make it even prettier! Check it out [here](http://jeenalee.github.io/interactive-pretty-stuff/).

[`gh-pages`](https://help.github.com/articles/creating-project-pages-manually/) will display the project page of your repo. [Here](./github_tricks/gh-page.md) is an overview of creating the project page for interactive-pretty-stuff.

20160412
Git Tutorial with PyLadies: Notes are [here](./github_tricks/git_tutorial.md). I learned about branching, merging, and forking!

20160415
[Edit Distance](https://en.wikipedia.org/wiki/Edit_distance): Edit distance calculates the shortest distance to travel between two strings. This is widely used for spell check as Norvig [demonstrated](http://norvig.com/spell-correct.html) so elegantly. Edit distance can be considered as the opposite of [Longest Common Substring](https://en.wikipedia.org/wiki/Longest_common_substring_problem). I implemented this algorithm in Python [here](./algorithms/edit_distance.py).

20160416
[Memoization](https://en.wikipedia.org/wiki/Memoization): Memoization is a method to optimize computing time. Before it computes a step, it will look up a hashtable first. If the step had been calculated before, it will return the reviously computed value. If not, it will compute the step and add the value to the hash table, and return the value. [Here](./algorithms/memoization.py) is a sample script that will compute edit distance with and without memoization.

20160418
[Parsing JSON in Python](https://docs.python.org/2/library/json.html#json-to-py-table): Parsing JSON files is straightforward in Python. The `json` module converts the json data structure to Python dictionary objects.

20160421
[Tail Recursion Elimination](https://en.wikipedia.org/wiki/Tail_call): Tail recursion elimination makes sure that when a tail recursive function is called, it is implemented without adding a new stack frame to the call stack. In essence, the original stack frame would be used again and again, saving space in memory. Many functional programming languages, in which tail recursion is the core value, tail recursion elimination is guaranteed. However, [Python doesn't](http://neopythonic.blogspot.com/2009/04/tail-recursion-elimination.html) support tail recursion elimination. This means that even if I were to implement my [Unbalanced Tree Set Algorithm](https://github.com/jeenalee/set_algorithms/blob/master/unbalancedtree.py) iteratively, it will probably still hit the Python's recursion limit.

20160425
[Design Resources for Developers](http://blog.planetargon.com/entries/2016/4/11/20-free-design-resources-for-developers): Some really easy to use resources for making pretty designs.

20160426
[`pandas.DataFrame.merge`](http://pandas.pydata.org/pandas-docs/stable/generated/pandas.DataFrame.merge.html): `merge` is an amazing tool for merging different data tables. Focus on `how`, `left_on`/`right_on`, and `left_index`/`right_index`.

20160427
[Online/Incremental Machine Learning](https://en.wikipedia.org/wiki/Online_machine_learning): Is your data so big that you cannot load all of it into your memory? Incremental Learning allows you to train the model with parts of data at a time. It updates the classifier as it receives more and more data. [`scikit-learn`](https://en.wikipedia.org/wiki/Online_machine_learning#Implementations) supports online ML for some classifiers. The supported models in Weka are listed [here](http://weka.sourceforge.net/doc.dev/weka/classifiers/UpdateableClassifier.html).

20160502
[Naive Bayes Classifier](https://en.wikipedia.org/wiki/Naive_Bayes_classifier): I started reading about NBC because it is a classifier that can be trained incrementally. What is special about NBC that allows online training? Naive Bayes Classifier is a popular algorithm for filtering out spam emails. It is based on applying Bayes Theorem, which assumes independent relationship among predictors. For example, when classifying an apple, it will assume the size of the apple is independent of the color of the apple. The Bayes Theorem is:
```
          P(B|A)P(A)
P(A|B) = ------------
             P(B)
```
In other words:
```
                   P('money'|spam)P(spam)
P(spam|'money') = -----------------------
                         P('money')
```

20160503
[D3 bar graph](http://jeenalee.github.io/d3-practice/): I followed Bostock's tutorial on making a bar graph. I visualized a very small portion of CCLE gene expression data.

20160505
Treat your package like a package. After having `__init__.py`s in every directory, if you try to run your package in the command line (i.e. running a test suite from command line without 3rd party testing suite), you might get an error:
```
ValueError: Attempted relative import in non-package
```
If so, try the following:
```
python -m package.tests_dir.test_file
```

20160506
To install a Python library from github link:
`pip install git+https://github.com/user/library.git`

20160509
[Vector in Scala](http://docs.scala-lang.org/overviews/collections/performance-characteristics.html) has overall better performance than Scala's other data structures, and is immutable.

20160510
`class` and `object` in Scala: `object` can be thought of as a singleton object of a `class`. In some ways, `object` can be thought of creating an anonymous `class`. While a `class` is a description of something, `object` is a special implementation of some `class`.

20160516
For detecting edges in an image, use gradient orientation and magnitude.

20160517
In the mathematical context, [gradient](https://en.wikipedia.org/wiki/Gradient) measures the rate of change in a direction. In the edge detection context, gradient magnitude compresses the gradient around a given pixel, representing a region with a high rate of change in white, and a low rate of change in black. If the rate of is large at a given location, it can be considered that there is an edge at that location.

20160518
For drawing scatter plot for categorical x values, use `ggplot.geom_jitter`. Example is [here](./R/geom_jitter.R).

JSON understands double quotes only!

20160519
[How to install OpenCV with python binding](./random/opencv_py.sh).

20160520
[`git reset --soft`](./github_tricks/reset.md) `git reset --soft <commit | HEAD~ # of commits upstream of HEAD to undo>` allows you to rewrite the git history without deleting changes you made in your working directory. If you choose the option `--hard`, it will remove any changes you introduced since the last commit.

20160523
For performing machine learning on image data (and speech data as well), artificial neural network is a good option. Artificial neural network often performs well with complex, and often imcomplete, data. There are two ways to train ANN: self-organizing ANN through training the model with a large amount of data, and back-propagation ANN in which a human teacher evaluates whether the model's answer is correct or not. This input is used as a feedback for the model.

20160525
When scraping the web, try [scrapy](http://scrapy.org/).

20160526
[Work Stealing](https://en.wikipedia.org/wiki/Work_stealing): I learned about work stealing for the first time at Papers We Love meetup. The paper focused on the performance of [cyclic queue data structure](./papers/Chase_Lev_2005.pdf), and I found the general concept of work stealing interesting. It sounds like a grocery line problem -- how would the grocery store clerks design the lines so that every clerk is working about the same amount?

20160527
For handling text data with a wiki template, `mwparserfromhell` is a pretty handy python library.

20160603
When running a compiled scala code throws `java.lang.NoSuchMethodException`, try removing `import`, use `object` instead of `class`, or run the compiled code with the `$` at the end (for example, `scala fibonacci$` instead of `scala fibonacci`).

20160606
[Linearizability](https://en.wikipedia.org/wiki/Linearizability) is a concept that in concurrent computing, if a system introduces a change, the change looks instantaneous to the rest of the systems. This can be achieved by [locks](https://en.wikipedia.org/wiki/Lock_%28computer_science%29) that ensures that only one thread can access the data (for reading or writing depending on the type). [This talk](https://www.youtube.com/watch?v=QdkS6ZjeR7Q) by Kyle Kingsbury (@aphyr) was a helpful introduction.

20160607
[Serializability](https://en.wikipedia.org/wiki/Serializability) is a global property that ensures the same end result when a sequence of transactions takes place, regardless of the order of the transactions. On the other hand, linearizability is a local property of concurrent objects, for a single object or a single operation. A good overview of these two properties is [here](http://www.bailis.org/blog/linearizability-versus-serializability/).

I also learned about [`git upstream`](./github_tricks/upstream.md) today.

20160608
[How to split a directory on commandline](./random/split_directory.sh)

20160609
I started learning [Rust](https://doc.rust-lang.org/book/README.html). I'm still going through the first few sections, but I learned that Rust's `Cargo` is like a compiler + `pip` + `virtualenv`.

20160613
I wrote a simple [guessing game](./rust/guessing_game) with Rust, following the [Rust tutorial](https://doc.rust-lang.org/book/guessing-game.html).

20160614
[Convolutional Neural Network](https://en.wikipedia.org/wiki/Convolutional_neural_network) is atype of neural network algorithm that was inspired by how animals recognize an image. It involves convolution, in which the sample is broken down into many small "tiles" that overlap. The small tiles are fed into the same neural network, and the interesting results are pooled together to reduce dimensionality. One can repeat convolution and pooling many times to improve the network. [This](https://medium.com/@ageitgey/machine-learning-is-fun-part-3-deep-learning-and-convolutional-neural-networks-f40359318721#.1s0jjc4g5) was a very helpful overview of this algorithm.

20160616
[Struct](https://doc.rust-lang.org/book/structs.html) in Rust is a combination of data structure and type generator. I think of it as the `__init__` part of Python's class, but more powerful. I especially liked how it can be used to generate a customized type through [tuple structs](https://doc.rust-lang.org/book/structs.html#tuple-structs).

20160630
To ignore a directory after it's been added to git (and committed), you have to remove it from its cache on top of adding it to `.gitignore`.
```
git rm -r --cached <directory>
```

20160701
Today is the first day of Rails Girls Summer of Code! I learned about [Fetch API](https://fetch.spec.whatwg.org/#main-fetch). I also learned how the [web](https://rgsoc-jam.github.io/articles/2016-07-01/day01) works.

20160705
[How to sync fork on git](https://help.github.com/articles/syncing-a-fork/).

20160706
[How to add remote branches on git](./github_tricks/branches.md)

20160708
A lot of time learning Rust ownership system. In Rust, only one thing can own a mutable reference, but many things can have immutable references to the thing. Dereferencing and destructuring is a tricky concept, but [this example](./rust/deref_destruct.rs) is helpful.

20160711
If adding a rust test file to a test package, make sure to update `lib.rs`.

20160712
- Defining macro in emacs: `C-x (` (define macro) `C-x )` `C-e` (execute macro)
- For Boolean matching in Rust, use `&&`.
- In Rust, if `Result` returns only an error, use `Result<(), Error>`.
- To add crate dependencies in Rust, update `lib.rs` (`extern crate foo`) and `Cargo.toml` (`use foo="0.0.1"`).

20160713
[Deref](https://doc.rust-lang.org/book/deref-coercions.html) in Rust can result differently than what you expected. Check the documents!

20160714
[Some tips about `Result` and `match` in Rust](https://rgsoc-jam.github.io/articles/2016-07-14/putting-append-together)

20161004
For coordinates, it's pretty awesome to use complex numbers! Say current orientation is (1 + 0i). If you turn right, you multiply the position by `-i` (left is `i`). If you set that as a new position, you have made a step.

20170330
[How to use `rust-lldb`](./rust/rust-lldb.md) for debugging!

20170403
Emacs tip: For cleaning eshell, type `C-c M-o`.
