package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.command.groups.SequentialGroup;
import com.rowanmcalpin.nextftc.ftc.NextFTCOpMode;
import com.rowanmcalpin.nextftc.ftc.driving.MecanumDriverControlled;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx;

@TeleOp(name = "NextFTC TeleOp Program Java")
public class TestTeleOpProgram extends NextFTCOpMode {

    public TestTeleOpProgram() {
        //super(Claw.INSTANCE, Lift.INSTANCE);
    }

    public String frontLeftName = "front_left";
    public String frontRightName = "front_right";
    public String backLeftName = "back_left";
    public String backRightName = "back_right";

    public MotorEx frontLeftMotor;
    public MotorEx frontRightMotor;
    public MotorEx backLeftMotor;
    public MotorEx backRightMotor;

    public MotorEx[] motors;

    public Command driverControlled;

    @Override
    public void onInit() {
        frontLeftMotor = new MotorEx(frontLeftName);
        backLeftMotor = new MotorEx(backLeftName);
        backRightMotor = new MotorEx(backRightName);
        frontRightMotor = new MotorEx(frontRightName);

        // Change your motor directions to suit your robot.
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        motors = new MotorEx[] {frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor};
    }
    @Override
    public void onStartButtonPressed() {
        driverControlled = new MecanumDriverControlled(motors, gamepadManager.getGamepad1());
        driverControlled.invoke();

        //gamepadManager.getGamepad2().getDpadUp().setPressedCommand(Lift.INSTANCE::toHigh);

        //gamepadManager.getGamepad2().getDpadUp().setReleasedCommand(Claw.INSTANCE::open);

        /*gamepadManager.getGamepad2().getRightTrigger().setPressedCommand(
                value -> new SequentialGroup(
                        Claw.INSTANCE.close(),
                        Lift.INSTANCE.toHigh()
                )
        );

        gamepadManager.getGamepad2().getLeftBumper().setPressedCommand(
                () -> new ParallelGroup(
                        Claw.INSTANCE.open(),
                        Lift.INSTANCE.toLow()
                )
        );
        */
    }
}