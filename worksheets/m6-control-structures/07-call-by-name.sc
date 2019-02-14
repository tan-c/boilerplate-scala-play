//def assertTrue(predicate: () => Boolean): Boolean = predicate()
//
//assertTrue(() => 12 > 10)
//assertTrue(() => 12 + 34 - 12 > 30)
//
///* results in compilation failure, since it needs a function that takes nothing and returns Boolean */
//// assertTrue(12 > 10)


def assertTrue(predicate: => Boolean): Boolean = predicate

assertTrue(12 > 10)
assertTrue(12 + 34 - 12 < 30)


/* code evaluated before being passed to function */
def ifEval(predicate: Boolean,
           ifTrue: String,
           ifFalse: String): String = if (predicate) ifTrue else ifFalse

ifEval(1 > 0,
  {println("true branch executed"); "TRUE"},
  {println("false branch executed"); "FALSE"}
)

/* code evaluated only when a condition matches */
def ifByName(predicate: Boolean,
             ifTrue: => String,
             ifFalse: => String): String = if (predicate) ifTrue else ifFalse

ifByName(1 > 0,
  {println("true branch executed"); "TRUE"},
  {println("false branch executed"); "FALSE"}
)


// Call by name VS Call by value

def func(): Int ={
  println("Compute some stuff...")
  23 // return value
}

def callByValue(x:Int)={
  println(s"1 first : $x ")
  println(s"2 second : $x ")
}

def callByName(x: => Int)={
  println(s"1 first : $x ")
  println(s"2 second : $x ")
}

callByName(func()) // twice Compute some stuff...
println("---------------------------------")
callByValue(func()) // once Compute some stuff...
