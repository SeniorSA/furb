package br.furb.devnapratica.fundamentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.furb.devnapratica.fundamentos.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>, ClienteRepositoryCustom {

	public List<ClienteEntity> findByNomeIgnoreCase(String nome);
}
