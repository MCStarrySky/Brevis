package me.arasple.mc.brevis

import me.arasple.mc.brevis.api.Settings
import taboolib.common.platform.Plugin
import taboolib.common.platform.function.console
import taboolib.common.platform.function.disablePlugin
import taboolib.common.platform.function.pluginVersion
import taboolib.module.lang.sendLang
import taboolib.module.nms.MinecraftVersion
import taboolib.platform.BukkitPlugin

/**
 * @author Arasple
 * @date 2021/2/25 11:12
 */
object Brevis : Plugin() {

    val plugin by lazy {
        BukkitPlugin.getInstance()
    }

    override fun onLoad() {
        console().sendLang("Plugin-Loading", pluginVersion)
    }

    override fun onEnable() {
        if (MinecraftVersion.majorLegacy < 10900) {
            console().sendLang("Plugin-UnsupportedVersion", pluginVersion)
            disablePlugin()
            return
        }

        console().sendLang("Plugin-Enabled", pluginVersion)
    }

    override fun onDisable() {

    }

}