import com.wiki.wikipet.model.Usuario;
import com.wiki.wikipet.repository.UsuarioRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMutationResolver implements GraphQLMutationResolver {

    private final UsuarioRepository usuarioRepository;

    public UsuarioMutationResolver(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario crearUsuario(String nombre, String email) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Long id, String nombre, String email) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setNombre(nombre);
            usuario.setEmail(email);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public Boolean eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
