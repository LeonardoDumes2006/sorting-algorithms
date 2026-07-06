package ordenacao;

import ordenacao.algoritmos.*;
import ordenacao.util.GeradorVetores;

public class Main {

    public static void main(String[] args) {
        int[] tamanhos = {100_000, 1_000_000};
        String[] cenarios = {"Ordenado", "Invertido", "Aleatório"};

        for (int tamanho : tamanhos) {
            System.out.println("=========================================================");
            System.out.println(" INICIANDO BATERIA DE TESTES: " + tamanho + " ELEMENTOS");
            System.out.println("=========================================================");


            for (String cenario : cenarios) {
                System.out.println("--- Cenário: " + cenario + " ---");

                // 1. Gera o vetor original da rodada
                int[] vetorOriginal;
                if (cenario.equals("Ordenado")) {
                    vetorOriginal = GeradorVetores.gerarOrdenado(tamanho);
                } else if (cenario.equals("Invertido")) {
                    vetorOriginal = GeradorVetores.gerarInvertido(tamanho);
                } else {
                    vetorOriginal = GeradorVetores.gerarAleatorio(tamanho);
                }

                // 2. Clona o vetor para cada algoritmo (Garante comparação justa)
                System.out.println("Bubble Sort    -> " + BubbleSort.ordenar(vetorOriginal.clone()));
                System.out.println("Selection Sort -> " + SelectionSort.ordenar(vetorOriginal.clone()));
                System.out.println("Insertion Sort -> " + InsertionSort.ordenar(vetorOriginal.clone()));
                
                System.out.println("Merge Sort     -> " + MergeSort.ordenar(vetorOriginal.clone()));
                System.out.println("Quick Sort     -> " + QuickSort.ordenar(vetorOriginal.clone()));
                
                System.out.println("Shell Sort     -> " + ShellSort.ordenar(vetorOriginal.clone()));
                System.out.println("Heap Sort      -> " + HeapSort.ordenar(vetorOriginal.clone()));
                
                System.out.println("---------------------------------------------------------");
            }
        }
        
    }
}