package app;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "cpfConverter")
public class CpfConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String valor) {
        String cpf = null;
        
        if (valor != null && !valor.equals("")) {
            cpf = valor.replaceAll("\\.", "").replaceAll("\\-", "");
        }
        
        return cpf;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object valor) 
            throws ConverterException {
        
        String cpf = valor.toString();
        
        if(cpf != null && cpf.length() == 11) {
           cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
        } else {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("mensagemErro", new FacesMessage("Digite o cpf corretamente!"));
        }
        
        return cpf;
    }
    
}
