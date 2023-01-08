package Utils

/**
 * get string to avoid some texts issue -> to lowercase + trim + remove duplicated spaces
 */
fun String.toExecutableArgument(): String = this
        .toLowerCase()
        .trim()
        .replace(
                regex = "\\s+".toRegex(),
                replacement = " "
        )
