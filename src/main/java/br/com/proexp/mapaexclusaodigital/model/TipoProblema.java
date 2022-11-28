package br.com.proexp.mapaexclusaodigital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoProblema {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	public enum NaturezaProblema {
		Outro,
		Recurso,
		Estrutura,
		Conhecimento
	}
	
	private NaturezaProblema natureza;
	
	private String titulo;
	
	private String descricao;

	public TipoProblema() {
		super();
	}

	public TipoProblema(Integer id, 
			NaturezaProblema natureza, 
			String titulo, String descricao) {
		this.natureza = natureza;
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public NaturezaProblema getNatureza() {
		return natureza;
	}

	public void setNatureza(NaturezaProblema natureza) {
		this.natureza = natureza;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "TipoProblema [natureza=" + 
				natureza + 
				", id=" + id + ", titulo=" + titulo + ", descricao=" + descricao
				+ "]";
	}
	
//	public static void main(String[] args) {
//		System.out.println(TipoProblema.NaturezaProblema.Outro.ordinal());
//		System.out.println(TipoProblema.NaturezaProblema.Recurso.ordinal());
//		System.out.println(TipoProblema.NaturezaProblema.Estrutura.ordinal());
//		System.out.println(TipoProblema.NaturezaProblema.Conhecimento.ordinal());
//	}
//	
}
