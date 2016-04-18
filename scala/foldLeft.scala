// Defining the List object.
sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}

// `foldLeft` applies the function to head as it goes. `foldRight`
// moves to the right (tail) recursively, and will run out of memory
// if the list is large.
@annotation.tailrec
def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B =
  as match {
    case Nil => z
    case Cons(h, t) => foldLeft(t, f(z, h))(f) 
  }

@annotation.tailrec
def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B =
  as match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

def left_sum(ns: List[Int]) =
  foldLeft(ns, 0)((s, h) => s + h)

def left_product(ns: List[Int]) =
  foldLeft(ns, 1.0)((s, h) => s * h)

def left_length[A](ns: List[A]): Int =
  foldLeft(ns, 0)((l, _) => l + 1)
// in the long version: foldLeft(ns, 0)((l, head) => l + 1)

def reverse[A](ns: List[A]): List[A] =
  foldLeft(ns, List[A]())((acc, h) => Cons(h, acc))
// a = Cons(1,Cons(2,Cons(3,Nil)))
// reverse(a)
// foldLeft(Cons(1,Cons(2,Cons(3,Nil))), List[A])(acc, head) => Cons(head, acc)
//     List[A] => Cons(1, Nil)
// foldLeft(Cons(2,Cons(3,Nil)), Cons(1, Nil))(acc, head) => Cons(head, acc)
//     Cons(1, Nil) => Cons(2, Cons(1, Nil))
// foldLeft(Cons(3,Nil), Cons(2, Cons(1, Nil)))(acc, head) => Cons(head, acc)
//     Cons(2, Cons(1, Nil)) => Cons(3, Cons(2, Cons(1, Nil)))

def appendViaFoldRight[A](l: List[A], r: List[A]): List[A] =
  foldRight(l, r)(Cons(_,_))
//             ^  ^~~ Actually is `((head, r) => Cons(head, r))`
//             `~~ to be used as the parameter for the
//                 following anon function.
// If we wrote `foldRight(l, r)(Cons)` it won't work because `Cons` is not a function.


// Exercise 3.16
def addOne(ns: List[Int]): List[Int] =
  foldRight(ns, List[Int]())((h, l) => Cons(h+1, l))

def concat[A](l: List[List[A]]): List[A] =
  foldRight(l, Nil:List[A])(append)

// Exercise 3.17
def switchToString(ns: List[Double]): List[String] =
  foldRight(ns, List[String]())((h, l) => Cons(h.toString, l))

// Exercise 3.18: not stack-safe
def map[A, B](as: List[A])(f: A => B): List[B] =
  foldRight(as, List[B]())((h, t) => Cons(f(h), t))

// Exercise 3.19
def filter[A](as: List[A])(f: A => Boolean): List[A] =
  foldRight(as, List[A]())((h, t) => if (f(h)) Cons(h, t) else t)

// Exercise 3.20
def flatMap[A,B](l: List[A])(f: A => List[B]): List[B] =
  concat(map(l)(f))

// Exercise 3.21
def flatMapFilter[A, B](as: List[A])(f: A => Boolean): List[B] =
  flatMap(as)(a => if (f(a)) List(a) else Nil)

// Exercise 3.22
def addLists(la: List[Int], lb: List[Int]): List[Int] =

