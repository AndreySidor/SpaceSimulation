package com.simulation.solarsystem.objects.classes

import com.simulation.solarsystem.objects.CanBeSatellite
import com.simulation.solarsystem.objects.RegularShapeObject
import com.simulation.solarsystem.objects.utils.Position
import com.simulation.solarsystem.objects.utils.Vector

/**
 * Планета
 * @param satellites спутники планеты
 */
class Planet(
    name: String,
    mass: Double,
    position: Position,
    acceleration: Vector,
    speed: Vector,
    val satellites : MutableList<CanBeSatellite> = mutableListOf(),
    override val size: Double,
    override var motherObject: SpaceObject? = null
) : SpaceObject(name, mass, position, acceleration, speed), RegularShapeObject, CanBeSatellite