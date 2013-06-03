/*
  Zdefiniuj aktora (obiekt implementujący cechę Actor), który będzie akceptował
  następujące rodzaje komunikatów:
  
    Ocena(zaw: String, w: Double, s: Double)
    Ranking
    Stop

  Po otrzymaniu komunikatu Ranking aktor powinien wyświetlać aktualny stan rankingu
  (w sensie „zadania sportowego”, włączając w to klasyfikację ex-aequo). Komunikaty
  Ocena(…) zawierają oceny poszczególnych zawodników (z notami za „wdzięk” i „spryt”).
  Noty oraz komunikaty Ranking mogą spływać w dowolnej kolejności. Komunikat Stop
  powinien powodować wyświetlenie „ostatecznej klasyfikacji” i zakończenie działania
  aktora.

  Tworząc kod aktora nie używaj zmiennych (var).

*/

object Act {

  import scala.actors.Actor

  class Ocena(val z: String, val w: Double, val s: Double) {
    override def toString = this.z + " (" + this.w + ", " + this.s + ")"
  }

  val dane = List(
    Ocena("Adamowski", 10, 10),
    Ocena("Malinowski", 10, 10),
    Ocena("Kowalski", 10, 10),
    Ocena("Wolszon", 10, 9),
    Ocena("Czarnecki", 9, 10),
    Ocena("Kubik", 9, 10),
    Ocena("Rubik", 9, 10),
    Ocena("Kozak", 10, 10))

  /*
    Nazwisko    srednia sr.wdziek   sr.spryt
    1   Adamowski   10      10          10
    2   Kozak       10      10          10
    3   Kowalski    9.66    9.66        9.66
    4   Malinowski  9.66    9.33        10
     */

  val sumaryczne = dane.groupBy((o) => o.z).
    mapValues(_.foldLeft(0.0, 0.0, 0)(
      (a, b) => (a._1 + b.w, a._2 + b.s, a._3 + 1)))

  val lista = sumaryczne.map((p) => p match {
    case (z, (w, s, n)) => ((w + s) / n, w / n, z)
  }).toList //.sort((a, b) => if(a._1 != b._1) a._1 > b._1 else if(a._2 != b._2) a._2 > b._2 else a._3 < b._3)

  type Wynik = (Double, Double, String)

  implicit def ordWynik(w1: Wynik) = new Ordered[Wynik] {
    def compare(w2: Wynik): Int = {

      if (w1._1 != w2._1) {
        if (w1._1 < w2._1) -1 else 1
      } else if (w1._2 != w2._2) {
        if (w1._2 < w2._2) -1 else 1
      } else if (w1._3 != w2._3) {
        if (w1._3 > w2._3) -1 else 1
      } else 0
    }
  }

  val posortowana = lista.toList.sortWith(_ >= _)

  for (w <- posortowana) {
    println(w._3 + ": " + w._1 + ", " + w._2)
  }

  val result = posortowana.foldLeft(List[(Int, Double, Double, String)]())((a, b) => b match {

    case (ws, w, n) =>
      if (a.isEmpty)
        (1, ws, w, n) :: a
      else if (a.head._2 == ws && a.head._3 == w)
        (a.head._1, ws, w, n) :: a
      else
        (a.head._1 + 1, ws, w, n) :: a
  })

  println("----------------------")

  for (r <- result.reverse)
    println(r._1 + ". " + r._4)

  // actors  

  case object Ocena {
    def apply(z: String, w: Double, s: Double) = new Ocena(z, w, s)
  }
  
  case object Stop {
    def apply(a: Int, b: Double, c: Double, d: String) = result
  }

  class MyActor(name: String) extends Actor {
    def act() {

      loop {
        react {
          case dane =>
            if (result != null) {
              val actorTwo = new MyActor("B").start()
              actorTwo ! (result == null)
            }

            println("[Aktor " + name + "] : " + result.toString())

        }
        react {
          case wynik =>
            if (result != null) {
              val actorThree = new MyActor("C").start()
              actorThree ! result

            }

            println("[Aktor " + name + "] : " + result.toString())
            exit()
          //case 'stop => println()

        }
      }
    }
    override def toString = "[Aktor]"
  }

  def main(args: Array[String]): Unit = {

    val actorOne = new MyActor("A").start()
    actorOne ! Stop
    actorOne ! result

  }

}
