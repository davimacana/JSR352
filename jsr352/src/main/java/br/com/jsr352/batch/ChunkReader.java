package br.com.jsr352.batch;

import java.io.Serializable;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemReader;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsr352.dao.ParceriaDao;
import br.com.jsr352.model.Parceria;
import br.com.jsr352.model.Proposta;

@Dependent
@Named("ChunkReader")
public class ChunkReader implements ItemReader {
	
	private static final Logger logger = Logger.getLogger(ChunkReader.class.getCanonicalName());

	private StringTokenizer tokens;
	
	@Inject
	private ParceriaDao parceriaDao;
	
	@Inject
	private JobContext contextoBatch;
	
    @Inject
    @BatchProperty(name = "qtdPropostas")
    private String qtdPropostas;
    
    @Inject
    @BatchProperty(name = "idParceria")
    private String idParceria;
    
    /**
	 * Método executado para abrir os recursos de leitura
	 */
	@Override
	public void open(Serializable checkpoint) throws Exception {
		StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Integer.valueOf(qtdPropostas); i++) {
            builder.append(i);
            if (i < Integer.valueOf(qtdPropostas))
                builder.append(",");
        }
        tokens = new StringTokenizer(builder.toString(), ",");
		logger.info("Passou no ChunkReader.Open()");
	}
	
	/**
	 * Método utilizado para retornar o próximo item de leitura para processamento.
	 */
	@Override
	public Object readItem() throws Exception {
		if (tokens.hasMoreTokens()) {
			int token = Integer.valueOf(tokens.nextToken());
			logger.info("readItem: " + token);
			Parceria parceria = parceriaDao.consultaParceria(idParceria);
			Proposta proposta = parceria.getPropostas().get(token);
			return proposta;
		}
		logger.info("Passou no ChunkReader.readItem()");
		return null;
	}

	@Override
	public Serializable checkpointInfo() throws Exception {
		// TODO Auto-generated method stub
		logger.info("Passou no ChunkReader.checkpointInfo()");
		return null;
	}

	/**
	 * Método usado para fechamento dos recursos de leitura.
	 */
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		logger.info("Passou no ChunkReader.close()");
	}
}
