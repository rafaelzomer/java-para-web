package app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CnpjController {
    
    private String cnpj;
    
    public CnpjController() {
    }
    
    public void converter() {
        System.out.println("Cnpj: " + cnpj);
    }
    
    public String getCnpj() {
        return cnpj;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
