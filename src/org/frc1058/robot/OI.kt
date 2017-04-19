package org.frc1058.robot

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public object OI {
	
	public val driverGamepad =  Gamepad(0);
	public val operatorGamepad = Gamepad(1);
	
	public fun OI(){
	 //JoystickButton(driverGamepad, 7).whenPressed(LightLEDRings("gearmanipulator"));
	 
	}
	
}