package com.willfp.ecoenchants.commands

import com.willfp.eco.core.EcoPlugin
import com.willfp.eco.core.command.impl.Subcommand
import com.willfp.ecoenchants.enchant.EnchantGUI
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender

class CommandGUI(plugin: EcoPlugin) : Subcommand(plugin, "gui", "ecoenchants.command.gui", false) {
    override fun onExecute(sender: CommandSender, args: List<String>) {
        val playerName = args.getOrNull(0)
        if (playerName == null) {
            sender.sendMessage(plugin.langYml.getMessage("requires-player"))
            return
        }
        val player = Bukkit.getPlayer(playerName)
        if (player == null) {
            sender.sendMessage(plugin.langYml.getMessage("invalid-player"))
            return
        }
        EnchantGUI.openGUI(player)
    }
}
