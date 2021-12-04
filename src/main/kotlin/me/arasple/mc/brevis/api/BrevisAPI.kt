package me.arasple.mc.brevis.api

import me.arasple.mc.brevis.util.Performance
import org.bukkit.entity.Player
import taboolib.common.platform.function.adaptPlayer
import taboolib.library.kether.LocalizedException
import taboolib.module.kether.KetherShell
import java.util.concurrent.CompletableFuture

/**
 * @author Arasple
 * @date 2021/2/25 11:56
 */
object BrevisAPI {

    @JvmStatic
    fun eval(player: Player, script: String): CompletableFuture<Any?> {
        Performance.check("Brevis:Handler:Check:React") {
            return try {
                KetherShell.eval(script, namespace = listOf("trhologram", "trmenu")) {
                    sender = adaptPlayer(player)
                }
            } catch (e: LocalizedException) {
                println("[Brevis] Unexpected exception while parsing kether shell:")
                e.localizedMessage.split("\n").forEach {
                    println("[Brevis] $it")
                }
                CompletableFuture.completedFuture(false)
            }
        }
        throw Exception()
    }

}