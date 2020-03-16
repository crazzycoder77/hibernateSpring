package com.cognizant.spring.orm.dal;

import java.util.List;
import java.util.Scanner;

import com.cognizant.spring.orm.dao.PassengerDao;
import com.cognizant.spring.orm.entity.Passenger;

public class PassengerDalImpl implements PassengerDal {
	Scanner sc;
	PassengerDao passengerDao;
	public PassengerDalImpl(Scanner sc, PassengerDao passengerDao) {
		super();
		this.sc = sc;
		this.passengerDao = passengerDao;
	}

	public void add() {
		System.out.println("----Add New Passenger----");
		System.out.print("Enter Passenger Id : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("Enter First Name   : ");
		String firstName=sc.nextLine();
		System.out.print("Enter Last Name    : ");
		String lastName = sc.nextLine();
		Passenger passenger = new Passenger(id, firstName, lastName);
		int result = this.passengerDao.create(passenger);
		if(result>0)
			System.out.println("Insertion Succesfull");
		else
			System.out.println("Insertion Unsuccesfull");
	}

	public void delete() {
		System.out.println("----Delete Passenger----");
		System.out.print("Enter Passenger Id : ");
		int id = Integer.parseInt(sc.nextLine());
		Passenger passenger=new Passenger(id);
		try{
			this.passengerDao.delete(passenger);
			System.out.println("Deleteion Succesfull");
		}
		catch(Exception e){
			System.out.println("Deletion Unsuccessfull");
		}
	}

	public void update() {
		System.out.println("----Update Passenger----");
		System.out.print("Enter Passenger Id : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("Enter First Name   : ");
		String firstName=sc.nextLine();
		System.out.print("Enter Last Name    : ");
		String lastName = sc.nextLine();
		Passenger passenger = new Passenger(id, firstName, lastName);
		try{
			this.passengerDao.update(passenger);
			System.out.println("Updation Succesfull");
		}
		catch(Exception e){
			System.out.println("Deletion Sucessfull");
		}
	}

	public void find() {
		System.out.println("----Find Passenger By Id----");
		System.out.print("Enter Passenger Id : ");
		int id = Integer.parseInt(sc.nextLine());
		Passenger passenger = this.passengerDao.find(id);
		System.out.printf("%4s|%20s|%20s\n", "ID", "FirstName", "LastName");
		System.out.printf("%4s|%20s|%20s\n",
				passenger.getId(), passenger.getFirstName(), passenger.getLastName());
	}

	public void findAll() {
		System.out.println("----All Passenger In Database----");
		List<Passenger> passengers = this.passengerDao.find();
		System.out.printf("%4s|%20s|%20s\n", "ID", "FirstName", "LastName");
		passengers.forEach(passenger ->{
			System.out.printf("%4s|%20s|%20s\n",
					passenger.getId(), passenger.getFirstName(), passenger.getLastName());
		});
	}

}
