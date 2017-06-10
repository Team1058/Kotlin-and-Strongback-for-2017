package org.frc1058.robot

import edu.wpi.first.wpilibj.buttons.JoystickButton
import org.frc1058.robot.GamepadHelper.GetDPad
import org.frc1058.robot.commands.*

object OI {
	
	val driverGamepad =  Gamepad(0)
    val operatorGamepad = Gamepad(1)

    fun OI(){
		JoystickButton(operatorGamepad, 1).whileHeld(DriveGearIntake(-0.5))
        JoystickButton(operatorGamepad, 4).whenPressed(PlaceGear())
        if(operatorGamepad.getLeftTrigger()){
			PivotGearIntake(RobotMap.INTAKE_PIVOT_VERTICAL_POSITION, 8.0)
        }
		JoystickButton(operatorGamepad, 3).whileHeld(Climb(-1.0))
        JoystickButton(operatorGamepad, 2).whileHeld(Climb(-0.45))
        with(GamepadHelper, {
            GetDPad(operatorGamepad, 270).whileActive(DriveAndPivotGearIntake(RobotMap.INTAKE_PIVOT_GEARINTAKE_POSITION,1.0))
            GetDPad(operatorGamepad, 225).whileActive(DriveAndPivotGearIntake(RobotMap.INTAKE_PIVOT_GEARINTAKE_POSITION,1.0))
            GetDPad(operatorGamepad, 315).whileActive(DriveAndPivotGearIntake(RobotMap.INTAKE_PIVOT_GEARINTAKE_POSITION,1.0))

            GetDPad(operatorGamepad, 90).whileActive(DriveAndPivotGearIntake(RobotMap.INTAKE_PIVOT_BALLINTAKE_POSITION,1.0))
            GetDPad(operatorGamepad, 45).whileActive(DriveAndPivotGearIntake(RobotMap.INTAKE_PIVOT_BALLINTAKE_POSITION,1.0))
            GetDPad(operatorGamepad, 135).whileActive(DriveAndPivotGearIntake(RobotMap.INTAKE_PIVOT_BALLINTAKE_POSITION,1.0))
        })
    }
	
}