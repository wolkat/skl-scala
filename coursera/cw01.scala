object HelloWorld {
   def silnia(n: Int): Int = n match {
       case 0 => 1
       case _ => n* silnia(n-1)
   }
   
   def dwumian(n: Int, k: Int): Int = silnia(n)/(silnia(k)*silnia(n-k))
   
   def pascal(n: Int) = {
       var l=n
       for (i <- 0 to (n-1)) {
           print("  " * l)
           for (j <- 0 to i) print(dwumian(i,j)+ "   ")
            l-=1
            println()
       }
   }
   
   def balance(chars: List[Char]): Boolean = {
        def licz(chars: List[Char], nawias: Int): Boolean = {
          if (chars.isEmpty) {
            nawias == 0
          } else {
            val h = chars.head
            val n =
              if (h == '(') nawias + 1
              else if (h == ')') nawias - 1
              else nawias
            if (n >= 0) licz(chars.tail, n)
            else false
          }
        }
 
        licz(chars, 0)
       
   }
   
   def main(args: Array[String]) {
      //println("Hello, world!")
      println(pascal(6))
      var s = "(())()"
      var z = "()(()(()"
      println(balance(s.toList))
      println(balance(z.toList))
      
      
   }
}
