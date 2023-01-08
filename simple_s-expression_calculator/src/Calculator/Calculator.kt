package Calculator

import Interfaces.IExecute

object Calculator : IExecute {


    override fun execute(initialArgument: String) {
        try {
            println("Result is: ${getResultFromString(initialArgument)}")
        } catch (e: Exception) {
            println("ERROR:" +
                    "\n\t${e.message ?: ", please check input"}")
        }
    }

    /**
     * recursive simplification + calculation
     * idea is - transform all brackets to values and get final result
     * example: add 1 (add 2 (add 0 3)) -> add 1 (add 2 3) -> add 1 5 -> 6
     */
    private fun getResultFromString(param: String): Long {
        var mutableString = param
        while (true) {
            val brackets = getFirstBrackets(mutableString)

            //need to simplify
            if (brackets != null) {
                mutableString = mutableString.replace(brackets, " ${getResultFromString(brackets.drop(1).dropLast(1))} ")
            } else {
                return processExpresionFromString(mutableString)
            }
        }
    }

    /**
     * calculate final list of values and commands like "add 1 2 3 OR 1 2 3 OR multiply add add 2 3 4"
     */
    private fun processExpresionFromString(expression: String): Long {
        var result: Long? = null

        //split by spaces
        val listOfExpressions = expression.split("\\s+".toRegex()).toTypedArray()

        var currentAction = Actions.UNKNOWN //set do default
        listOfExpressions.forEach {
            if (it != "") {
                val value = it.toLongOrNull() //parse to long to check if it digit or action

                if (value != null) {//digit
                    //do calculation
                    result = applyNewValue(result, value, currentAction)

                } else { //action
                    //update action
                    var newAction: Actions? = null
                    Actions.values().forEach { action ->
                        if (it == action.toString()) {
                            newAction = action
                        }
                    }
                    if (newAction != null) {
                        currentAction = newAction!!
                    } else {
                        throw Exception("No such action '$it'")
                    }
                }
            }
        }

        return result ?: 0
    }

    /**
     * do calculation depending on action
     */
    private fun applyNewValue(oldValue: Long?, newValue: Long, action: Actions): Long {
        var result = oldValue ?: 0
        when (action) {
            Actions.UNKNOWN -> { //just override
                result = newValue
            }
            Actions.ADD -> { // +
                result = if (oldValue == null) {
                    newValue
                } else {
                    result + newValue
                }
            }
            Actions.MULTIPLY -> { // *
                result = if (oldValue == null) {
                    newValue
                } else {
                    result * newValue
                }
            }
        }
        return result
    }


    /**
     * find first rounded brackets line in the string
     * @return (expr) if it is fine, null in there is no brackets, exception if something went wrong
     */
    private fun getFirstBrackets(expression: String): String? {
        var openBracketsCounter = 0
        var result = ""
        var isCopyActive = false
        for (c in expression) {
            //looking for new (
            if (c == '(') {
                isCopyActive = true
                openBracketsCounter++
            }
            //copy char to result
            if (isCopyActive) {
                result += c
            }

            if (c == ')') {
                //if ) before (
                if (openBracketsCounter <= 0) {
                    throw Exception("invalid input ')' before '('" +
                            "\n\t...$result...")
                }
                //remove from line
                openBracketsCounter--

                //if all line closed stop cycle
                if (openBracketsCounter == 0) {
                    return result
                }
            }
        }

        if (openBracketsCounter > 0) {
            throw Exception("expresion should not have unclosed brackets '('" +
                    "\n\t...$result...")
        }

        return null
    }

}