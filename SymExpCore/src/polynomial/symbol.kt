package polynomial

import text_util.sup
import kotlin.math.pow

/**
 * Symbol is the most basic unit of an expression.
 * it is represented as a pair of it's character
 * and the exponent the symbol is raised by
 */
class Symbol(val name: Char, val power: Int = 1) {
    /**
     * returns the value of the symbol when it is evaluated for a Double [num]
     */
    fun eval(num: Double) = num.pow(power)

    /**
     * represents the symbol as a human readable string
     */
    override fun toString(): String = "$name${power.sup()}"

    operator override fun equals(other: Any?): Boolean {
        return if (other is Symbol) name == other.name && power == other.power else false
    }
}