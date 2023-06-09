package com.inti.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Chambre {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int numero;
	private double superficie;
	private int etage;
	@NonNull
	private boolean disponibilite;
	private double prix;
	
	@ManyToOne
	@JoinColumn(name="id_hotel")
	private Hotel hotel;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;

}
