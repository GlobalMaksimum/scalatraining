val a = "hello world" // type inference
val b: String = "hello world"

var a2: Int = 2

val x = 3

/*
Byte
Char
Short
Int
Long
Float
Double
Boolean
String
 */

val op = 2 + 3 // + - * / %

val op = 2.+(3)

"istanbul".contains("ul")
"istanbul" contains "ul"

// control structure

val ifElseExample = if (op > 5) "op is five" else "less than five"
val ifElseExample = if (op > 5) {
  "op is five"
} else {
  "less than five"
}

val blockExpression = {
  val x = 4
  2+3
  x+3
}

print("dsadasdsa")
print("dasdsadsa")
//println("hello world");println("hello world")
val world = 2
val sample = s"hello ${world + 4}"
val a =
  s"""
    dasdasdsadas
    dasdasdad
    asdsa " " $world
    """

try {
  throw new Exception
} catch {
  case e:Exception => {
    
  }
}
