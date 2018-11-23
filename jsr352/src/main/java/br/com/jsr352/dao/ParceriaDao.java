package br.com.jsr352.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.jsr352.model.Parceria;
import br.com.jsr352.model.Proposta;

public class ParceriaDao {
	
	public Parceria consultaParceria(String idParceria) {
		Parceria parceria = new Parceria();
		if (Integer.parseInt(idParceria)==1) {
			parceria.setId(Integer.parseInt(idParceria));
			parceria.setNomeParceria("A");
			parceria.setTotalPropostas(3);
			
			List<Proposta> listaPropostas = new ArrayList<>();
			Proposta proposta1 = new Proposta();
			proposta1.setId(1);
			
			listaPropostas.add(proposta1);
			Proposta proposta3 = new Proposta();
			proposta3.setId(3);
			
			listaPropostas.add(proposta3);
			Proposta proposta6 = new Proposta();
			proposta6.setId(6);
			
			listaPropostas.add(proposta6);
			parceria.setPropostas(listaPropostas);
			
		} else if (Integer.parseInt(idParceria)==2) {
			parceria.setId(Integer.parseInt(idParceria));
			parceria.setNomeParceria("B");
			parceria.setTotalPropostas(1);
			
			List<Proposta> listaPropostas = new ArrayList<>();
			Proposta proposta2 = new Proposta();
			proposta2.setId(2);
			
			listaPropostas.add(proposta2);
			parceria.setPropostas(listaPropostas);
			
		} else if (Integer.parseInt(idParceria)==3) {
			parceria.setId(Integer.parseInt(idParceria));
			parceria.setNomeParceria("C");
			parceria.setTotalPropostas(2);
			
			List<Proposta> listaPropostas = new ArrayList<>();
			Proposta proposta4 = new Proposta();
			proposta4.setId(4);
			
			listaPropostas.add(proposta4);
			Proposta proposta5 = new Proposta();
			proposta5.setId(5);
			
			listaPropostas.add(proposta5);
			parceria.setPropostas(listaPropostas);
			
		}
		return parceria;
	}

}
