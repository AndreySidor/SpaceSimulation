package com.simulation.solarsystem.objects.utils

import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * Двумерный вектор
 */
data class Vector(
    override val x: Double,
    override val y: Double
) : TwoDimensional {

    /**
     * Модуль (длинна) вектора
     */
    val mod: Double
        get() = sqrt(x.pow(2) + y.pow(2))

    /**
     * Сложение с другим вектором
     */
    operator fun plus(other: Vector): Vector = Vector(
        x = this.x + other.x,
        y = this.y + other.y
    )

    /**
     * Вычитание другого вектора
     */
    operator fun minus(other: Vector): Vector = Vector(
        x = this.x - other.x,
        y = this.y - other.y
    )

    companion object {
        /**
         * Создание двумерного вектора
         * @param mod модуль (длинна)
         * @param angle направление (угол от 0 до 360, отсчет начинается с положительной части оси абсцисс Х против часовой стрелки)
         */
        fun create(mod: Double, angle: Double): Vector {
            val rad = Math.toRadians(angle)
            return Vector(
                x = mod * cos(rad),
                y = mod * sin(rad)
            )
        }
    }
}