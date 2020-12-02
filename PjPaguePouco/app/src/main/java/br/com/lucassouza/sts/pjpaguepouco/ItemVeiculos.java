package br.com.lucassouza.sts.pjpaguepouco;

public class ItemVeiculos {

    private String titulo;
    private String modelo;
    private String citygasolina;
    private  String cityetanol;
    private  String estradagasolina;
    private String estradaEtanol;

    public ItemVeiculos(String titulo, String modelo, String citygasolina, String cityetanol, String estradagasolina, String estradaEtanol){
        this.titulo = titulo;
        this.modelo = modelo;
        this.citygasolina = citygasolina;
        this.cityetanol = cityetanol;
        this.estradagasolina = estradagasolina;
        this.estradaEtanol = estradaEtanol;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCitygasolina() {
        return citygasolina;
    }

    public void setCitygasolina(String citygasolina) {
        this.citygasolina = citygasolina;
    }

    public String getCityetanol() {
        return cityetanol;
    }

    public void setCityetanol(String cityetanol) {
        this.cityetanol = cityetanol;
    }

    public String getEstradagasolina() {
        return estradagasolina;
    }

    public void setEstradagasolina(String estradagasolina) {
        this.estradagasolina = estradagasolina;
    }

    public String getEstradaEtanol() {
        return estradaEtanol;
    }

    public void setEstradaEtanol(String estradaEtanol) {
        this.estradaEtanol = estradaEtanol;
    }


}
