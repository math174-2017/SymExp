package polynomial

import text_util.sup
import kotlin.math.pow

/**
 * A term is one of the basic units that composes a polynomial.
 * It stores multiple symbols which when used in an expression
 * are treated as products. for example if Term is storing
 * x and y^2 it would represent x*y^2
 */
class Term(vararg terms: Symbol) {
    private var termMap: Map<Char, Int> = mapOf()

    init {
        val names = terms.map { it.name }
        val combinedTerms = mutableListOf<Symbol>()
        val sortedTerms = terms.sortedBy {it.name}
        for (name in names.distinct()) {
            var sum = 0
            var idx: Int = sortedTerms.indexOf(sortedTerms.find {it.name == name})
            while (idx < sortedTerms.count() && sortedTerms[idx].name == name) {
                sum += sortedTerms[idx].power
                ++idx
            }
            combinedTerms.add(Symbol(name, sum))
        }
        termMap = combinedTerms.map { it.name to it.power }.toMap()
    }


    /**
     * represents an instance of Term as a human readable String
     */
    override fun toString(): String {
        return termMap.keys.joinToString(
                "",
                if (termMap.size > 1) "(" else "",
                if (termMap.size > 1) ")" else ""
        ) {
            "$it${if (termMap[it] != 1) termMap[it]!!.sup() else ""}"
        }
    }

    /**
     * eval evaluates using [values]. for example if [values]
     * is 'x' to 1 and 'y' to 2 it would evaluate the term
     * as if x = 1 and y = 2
     */
    fun eval(values: Map<Char, Number>): Double {
        var product = 1.0
        for (it in termMap.keys) {
            product *= values[it]!!.toDouble().pow(termMap[it]!!)
        }
        return product
    }

    fun symbols(): Array<Symbol> = termMap.keys.map {Symbol(it, termMap[it]!!)}.toTypedArray()


    fun size() = termMap.size

    fun similar(sym: Collection<Char>) = sym.sumBy {if (termMap.keys.contains(it)) 1 else 0 }


    /**
     * given a Char [key] it returns it's symbols
     */
    operator fun get(key: Char): Int = termMap[key]!!
}
