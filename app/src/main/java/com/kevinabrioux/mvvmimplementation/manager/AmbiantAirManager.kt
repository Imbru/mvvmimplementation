package com.kevinabrioux.mvvmimplementation.manager

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import com.kevinabrioux.mvvmimplementation.listener.LightListener

/**
 *
 * Created by kevinabrioux on 26/01/2018.
 */
class LightManager(context: Context, lightListener: LightListener) : SensorEventListener {

    private val sensorManager: SensorManager?
    private val lightSensor: Sensor?
    private val listener: LightListener?

    init {
        this.listener = lightListener
        this.sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        this.lightSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_LIGHT)
        this.sensorManager?.registerListener(this, this.lightSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        this.listener?.onLightChange(p0?.values?.get(0)?.toInt())
    }

}