// Defining the List object.
sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}

// foldRight iterates through a List, and reaches to the right end of
// the List.
def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B =
  as match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

// sum finds the sum of the items in the list using foldRight.  It
// iterates to the right end of the list, and sums the head of each
// Cons.
def sum(ns: List[Int]) =
  foldRight(ns, 0)((x, y) => x + y)

// length finds the length of the list using foldRight.
// It is similar to sum, but it ignores what the head of Cons is.
def length[A](l: List[A]): Int =
  foldRight(l, 0)((_, acc) => acc + 1)
//             ^       ^       ^-- Adds '1' to acc. See next line.
//                     `
//             `       `--- 'acc' is the parameter fed from previous step.
//             `             It will be '0' for the first iteration..
//             `
//             `--- This is the parameter of the next function.
//                  It will be annotated as 'acc'.

// The folllowing fake_length will return a value that is length + 5.
// It's because the initial value fed to the function is 5 instead of 0.
def fake_length[A](l: List[A]): Int =
  foldRight(l, 5)((head, acc) => acc + 1)
//             ^    ^--- We don't care about 'head'. Even if it's named
//             `         something funky, it won't matter because the
//             `         following anonymous function doesn't use this parameter.
//             `              
//             `--- This is the parameter of the next function.
//                  Because it starts with 5 (not 0), the value returned
//                  will be '5 + actual length'.
