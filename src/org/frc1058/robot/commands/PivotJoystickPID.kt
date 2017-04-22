package org.frc1058.robot.commands

import edu.wpi.first.wpilibj.command.Command;
import org.frc1058.robot.subsystems.GearManipulator;
import org.frc1058.robot.OI;

class PivotJoystickPID: Command {
	
	var k_MaxVoltage: Double = 0.0;
	var k_InitialSetpoint: Double = 0.0;
	
	public constructor(maxvoltage: Double, initialsetpoint: Double){
		requires(GearManipulator);
		k_MaxVoltage = maxvoltage;
    	k_InitialSetpoint = initialsetpoint;
	}
	
	override protected fun initialize() {
		GearManipulator.setIntakePosition(k_InitialSetpoint);
		GearManipulator.setMaxIntakeSpeed(k_MaxVoltage);
	}
	
	override protected fun execute() {
		if(OI.operatorGamepad.getStartButton()){
			GearManipulator.setIntakePosition(-GearManipulator.pivotMotor.getPosition() + -400*OI.operatorGamepad.getLeftStickY());
    	}
	}
	
	override protected fun isFinished(): Boolean {
		 return false;
	}
	
	override protected fun end() {
		
    }
	
	override protected fun interrupted() {
		
    }
	
}