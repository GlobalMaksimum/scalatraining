//Array
val l = List(1,2,3)
val l2 = List(9,8,7)
l.head
val lempty:List[Int] = List.empty
lempty.headOption

l.map(i=> i*2)
l.map(i=> i.toString + "str")
l.flatMap(i => List(i,i,i,i))
val nonFlatten = l.map(i => List(i,i,i,i))
nonFlatten.flatten

l.foreach(i => println(i))
l.zip(l2)
l2.zipWithIndex
l.reduce((l,r) => l+r)
//List.empty[Int].reduce((l,r) => l+r)
List.empty[Int].foldLeft(0)((z,e) => z+e)
l.map(_.toString).foldLeft("0")((z,e) => z+e)
l.map(_.toString).foldRight("0")((e,z) => z+e)
val arr = Array(1,2,3)
arr(0) = 5
val newList = l.prepended(0)

val newList2 = 0 :: l
val fromEmpty = 0 :: 1 :: 2 :: 3 :: Nil
val concat = newList2 ::: fromEmpty

// Set

val set = Set(2,1,3)

set.map(i=>if(i==1) 2 else i)
set.flatMap(i => Set(i,i*2,i*3))
set.zipWithIndex


// Map
val m = Map(34 -> "Istanbul",10 -> "Balikesir",17 -> "Canakkale",1->"Adana")
val m2 = Map((34 , "Istanbul"),(10 , "Balikesir"),(17 , "Canakkale"),(1,"Adana"))
m.map{case (k,v) => (k*2,v)}
m.map(_._1)

List((34 , "Istanbul"),(10 , "Balikesir"),(17 , "Canakkale"),(1,"Adana")).toMap
l.filterNot(_%2==0)

