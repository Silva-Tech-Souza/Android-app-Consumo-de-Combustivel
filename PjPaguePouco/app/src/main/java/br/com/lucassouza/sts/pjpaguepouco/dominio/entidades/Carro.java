package br.com.lucassouza.sts.pjpaguepouco.dominio.entidades;

import java.io.Serializable;

public class Carro implements Serializable {

     int CODIGO;
     String CITYGASOLINA;
     String CITYETANOL;



    public int getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(int CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getCITYGASOLINA() {
        return CITYGASOLINA;
    }

    public void setCITYGASOLINA(String CITYGASOLINA) {
        this.CITYGASOLINA = CITYGASOLINA;
    }

    public String getCITYETANOL() {
        return CITYETANOL;
    }

    public void setCITYETANOL(String CITYETANOL) {
        this.CITYETANOL = CITYETANOL;
    }
}
