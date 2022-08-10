// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSub extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private CANSparkMax LeftFrontDrive = new CANSparkMax(7, MotorType.kBrushless);
  private CANSparkMax RightFrontDrive = new CANSparkMax(8, MotorType.kBrushless);
  private CANSparkMax LeftBackDrive = new CANSparkMax(9, MotorType.kBrushless);
  private CANSparkMax RightBackDrive = new CANSparkMax(10, MotorType.kBrushless);

  private final DifferentialDrive m_RobotDrive = new DifferentialDrive(LeftFrontDrive, RightFrontDrive);
  private final DifferentialDrive m_RobotDriveBackward = new DifferentialDrive(LeftBackDrive, RightBackDrive);
  private XboxController exampleXbox;
  public DrivetrainSub() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    m_RobotDrive.tankDrive(exampleXbox.getLeftY() * 0.8, exampleXbox.getRightY() * 0.8);
    m_RobotDriveBackward.tankDrive(exampleXbox.getLeftY() * 0.8, exampleXbox.getRightY() * 0.8);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
