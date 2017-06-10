package org.frc1058.robot

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.Trigger

object GamepadHelper {
	
	var deadband : Double = .15

    internal class GetDPad(private var joy: Joystick, degrees: Int) : Trigger() {
		private var m_degrees: Int = degrees

		override fun get(): Boolean {
	        return (joy.getPOV(0) == m_degrees)
        }
	}

	fun ValueWithDeadBand(value: Double, userDeadband: Double = deadband): Double{
		if(Math.abs(value) > userDeadband)
			return value
        else
			return 0.0
    }
}