package expression

/**
 * converts an Int to a String that
 * has an equivalent value as a super script
 */
fun Int.sup(): String {
    val toSup: Map<Int, Char> = mapOf(
            0 to 0x2070.toChar(),
            1 to 0x00B9.toChar(),
            2 to 0x00B2.toChar(),
            3 to 0x00B3.toChar(),
            4 to 0x2074.toChar(),
            5 to 0x2074.toChar(),
            6 to 0x2074.toChar(),
            7 to 0x2074.toChar(),
            8 to 0x2074.toChar(),
            9 to 0x2074.toChar()

    )
    var text = ""
    for (digit in splitDigits(this)) {
        text += toSup[digit]
    }
    return text
}

/**
 * takes an Int [num] and splits it into a
 * MutableList where a each digit of [num] is
 * an item and the order digits is maintained
 */
fun splitDigits(num: Int): MutableList<Int> {
    val digits = mutableListOf<Int>()
    val length = num.toString().length - 1
    for (idx in 0..length) {
        digits.add(digitAt(num, idx))
    }
    return digits
}

/**
 * given a Int [num] digitAt returns the digit at the
 * index [idx] where the ones place has an index of 0
 */
fun digitAt(num: Int, idx: Int): Int {
    val digitChar = num.toString()[idx]
    return digitChar.toString().toInt()
}