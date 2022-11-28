package br.com.proexp.mapaexclusaodigital.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Problema {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idTipo", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private TipoProblema tipo;
	
	private String descricao;
	private String estado;
	private String cidade;
	private String ticket;
	public Problema() {
	}
	public Problema(Integer id, TipoProblema tipo, String descricao, String estado, String cidade, String ticket) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.estado = estado;
		this.cidade = cidade;
		this.ticket = ticket;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TipoProblema getTipo() {
		return tipo;
	}
	public void setTipo(TipoProblema tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	@Override
	public String toString() {
		return "Problema [id=" + id + ", tipo=" + tipo + ", descricao=" + descricao + ", estado=" + estado + ", cidade="
				+ cidade + ", ticket=" + ticket + "]";
	}
	
	
	
}
