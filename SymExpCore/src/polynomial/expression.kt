package polynomial

class Expression {
    var poly: MutableMap<Term, Polynomial> = mutableMapOf()
    var ones: Double = 0.0

    operator fun plusAssign(p: Polynomial) {
        poly[p.term] = p
    }

    fun derivative(): Boolean {
        val maxSym = poly.keys.maxBy {it.size()}!!.symbols().toList()
        if (poly.keys.all {
            maxSym.containsAll(it.symbols().toList())
        }) {
            var valid = true
            for (p in poly.values) {
                valid = p.derivative() and valid
                ones += p.ones
                p.ones = 0
            }
            return valid
        } else {
           return false
        }
    }

    override fun toString(): String {
        return poly.values.joinToString() + if (ones != 0.0) " + ${ones.toInt()}" else ""
    }
}