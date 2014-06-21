package converter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.CategoriaDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Categoria;

/**
 *
 * @author Drazzull
 */
@FacesConverter(value = "categoriaConverter")
public class CategoriaConverter implements Converter
{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value)
    {
        if (value != null && !value.equals(""))
        {
            CategoriaDao dao = new CategoriaDao();
            return dao.getCategoriaPorCodigo(Long.parseLong(value));
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value)
    {
        if (value instanceof Categoria)
        {
            Categoria categoria = (Categoria) value;
            return String.valueOf(categoria.getIdCategoria());
        }

        return "";
    }
}
