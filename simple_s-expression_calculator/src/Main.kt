import Calculator.Calculator
import Command.Commands
import Utils.Texts
import Utils.ValidationUtils
import Utils.toExecutableArgument

//enter point
fun main(args: Array<String>) {
    startProcess(args)


//for debug purposes
//    startTest("multiply ${Long.MIN_VALUE}") //use only for internal test
//    startTest("--help") //use only for internal test
}

/**
 * initial process
 */
private fun startProcess(args: Array<String>) {

    //is args valid
    if (!ValidationUtils.isArgsValidSize(args)) {
        //incorrect amount
        println(Texts.ARGUMENT_AMOUNT_ERROR)
        return
    }

    //get command and covert to lowercase and fix some other possible issues
    val argument = args[0].toExecutableArgument()

    //do job
    if (ValidationUtils.isCommand(argument)) {
        Commands.execute(argument)
    } else {
        Calculator.execute(argument)
    }
}

/**
 * use only for debug purposes
 */
private fun startTest(string: String) {
    val array = arrayOf(string)
    startProcess(array)
}


