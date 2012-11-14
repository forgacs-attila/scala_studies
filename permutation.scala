package woot.interview

object p1 {

  def angle(h: Int, m: Int): Int = {
    val H = h * (360 / 12)
    val M = m * (360 / 60)
    math.abs(H - M) % 360
  }                                               //> angle: (h: Int, m: Int)Int

  angle(1, 0)                                     //> res0: Int = 30
  3 * 15                                          //> res1: Int(45) = 45
  angle(0, 45)                                    //> res2: Int = 270
  angle(3, 45)                                    //> res3: Int = 180

  def permutate(s: String): List[String] = {
    def mergeToAll(c: String, big: String): List[String] = {
      println("Merge:" + big + " <<-" + c)
      big match {
        case s: String if s.length > 0 =>
          (-1 to s.length - 1).toList.map(
            {
              case -1 => c + s
              case i: Int if i == s.length() - 1 => s + c
              case i: Int => big.substring(0, i + 1) + c + big.substring(i + 1, s.length)
            })
        case _ => List()
      }
    }
    s match {
      case s: String if s.length() == 1 => List(s)
      case s: String if s.length() == 2 => List("" + s(0) + s(1), "" + s(1) + s(0))
      case s: String if s.length() > 2 => {
        val C = s(0).toString
        val L = permutate(s.substring(1))
        println(C + ":" + L)
        (for (z <- L) yield mergeToAll(C, z)).flatten
      }
      case _ => List()
    }
  }                                               //> permutate: (s: String)List[String]

  permutate("a")                                  //> res4: List[String] = List(a)
  permutate("ab")                                 //> res5: List[String] = List(ab, ba)
  permutate("#ab")                                //> #:List(ab, ba)
                                                  //| Merge:ab <<-#
                                                  //| Merge:ba <<-#
                                                  //| res6: List[String] = List(#ab, a#b, ab#, #ba, b#a, ba#)
  val permOf4 = permutate("#abc")                 //> a:List(bc, cb)
                                                  //| Merge:bc <<-a
                                                  //| Merge:cb <<-a
                                                  //| #:List(abc, bac, bca, acb, cab, cba)
                                                  //| Merge:abc <<-#
                                                  //| Merge:bac <<-#
                                                  //| Merge:bca <<-#
                                                  //| Merge:acb <<-#
                                                  //| Merge:cab <<-#
                                                  //| Merge:cba <<-#
                                                  //| permOf4  : List[String] = List(#abc, a#bc, ab#c, abc#, #bac, b#ac, ba#c, ba
                                                  //| c#, #bca, b#ca, bc#a, bca#, #acb, a#cb, ac#b, acb#, #cab, c#ab, ca#b, cab#,
                                                  //|  #cba, c#ba, cb#a, cba#)
	assert(permOf4.length == (1 to 4).toList.fold(1)(_ * _)   )

	(1 to 4).toList.fold(1)(_ * _)            //> res7: Int = 24
}