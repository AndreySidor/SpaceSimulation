package com.simulation.solarsystem.ui.components

/**
 * Объект камеры 2D
 * @param scale приближение / отдаление
 * @param offsetX смещение по оси X
 * @param offsetY смещение по оси Y
 * @param rotation угол поворота в градусах
 */
data class Camera(
    var scale : Float,
    var offsetX : Float,
    var offsetY : Float,
    var rotation : Float
) {
    fun update(
        scale : Float? = null,
        offsetX : Float? = null,
        offsetY : Float? = null,
        rotation : Float? = null
    ) {
        scale?.let { this.scale *= it }
        offsetX?.let { this.offsetX += it }
        offsetY?.let { this.offsetY += it }
        rotation?.let { this.rotation += it }
    }

    fun updateWithRecreate(
        scale : Float? = null,
        offsetX : Float? = null,
        offsetY : Float? = null,
        rotation : Float? = null
    ) : Camera {
        return Camera(
            scale = if (scale == null) this.scale else this.scale * scale,
            offsetX = if (offsetX == null) this.offsetX else this.offsetX + offsetX,
            offsetY = if (offsetY == null) this.offsetY else this.offsetY + offsetY,
            rotation = if (rotation == null) this.rotation else this.rotation + rotation,
        )
    }
}
