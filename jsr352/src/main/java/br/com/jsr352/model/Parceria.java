package br.com.jsr352.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Named
public class Parceria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int totalPropostas;
	private String nomeParceria;
	List<Proposta> propostas = new ArrayList<>();
	
}
