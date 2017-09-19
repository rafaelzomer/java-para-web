package app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CpfController {
    
    private String cpf;
    
    public CpfController() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void converter() {
        System.out.println("Codigo: " + cpf);
    }
    
}
