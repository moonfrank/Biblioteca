package Data;

import Entities.*;
import java.sql.*;
import java.util.LinkedList;

public class UsuarioAdapter
{
    public LinkedList<Usuario> getAll()
    {
        LinkedList<Usuario> usuarios = new LinkedList<>();
        RolAdapter ra = new RolAdapter();
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = DbConnector.getInstancia().getConn().createStatement();
            rs = stmt.executeQuery("select * from usuarios");
            while (rs.next())
            {
                Usuario usr = new Usuario();
                usr.setID(rs.getInt("id"));
                usr.setUsername(rs.getString("username"));
                usr.setPassword(rs.getString("password"));
                usr.setNombre(rs.getString("nombre"));
                usr.setApellido(rs.getString("apellido"));
                usr.setEmail(rs.getString("email"));
                usr.setEstado(rs.getBoolean("habilitado"));
                ra.setRoles(usr);
                usuarios.add(usr);
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
                if (stmt!=null) stmt.close();
                if (rs!=null) rs.close();
                DbConnector.getInstancia().releaseConn();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return usuarios;
    }

    public Usuario getOne(int id)
    {
        Usuario usr = new Usuario();
        RolAdapter ra = new RolAdapter();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            pstmt = DbConnector.getInstancia().getConn().
                                      prepareStatement("select * from usuarios where id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                usr.setID(rs.getInt("id"));
                usr.setUsername(rs.getString("username"));
                usr.setPassword(rs.getString("password"));
                usr.setNombre(rs.getString("nombre"));
                usr.setApellido(rs.getString("apellido"));
                usr.setEmail(rs.getString("email"));
                usr.setEstado(rs.getBoolean("habilitado"));
                ra.setRoles(usr);
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
                if (pstmt!=null) pstmt.close();
                if (rs!=null) rs.close();
                DbConnector.getInstancia().releaseConn();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return usr;
    }

    public Usuario getOne(String username, String password)
    {
        Usuario usr = new Usuario();
        RolAdapter ra = new RolAdapter();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            pstmt = DbConnector.getInstancia().getConn().
                                      prepareStatement("select * from usuarios where username=? and password=?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if(rs!=null && rs.next())
            {
                usr.setID(rs.getInt("id"));
                usr.setUsername(rs.getString("username"));
                usr.setPassword(rs.getString("password"));
                usr.setNombre(rs.getString("nombre"));
                usr.setApellido(rs.getString("apellido"));
                usr.setEmail(rs.getString("email"));
                usr.setEstado(rs.getBoolean("habilitado"));
                ra.setRoles(usr);
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
                if (pstmt!=null) pstmt.close();
                if (rs!=null) rs.close();
                DbConnector.getInstancia().releaseConn();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return usr;
    }

    public void add(Usuario usr, int r)
    {
        PreparedStatement stmt= null;
        ResultSet keyResultSet=null;
        try
        {
            stmt=DbConnector.getInstancia().getConn().
                    prepareStatement("insert into usuarios(username,password,nombre,apellido,email,estado) " +
                                         "values(?,?,?,?,?,?)",
                            PreparedStatement.RETURN_GENERATED_KEYS
                    );
            stmt.setString(1, usr.getUsername());
            stmt.setString(2, usr.getPassword());
            stmt.setString(3, usr.getNombre());
            stmt.setString(4, usr.getApellido());
            stmt.setString(5, usr.getEmail());
            stmt.setBoolean(6, usr.getEstado());
            stmt.executeUpdate();
            
            if(stmt!=null)stmt.close();

            keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next())
            {
                usr.setID(keyResultSet.getInt(1));
            }
            stmt=DbConnector.getInstancia().getConn().
            		prepareStatement("insert into roles_usuarios(id_persona,id_rol) values(?,?)");
            stmt.setInt(1,usr.getID());
            stmt.setInt(2,r);
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

    public void edit(Usuario usr, int r)
    {
        PreparedStatement stmt= null;
        try
        {
            stmt=DbConnector.getInstancia().getConn().
                 prepareStatement("update usuarios set username=?, password=?, nombre=?, apellido=?, email=?, " +
                                      "habilitado=? where id=?");
            stmt.setString(1, usr.getUsername());
            stmt.setString(2, usr.getPassword());
            stmt.setString(3, usr.getNombre());
            stmt.setString(4, usr.getApellido());
            stmt.setString(5, usr.getEmail());
            stmt.setBoolean(6, usr.getEstado());
            stmt.setInt(7, usr.getID());
            stmt.executeUpdate();
            
            if(stmt!=null)stmt.close();

            stmt=DbConnector.getInstancia().getConn().
                    prepareStatement("update roles_usuarios set id_rol=? where id_usuario=?");
            stmt.setInt(1,r);
            stmt.setInt(2, usr.getID());
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
                if(stmt!=null) stmt.close();
                DbConnector.getInstancia().releaseConn();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void delete(Usuario usr)
    {
        PreparedStatement stmt= null;
        try
        {
            stmt=DbConnector.getInstancia().getConn().
                    prepareStatement(
                            "delete from roles_usuarios where id_usuario=?");
            stmt.setInt(1, usr.getID());
            stmt.executeUpdate();
            
            if(stmt!=null)stmt.close();
            
            stmt=DbConnector.getInstancia().getConn().
                    prepareStatement(
                            "delete from usuarios where id=?");
            stmt.setInt(1, usr.getID());
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
