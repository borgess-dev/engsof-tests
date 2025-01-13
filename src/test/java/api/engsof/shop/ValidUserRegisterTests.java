package api.engsof.shop;

import api.engsof.shop.entities.Cliente;
import api.engsof.shop.repositories.ClienteRepository;
import api.engsof.shop.services.ClienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ValidUserRegisterTests {

	@Mock
	private ClienteRepository clienteRepository;

	@InjectMocks
	private ClienteService clienteService;

	@Test
	@DisplayName("usuario com campos obrigatorios e opcionais preenchidos")
	public void usuarioComTodosCamposPreenchidosTest() {
		Cliente cliente = new Cliente(
			"Eduardo Borges",
			"borgessedu@gmail.com",
			"38999311955"
		);
		Mockito.when(clienteService.cadastrarCliente(cliente)).thenReturn(new Cliente());
	}

	@Test
	@DisplayName("usuario com campos obrigatorios preenchidos")
	public void usuarioComCamposObrigatoriosPreenchidosTest() {
		Cliente cliente = new Cliente(
				"Eduardo Borges",
				"",
				"38999311955"
		);
		Mockito.when(clienteService.cadastrarCliente(cliente)).thenReturn(new Cliente());
	}
}
