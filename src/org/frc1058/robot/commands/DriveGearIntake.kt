package org.frc1058.robot.commands

import edu.wpi.first.wpilibj.command.Command
import org.frc1058.robot.subsystems.GearManipulator


class DriveGearIntake(speed: Double) : Command() {
	
	var rollerSpeed: Double = speed

	override fun initialize() {
	}
	
	override fun execute() {
		GearManipulator.setRollerSpeed(rollerSpeed)
    }
	
	override fun isFinished(): Boolean {
		 return false
    }
	
	override fun end() {
		GearManipulator.setRollerSpeed(0.0)
    }
	
	override fun interrupted() {
		GearManipulator.setRollerSpeed(0.0)
    }
}