package br.com.jsr352.model;

import java.io.Serializable;

import javax.inject.Named;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Named
public class Proposta implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
}
