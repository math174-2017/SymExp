package polynomial

fun main(args: Array<String>) {
    val expr = Polynomial(Symbol('x'))
    expr += Sym.pow(3)
    expr -= 4 * Sym
    println("f(x) = $expr")
    expr.derivative()
    println("Df = $expr")
}