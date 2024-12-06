package com.example.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Events") 
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	@Column
	private String eventName ;
	@Column
	private String date ;
	@Column
	private String heure ;
	@Column
	private int nbrpart ;
	public Event( String eventName, String date, String heure, int nbrpart) {
		super();
		this.eventName = eventName;
		this.date = date;
		this.heure = heure;
		this.nbrpart = nbrpart;
	}
	public Event () {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public int getNbrpart() {
		return nbrpart;
	}
	public void setNbrpart(int nbrpart) {
		this.nbrpart = nbrpart;
	}
	

}
