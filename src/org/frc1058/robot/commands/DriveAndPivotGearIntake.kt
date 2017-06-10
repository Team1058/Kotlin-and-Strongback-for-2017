package org.frc1058.robot.commands

import edu.wpi.first.wpilibj.command.Command
import org.frc1058.robot.subsystems.GearManipulator
import org.frc1058.robot.OI
import org.frc1058.robot.RobotMap

class DriveAndPivotGearIntake(setpoint: Double, speed: Double, voltage: Double = 6.0) : Command() {
	
	var rollerSpeed: Double = speed
    var intakeSetpoint: Double = setpoint
    var maxVoltage: Double = voltage

    override fun initialize() {
		GearManipulator.setMaxIntakeSpeed(maxVoltage)
    }
	
	override fun execute() {
		GearManipulator.setIntakePosition(intakeSetpoint)
        if(!OI.operatorGamepad.getRightAxisButton()){
			GearManipulator.setRollerSpeed(rollerSpeed)
        }
    	else{
    		GearManipulator.setRollerSpeed(0.0)
        }
	}
	
	override fun isFinished(): Boolean {
		 return false
    }
	
	override fun end() {
		GearManipulator.setIntakePosition(RobotMap.INTAKE_PIVOT_VERTICAL_POSITION)
        GearManipulator.setRollerSpeed(0.0)
    }
	
	override fun interrupted() {
		GearManipulator.setRollerSpeed(0.0)
        GearManipulator.setIntakePosition(RobotMap.INTAKE_PIVOT_VERTICAL_POSITION)
    }
}