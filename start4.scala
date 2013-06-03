object Program {

  def silnia(n: Int): Int = {
		//assert(n>=0)
		if (n<=0) {
			1
			 }			
		else {
			n * silnia(n-1)
		}
	}

	def silnia2(n: Int): Int = n match {
		case 0 => 1
		case k => k * silnia2(k - 1)
	}

	def odwroc[T](l: List[T]): List[T] = {
		if (l.isEmpty) {
			Nil
			 }
			
		else {
			l.last :: odwroc(l.init)


		}
	}

	def odwroc[T](l1: List[T], l2: List[T]): List[T] = {
		if (l1.isEmpty) {
			l2
			 }
			
		else {
			odwroc(l1.tail, l1.head :: l2)

		}
	}

	def bezpowtorzen[T](l1: List[T], l2: List[T]): List[T] = {
		if (l1.isEmpty) {
			l2
			 }
			
		else {
			
			bezpowtorzen(l1.head :: l2, l1.tail)
		}
	}
	def bezpowtorzen[T](l1: List[T], l2: List[T], cos: Set[T]): List[T] = {
		if (l1.isEmpty) {
			l2.reverse
			 }
			
		else {
			val e = l1.head
			if (cos.contains(e)) {
				bezpowtorzen(l1.tail, l2, cos)
			}
			else {
				bezpowtorzen(l1.tail, e :: l2, cos + e)
			}
		}
	}
	def main(args: Array[String]) = {
		val list = List(2,3,2,5,1,3,6,8,7)
		//println(odwroc(list))
		//println(odwroc(list, Nil))
		//println(bezpowtorzen(list, Nil))
		println(bezpowtorzen(list, Nil, Set()))
		//println(silnia(5))
		//println(silnia2(5))
	}

}
