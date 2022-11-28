package br.com.proexp.mapaexclusaodigital.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.proexp.mapaexclusaodigital.repository.TipoProblemaRepository;

public class SaveProblemForm {
	
	private String idTipo;
	private String descricao;
	private String estado;
	private String cidade;
	
	private String ticket;
	
	public SaveProblemForm() {
		super();
	}
	public SaveProblemForm(String idTipo, String descricao, String estado, String cidade) {
		this.idTipo = idTipo;
		this.descricao = descricao;
		this.estado = estado;
		this.cidade = cidade;
	}
	public String getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
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
	public List<Problema> getProblemas(TipoProblemaRepository repository) {
		
		List<Problema> problemas = new ArrayList<Problema>();
		
		String[] idTipoList = idTipo.split(",");
		String[] descricaoList = descricao.split(",");
		String[] estadoList = estado.split(",");
		String[] cidadeList = cidade.split(",");
		
		for (int i = 0; i < idTipoList.length; i++) {
			Integer idTipo = Integer.parseInt(idTipoList[i]);
			Optional<TipoProblema> tipo = repository.findById(idTipo);
			String descricao = descricaoList[i];
			String estado = estadoList[i];
			String cidade = cidadeList[i];
			
			if (tipo.isEmpty()) {
				throw new IllegalArgumentException("idTipoProblema não encontrado");
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmsss");
		
			Random rand = new Random();
			int aleatorio = rand.nextInt(999);
			
			this.ticket = String.format("%s%03d", sdf.format(new Date()), aleatorio);
			
			Problema p = new Problema(0, tipo.get(), descricao, estado, cidade, ticket);
			
			problemas.add(p);
		}
		return problemas;
	}
	
}
