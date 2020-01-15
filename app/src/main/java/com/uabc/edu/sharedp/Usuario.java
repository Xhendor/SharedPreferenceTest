package com.uabc.edu.sharedp;

public class Usuario {

    private String nombre;
    private String corre;
    private byte[] passwd;

    public Usuario(String nombre, String corre, byte[] passwd) {
        this.nombre = nombre;
        this.corre = corre;
        this.passwd = passwd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorre() {
        return corre;
    }

    public void setCorre(String corre) {
        this.corre = corre;
    }

    public byte[] getPasswd() {
        return passwd;
    }

    public void setPasswd(byte[] passwd) {
        this.passwd = passwd;
    }
}
