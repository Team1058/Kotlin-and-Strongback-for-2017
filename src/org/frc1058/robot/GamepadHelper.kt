package org.frc1058.robot

public object GamepadHelper {
	
	public var deadband : Double = .15;
	
	public fun ValueWithDeadBand(value: Double, userDeadband: Double = deadband): Double{
		if(Math.abs(value) > userDeadband)
			return value;
		else
			return 0.0;
	}
	
	
}