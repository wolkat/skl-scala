object Program {

  	def kwadrat(n: Int): Unit = { 
			var x = 0
			do { 
		  		println("*" * n)
		  		x += 1 
		  	} while (x < n)
		}

		def kwadrat1(n: Int): Unit = {
			for(i<-1 to n){
				for(j<-1 to n){
					print("*")
				}
				println()
			}
		}

		def kwadrat2(n: Int): String = (("*" * n) + "\n") * n

		def trojkat(wys: Int): Unit = {
			
			//for (i<-1 to wys) println(" " * (wys - i) + " *" * i)
			/*
			val wynik = (for (i<-1 to wys) yield 
				(" " * (wys - i) + " *" * i ).mkString("\n")
			println (wynik)
			*/
			(for (i<-1 to wys) yield 
				(" " * (wys - i) + " *" * i )).mkString("\n")
		} 

		def ramka(str: String): String = {
			val x = ("*" * (str.length + 4) + "\n")
			val y = ("* " + " " * str.length + " *\n")
			(x + y +"* " + str + " *\n" + y + x)

		}
		
		def duzaRamka(linie: List[String]): String = {
			val dl = linie.map(_.length).max
			val x = ("*" * (dl + 4) + "\n")
			//val y = ("* " + " " * str.length + " *\n")
			(for (el <- linie) yield 
				("* " + el + " *\n")).mkString("\n")
			
		}

	 def main(args: Array[String]){
	 	println("Ahoj Scala!")
	 	//println(kwadrat2(5))
	 	//println(trojkat(6))
	 	//println(ramka("Ala ma kota"))
	 	val lista = List("Ala ma kota","psa też", "i papugę")
	 	println(duzaRamka(lista))
	 }	

}
