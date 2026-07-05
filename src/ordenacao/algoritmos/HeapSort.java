package ordenacao.algoritmos;

import ordenacao.util.MetricasOrdenacao;

public class HeapSort {

    public static MetricasOrdenacao ordenar(int[] vetor) {
        MetricasOrdenacao metricas = new MetricasOrdenacao();
        int n = vetor.length;
        
        long tempoInicio = System.currentTimeMillis();
        
        // 1º Passo: Constrói o max heap (reorganiza o vetor como uma árvore)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(vetor, n, i, metricas);
        }
        
        // 2º Passo: Extrai os elementos do heap um por um
        for (int i = n - 1; i > 0; i--) {
            // Aqui ocorre a movimentação (troca a raiz/maior elemento com o final do vetor)
            metricas.setTrocas(metricas.getTrocas() + 1);
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;
            
            // Chama o heapify na heap reduzida para encontrar o novo maior elemento
            heapify(vetor, i, 0, metricas);
        }
        
        long tempoFim = System.currentTimeMillis();
        metricas.setTempoExecucao(tempoFim - tempoInicio);
        
        return metricas;
    }

    // Função para transformar um sub-vetor em um Max-Heap
    private static void heapify(int[] vetor, int n, int i, MetricasOrdenacao metricas) {
        int maior = i; // Inicializa o maior como a raiz
        int esquerda = 2 * i + 1; 
        int direita = 2 * i + 2; 
        
        if (esquerda < n) {
            // Comparação para verificar se o filho da esquerda é maior que a raiz
            metricas.setComparacoes(metricas.getComparacoes() + 1);
            if (vetor[esquerda] > vetor[maior]) {
                maior = esquerda;
            }
        }
        
        if (direita < n) {
            // Comparação para verificar se o filho da direita é maior que o maior atual
            metricas.setComparacoes(metricas.getComparacoes() + 1);
            if (vetor[direita] > vetor[maior]) {
                maior = direita;
            }
        }
        
        // Se o maior não for a raiz
        if (maior != i) {
            // Movimentação (troca o nó atual com o maior encontrado)
            metricas.setTrocas(metricas.getTrocas() + 1);
            int temp = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = temp;
            
            // Aplica recursivamente o heapify na subárvore afetada
            heapify(vetor, n, maior, metricas);
        }
    }
}