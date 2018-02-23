package expression

fun main(args: Array<String>) {
    val expr = Polynomial(Symbol('x'), Symbol('y', 2))
    expr.add(1, 3)
    expr.add(-1, 1)
    println(expr)
    print(expr.eval(mapOf('x' to 2.0, 'y' to 3.0)))
}