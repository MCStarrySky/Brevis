package me.arasple.mc.brevis

import me.arasple.mc.brevis.api.Settings
import me.arasple.mc.brevis.module.shortcut.Session
import me.arasple.mc.brevis.util.Performance
import org.bukkit.Bukkit
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.*
import taboolib.common.platform.function.isPrimaryThread
import taboolib.common.platform.function.onlinePlayers
import taboolib.common.platform.function.submit

/**
 * @author Arasple
 * @date 2021/2/25 13:11
 */
@CommandHeader(name = "brevis", permission = "brevis.access")
object BrevisCommand {

    @CommandBody
    val mirror = subCommand {
        execute<ProxyCommandSender> { sender, _, _ ->
            submit(async = !isPrimaryThread) {
                Performance.collect(sender) {
                    childFormat = "§8  {0}§7{1} §2[{3} ms] §7{4}%"
                    parentFormat = "§8  §8{0}§7{1} §8[{3} ms] §7{4}%"
                }.run {
                    sender.sendMessage("\n§a§lBrevis §3§l§nPerformance Mirror\n§r")
                    print(sender, getTotal(), 0)
                }
            }
        }
    }

    @CommandBody(permissionDefault = PermissionDefault.OP)
    val reload = subCommand {
        execute<ProxyCommandSender> { _, _, _ ->
            Settings.onReload()
        }
    }

    @CommandBody
    val debug = subCommand {
        dynamic {
            suggestion<ProxyCommandSender> { _, _ ->
                onlinePlayers().map { it.name }
            }
            execute<ProxyCommandSender> { sender, _, argument ->
                val player = Bukkit.getPlayer(argument)
                if (player != null && player.isOnline) {
                    sender.sendMessage(Session.get(player).toString())
                }
            }
        }
    }

}