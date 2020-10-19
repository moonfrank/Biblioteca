package Entities;

public class Genero extends Entity
{
    private int _Codigo;
    private String _Descripcion;

    public int getCodigo() { return _Codigo; }
    public void setCodigo(int _Codigo) { this._Codigo = _Codigo; }

    public String getDescripcion() { return _Descripcion; }
    public void setDescripcion(String _Descripcion) { this._Descripcion = _Descripcion; }
}
