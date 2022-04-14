val myArray = Array(1,2,3)

for(i <- myArray) println(i)

for(i <- myArray) yield i*2

val  matrix = Array.ofDim[Int](2,3)

matrix(0)(0) = 1
for{
  row <- matrix
  cell <- row
} println(cell)

val i=3

myArray(321321) = 3


val tuple2: (Int, String) = (1,"hello")
val tuple3 = (1,"hello",1.5d)
val tuple2Swapped: (String, Int) = tuple2.swap