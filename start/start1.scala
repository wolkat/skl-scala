object start {
   def funkcja = (napis: String, n: Int) => napis.length *n
	  //funkcja("ala",3)
	  //funkcja: (String, Int) => Int = <function2>


	  def funkcja1 = (napis: String, n: Int) => napis *  n
	  //funkcja1("ala",3)
	  //funkcja1; (String, Int) => String = <function2>

	  def max(x: Int, y: Int) = if (x>y) x else y
	  //max: (x: Int, y: Int)Int

	  //max(12,4)

	  def app(fun: (Int)=>Int, lista: List[Int])= lista.map(fun)
	  //app: (fun: Int => Int, lista: List[Int])List[Int]

	  def app2(fun: (Int,Int)=>Int)(a: Int)(b: Int)= fun(a,b)
	  //app2: (fun: (Int, Int) => Int)(a: Int)(b: Int)Int


	def main(args: Array[String]) {
	  
	  val lista = args.toList
	  lista.foreach(napis => println(napis))
	  funkcja("ala",3)
	  funkcja1("ala",3)
	  max(-3,34)
	  val wartosc = {max(12,4); max(1,5)}
	  println(wartosc)
	  app(x => x + 1, List(1,2,3,4))
	  //res0: List[Int] = List(2, 3, 4, 5)
	  val f = app2(_+_) _
	  //res3: Int => (Int => Int) = <function1>
	  f(2)(3)

	  /*println("Hello " )
	  val dl = args.length
	  var x = 0
	  if (dl==0) println("nie da rady")
	  else {
	  	do { 
	  		println(args(x))
	  		x +=1 
	  	} 
	  	while (x<dl)
	  } */
	  /*
	  val arr=Array("Bolek", "Lolek")
	  val list = arr.toList
	  list.foreach(napis=> println(napis.length))
	  

	  */
	}
}
