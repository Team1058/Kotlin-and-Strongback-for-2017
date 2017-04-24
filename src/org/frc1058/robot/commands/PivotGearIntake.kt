package org.frc1058.robot.commands

import edu.wpi.first.wpilibj.command.Command;
import org.frc1058.robot.subsystems.GearManipulator;
import org.frc1058.robot.RobotMap;

public class PivotGearIntake : Command {
	
	var maxVoltage: Double = 0.0;
	var intakeSetpoint: Double = 0.0;
	var onTarget: Boolean = false;
	
	public constructor(setpoint: Double, voltage: Double){
		requires(GearManipulator);
    	maxVoltage = voltage;
    	intakeSetpoint = setpoint;
	}
	
	override protected fun initialize() {
		GearManipulator.setMaxIntakeSpeed(maxVoltage);
	}
	
	override protected fun execute() {
		if(GearManipulator.pivotMotor.getPosition() < (intakeSetpoint-RobotMap.DRIVEBASE_POSITION_TOLERANCE) && GearManipulator.pivotMotor.getPosition() > (intakeSetpoint+RobotMap.DRIVEBASE_POSITION_TOLERANCE)){
    		onTarget = true;
    	}
	}
	
	override protected fun isFinished(): Boolean {
		 return onTarget;
	}
	
	override protected fun end() {
		
    }
	
	override protected fun interrupted() {
		
    }
}