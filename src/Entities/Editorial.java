package Entities;

public class Editorial extends Entity
{
    private String  _RazonSocial,
                    _Direccion,
                    _Telefono,
                    _Email;

    public String getRazonSocial() {return _RazonSocial;}
    public void setRazonSocial(String _RazonSocial) {this._RazonSocial = _RazonSocial;}

    public String getDireccion() {return _Direccion;}
    public void setDireccion(String _Direccion) {this._Direccion = _Direccion;}

    public String getTelefono() {return _Telefono;}
    public void setTelefono(String _Telefono) {this._Telefono = _Telefono;}

    public String getEmail() {return _Email;}
    public void setEmail(String _Email) {this._Email = _Email;}
}
