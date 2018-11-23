package br.com.jsr352.batch;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.batch.api.chunk.ItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("ChunkWriter")
public class ChunkWriter implements ItemWriter {

	private static final Logger logger = Logger.getLogger(ChunkProcessor.class.getCanonicalName());

	@Override
	public void writeItems(List items) throws Exception {
		logger.info("Passou no ChunkWriter.writeItems()");
		
		Iterator itr = items.iterator();
		while (itr.hasNext()) {
			logger.info("Loop com a lista dos itens a serem escritos: " + itr.next().toString());
		}
	}

	@Override
	public void open(Serializable checkpoint) throws Exception {
		// TODO Auto-generated method stub
		//logger.info("Passou no ChunkWriter.open()");
	}
	
	@Override
	public Serializable checkpointInfo() throws Exception {
		// TODO Auto-generated method stub
		//logger.info("Passou no ChunkWriter.checkpointInfo()");
		return null;
	}
	
	@Override
	public void close() throws Exception {
		logger.info("Passou no ChunkWriter.close()");
		// TODO Auto-generated method stub
	}

}
