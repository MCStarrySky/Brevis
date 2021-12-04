package me.arasple.mc.brevis.module.listener

import me.arasple.mc.brevis.module.shortcut.Session
import org.bukkit.event.player.PlayerQuitEvent
import taboolib.common.platform.event.SubscribeEvent

/**
 * @author Arasple
 * @date 2021/2/25 13:15
 */
object ListenerQuit {

    @SubscribeEvent
    fun e(e: PlayerQuitEvent) {
        Session.delete(e.player)
    }

}