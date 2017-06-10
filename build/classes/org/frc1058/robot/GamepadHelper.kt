package org.frc1058.robot

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

public object GamepadHelper {
	
	public var deadband : Double = .15;
	
	public class GetDPad : Trigger {
		private var joy: Joystick;
		private var m_degrees: Double = 0.0;
	
		public constructor(joy: Joystick, degrees: Double) {
			this.joy = joy;
			m_degrees = degrees;
		}	

		override public fun get(): Boolean {
	        return (joy.getPOV(0).equals( m_degrees));
	    }
	}
	
	public fun ValueWithDeadBand(value: Double, userDeadband: Double = deadband): Double{
		if(Math.abs(value) > userDeadband)
			return value;
		else
			return 0.0;
	}
	
	
}