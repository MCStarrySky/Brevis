package me.arasple.mc.brevis.util

import taboolib.common.platform.ProxyCommandSender
import taboolib.common5.Mirror

/**
 * @author Arasple
 * @date 2021/2/6 19:31
 */
object Performance {

    fun collect(sender: ProxyCommandSender, opt: Mirror.MirrorSettings.() -> Unit = {}): Mirror.MirrorCollect {
        return MIRROR.report(sender, opt)
    }

    inline fun check(id: String, func: () -> Unit) {
        Mirror.mirrorData.computeIfAbsent(id) { Mirror.MirrorData() }.define()
        func()
        Mirror.mirrorData[id]?.finish()
    }

    private val MIRROR = Mirror

}