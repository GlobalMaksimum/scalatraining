var a = 0

while (a < 10) {
  println(s"my value $a")
  a = a + 1
}

a = 0
do {
  println(s"my value $a")
  a = a + 1
} while (a < 10)

// for comprehension
// for(i:Int=0;i<10;i+=)
// val x = 1.to(10)
for (i <- 1 to 10) println(i)
for (i <- 1 until 10; j <- 1 to 5) println(s"my i:$i and j:$j")
for {
  i <- 1 until 10
  j <- 1 to 5
} println(s"my i:$i and j:$j")

for {
  i <- 1 until 10
  j <- 1 to 5
} yield i + j

//def abs(x:Double) = if(x>=0) x else -x
def abs(x: Double): Double = if (x >= 0) x else -x

def abs(x: Double): Double = if (x >= 0) {
  x
} else {
  -x
}

def myvalue = 1

def decorate(str: String, left: String = "(", right: String = ")"):String = {
  if (str == "exception")
    throw new Exception
  else
    s"$left$str$right"
}


//decorate(str="hello",right="]",left="[")

var a = 1
def hello = "dasdsadsa"
def myProcedure(): Unit = {
  println("hello")
}

def calculateSomething(x:Int):Int = ???


def sum(args:Int*):Int = {
  var result = 0
  for (i <- args) result += i
  result
}

sum(1,2,3)
