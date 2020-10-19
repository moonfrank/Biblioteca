package Entities;

import java.util.Date;

public class Libro extends Entity
{
    private int _ISBN,
                _NumeroInventario,
                _IDGenero,
                _IDEditorial;
    private String  _Titulo,
                    _Autor;
    private Date    _FechaSalida;
    public enum Estado {Disponible,Prestado}

    public int getISBN() { return _ISBN; }
    public void setISBN(int _ISBN) { this._ISBN = _ISBN; }

    public int getNumeroInventario() { return _NumeroInventario; }
    public void setNumeroInventario(int _NumeroInventario) { this._NumeroInventario = _NumeroInventario; }

    public int getIDGenero() { return _IDGenero; }
    public void setIDGenero(int _IDGenero) { this._IDGenero = _IDGenero; }

    public int getIDEditorial() { return _IDEditorial; }
    public void setIDEditorial(int _IDEditorial) { this._IDEditorial = _IDEditorial; }

    public String getTitulo() { return _Titulo; }
    public void setTitulo(String _Titulo) { this._Titulo = _Titulo; }

    public String getAutor() { return _Autor; }
    public void setAutor(String _Autor) { this._Autor = _Autor; }

    public Date getFechaSalida() { return _FechaSalida; }
    public void setFechaSalida(Date _FechaSalida) { this._FechaSalida = _FechaSalida; }
}
