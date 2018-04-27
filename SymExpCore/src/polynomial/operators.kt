package polynomial

infix fun Char.equals(value: Number) = this to value

operator fun Symbol.times(other: Symbol) = Term(this, other)

operator fun Term.times(other:Symbol) = Term(*this.symbols(), other)

operator fun Number.times(s: Sym): Sym = s * this

object Sym {
    var power: Int = 1
    var multiple: Double = 1.0

    operator fun times(num: Number): Sym {
        multiple = num.toDouble()
        return this
    }

    fun pow(num: Number): Sym {
        power = num.toInt()
        return this
    }

    fun reset() {
        power = 1
        multiple = 1.0
    }
}

fun MutableList<Double>.pop(): Number {
    val num = this[0]
    this.removeAt(0)
    return num
}