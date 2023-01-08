package Command

import Utils.Texts

data class CommandInfo(
        val commandList: ArrayList<String>, //allowed command like "help", "h"
        val outputText: String //text to be displayed
) {
    companion object {
        val existingCommands = arrayListOf(
                CommandInfo(arrayListOf("h", "help"), Texts.HELP_COMMAND),
                CommandInfo(arrayListOf("a", "author"), Texts.AUTHOR_COMMAND)
        )
    }
}