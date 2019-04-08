package br.furb.devnapratica.fundamentos.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoDTO {

	private Long id;
	private List<ItemDTO> itens;
	private LocalDateTime dataPedido;

	public PedidoDTO() {
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemDTO> itens) {
		this.itens = itens;
	}

}
