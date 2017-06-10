package org.frc1058.robot.commands

import edu.wpi.first.wpilibj.command.Command
import org.frc1058.robot.subsystems.GearManipulator
import org.frc1058.robot.OI

class PivotJoystickPID(initialsetpoint: Double, maxvoltage: Double) : Command() {
	
	var k_MaxVoltage: Double = maxvoltage
    var k_InitialSetpoint: Double = initialsetpoint

	override fun initialize() {
		GearManipulator.setIntakePosition(k_InitialSetpoint)
        GearManipulator.setMaxIntakeSpeed(k_MaxVoltage)
    }
	
	override fun execute() {
		if(OI.operatorGamepad.getStartButton()){
			GearManipulator.setIntakePosition(-GearManipulator.pivotMotor.position + -400*OI.operatorGamepad.getLeftStickY())
        }
	}
	
	override fun isFinished(): Boolean {
		 return false
    }
	
	override fun end() {
		
    }
	
	override fun interrupted() {
		
    }

	init {
		requires(GearManipulator)
	}
}