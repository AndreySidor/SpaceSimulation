package com.simulation.solarsystem.objects.classes

import com.simulation.solarsystem.objects.RegularShapeObject
import com.simulation.solarsystem.objects.utils.Position
import com.simulation.solarsystem.objects.utils.Vector

/**
 * Звезда
 * @param type тип звезды [Star.Type]
 * @param spaceObjects объекты захваченный гравитационным полем
 */
class Star(
    name: String,
    mass: Double,
    position: Position,
    acceleration: Vector,
    speed: Vector,
    var type : Type,
    val spaceObjects : MutableList<SpaceObject> = mutableListOf(),
    override val size: Double
) : SpaceObject(name, mass, position, acceleration, speed), RegularShapeObject {
    companion object {

        /**
         * Тип звезды
         */
        enum class Type(val value : String) {
            MAIN_SEQUENCE_STAR("Звезда главной последовательности"),
            RED_GIANT("Красный гигант"),
            WHITE_DWARF("Белый карлик"),
            NEUTRON_STAR("Нейтронная звезда"),
            RED_DWARF("Красный карлик"),
            BROWN_DWARF("Коричневый карлик")
        }
    }
}