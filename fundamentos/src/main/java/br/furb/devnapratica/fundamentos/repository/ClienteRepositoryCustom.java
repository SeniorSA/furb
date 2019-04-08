package br.furb.devnapratica.fundamentos.repository;

import java.util.List;

import br.furb.devnapratica.fundamentos.entity.ClienteEntity;

public interface ClienteRepositoryCustom {

	public List<ClienteEntity> buscarPeloNome(String nome);
}
