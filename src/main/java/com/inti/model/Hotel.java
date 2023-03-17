package com.inti.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @AllArgsConstructor @NoArgsConstructor
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idH;
	private String nom; 
	
	@OneToOne
	@JoinColumn(name="idRespo")
	private Responsable responsable;
	
	@ManyToOne
	@JoinColumn(name="idChaine")
	private Chaine chaine;
	
	@OneToMany(mappedBy ="hotel" )
	private List<Salarie> listSalarie;
	
	@OneToMany(mappedBy = "hotel")
	private List<Chambre> listChambre;
}
