package com.simulation.solarsystem.objects.classes

import com.simulation.solarsystem.objects.CanBeSatellite
import com.simulation.solarsystem.objects.IrregularlyShapedObject
import com.simulation.solarsystem.objects.utils.Position

/**
 * Астероид
 */
class Asteroid(
    name: String,
    mass: Double,
    position: Position,
    acceleration: Double,
    speed: Double,
    override val minSize: Double,
    override val maxSize: Double,
    override var motherObject: SpaceObject? = null
) : SpaceObject(name, mass, position, acceleration, speed), IrregularlyShapedObject, CanBeSatellite