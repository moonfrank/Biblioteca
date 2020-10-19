package Logic;

import Entities.*;
import Data.*;

import java.util.LinkedList;

public class UsuarioLogic
{
    protected static UsuarioAdapter adapter;
    
    public UsuarioAdapter getAdapter()
    {
    	if (adapter==null) adapter = new UsuarioAdapter();
    	return adapter;
    }

    public Usuario getOne(int ID)
    {
        return this.getAdapter().getOne(ID);
    }

    public Usuario getOne(String nomUsu, String pass)
    {
        return this.getAdapter().getOne(nomUsu, pass);
    }

    public LinkedList<Usuario> getAll()
    {
        return this.getAdapter().getAll();
    }

    public void Save(Usuario u, Rol r)
    {
    	this.getAdapter().add(u, r.getID());
    }

    public void Delete(int ID)
    {
        Usuario u = this.getAdapter().getOne(ID);
        this.getAdapter().delete(u);
    }
}
