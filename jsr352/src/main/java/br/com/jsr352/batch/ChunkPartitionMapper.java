package br.com.jsr352.batch;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.batch.api.partition.PartitionMapper;
import javax.batch.api.partition.PartitionPlan;
import javax.batch.api.partition.PartitionPlanImpl;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsr352.model.Parceria;
import br.com.jsr352.model.Proposta;

@Dependent
@Named("ChunkPartitionMapper")
public class ChunkPartitionMapper implements PartitionMapper {
	
	private static final Logger logger = Logger.getLogger(ChunkPartitionMapper.class.getCanonicalName());
	
	@Override
	public PartitionPlan mapPartitions() throws Exception {
		return new PartitionPlanImpl() {
			
			private int qtdPropostas;
			private List<Parceria> parcerias = new ArrayList<>();
			
			@Inject
			private JobContext contextoBatch;
			
			@Override
            public int getPartitions() {
				init();
            	return parcerias.size();
            }
			
			@Override
            public int getThreads() {
                return 1;
            }
			
			private void init() {
				//TypedQuery<VwProposta> query = em.createNamedQuery("VwProposta.findAllOrderByEmpresa", VwProposta.class);
				//listaPropostas = query.getResultList();
				qtdPropostas = 6;
				for(int i = 0; i < 3; i++) {
					Parceria parceria = new Parceria();
					if (i==0) {
						parceria.setId(1);
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
						
					} else if (i==1) {
						parceria.setId(2);
						parceria.setNomeParceria("B");
						parceria.setTotalPropostas(1);
						
						List<Proposta> listaPropostas = new ArrayList<>();
						Proposta proposta2 = new Proposta();
						proposta2.setId(2);
						
						listaPropostas.add(proposta2);
						parceria.setPropostas(listaPropostas);
						
					} else if (i==2) {
						parceria.setId(3);
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
					parcerias.add(parceria);					
				}
            }
			
            @Override
            public Properties[] getPartitionProperties() {
            	logger.info("Passou no ChunkPartitionMapper.getPartitionProperties()");
            	Properties[] propriedades = new Properties[parcerias.size()];
            	int i = 0;
        		for(Parceria parceria : parcerias) {
        			propriedades[i] = new Properties();
                	propriedades[i].setProperty("qtdPropostas", String.valueOf(parceria.getPropostas().size()));
                	propriedades[i].setProperty("idParceria", String.valueOf(parceria.getId()));
                	i=++i;
        		}
                return propriedades;
            }
        };
    }

}
