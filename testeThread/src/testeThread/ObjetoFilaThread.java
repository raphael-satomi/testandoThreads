package testeThread;

import java.util.Objects;

public class ObjetoFilaThread {

	private String nome;
	private String tituloRelatorio;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTituloRelatorio() {
		return tituloRelatorio;
	}
	public void setTituloRelatorio(String tituloRelatorio) {
		this.tituloRelatorio = tituloRelatorio;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(nome, tituloRelatorio);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjetoFilaThread other = (ObjetoFilaThread) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(tituloRelatorio, other.tituloRelatorio);
	}
	
}
