package br.com.jsr352.batch;

import java.util.logging.Logger;

import javax.batch.api.Batchlet;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("BatchletImpl")
public class BatchletImpl implements Batchlet {

	private static final Logger logger = Logger.getLogger(ChunkReader.class.getCanonicalName());
	
    @Override
    public String process() throws Exception {
        logger.info("Realizando o teste do job.");
        return "COMPLETED";
    }

    @Override
    public void stop() throws Exception {
        
    }
}
