package com.simulation.solarsystem.objects.utils

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Позиция в двумерном пространстве
 */
data class Position(
    override val x: Double,
    override val y: Double
) : TwoDimensional {

    /**
     * Вычисление расстояния между двумя позициями (прямая)
     */
    fun distance(point: Position): Double =
        sqrt((point.x - this.x).pow(2) + (point.y - this.y).pow(2))

    /**
     * Смещение позиции
     */
    fun offset(x: Double, y: Double): Position = Position(
        x = this.x + x,
        y = this.y + y
    )
}