package ordenacao.algoritmos;

import ordenacao.util.MetricasOrdenacao;

public class MergeSort {

    public static MetricasOrdenacao ordenar(int[] array) {
        MetricasOrdenacao metricas = new MetricasOrdenacao();
        long tempoInicio = System.currentTimeMillis();
        
        if (array != null && array.length > 1) {
            mergeSortRecursivo(array, 0, array.length - 1, metricas);
        }
        
        long tempoFim = System.currentTimeMillis();
        metricas.setTempoExecucao(tempoFim - tempoInicio);
        
        return metricas;
    }
    
    private static void mergeSortRecursivo(int[] array, int inicio, int fim, MetricasOrdenacao metricas) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            
            // Divisão do problema ordenando recursivamente o subarray esquerdo e direito
            mergeSortRecursivo(array, inicio, meio, metricas);
            mergeSortRecursivo(array, meio + 1, fim, metricas);
            
            // Conquista e combinação dos resultados intercalando os dois subarrays ordenados
            merge(array, inicio, meio, fim, metricas);
        }
    }
    
    private static void merge(int[] array, int inicio, int meio, int fim, MetricasOrdenacao metricas) {
        // 1. Determinação do tamanho dos subarrays
        int tamanhoEsq = meio - inicio + 1;
        int tamanhoDir = fim - meio;

        int[] vetorEsq = new int[tamanhoEsq];
        int[] vetorDir = new int[tamanhoDir];

        // 2. Cópia dos elementos do vetor principal para os auxiliares
        for (int i = 0; i < tamanhoEsq; i++) {
            vetorEsq[i] = array[inicio + i];
        }
        for (int j = 0; j < tamanhoDir; j++) {
            vetorDir[j] = array[meio + 1 + j];
        }

        // 3. Processo de intercalação (Merge)
        int i = 0, j = 0, k = inicio;

        // Compara os elementos e insere o menor no array original
        while (i < tamanhoEsq && j < tamanhoDir) {
            // Aqui ocorre a comparação entre elementos para o Merge 
            metricas.setComparacoes(metricas.getComparacoes() + 1);
            
            if (vetorEsq[i] <= vetorDir[j]) {
                // Movimentação de elementos de volta ao vetor original
                array[k] = vetorEsq[i];
                metricas.setTrocas(metricas.getTrocas() + 1);
                i++;
            } else {
                // Movimentação de elementos de volta ao vetor original 
                array[k] = vetorDir[j];
                metricas.setTrocas(metricas.getTrocas() + 1);
                j++;
            }
            k++;
        }

        // 4. Transferência dos elementos remanescentes (se houver)
        while (i < tamanhoEsq) {
            array[k] = vetorEsq[i];
            metricas.setTrocas(metricas.getTrocas() + 1);
            i++; k++;
        }
        while (j < tamanhoDir) {
            array[k] = vetorDir[j];
            metricas.setTrocas(metricas.getTrocas() + 1);
            j++; k++;
        }
    }
}