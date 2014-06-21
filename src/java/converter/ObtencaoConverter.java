package converter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.ObtencaoDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Obtencao;

/**
 *
 * @author Drazzull
 */
@FacesConverter(value = "obtencaoConverter")
public class ObtencaoConverter implements Converter
{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value)
    {
        if (value != null && !value.equals(""))
        {
            ObtencaoDao dao = new ObtencaoDao();
            return dao.getObtencaoPorCodigo(Long.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value)
    {
        if (value instanceof Obtencao)
        {
            Obtencao obtencao = (Obtencao) value;
            return String.valueOf(obtencao.getIdObtencao());
        }
        
        return "";
    }
}
