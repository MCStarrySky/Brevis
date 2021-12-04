package me.arasple.mc.brevis.module.listener

import me.arasple.mc.brevis.module.shortcut.Track
import me.arasple.mc.brevis.module.shortcut.TrackType
import me.arasple.mc.brevis.util.getSession
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.SubscribeEvent
import taboolib.module.nms.MinecraftVersion

/**
 * @author Arasple
 * @date 2021/2/25 11:30
 */
object ListenerInteract {

    @SubscribeEvent(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun e(e: PlayerInteractEvent) {
        if (MinecraftVersion.majorLegacy >= 10900 && e.hand == EquipmentSlot.OFF_HAND) return

        e.isCancelled = e.player.getSession().post(Track(TrackType.INTERACT, e.action.ordinal))
    }

}