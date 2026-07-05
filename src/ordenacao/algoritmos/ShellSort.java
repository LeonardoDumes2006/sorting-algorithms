package ordenacao.algoritmos;

import ordenacao.util.MetricasOrdenacao;

public class ShellSort {

    public static MetricasOrdenacao ordenar(int[] vetor) {
        MetricasOrdenacao metricas = new MetricasOrdenacao();
        int n = vetor.length;
        
        long tempoInicio = System.currentTimeMillis();
        
        // Começa com um "gap" (salto) grande e vai reduzindo até chegar a 1
        for (int gap = n / 2; gap > 0; gap /= 2) {
            
            for (int i = gap; i < n; i++) {
                int chave = vetor[i];
                int j = i;
                
                // Substituímos o for interno por um while para ter controle absoluto das métricas
                while (j >= gap) {
                    
                    // Aqui ocorre a comparação entre elementos distantes pelo 'gap'
                    metricas.setComparacoes(metricas.getComparacoes() + 1);
                    
                    if (vetor[j - gap] > chave) {
                        // Aqui ocorre a movimentação (troca) de elementos
                        metricas.setTrocas(metricas.getTrocas() + 1);
                        vetor[j] = vetor[j - gap];
                        j -= gap;
                    } else {
                        break; // Se não for maior, já está na posição certa para este gap
                    }
                }
                vetor[j] = chave;
            }
        }
        
        long tempoFim = System.currentTimeMillis();
        metricas.setTempoExecucao(tempoFim - tempoInicio);
        
        return metricas;
    }
}