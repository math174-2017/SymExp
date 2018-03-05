package polynomial

fun main(args: Array<String>) {
    val expr = Polynomial(Symbol('x') * Symbol('y',2))
    expr += Sym.pow(3)
    expr -= 4 * Sym
    val exprVal = expr.eval('x' equals 2, 'y' equals 3)
    println("$expr = $exprVal")
}