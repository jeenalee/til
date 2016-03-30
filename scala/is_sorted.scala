def isSorted[A](as: Array[A], f: (A,A) => Boolean): Boolean = {
  @annotation.tailrec
  def loop(n: Int): Boolean =
    if (n+1 == as.length) true 
    else if ((f(as(n), as(n+1))) == false) false
    else loop(n+1)

  loop(0)
}

def ordered(n: Int, m: Int): Boolean = {
  n <= m
}

isSorted(Array(1, 2, 3), ordered)
