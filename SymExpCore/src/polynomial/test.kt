package polynomial

fun main(args: Array<String>) {
    val expr = Polynomial(Symbol('x') * Symbol('y',2))
    expr.add(1,3)
    expr.add(-4,1)
    val exprVal = expr.eval('x' equals 2, 'y' equals 3)
    println("$expr = $exprVal")
}