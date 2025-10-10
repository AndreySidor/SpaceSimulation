package com.simulation.solarsystem.objects

/**
 * Объект неправильной формы
 */
interface IrregularlyShapedObject {

    /**
     * Минимальный радиус в км
     */
    val minSize : Double

    /**
     * Максимальный радиус в км
     */
    val maxSize : Double
}