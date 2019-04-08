package br.furb.devnapratica.fundamentos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.furb.devnapratica.fundamentos.dto.ClienteDTO;
import br.furb.devnapratica.fundamentos.entity.ClienteEntity;
import br.furb.devnapratica.fundamentos.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClienteDTO> buscarClientes(String nome) {
		return convertEntityToDTO(clienteRepository.buscarPeloNome(nome));
	}

	public List<ClienteDTO> listarClientes() {
		return convertEntityToDTO(clienteRepository.findAll());
	}

	public List<ClienteDTO> convertEntityToDTO(List<ClienteEntity> entityList) {
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		for (ClienteEntity entity : entityList) {
			ClienteDTO cliente = new ClienteDTO();
			cliente.setId(entity.getId());
			cliente.setNome(entity.getNome());
			clientes.add(cliente);
		}
		return clientes;
	}

	public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setNome(clienteDTO.getNome());

		ClienteEntity clienteCriado = clienteRepository.save(clienteEntity);
		ClienteDTO clienteDTOCriado = new ClienteDTO();
		clienteDTOCriado.setId(clienteCriado.getId());
		clienteDTOCriado.setNome(clienteCriado.getNome());
		return clienteDTOCriado;
	}

	public void deletarCliente(Long id) {
		clienteRepository.deleteById(id);
	}
}
