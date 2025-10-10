package com.simulation.solarsystem.objects

import com.simulation.solarsystem.objects.classes.SpaceObject
import kotlin.math.abs
import kotlin.math.cbrt

/**
 * Объект может быть спутником другого небесного тела (более массивного)
 */
interface CanBeSatellite {

    /**
     * Родительский объект (более массивный)
     */
    var motherObject : SpaceObject?

    /**
     * Сфера Хилла
     *
     * Расстояние от центра масс, где сила гравитации текущего тела выше, чем родительского motherObject
     */
    val hillSphere : Double?
        get() = motherObject?.let {
            val currentObject = this as? SpaceObject ?: return@let null
            val r = abs(currentObject.position.distance(it.position))
            r * cbrt(currentObject.mass / (3 * (currentObject.mass + it.mass)))
        }
}