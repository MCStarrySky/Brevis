package me.arasple.mc.brevis.api

import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.function.pluginVersion
import taboolib.module.metrics.Metrics
import taboolib.module.metrics.charts.SingleLineChart

/**
 * @author Arasple
 * @date 2021/2/25 13:39
 */
object Metrics {

    private val B_STATS by lazy { Metrics(10469, pluginVersion, Platform.BUKKIT) }

    @Awake(LifeCycle.INIT)
    fun initialization() {
        B_STATS.let {
            it.addCustomChart(SingleLineChart("shortcuts") {
                Settings.INSTANCE.shortcuts.size
            })
        }
    }

}