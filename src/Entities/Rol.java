package Entities;

public class Rol
{
    private int _ID;
    private String _Descripcion;

    public int getID() {
        return _ID;
    }
    public void setID(int _ID) {
        this._ID = _ID;
    }

    public String getDescripcion() {
        return _Descripcion;
    }
    public void setDescripcion(String _Descripcion) {
        this._Descripcion = _Descripcion;
    }
    @Override
    public String toString() {
        return "Rol [id=" + _ID + ", Descripcion=" + _Descripcion + "]";
    }
}
