def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
  @annotation.tailred
  def loop(n: Int): Boolean =
    if (n+1 == as.length) true 
    else if ((ordered(as(n), as(n+1))) == false) false
    else loop(n+1)

  loop(0)
}

def ordered(n: Int, m: Int): Boolean = {
  n <= m
}

