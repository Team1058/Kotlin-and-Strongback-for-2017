package org.frc1058.robot

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.frc1058.robot.commands.DriveGearRoller;
import org.frc1058.robot.commands.DriveAndPivotGearRoller;
import org.frc1058.robot.GamepadHelper;

public object OI {
	
	public val driverGamepad =  Gamepad(0);
	public val operatorGamepad = Gamepad(1);
	
	public fun OI(){
		JoystickButton(operatorGamepad, 1).whileHeld(DriveGearRoller(-0.5));
		
		
		GamepadHelper.GetDPad(operatorGamepad, 270.0).whileActive(DriveAndPivotGearRoller(RobotMap.INTAKE_PIVOT_GEARINTAKE_POSITION,1.0))
		GamepadHelper.GetDPad(operatorGamepad, 225.0).whileActive(DriveAndPivotGearRoller(RobotMap.INTAKE_PIVOT_GEARINTAKE_POSITION,1.0))
		GamepadHelper.GetDPad(operatorGamepad, 315.0).whileActive(DriveAndPivotGearRoller(RobotMap.INTAKE_PIVOT_GEARINTAKE_POSITION,1.0))
		
		GamepadHelper.GetDPad(operatorGamepad, 90.0).whileActive(DriveAndPivotGearRoller(RobotMap.INTAKE_PIVOT_BALLINTAKE_POSITION,1.0))
		GamepadHelper.GetDPad(operatorGamepad, 45.0).whileActive(DriveAndPivotGearRoller(RobotMap.INTAKE_PIVOT_BALLINTAKE_POSITION,1.0))
		GamepadHelper.GetDPad(operatorGamepad, 135.0).whileActive(DriveAndPivotGearRoller(RobotMap.INTAKE_PIVOT_BALLINTAKE_POSITION,1.0))
	}
	
}