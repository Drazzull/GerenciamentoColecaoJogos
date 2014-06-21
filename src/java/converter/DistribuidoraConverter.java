package converter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.DistribuidoraDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Distribuidora;

/**
 *
 * @author Drazzull
 */
@FacesConverter(value = "distribuidoraConverter")
public class DistribuidoraConverter implements Converter
{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value)
    {
        if (value != null && !value.equals(""))
        {
            DistribuidoraDao dao = new DistribuidoraDao();
            return dao.getDistribuidoraPorCodigo(Long.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value)
    {
        if (value instanceof Distribuidora)
        {
            Distribuidora distribuidora = (Distribuidora) value;
            return String.valueOf(distribuidora.getIdDistribuidora());
        }
        return "";
    }

}
