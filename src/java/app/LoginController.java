package app;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LoginController {
    
    private Usuario usuario;
    
    public LoginController() {
    }
    
    @PostConstruct
    public void newUsuario() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String entrar() {
        if (usuario.getUsuario().equals("admin") && usuario.getSenha().equals("AbC123")) {
            return "success";
        }
        return "failure";
    }
}
