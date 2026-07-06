package ordenacao.util;

public class MetricasOrdenacao {
    
    private long comparacoes;
    private long trocas;
    private long tempoExecucao; 

    // O construtor zera as métricas toda vez que um algoritmo começar
    public MetricasOrdenacao() {
        this.comparacoes = 0;
        this.trocas = 0;
        this.tempoExecucao = 0;
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public void setComparacoes(long comparacoes) {
        this.comparacoes = comparacoes;
    }

    public long getTrocas() {
        return trocas;
    }

    public void setTrocas(long trocas) {
        this.trocas = trocas;
    }

    public long getTempoExecucao() {
        return tempoExecucao;
    }

    public void setTempoExecucao(long tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MetricasOrdenacao [comparacoes=");
		builder.append(comparacoes);
		builder.append(", trocas=");
		builder.append(trocas);
		builder.append(", tempoExecucao=");
		builder.append(tempoExecucao);
		builder.append("]");
		return builder.toString();
	}

   
}