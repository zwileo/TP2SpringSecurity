package com.inti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @AllArgsConstructor @NoArgsConstructor 
public class Chaine {
	
	
	private String nom; 
	
	@OneToMany
	@JoinTable(joinColumns = @JoinColumn(name ="idH"))
	private Hotel hotel;

}
