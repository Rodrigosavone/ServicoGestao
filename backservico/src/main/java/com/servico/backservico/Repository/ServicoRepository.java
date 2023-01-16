package com.servico.backservico.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.servico.backservico.Entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

	@Query("select s FROM Servico s where s.valorPago <> null and s.valorPago > 0")
	List<Servico> buscarServicosPendente();
	
	@Query("select s from Servico s where s.status = 'cancelado'")
	List<Servico> buscarServicosCancelados();

}
