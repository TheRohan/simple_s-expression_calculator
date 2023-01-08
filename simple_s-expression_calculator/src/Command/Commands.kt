package Command

import Interfaces.IExecute
import Utils.Texts

/**
 * Text info command
 */
object Commands : IExecute {

    override fun execute(initialArgument: String) {
        //remove -- prefix
        val command = initialArgument.removeRange(0, 2)

        //check command list and get message if exist
        var resultText: String? = null
        for (it in CommandInfo.existingCommands) {
            for (commandFromList in it.commandList) {
                if (commandFromList == command) {
                    resultText = it.outputText
                    break
                }
            }
            if (resultText != null) {
                break
            }
        }

        //display command or error if no command was found
        println(resultText ?: Texts.NO_COMMAND_FOUND_ERROR)
    }

}