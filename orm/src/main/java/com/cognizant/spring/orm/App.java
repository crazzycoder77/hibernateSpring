package com.cognizant.spring.orm;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring.orm.dal.PassengerDal;
import com.cognizant.spring.orm.dal.PassengerDalImpl;
import com.cognizant.spring.orm.dao.PassengerDao;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    	int choice = 0;
    	PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");
    	PassengerDal passengerDal = new PassengerDalImpl(sc, passengerDao);
    	do{
    		System.out.println("----Menu----");
    		System.out.println("0. Exit");
    		System.out.println("1. Add New Passenger");
    		System.out.println("2. Update Passenger");
    		System.out.println("3. Delete Passenger");
    		System.out.println("4. See Passengers By Id");
    		System.out.println("5. See All Passenger");
    		System.out.print("Enter Your Choice : ");
    		choice = Integer.parseInt(sc.nextLine());
    		switch (choice) {
			case 1:
				passengerDal.add();
				break;
			case 2:
				passengerDal.update();
				break;
			case 3:
				passengerDal.delete();
				break;
			case 4:
				passengerDal.find();
				break;
			case 5:
				passengerDal.findAll();
			}
    	}while(choice!=0);
    }
}
