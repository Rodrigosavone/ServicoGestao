package com.servico.backservico.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servico.backservico.Entity.Servico;
import com.servico.backservico.Repository.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;
	
	public List<Servico> buscarTodos() {
		return servicoRepository.findAll();
	}
	
	public List<Servico> buscarServicosPendente(){
		return servicoRepository.buscarServicosPendente();
	}
	
	public List<Servico> buscarServicosCancelados() {
		return servicoRepository.buscarServicosCancelados();
	}
	
	public Servico inserir(Servico servico) {
		if(servico.getValorPago() == null || servico.getValorPago() == 0 || servico.getDescricaoServico() == null) {
			servico.setStatus("pendente");
		} else {
			servico.setStatus("realizado");
		}
		return servicoRepository.save(servico);
	}
	
	public Servico alterar(Servico servico) {
		if(servico.getValorPago() != null && servico.getValorPago() > 0 && servico.getDescricaoServico() != null) {
			servico.setStatus("realizado");
		}
		return servicoRepository.save(servico);
	}
	
	public void excluir(Long id) {
		Servico servico = servicoRepository.findById(id).get();
		servicoRepository.delete(servico);
	}
}
