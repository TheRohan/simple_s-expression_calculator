package Utils

object Texts {

    //errors
    val ARGUMENT_AMOUNT_ERROR
        get() = "You need to provide 1 argument only!" +
                "\n\tExample:" +
                "\n\t $RUN_COMMAND_EXAMPLE --help" +
                "\n\t $RUN_COMMAND_EXAMPLE 123" +
                "\n\t $RUN_COMMAND_EXAMPLE \"add 1 3\"" +
                "\n\t $RUN_COMMAND_EXAMPLE \"(multiply 2 2)\"" +
                "\nFor more details use next command:" +
                "\n\t $RUN_COMMAND_EXAMPLE --help"

    val NO_COMMAND_FOUND_ERROR
        get() = "No such command was found please use next command to get a help" +
                "\n$RUN_COMMAND_EXAMPLE --help"


    //command
    val HELP_COMMAND
        get() = "\nS-expression calculator by Podbereznyi Ruslan" +
                "\nCommands:" +
                "\n\t --h | --help \tdisplay help menu" +
                "\n\t --a | --author \tdisplay author details" +
                "\n\nUsage:" +
                "\n\t (FUNCTION EXPR EXPR)" +
                "\nExample:" +
                "\n\t 123" +
                "\n\t add 1 3" +
                "\n\t add 1 (add 3 2)" +
                "\n\t multiply 3 5 3 4 -123" +
                "\n\t multiply 3 5 add 3 multiply 2" +
                "\n\t multiply 3 (multiply 5 2)" +
                "\n\t multiply 3 (multiply 5 (multiply 4 (add 3 5)))" +
                "\nNote:" +
                "\n\t your result will have next borders:" +
                "\n\t (can't be less) min value is ${Long.MIN_VALUE}" +
                "\n\t (can't be more) max value is ${Long.MAX_VALUE}"


    val AUTHOR_COMMAND
        get() = "\nS-expression calculator by Podbereznyi Ruslan" +
                "\nHow to connect:" +
                "\n\t Email - ruslan.podbereznyi.dev@gmail.com" +
                "\n\t LinkedIn - https://www.linkedin.com/in/ruslan-podbereznyi-408148221/"


    //helper
    private const val RUN_COMMAND_EXAMPLE = "java -jar s_expression_calculator.jar"
}
