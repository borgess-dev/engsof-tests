package api.engsof.shop;

import api.engsof.shop.entities.Cliente;
import api.engsof.shop.exceptions.FieldCannotBeNull;
import api.engsof.shop.exceptions.StringMustHaveContent;
import api.engsof.shop.repositories.ClienteRepository;
import api.engsof.shop.services.ClienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("testes para cadastro invalido")
@ExtendWith(MockitoExtension.class)
public class InvalidUserRegisterTests {
    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    @DisplayName("usuario com telefone null nao deve ser cadastrado")
    public void cadastroUsuarioComTelefoneNullTest() {
        Cliente cliente = new Cliente(
                "Eduardo Borges",
                "borgessedu@gmail.com",
                null
        );
        assertThrows(FieldCannotBeNull.class, () -> Mockito.when(clienteService.cadastrarCliente(cliente)));
    }

    @Test
    @DisplayName("usuario com telefone vazio nao deve ser cadastrado")
    public void cadastroUsuarioComTelefoneVazioTest() {
        Cliente cliente = new Cliente(
                "Eduardo Borges",
                "borgessedu@gmail.com",
                ""
        );
        assertThrows(StringMustHaveContent.class, () -> Mockito.when(clienteService.cadastrarCliente(cliente)));
    }

    @Test
    @DisplayName("usuario sem nome nao deve ser cadastrado")
    public void cadastroUsuarioComNomeVazioTest() {
        Cliente cliente = new Cliente(
                "",
                "borgessedu@gmail.com",
                "38999311955"
        );
        assertThrows(StringMustHaveContent.class, () -> Mockito.when(clienteService.cadastrarCliente(cliente)));
    }

    @Test
    @DisplayName("usuario sem nome nao deve ser cadastrado")
    public void cadastroUsuarioComNomeNullTest() {
        Cliente cliente = new Cliente(
                null,
                "borgessedu@gmail.com",
                "38999311955"
        );
        assertThrows(FieldCannotBeNull.class, () -> Mockito.when(clienteService.cadastrarCliente(cliente)));
    }



}
