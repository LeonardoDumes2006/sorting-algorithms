package ordenacao.algoritmos;

import ordenacao.util.MetricasOrdenacao;

public class MergeSort {

    public static MetricasOrdenacao ordenar(int[] vetor) {
        MetricasOrdenacao metricas = new MetricasOrdenacao();
        long tempoInicio = System.currentTimeMillis();
        
        if (vetor.length > 0) {
            mergeSortRecursivo(vetor, 0, vetor.length - 1, metricas);
        }
        
        long tempoFim = System.currentTimeMillis();
        metricas.setTempoExecucao(tempoFim - tempoInicio);
        
        return metricas;
    }

    private static void mergeSortRecursivo(int[] vetor, int inicio, int fim, MetricasOrdenacao metricas) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            
            // Aqui é feita a divisão do problema em subproblemas menores usando recursão
            mergeSortRecursivo(vetor, inicio, meio, metricas);
            mergeSortRecursivo(vetor, meio + 1, fim, metricas);
            
            //  Aqui ocorre a combinação dos resultados (juntando as metades ordenadas)
            merge(vetor, inicio, meio, fim, metricas);
        }
    }

    private static void merge(int[] vetor, int inicio, int meio, int fim, MetricasOrdenacao metricas) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;
        
        int[] esquerda = new int[n1];
        int[] direita = new int[n2];
        
        for (int i = 0; i < n1; ++i) esquerda[i] = vetor[inicio + i];
        for (int j = 0; j < n2; ++j) direita[j] = vetor[meio + 1 + j];
        
        int i = 0, j = 0, k = inicio;
        
        while (i < n1 && j < n2) {
            // Aqui ocorre a comparação entre elementos das duas metades
            metricas.setComparacoes(metricas.getComparacoes() + 1);
            
            if (esquerda[i] <= direita[j]) {
                // Aqui ocorre a movimentação de elementos para o vetor original
                vetor[k] = esquerda[i];
                metricas.setTrocas(metricas.getTrocas() + 1);
                i++;
            } else {
                vetor[k] = direita[j];
                metricas.setTrocas(metricas.getTrocas() + 1);
                j++;
            }
            k++;
        }
        
        // Copiando os elementos restantes, se houver
        while (i < n1) {
            vetor[k] = esquerda[i];
            metricas.setTrocas(metricas.getTrocas() + 1);
            i++; k++;
        }
        while (j < n2) {
            vetor[k] = direita[j];
            metricas.setTrocas(metricas.getTrocas() + 1);
            j++; k++;
        }
    }
}