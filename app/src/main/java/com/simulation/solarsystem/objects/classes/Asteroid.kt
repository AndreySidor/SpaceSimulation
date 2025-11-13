package com.simulation.solarsystem.objects.classes

import com.simulation.solarsystem.objects.CanBeSatellite
import com.simulation.solarsystem.objects.IrregularlyShapedObject
import com.simulation.solarsystem.objects.utils.Position
import com.simulation.solarsystem.objects.utils.Vector

/**
 * Астероид
 */
class Asteroid(
    name: String,
    mass: Double,
    position: Position,
    acceleration: Vector,
    speed: Vector,
    override val minSize: Double,
    override val maxSize: Double,
    override var motherObject: SpaceObject? = null
) : SpaceObject(name, mass, position, acceleration, speed), IrregularlyShapedObject, CanBeSatellite