package Utils

object ValidationUtils {

    /**
     *  check if arguments have valid size
     */
    fun isArgsValidSize(args: Array<String>) = args.size == 1

    /**
     * check if string is command
     */
    fun isCommand(str:String) = str.startsWith("--")


}
