package com.demo.mapping.one2one.uni;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "parking_table_uni")
public class Parking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int partingId;
	
	
	private String parkingLocation;

	@JoinColumn(name = "eid_fk", nullable = false)
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Employee employee;

	
	public int getPartingId() {
		return partingId;
	}

	public void setPartingId(int partingId) {
		this.partingId = partingId;
	}

	public String getParkingLocation() {
		return parkingLocation;
	}

	public void setParkingLocation(String parkingLocation) {
		this.parkingLocation = parkingLocation;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Parking(String parkingLocation) {
		this.parkingLocation = parkingLocation;
	}

	public Parking() {}

	@Override
	public String toString() {
		return "Parking [partingId=" + partingId + ", parkingLocation=" + parkingLocation 
				+ "]";
	}
	
	
	
}
