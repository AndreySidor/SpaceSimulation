package com.simulation.solarsystem.objects.utils

import kotlin.math.abs
import kotlin.math.sqrt

/**
 * Позиция объекта в пространстве
 * @param x координата оси абсцисс (горизонталь)
 * @param y координата оси ординат (вертикаль)
 */
data class Position(
    var x : Double,
    var y : Double
) {

    /**
     * Смещение позиции
     */
    fun offset(x : Double, y : Double) {
        this.x += x
        this.y += y
    }

    /**
     * Вычисление расстояния между двумя позициями (прямая)
     */
    fun distance(point : Position) : Double {
        return when {
            this.x == point.x -> abs(point.y - this.y)
            this.y == point.y -> abs(point.x - this.x)
            else -> sqrt(abs(point.x - this.x) + abs(point.y - this.y))
        }
    }
}
