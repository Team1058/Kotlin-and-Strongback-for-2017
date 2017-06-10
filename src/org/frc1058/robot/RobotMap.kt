package org.frc1058.robot

object RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public  int leftMotor = 1;
	// public  int rightMotor = 2;
	
	//TALON IDS
    val SHOOTER1_TALON_ID = 5
    val HOPPER_MOTOR_TALON_ID = 0
    val GEAR_MANIPULATOR_PIVOT_TALON_ID = 6
    val LEFT_DRIVE_1_TALON_ID = 7
    val LEFT_DRIVE_2_TALON_ID = 8
    val RIGHT_DRIVE_1_TALON_ID = 3
    val RIGHT_DRIVE_2_TALON_ID = 2
    val CLIMBER_TALON_ID = 4
    val CYCLONE_TALON_ID = 1

    //PWM IDS
    val GEAR_MANIPULATOR_ROLLER_VICTOR_ID = 1
    val CAMERA_SERVO = 0

    //MISC IDS:
    val GEAR_MANIPULATOR_SOLENOID = 6
    val GEAR_LED_RING_CHANNEL = 0
    val SHOOTER_LED_RING_CHANNEL = 1
    //DONT USE PCM CHANNEL 7 IT THROWS ERRORS
	
	//PID VALUES
    val DRIVEBASE_kP : Double = 0.35
    val DRIVEBASE_kI : Double = 0.0
    val DRIVEBASE_kD : Double = 0.0
    val DRIVEBASE_kF : Double = 1.0
    val GEAR_MANIPULATOR_kP : Double = 1.0
    val GEAR_MANIPULATOR_kI : Double = 0.05
    val GEAR_MANIPULATOR_kD : Double = 0.0

    //TOLERANCES AND GENERAL
    val DRIVEBASE_POSITION_TOLERANCE = 0.5
    val INTAKE_PIVOT_ENCODER_TOLERANCE = 50
    val DRIVEBASE_MAX_RPM = 653
    val BOILER_EDGE_SHOOTER_RPM = -4100//run at -4100 for nominal speed
	val DRIVEBASE_COUNTS_PER_REV = 256

    //POSITIONS
    val INTAKE_PIVOT_STOW_POSITION = 0.0
    val INTAKE_PIVOT_VERTICAL_POSITION = 1600.0
    val INTAKE_PIVOT_GEARINTAKE_POSITION = 3795.0
    val INTAKE_PIVOT_BALLINTAKE_POSITION = 982.0

    // If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// int rangefinderPort = 1;
	// int rangefinderModule = 1;
	
	//GAMEPAD PORTS
	
	val xButton = 3
    val aButton = 1
    val bButton = 2
    val yButton = 4
    val leftBumper = 5
    val rightBumper = 6
    val backButton = 7
    val startButton = 8
    val leftStickPress = 9
    val rightStickPress = 10
    val leftStick_xAxis = 0
    val leftStick_yAxis = 1
    val leftTrigger_Axis = 2
    val rightTrigger_Axis = 3
    val rightStick_xAxis = 4
    val rightStick_yAxis = 5
}