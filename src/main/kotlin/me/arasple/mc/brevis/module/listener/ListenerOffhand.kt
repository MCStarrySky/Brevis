package me.arasple.mc.brevis.module.listener

import me.arasple.mc.brevis.module.shortcut.Track
import me.arasple.mc.brevis.module.shortcut.TrackType
import me.arasple.mc.brevis.util.getSession
import org.bukkit.event.player.PlayerSwapHandItemsEvent
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent

/**
 * @author Arasple
 * @date 2021/2/25 11:30
 */
object ListenerOffhand {

    @SubscribeEvent(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun e(e: PlayerSwapHandItemsEvent) {
        e.isCancelled =  e.player.getSession().post(Track(TrackType.OFFHAND))
    }

}