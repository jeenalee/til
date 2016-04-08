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
