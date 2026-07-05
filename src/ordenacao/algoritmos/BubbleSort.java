package ordenacao.algoritmos;

import ordenacao.util.MetricasOrdenacao;

public class BubbleSort {
	
	public static MetricasOrdenacao ordenar(int[] vetor) {
		MetricasOrdenacao metricas = new MetricasOrdenacao();
		int n = vetor.length;
		
		// Inicia a contagem do tempo antes de começar a ordenar
		long tempoInicio = System.currentTimeMillis();
		
		for(int i = 0; i < n - 1; i++) {
			boolean houveTroca = false; 
			
			for(int j = 0; j < n - 1 - i; j++) {
				// Aqui ocorre a comparação entre elementos
				metricas.setComparacoes(metricas.getComparacoes() + 1);
				
				if(vetor[j] > vetor[j+1]) {
					
					// Aqui ocorre a troca ou movimentação de elementos
					int temp = vetor[j];
					vetor[j] = vetor[j+1];
					vetor[j+1] = temp;
					
					metricas.setTrocas(metricas.getTrocas() + 1);
					houveTroca = true;
				}
			}
			
			if(!houveTroca) {
				break;
			}	
		}
		
		// Finaliza a contagem do tempo e guarda na classe de métricas
		long tempoFim = System.currentTimeMillis();
		metricas.setTempoExecucao(tempoFim - tempoInicio);
		
		return metricas;
	}
}