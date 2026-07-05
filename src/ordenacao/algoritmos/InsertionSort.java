package ordenacao.algoritmos;

import ordenacao.util.MetricasOrdenacao;

public class InsertionSort {
	
	public static MetricasOrdenacao ordenar(int[] vetor) {
		MetricasOrdenacao metricas = new MetricasOrdenacao();
		int n = vetor.length;
		
		long tempoInicio = System.currentTimeMillis();
		
		for(int i = 1; i < n; i++) {
			int chave = vetor[i];
			int j = i - 1;
			
			while (j >= 0) {
				// Aqui ocorre a comparação entre elementos
				metricas.setComparacoes(metricas.getComparacoes() + 1);
				
				if (vetor[j] > chave) {
					// Aqui ocorre a movimentação (deslocamento) de elementos
					metricas.setTrocas(metricas.getTrocas() + 1);
					
					vetor[j + 1] = vetor[j];
					j--;
				} else {
					// Se o elemento não for maior que a chave, já está no lugar certo
					break; 
				}
			}
			vetor[j + 1] = chave;
		}
		
		long tempoFim = System.currentTimeMillis();
		metricas.setTempoExecucao(tempoFim - tempoInicio);
		
		return metricas;
	}
}