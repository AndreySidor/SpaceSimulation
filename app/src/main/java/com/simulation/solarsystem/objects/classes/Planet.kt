package com.simulation.solarsystem.objects.classes

import com.simulation.solarsystem.objects.CanBeSatellite
import com.simulation.solarsystem.objects.RegularShapeObject
import com.simulation.solarsystem.objects.classes.SpaceObject
import com.simulation.solarsystem.objects.utils.Position

/**
 * Планета
 * @param satellites спутники планеты
 */
class Planet(
    name: String,
    mass: Double,
    position: Position,
    acceleration: Double,
    speed: Double,
    val satellites : MutableList<CanBeSatellite> = mutableListOf(),
    override val size: Double,
    override var motherObject: SpaceObject? = null
) : SpaceObject(name, mass, position, acceleration, speed), RegularShapeObject, CanBeSatellite