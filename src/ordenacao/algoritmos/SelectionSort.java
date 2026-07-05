package ordenacao.algoritmos;

import ordenacao.util.MetricasOrdenacao;

public class SelectionSort {
	
	public static MetricasOrdenacao ordenar(int[] vetor) {
		MetricasOrdenacao metricas = new MetricasOrdenacao();
		int n = vetor.length;
		
		long tempoInicio = System.currentTimeMillis();
		
		for(int i = 0; i < n - 1; i++) {
			int indiceMenor = i;
			
			// Busca o menor elemento na parte não ordenada
			for(int j = i + 1; j < n; j++) {
				
				//  Aqui ocorre a comparação entre elementos
				metricas.setComparacoes(metricas.getComparacoes() + 1);
				
				if(vetor[j] < vetor[indiceMenor]) {
					indiceMenor = j;
				}
			}
			
			if(indiceMenor != i) {
				// Aqui ocorre a troca ou movimentação de elementos
				metricas.setTrocas(metricas.getTrocas() + 1);
				
				int temp = vetor[i];
				vetor[i] = vetor[indiceMenor];
				vetor[indiceMenor] = temp;
			}
		}
		
		long tempoFim = System.currentTimeMillis();
		metricas.setTempoExecucao(tempoFim - tempoInicio);
		
		return metricas;
	}
}