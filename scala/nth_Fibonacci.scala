def fib(n: Int): BigInt = {
  def fibHelper(n:Int, prev: BigInt = 0, next: BigInt = 1): BigInt = n match {
    case 0 => prev
    case 1 => next
      // If n is not 0 or 1, next becomes prev and next+prev becomes
      // next.  When n reaches 1, fibHelper will return next, which
      // will be the sum of the two previous Fibonacci numbers.
    case _ => fibHelper(n - 1, next, (next + prev))
  }
  fibHelper(n)
}

// Another way to do it without pattern matching is:
def fib(n: Int): BigInt = {
  def fibHelper(n: Int, prev: BigInt = 0, next: BigInt = 1): BigInt = {
    if (n == 0) prev
    else if (n == 1) next
    else fibHelper(n - 1, next, (next + prev))
  }
  fibHelper(n)
}
