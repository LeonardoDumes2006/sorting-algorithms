package ordenacao.algoritmos;

import ordenacao.util.MetricasOrdenacao;

public class QuickSort {

    public static MetricasOrdenacao ordenar(int[] vetor) {
        MetricasOrdenacao metricas = new MetricasOrdenacao();
        long tempoInicio = System.currentTimeMillis();
        
        if (vetor.length > 0) {
            quickSortRecursivo(vetor, 0, vetor.length - 1, metricas);
        }
        
        long tempoFim = System.currentTimeMillis();
        metricas.setTempoExecucao(tempoFim - tempoInicio);
        
        return metricas;
    }

    private static void quickSortRecursivo(int[] vetor, int inicio, int fim, MetricasOrdenacao metricas) {
        if (inicio < fim) {
            // A divisão do problema ocorre aqui, particionando o vetor em torno de um pivô
            int indicePivo = particionar(vetor, inicio, fim, metricas);
            
            // Chamadas recursivas para as duas metades (não há passo de combinação explícito no Quick Sort)
            quickSortRecursivo(vetor, inicio, indicePivo - 1, metricas);
            quickSortRecursivo(vetor, indicePivo + 1, fim, metricas);
        }
    }

    private static int particionar(int[] vetor, int inicio, int fim, MetricasOrdenacao metricas) {
        int pivo = vetor[fim];
        int i = (inicio - 1);
        
        for (int j = inicio; j < fim; j++) {
            // Aqui ocorre a comparação com o pivô
            metricas.setComparacoes(metricas.getComparacoes() + 1);
            
            if (vetor[j] <= pivo) {
                i++;
                
                // Aqui ocorre a troca de elementos para organizar a partição
                metricas.setTrocas(metricas.getTrocas() + 1);
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }
        
        // Colocando o pivô na posição correta
        metricas.setTrocas(metricas.getTrocas() + 1);
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;
        
        return i + 1;
    }
}