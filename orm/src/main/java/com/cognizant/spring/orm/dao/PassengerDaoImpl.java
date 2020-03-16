package com.cognizant.spring.orm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.spring.orm.entity.Passenger;

public class PassengerDaoImpl implements PassengerDao {
	@Autowired
	HibernateTemplate hibrenateTemplate;
	
	public HibernateTemplate getHibrenateTemplate() {
		return hibrenateTemplate;
	}

	public void setHibrenateTemplate(HibernateTemplate hibrenateTemplate) {
		this.hibrenateTemplate = hibrenateTemplate;
	}

	 
	public int create(Passenger passenger) {
		int result = (Integer) this.hibrenateTemplate.save(passenger);
		return result;
	}

	 
	public void delete(Passenger passenger) {
		this.hibrenateTemplate.delete(passenger);
	}

	 
	public void update(Passenger passenger) {
		this.hibrenateTemplate.update(passenger);
	}

	public Passenger find(int id) {
		return this.hibrenateTemplate.get(Passenger.class, id);
	}

	public List<Passenger> find() {
		// TODO Auto-generated method stub
		return this.hibrenateTemplate.loadAll(Passenger.class);
	}

}
