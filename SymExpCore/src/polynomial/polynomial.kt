package polynomial

import text_util.sup
import kotlin.math.pow

/**
 * a polynomial is the largest unit that composes an Expression.
 * it stores a Term and a list of coefficients. if a coefficient
 * is stored at an index of 0 it is the coefficient for the Term
 * to the power of 1, so if it were stored at an index of 1 it
 * would be the coefficient of the Term to the power of 2 and so
 * on.
 */
class Polynomial(val term: Term) {
    constructor(symbol: Symbol) : this(Term(symbol))

    private var coefficients: MutableList<Double> = mutableListOf()
    var ones = 0

    /**
     * represents an instance of Polynomial as a human readable String
     */
    override fun toString(): String = terms().joinToString(" + ").replace("+ -", "- ")

    /**
     * evaluates a polynomial for [values]. for example
     * if [values] is 'x' to 1 and 'y' to 2 it would
     * evaluate the term as if x = 1 and y = 2
     */
    fun eval(vararg values: Pair<Char, Number>): Double {
        val valueMap = values.toMap()
        val solve = term.size() - term.similar(valueMap.keys)
        if (solve > 0) {
            return 1.0
        } else {
            return (0 until coefficients.size).sumByDouble {
                coefficients[it] * term.eval(valueMap).pow(it + 1)
            } + ones
        }
    }

    /**
     * it increments a value the coefficient by [value]
     * at the index [power] - 1, while filling empty
     * indexes with 0s.
     */
    fun add(value: Number, power: Int) {
        while (coefficients.size < power) coefficients.add(0.0)
        coefficients[power - 1] += value.toDouble()
    }

    operator fun plusAssign(newTerm: Sym) {
        val multiple = newTerm.multiple
        val power = newTerm.power
        newTerm.reset()
        while (coefficients.size < power) coefficients.add(0.0)
        coefficients[power - 1] += multiple
    }

    operator fun minusAssign(newTerm: Sym) {
        val multiple = -1 * newTerm.multiple
        val power = newTerm.power
        newTerm.reset()
        while (coefficients.size < power) coefficients.add(0.0)
        coefficients[power - 1] += multiple
    }

    /**
     * breaks the coefficients list down to a list of human readable Strings for each term of the polynomial.
     */
    fun terms(): List<String> {
        val text = mutableListOf<String?>()
        ((coefficients.size - 1) downTo 0).forEach {
            text.add(multiple(it, "$term${exponent(it)}"))
        }
        return text.plus(listOf<String?>(if (ones != 0) "${ones.toInt()}" else null)).filterNotNull()
    }

    /**
     * handles the logic for representing a term being multiplied by a coefficient
     */
    private fun multiple(num: Int, term: String): String? {
        return when (coefficients[num]) {
            0.0 -> null
            1.0 -> term
            -1.0 -> "-$term"
            coefficients[num].toInt().toDouble() -> "${coefficients[num].toInt()}$term"
            else -> "${coefficients[num]}$term"
        }
    }

    /**
     * handles the logic for representing a term being raised to a power
     */
    private fun exponent(num: Int): String {
        return if (num != 0) (num + 1).sup() else ""
    }

    fun derivative(): Boolean {
        if (term.size() <= 1) {
            for (n in 0 until coefficients.size) {
                coefficients[n] = (n + 1) * coefficients[n]
            }
            ones = coefficients.pop().toInt()
        }
        return term.size() <= 1
    }
}