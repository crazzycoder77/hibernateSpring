package com.cognizant.spring.orm.dao;

import java.util.List;

import com.cognizant.spring.orm.entity.Passenger;

public interface PassengerDao {
	public int create(Passenger passenger);
	public void delete(Passenger id);
	public void update(Passenger passenger);
	public Passenger find(int id);
	public List<Passenger> find();
}
