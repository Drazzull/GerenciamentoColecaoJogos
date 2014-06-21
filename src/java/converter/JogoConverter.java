package converter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.JogoDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Jogo;

/**
 *
 * @author Drazzull
 */
@FacesConverter(value = "jogoConverter")
public class JogoConverter implements Converter
{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value)
    {
        if (value != null && !value.equals(""))
        {
            JogoDao dao = new JogoDao();
            return dao.getJogoPorCodigo(Long.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value)
    {
        if (value instanceof Jogo)
        {
            Jogo jogo = (Jogo) value;
            return String.valueOf(jogo.getIdJogo());
        }
        
        return "";
    }
}
