object Program {
  def trojkat(c: Char): String = {
		val x = 'A' to c
		val str = (for (i<-x) yield  {
			val space = (for (j<- i until c) yield " ").mkString("")
			val s = ('A' until i).mkString("")
			(space + s + i + s.reverse + space)
			
			})
		val str2 = ((str.reverse).drop(1))
		(str.mkString("\n") + "\n" + str2.mkString("\n"))
				
	}

	def dlugosc(l: List[Int]): Int = {
		//head, tail, Nil
		if (l.isEmpty) {
			0
			 }
			
		else {
			dlugosc(l.tail) + 1
			
		}
	}

	def dlugosc1[T](l: List[T]): Int = {
		//head, tail, Nil
		if (l.isEmpty) {
			0
			 }
			
		else {
			dlugosc1(l.tail) + 1
			
		}
	}


	def main(args: Array[String]) = {
		val lista = List(1,2,4,3,5,2,8)
		val lista2 = List("ala", "ma", "kota")
		//println(trojkat('E'))
		println(dlugosc(lista))
		println(dlugosc1(lista2))
	}

}
