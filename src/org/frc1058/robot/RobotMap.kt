package org.frc1058.robot

public object RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public  int leftMotor = 1;
	// public  int rightMotor = 2;
	
	//TALON IDS
	public val SHOOTER1_TALON_ID = 5;
	public val HOPPER_MOTOR_TALON_ID = 0;
	public val GEAR_MANIPULATOR_PIVOT_TALON_ID = 6;
	public val LEFT_DRIVE_1_TALON_ID = 7;
	public val LEFT_DRIVE_2_TALON_ID = 8;
	public val RIGHT_DRIVE_1_TALON_ID = 3;
	public val RIGHT_DRIVE_2_TALON_ID = 2;
	public val CLIMBER_TALON_ID = 4;
	public val CYCLONE_TALON_ID = 1;
	
	//PWM IDS
	public val GEAR_MANIPULATOR_ROLLER_VICTOR_ID = 1;
	public val CAMERA_SERVO = 0;

	//MISC IDS:
	public val GEAR_MANIPULATOR_SOLENOID = 6;
	public val GEAR_LED_RING_CHANNEL = 0;
	public val SHOOTER_LED_RING_CHANNEL = 1;
	//DONT USE PCM CHANNEL 7 IT THROWS ERRORS
	
	//PID VALUES
	public val DRIVEBASE_kP : Double = 0.35;
	public val DRIVEBASE_kI : Double = 0.0;
	public val DRIVEBASE_kD : Double = 0.0;
	public val DRIVEBASE_kF : Double = 1.0;
	public val GEAR_MANIPULATOR_kP : Double = 1.0;
	public val GEAR_MANIPULATOR_kI : Double = 0.05;
	public val GEAR_MANIPULATOR_kD : Double = 0.0;

	//TOLERANCES AND GENERAL
	public val DRIVEBASE_POSITION_TOLERANCE = 0.5;
	public val INTAKE_PIVOT_ENCODER_TOLERANCE = 50;
	public val DRIVEBASE_MAX_RPM = 653;
	public val BOILER_EDGE_SHOOTER_RPM = -4100;//run at -4100 for nominal speed
	public val DRIVEBASE_COUNTS_PER_REV = 256;
		
	//POSITIONS
	public val INTAKE_PIVOT_STOW_POSITION = 0;
	public val INTAKE_PIVOT_VERTICAL_POSITION = 1600;
	public val INTAKE_PIVOT_GEARINTAKE_POSITION = 3795;
	public val INTAKE_PIVOT_BALLINTAKE_POSITION = 982;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// int rangefinderPort = 1;
	// int rangefinderModule = 1;
	
	//GAMEPAD PORTS
	
	public val xButton = 3;
	public val aButton = 1;
	public val bButton = 2;
	public val yButton = 4;
	public val leftBumper = 5;
	public val rightBumper = 6;
	public val backButton = 7;
	public val startButton = 8;
	public val leftStickPress = 9;
	public val rightStickPress = 10;
	public val leftStick_xAxis = 0;
	public val leftStick_yAxis = 1;
	public val leftTrigger_Axis = 2;
	public val rightTrigger_Axis = 3;
	public val rightStick_xAxis = 4;
	public val rightStick_yAxis = 5;
}