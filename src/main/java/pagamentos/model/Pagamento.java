package pagamentos.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pagamento")
public class Pagamento {

	private Long id;
	private String cliente;
	private Integer conta;
	private Integer credito;
	private List<String> mensalidades;
	private Integer valorMensalidade;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Integer getConta() {
		return conta;
	}
	public void setConta(Integer conta) {
		this.conta = conta;
	}
	public Integer getCredito() {
		return credito;
	}
	public void setCredito(Integer credito) {
		this.credito = credito;
	}
	public List<String> getMensalidades() {
		return mensalidades;
	}
	public void setMensalidades(List<String> mensalidades) {
		this.mensalidades = mensalidades;
	}
   public Integer getValorMensalidade() {
		return valorMensalidade;
	}
	public void setValorMensalidade(Integer valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
