package Entities;

public class Usuario extends Entity
{
    public enum TipoUsuario {Admin,Bibliotecario,Socio}
    
    private int 	_DNI;
	private String  _Nombre,
                    _Apellido,
                    _Username,
                    _Password,
                    _Email;
    private boolean _Habilitado;
    private Rol _Rol;
    
    public int get_DNI() {return _DNI;}
	public void set_DNI(int _DNI) {this._DNI = _DNI;}

    public String getNombre() {return _Nombre;}
    public void setNombre(String _Nombre) {this._Nombre = _Nombre;}

    public String getApellido() {return _Apellido;}
    public void setApellido(String _Apellido) {this._Apellido = _Apellido;}

    public String getUsername() {return _Username;}
    public void setUsername(String _Username) {this._Username = _Username;}

    public String getPassword() {return _Password;}
    public void setPassword(String _Password) {this._Password = _Password;}

    public String getEmail() {return _Email;}
    public void setEmail(String _Email) {this._Email = _Email;}

    public boolean getEstado() {return _Habilitado;}
    public void setEstado(boolean _Estado) {this._Habilitado = _Estado;}

    public Rol getRol() {return _Rol;}
    public void setRol(Rol _Rol) {this._Rol = _Rol;}
}
