package ordenacao.algoritmos;

import ordenacao.util.MetricasOrdenacao;

public class QuickSort {

    public static MetricasOrdenacao ordenar(int[] array) {
        MetricasOrdenacao metricas = new MetricasOrdenacao();
        long tempoInicio = System.currentTimeMillis();
        
        if (array != null && array.length > 1) {
            quickSort(array, 0, array.length - 1, metricas);
        }
        
        long tempoFim = System.currentTimeMillis();
        metricas.setTempoExecucao(tempoFim - tempoInicio);
        
        return metricas;
    }
    
    private static void quickSort(int[] array, int inicio, int fim, MetricasOrdenacao metricas) {
        if (inicio < fim) {
            // A divisão do problema ocorre aqui, obtendo o índice de corte (partição) 
            int pontoDeCorte = particao(array, inicio, fim, metricas);
            
            // Usamos o ponto de corte para dividir
            quickSort(array, inicio, pontoDeCorte, metricas);
            quickSort(array, pontoDeCorte + 1, fim, metricas);
        }
    }
    
    private static int particao(int[] array, int inicio, int fim, MetricasOrdenacao metricas) {
        // 1. Definição do Pivô no meio
        int meio = (inicio + fim) / 2;
        int pivo = array[meio];
        
        // 2. Inicialização dos ponteiros nas extremidades do escopo atual
        int i = inicio;
        int j = fim;
        
        while (true) {
            // Avança o ponteiro 'i' e contabiliza cada comparação feita com o pivô
            metricas.setComparacoes(metricas.getComparacoes() + 1); // Primeira verificação do while
            while (array[i] < pivo) {
                i++;
                // COMENTÁRIO OBRIGATÓRIO: Comparação entre elementos (buscando valor maior ou igual ao pivô) [cite: 25]
                metricas.setComparacoes(metricas.getComparacoes() + 1); 
            }
            
            // Recua o ponteiro 'j' e contabiliza cada comparação feita com o pivô
            metricas.setComparacoes(metricas.getComparacoes() + 1); // Primeira verificação do while
            while (array[j] > pivo) {
                j--;
                // COMENTÁRIO OBRIGATÓRIO: Comparação entre elementos (buscando valor menor ou igual ao pivô) [cite: 25]
                metricas.setComparacoes(metricas.getComparacoes() + 1);
            }
            
            if (i >= j) {
                return j;
            }
            
            // 3. Operação de troca para readequar os elementos mal posicionados
            // Aqui ocorre a troca (movimentação) de elementos 
            metricas.setTrocas(metricas.getTrocas() + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            
            // Incrementa para evitar laço infinito após troca de elementos iguais ao pivô
            i++;
            j--;
        }
    }
}