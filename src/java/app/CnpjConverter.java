package app;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "cnpjConverter")
public class CnpjConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        String cnpj = null;
        
        if (cnpj != null && !cnpj.equals("")) {
            cnpj.replaceAll("\\.", "")
                    .replaceAll("\\", "")
                        .replaceAll("\\-", "");
        }
        
        return cnpj;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object valor) {
        
        String cnpj = valor.toString();
        
        System.out.println(cnpj);
        
        if(cnpj != null && cnpj.length() == 14) {
            cnpj = cnpj.substring(0,2) + 
                    "." + cnpj.substring(2, 5) + 
                        "." + cnpj.substring(5,8) + 
                            "/" + cnpj.substring(8, 12) + "-";
        } else {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("mensagemErro", new FacesMessage("Digite o cnpj corretamente!"));
        }
         
        return cnpj;
    }
    
}
