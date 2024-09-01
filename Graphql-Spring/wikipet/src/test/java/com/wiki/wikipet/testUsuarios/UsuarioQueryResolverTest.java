import com.wiki.wikipet.service.UsuarioService;
import com.wiki.wikipet.model.Usuario;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.wiki.wikipet.resolver.UsuarioQueryResolver;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class UsuarioQueryResolverTest {

    @InjectMocks
    private UsuarioQueryResolver usuarioQueryResolver;

    @Mock
    private UsuarioService usuarioService;

    @Test
    void testGetUsuarios() {
        // Arrange
        MockitoAnnotations.openMocks(this);
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan Pérez");
        when(usuarioService.obtenerUsuarios()).thenReturn(List.of(usuario));

        // Act
        List<Usuario> usuarios = usuarioQueryResolver.getUsuarios();

        // Assert
        assertThat(usuarios).hasSize(1);
        assertThat(usuarios.get(0).getNombre()).isEqualTo("Juan Pérez");
    }
}
