package com.bridge;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayRollService {

    ArrayList<EmployeePayRoll> employeePayRolls = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public  void readData(){
        EmployeePayRoll employeePayroll = new EmployeePayRoll();
        System.out.println("Enter Id");
        employeePayroll.setId(scanner.nextInt());
        System.out.println("Enter Name");
        employeePayroll.setName(scanner.next());
        System.out.println("Enter Salary");
        employeePayroll.setSalary(scanner.nextInt());

        employeePayRolls.add(employeePayroll);

    }

    public void writeData(){
        System.out.println(employeePayRolls);
    }

    public static void main(String[] args) {
        EmployeePayRollService service = new EmployeePayRollService();
        service.readData();
        service.writeData();
    }

}
