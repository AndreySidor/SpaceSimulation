package com.simulation.solarsystem.objects.classes

import com.simulation.solarsystem.objects.utils.Position

/**
 * Абстрактный класс космического тела
 * @param name наименование
 * @param mass масса (т)
 * @param position позиция в пространстве x, y (км) (центр тела)
 * @param acceleration ускорение (м/с^2)
 * @param speed скорость (м/с)
 */
sealed class SpaceObject(
    val name : String,
    val mass : Double,
    var position : Position,
    var acceleration : Double,
    var speed : Double
)