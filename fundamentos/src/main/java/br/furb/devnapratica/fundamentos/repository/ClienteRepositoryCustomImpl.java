package br.furb.devnapratica.fundamentos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.jpa.impl.JPAQuery;

import br.furb.devnapratica.fundamentos.entity.ClienteEntity;
import br.furb.devnapratica.fundamentos.entity.QClienteEntity;

public class ClienteRepositoryCustomImpl implements ClienteRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	private QClienteEntity qCliente = QClienteEntity.clienteEntity;

	@Override
	public List<ClienteEntity> buscarPeloNome(String nome) {
		JPAQuery<ClienteEntity> query = new JPAQuery<ClienteEntity>(entityManager);
		return query.select(qCliente).from(qCliente).where(qCliente.nome.equalsIgnoreCase(nome)).fetch();
	}
}
