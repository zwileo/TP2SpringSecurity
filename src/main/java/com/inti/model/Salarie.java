package com.inti.model;

import java.time.LocalDate;

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

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salarie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String type;
	public LocalDate dateNaissance;
	public LocalDate dateEmbauche;
	
	
	public Salarie(String type, LocalDate dateNaissance, LocalDate dateEmbauche) {
		super();
		this.type = type;
		this.dateNaissance = dateNaissance;
		this.dateEmbauche = dateEmbauche;
	}
	
	@ManyToOne
	@JoinColumn(name="idH")
	private Hotel hotel;
	
}
