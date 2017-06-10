package org.frc1058.robot

class Gamepad(port: Int) : edu.wpi.first.wpilibj.Joystick(port) {

	fun getLeftStickX(): Double {
		return getRawAxis(RobotMap.leftStick_xAxis)
    }
	
	fun getLeftStickY(): Double {
		return getRawAxis(RobotMap.leftStick_yAxis)
    }
	
	fun getLeftAxisButton(): Boolean {
		return getRawButton(RobotMap.leftStickPress)
    }
	
	fun getRightStickX(): Double {
		return getRawAxis(RobotMap.rightStick_xAxis)
    }
	
	fun getRightStickY(): Double {
		return getRawAxis(RobotMap.rightStick_yAxis)
    }
	
	fun getRightAxisButton(): Boolean {
		return getRawButton(RobotMap.rightStickPress)
    }
	
	fun getLeftBumper(): Boolean {
		return getRawButton(RobotMap.leftBumper)
    }
	
	fun getRightBumper(): Boolean {
		return getRawButton(RobotMap.rightBumper)
    }
	
	fun getLeftTrigger(): Boolean {
		val leftTrigger: Boolean = getRawAxis(RobotMap.leftTrigger_Axis) > .8
		return leftTrigger
    }
	
	fun getRightTrigger(): Boolean {
		val rightTrigger = getRawAxis(RobotMap.rightTrigger_Axis) > .8
		return rightTrigger
    }
	
	fun getXButton(): Boolean {
		return getRawButton(RobotMap.xButton)
    }
	
	fun getAButton(): Boolean{
		return getRawButton(RobotMap.aButton)
    }
	
	fun getBButton(): Boolean {
		return getRawButton(RobotMap.bButton)
    }
	
	fun getYButton(): Boolean {
		return getRawButton(RobotMap.yButton)
    }
	
	fun getStartButton(): Boolean {
		return getRawButton(RobotMap.startButton)
    }
	
	fun getBackButton(): Boolean {
		return getRawButton(RobotMap.backButton)
    }
	
	fun getDpadUp() = getPOV(0)== 0

    fun getDpadRight() = getPOV(90)==0

    fun getDpadDown() = getPOV(180)==0

    fun getDpadLeft() = getPOV(270)==0
}