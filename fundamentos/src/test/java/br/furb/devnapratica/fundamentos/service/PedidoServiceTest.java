package br.furb.devnapratica.fundamentos.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.client.ExpectedCount;

import br.furb.devnapratica.fundamentos.entity.ItemEntity;
import br.furb.devnapratica.fundamentos.entity.PedidoEntity;
import br.furb.devnapratica.fundamentos.repository.PedidoRepository;

public class PedidoServiceTest {
	private static final Long mockId = 1L;
	@InjectMocks
	private PedidoService pedidoService;
	
	@Mock
	private PedidoRepository pedidoRepository;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass");
	}
	
	@Before
	public void setup() {
		System.out.println("before");
		MockitoAnnotations.initMocks(this);
	}
	
	@After
	public void after() {
		System.out.println("after");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass");
	}
	
	@Test
	public void getTotalPedidos_should_returnFive() {
		System.out.println("test1");
		// Init 
		PedidoEntity mockPedido = new PedidoEntity(mockId);
		mockPedido.setItens(new ArrayList<>());
		
		ItemEntity item1 = new ItemEntity();
		item1.setQuantidade(3L);
		
		ItemEntity item2 = new ItemEntity();
		item2.setQuantidade(2L);
		
		mockPedido.getItens().add(item1);
		mockPedido.getItens().add(item2);
		
		// When
		Mockito.when(pedidoRepository.findById(mockId)).thenReturn(Optional.of(mockPedido));
		long result = pedidoService.getTotalPedidos(mockId);
		
		// assertEquals
	
		assertEquals(5L, result);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void getTotalPedidos_should_throwException() {
		System.out.println("test2");
		Mockito.when(pedidoRepository.findById(mockId)).thenReturn(Optional.empty());
		pedidoService.getTotalPedidos(mockId);
	}

}
