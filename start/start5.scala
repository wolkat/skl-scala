def silnia(n: Int): Int = 
  (1 to n).toList.foldLeft(1)((l:Int, m: Int) => l * m)

val l3 = List(1, 2, 3, 4, 5,6,7,8,9)
val l1 = "Jaś i Ola mają psa Asa Pas mama ma Asp"

val m1 = l1.split(" ").toList
m1.groupBy[Int](_.toLowerCase.toSet.size)
//res95: scala.collection.immutable.Map[Int,List[String]] = Map(2 -> List(Asa, mama, ma), 4 -> List(mają), 1 -> List(i), 3 -> List(Jaś, Ola, psa, Pas, Asp))
m1.groupBy(_.toLowerCase.toSet)
//res97: scala.collection.immutable.Map[scala.collection.immutable.Set[Char],List[String]] = Map(Set(p, s, a) -> List(psa, Pas, Asp), Set(j, a, ś) -> List(Jaś), Set(i) -> List(i), Set(o, l, a) -> List(Ola), Set(m, a, j, ą) -> List(mają), Set(m, a) -> List(mama, ma), Set(a, s) -> List(Asa))

m1.groupBy[Int](_.toLowerCase.toSet.size)
//res98: scala.collection.immutable.Map[Int,List[String]] = Map(2 -> List(Asa, mama, ma), 4 -> List(mają), 1 -> List(i), 3 -> List(Jaś, Ola, psa, Pas, Asp))

m1.filter(_.length == 3).groupBy(_.toLowerCase.toSet)
//res111: scala.collection.immutable.Map[scala.collection.immutable.Set[Char],List[String]] = Map(Set(j, a, ś) -> List(Jaś), Set(a, s) -> List(Asa), Set(p, s, a) -> List(psa, Pas, Asp), Set(o, l, a) -> List(Ola))

m1.filter(_.length == 3).groupBy(_.toLowerCase.toSet).size
//res115: Int = 4


l3.foldLeft(List(1,2,3))((l: List[Int], n: Int) =>  l ::: List(n) )
//res156: List[Int] = List(1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 8, 9)

l3.foldLeft(Set(1,2,3))((l: Set[Int], n: Int) =>  l + n ).toSeq.sorted
//res152: Seq[Int] = ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9)

l3.foldLeft(Set(1,2,3))((l: Set[Int], n: Int) =>  l + n ).toList
//res148: List[Int] = List(5, 1, 6, 9, 2, 7, 3, 8, 4)

l3.foldLeft(Set(1,2,3))((l: Set[Int], n: Int) =>  l + n )
//res147: scala.collection.immutable.Set[Int] = Set(5, 1, 6, 9, 2, 7, 3, 8, 4)
