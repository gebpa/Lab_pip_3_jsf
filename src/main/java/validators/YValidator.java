package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validators.YValidator")
public class YValidator implements Validator {
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        FacesMessage msg;
        double yValue;
        try {
            String value = o.toString ();
            yValue = Double.parseDouble (value);
        } catch(ValidatorException e){
            msg=new FacesMessage("y должен быть числом");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        if (yValue<-3 || yValue>3){
            msg=new FacesMessage("y должен быть от -3 до 3");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
