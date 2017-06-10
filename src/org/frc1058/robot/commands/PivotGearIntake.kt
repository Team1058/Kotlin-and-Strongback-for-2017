package org.frc1058.robot.commands

import edu.wpi.first.wpilibj.command.Command
import org.frc1058.robot.subsystems.GearManipulator
import org.frc1058.robot.RobotMap

class PivotGearIntake(setpoint: Double, voltage: Double = 6.0) : Command() {
	
	var maxVoltage: Double = voltage
    var intakeSetpoint: Double = setpoint
    var onTarget: Boolean = false

	override fun initialize() {
		GearManipulator.setMaxIntakeSpeed(maxVoltage)
    }
	
	override fun execute() {
		if(GearManipulator.pivotMotor.position < intakeSetpoint-RobotMap.DRIVEBASE_POSITION_TOLERANCE && GearManipulator.pivotMotor.position > intakeSetpoint+RobotMap.DRIVEBASE_POSITION_TOLERANCE){
    		onTarget = true
        }
	}
	
	override fun isFinished(): Boolean {
		 return onTarget
    }
	
	override fun end() {
		
    }
	
	override fun interrupted() {
		
    }

	init {
		requires(GearManipulator)
	}
}