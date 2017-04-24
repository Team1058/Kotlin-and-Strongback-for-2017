package org.frc1058.robot

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.frc1058.robot.commands.DriveGearIntake;
import org.frc1058.robot.commands.DriveAndPivotGearIntake;
import org.frc1058.robot.commands.PivotGearIntake;
import org.frc1058.robot.commands.PlaceGear;
import org.frc1058.robot.GamepadHelper;
import edu.wpi.first.wpilibj.buttons.Button;

public object OI {
	
	public val driverGamepad =  Gamepad(0);
	public val operatorGamepad = Gamepad(1);
	
	public fun OI(){
		JoystickButton(operatorGamepad, 1).whileHeld(DriveGearIntake(-0.5));
		JoystickButton(operatorGamepad, 4).whenPressed(PlaceGear());
		if(operatorGamepad.getLeftTrigger()){
			PivotGearIntake(RobotMap.INTAKE_PIVOT_VERTICAL_POSITION, 8.0);
		}
		
		GamepadHelper.GetDPad(operatorGamepad, 270.0).whileActive(DriveAndPivotGearIntake(RobotMap.INTAKE_PIVOT_GEARINTAKE_POSITION,1.0))
		GamepadHelper.GetDPad(operatorGamepad, 225.0).whileActive(DriveAndPivotGearIntake(RobotMap.INTAKE_PIVOT_GEARINTAKE_POSITION,1.0))
		GamepadHelper.GetDPad(operatorGamepad, 315.0).whileActive(DriveAndPivotGearIntake(RobotMap.INTAKE_PIVOT_GEARINTAKE_POSITION,1.0))
		
		GamepadHelper.GetDPad(operatorGamepad, 90.0).whileActive(DriveAndPivotGearIntake(RobotMap.INTAKE_PIVOT_BALLINTAKE_POSITION,1.0))
		GamepadHelper.GetDPad(operatorGamepad, 45.0).whileActive(DriveAndPivotGearIntake(RobotMap.INTAKE_PIVOT_BALLINTAKE_POSITION,1.0))
		GamepadHelper.GetDPad(operatorGamepad, 135.0).whileActive(DriveAndPivotGearIntake(RobotMap.INTAKE_PIVOT_BALLINTAKE_POSITION,1.0))
	}
	
}