package Logic;

import java.util.LinkedList;

import Data.RolAdapter;
import Entities.*;

public class RolLogic 
{
	protected static RolAdapter adapter;
    
    public RolAdapter getAdapter()
    {
    	if (adapter==null) adapter = new RolAdapter();
    	return adapter;
    }

    public Rol getOne(int ID)
    {
        return this.getAdapter().getOne(ID);
    }

    public LinkedList<Rol> getAll()
    {
        return this.getAdapter().getAll();
    }

    public void Save(Rol r)
    {
    	this.getAdapter().add(r);
    }

    public void Delete(Rol r)
    {
        // this.getAdapter().getOne(r);
        this.getAdapter().delete(r);
    }
}
