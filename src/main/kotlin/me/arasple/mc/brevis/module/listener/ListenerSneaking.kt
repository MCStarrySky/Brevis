package me.arasple.mc.brevis.module.listener

import me.arasple.mc.brevis.module.shortcut.Track
import me.arasple.mc.brevis.module.shortcut.TrackType
import me.arasple.mc.brevis.util.getSession
import org.bukkit.event.player.PlayerToggleSneakEvent
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent


/**
 * @author Arasple
 * @date 2021/2/25 11:30
 */
object ListenerSneaking {

    @SubscribeEvent(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun e(e: PlayerToggleSneakEvent) {
        if (e.isSneaking) {
            e.player.getSession().post(Track(TrackType.SNEAKING))
        }
    }

}