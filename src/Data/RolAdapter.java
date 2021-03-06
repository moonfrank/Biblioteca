package Data;

import Entities.*;
import java.sql.*;
import java.util.LinkedList;

public class RolAdapter
{
    public LinkedList<Rol> getAll()
    {
        Statement stmt=null;
        ResultSet rs=null;
        LinkedList<Rol> roles= new LinkedList<>();
        try
        {
            stmt= DbConnector.getInstancia().getConn().createStatement();
            rs= stmt.executeQuery("select * from roles");
            if(rs!=null)
            {
                while(rs.next())
                {
                    Rol r=new Rol();
                    r.setID(rs.getInt("id"));
                    r.setDescripcion(rs.getString("descripcion"));
                    roles.add(r);
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(rs!=null) {rs.close();}
                if(stmt!=null) {stmt.close();}
                DbConnector.getInstancia().releaseConn();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return roles;
    }

    public Rol getOne(int rolToSearch)
    {
        Rol r=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try
        {
            stmt=DbConnector.getInstancia().getConn().prepareStatement("select * from roles where id=?");
            stmt.setInt(1, rolToSearch);
            rs=stmt.executeQuery();
            if(rs!=null && rs.next())
            {
                r=new Rol();
                r.setID(rs.getInt("id"));
                r.setDescripcion(rs.getString("descripcion"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(rs!=null) {rs.close();}
                if(stmt!=null) {stmt.close();}
                DbConnector.getInstancia().releaseConn();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return r;
    }

    public void setRoles(Usuario usr)
    {
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try
        {
            stmt=DbConnector.getInstancia().getConn().
                    prepareStatement("select roles.* from roles inner join roles_usuarios " +
                                         "on roles.id=roles_usuarios.id_rol where id_usuario=?");
            stmt.setInt(1, usr.getID());
            rs= stmt.executeQuery();
            if(rs!=null)
            {
                while(rs.next())
                {
                    Rol r = new Rol();
                    r.setID(rs.getInt("id"));
                    r.setDescripcion(rs.getString("descripcion"));
                    usr.setRol(r);
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(rs!=null) {rs.close();}
                if(stmt!=null) {stmt.close();}
                DbConnector.getInstancia().releaseConn();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void add(Rol rol)
    {
        PreparedStatement stmt= null;
        ResultSet keyResultSet=null;
        try
        {
            stmt=DbConnector.getInstancia().getConn().
                 prepareStatement("insert into roles(descripcion) values(?)",
                                      PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, rol.getDescripcion());
            stmt.executeUpdate();
            keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()) rol.setID(keyResultSet.getInt(1));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void update(Rol rol)
    {
        PreparedStatement stmt= null;
        try
        {
            stmt=DbConnector.getInstancia().getConn().
                 prepareStatement("update roles set descripcion=? where id=?");
            stmt.setString(1, rol.getDescripcion());
            stmt.setInt(2, rol.getID());
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void delete(Rol rol)
    {
        PreparedStatement stmt= null;
        try
        {
            stmt=DbConnector.getInstancia().getConn().prepareStatement("delete from roles where id=?");
            stmt.setInt(1, rol.getID());
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
