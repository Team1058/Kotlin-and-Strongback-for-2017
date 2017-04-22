package org.frc1058.robot

import org.frc1058.robot.RobotMap;
 
class Gamepad : edu.wpi.first.wpilibj.Joystick{
	
	public constructor(port: Int): super(port);
	
	public fun getLeftStickX(): Double {
		return getRawAxis(RobotMap.leftStick_xAxis);
	}
	
	public fun getLeftStickY(): Double {
		return getRawAxis(RobotMap.leftStick_yAxis);
	}
	
	public fun getLeftAxisButton(): Boolean {
		return getRawButton(RobotMap.leftStickPress);
	}
	
	public fun getRightStickX(): Double {
		return getRawAxis(RobotMap.rightStick_xAxis);
	}
	
	public fun getRightStickY(): Double {
		return getRawAxis(RobotMap.rightStick_yAxis);
	}
	
	public fun getRightAxisButton(): Boolean {
		return getRawButton(RobotMap.rightStickPress);
	}
	
	public fun getLeftBumper(): Boolean {
		return getRawButton(RobotMap.leftBumper);
	}
	
	public fun getRightBumper(): Boolean {
		return getRawButton(RobotMap.rightBumper);
	}
	
	public fun getLeftTrigger(): Boolean {
		var leftTrigger: Boolean;
		if(getRawAxis(RobotMap.leftTrigger_Axis) > .8 ){
			leftTrigger = true;
		}
		else{
			leftTrigger = false;
		}
		return leftTrigger;
	}
	
	public fun getRightTrigger(): Boolean {
		var rightTrigger: Boolean;
		if(getRawAxis(RobotMap.rightTrigger_Axis) > .8 ){
			rightTrigger = true;
		}
		else{
			rightTrigger = false;
		}
		return rightTrigger;
	}
	
	public fun getXButton(): Boolean {
		return getRawButton(RobotMap.xButton);
	}
	
	public fun getAButton(): Boolean{
		return getRawButton(RobotMap.aButton);
	}
	
	public fun getBButton(): Boolean {
		return getRawButton(RobotMap.bButton);
	}
	
	public fun getYButton(): Boolean {
		return getRawButton(RobotMap.yButton);
	}
	
	public fun getStartButton(): Boolean {
		return getRawButton(RobotMap.startButton);
	}
	
	public fun getBackButton(): Boolean {
		return getRawButton(RobotMap.backButton);
	}
	
	public fun getDpadUp(): Boolean {
		//return(getPOV(0) == 0) ? true : false);
		if(getPOV(0)==0){
			return true;
		}
		else{
			return false;	
		}
	}
	
	public fun getDpadRight(): Boolean {
		if(getPOV(90)==0){
			return true;
		}
		else{
			return false;	
		}
	}
	
	public fun getDpadDown(): Boolean {
		if(getPOV(180)==0){
			return true;
		}
		else{
			return false;	
		}
	}

	public fun getDpadLeft(): Boolean {
		if(getPOV(270)==0){
			return true;
		}
		else{
			return false;	
		}
	}	
}