sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def tail[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(_, t) => t
  }

  def setHead[A](head: A, l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(oldhead, t) => Cons(head, t)
  }

}

def drop[A](l: List[A], n: Int): List[A] =
  if (n <= 0) l
  else l match {
    case Nil => Nil
    case Cons(_,t) => drop(t, n-1)
  }

// def dropWhile[A](l: List[A], f: A => Boolean): List[A] = {
//   if (l == Nil) Nil
//   else if (l == Cons(h, t)) {
//     if (f(h)) dropWhile(t, f)
//   }
// }


def dropWhile[A](l: List[A], f: A => Boolean): List[A] =
  l match {
    case Cons(h,t) if f(h) => dropWhile(t, f)
    case _ => l
  }


def init[A](l: List[A]): List[A] =
  l match {
    case Cons(h, t) if (t == Nil) => l
  }

def init[A](l: List[A]): List[A] =
  l match {
    case Nil => Nil
    case Cons(_,Nil) => Nil
    case Cons(h,t) => Cons(h,init(t))
  }
