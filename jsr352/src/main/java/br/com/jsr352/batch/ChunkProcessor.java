package br.com.jsr352.batch;

import java.util.logging.Logger;

import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

import br.com.jsr352.model.Proposta;

@Dependent
@Named("ChunkProcessor")
public class ChunkProcessor implements ItemProcessor {

	private static final Logger logger = Logger.getLogger(ChunkProcessor.class.getCanonicalName());
	
	@Override
	public Object processItem(Object item) throws Exception {
		Proposta proposta = (Proposta) item;
		logger.info("Passou no ChunkProcessor.processItem()");
		logger.info("Proposta: " +  proposta.getId());
		return proposta;
	}

}
