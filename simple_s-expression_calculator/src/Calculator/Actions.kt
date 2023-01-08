package Calculator

/**
 * list of strings/key words for actions
 */
enum class Actions {
    UNKNOWN {
        override fun toString(): String {
            return ""
        }
    },

    ADD {
        override fun toString(): String {
            return "add"
        }
    },

    MULTIPLY {
        override fun toString(): String {
            return "multiply"
        }
    }
}