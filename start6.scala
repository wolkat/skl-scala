val l = List(1,4,3,5,6,12,15)
//l: List[Int] = List(1, 4, 3, 5, 6, 12, 15)

var m = List(10,10,10)
//m: List[Int] = List(10, 10, 10)

l zip m
//res0: List[(Int, Int)] = List((1,10), (4,10), (3,10))
l zipAll (m, -1, -2)
//res2: List[(Int, Int)] = List((1,10), (4,10), (3,10), (5,-2), (6,-2), (12,-2), (15,-2))
m.zipAll(l,-1,-2)
//res3: List[(Int, Int)] = List((10,1), (10,4), (10,3), (-1,5), (-1,6), (-1,12), (-1,15))
val secret = List(2,5,1,0,2)
//secret: List[Int] = List(2, 5, 1, 0, 2)

val move=List(1,3,2,1,2)
//move: List[Int] = List(1, 3, 2, 1, 2)

//def porownanie(s: List[Int], m: List[Int]): List[Char] = {

//}
val secret = List(2,5,1,2,2)
val move = List(1,3,2,1,2)
//val same = ser.partition(s => s._1  == s._2)._1.length
//same: Int = 1
//val dif = ser.partition(s => s._1  == s._2)._2
//dif: List[(Int, Int)] = List((2,1), (5,3), (1,2), (0,1))
val (good,bad) = secret.zip(move).partition { case (x,y) => x == y }
//good: List[(Int, Int)] = List((2,2))
//bad: List[(Int, Int)] = List((1,2), (3,5), (2,1), (1,0))
val black = good.size
val white = bad.unzip._1.intersect(bad.unzip._2).size

//secret.map(x=> (x, secret.count(y => y==x))).toSet
val wz1 = (n: Int) => if (n == 2 || n== 7) 1 else 0
val wz2 = (n: Int) => match n {
  case 2 => 2
	case 7 => 1
	case _ => 0
}
def suma(wz1: Int => Int, wz2: Int => Int): Int => Int = {
	(n: Int) => wz1(n) + wz2(n)
}
def iloczyn(wz1: Int => Int, wz2: Int => Int): Int => Int = {
	(n: Int) => wz1(n).min(wz2(n))
}
def suma[T](wz1: T => Int, wz2: T => Int): T => Int = {
	(n: T) => wz1(n) + wz2(n)
}
def iloczyn[T](wz1: T => Int, wz2: T => Int): T => Int = {
	(n: T) => wz1(n).min(wz2(n))
}
suma(wz1, wz2)(2)
iloczyn(wz1, wz2)(2)

//zad domowe
def toMultiSet[T](l: List[T]): T => Int = {
	//(n: Int) => l.count(_ == n)
	//(n: Int) => n::l
	n => l.count(_ == n)
}




def iloczyn[T](l1: List[T], l2: List[T]): T => Int = {
	t => l1.count(_ == t).min(l2.count(_ == t))
}

//-------
type MultiSet[T] = T => Int
def toMultiSet[T](l: List[T]): MultiSet[T] = { t => l.count(_ == t) }
def iloczyn[T](ms1: MultiSet[T], ms2: MultiSet[T]): MultiSet[T] =
	t => (ms1(t) min ms2(t))


val l1 = List(1,2,5,3,4,1,8)
val l2 = List(2,1,0,9,4,4,3)
val ms = iloczyn(toMultiSet(l1),toMultiSet(l2))
val czarne = (l1 zip l2).count( x => x._1 == x._2)

val biale = (for (e <- l1.distinct) yield ms(e)).sum - czarne

val f = toMultiSet(List(1,2,1,3,1,2)): Int => Int
f(1)

