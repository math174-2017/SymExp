package polynomial

fun main(args: Array<String>) {
    val expr = Expression()
    val p = Polynomial(Symbol('x'))
    p += Sym.pow(3)
    p -= 4 * Sym
    expr += p
    println(expr)
    assert(expr.derivative())
    println(expr)
}