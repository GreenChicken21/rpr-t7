package ba.unsa.etf.rpr.tutorijal7;

public class Drzava {
    private String naziv = "";
    private int brojStanovnika = 0;
    private double povrsina = 0;
    private String jedinica = "";
    private Grad glavniGrad = new Grad();

    public Drzava(){}

    public Drzava(String naziv, int stanovnika, double povrsina, String jedinica, Grad glavniGrad) {
        setNaziv(naziv);
        setBrojStanovnika(stanovnika);
        setPovrsina(povrsina);
        setJedinica(jedinica);
        setGlavniGrad(glavniGrad);
    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public double getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(double povrsina) {
        this.povrsina = povrsina;
    }

    public String getJedinica() {
        return jedinica;
    }

    public void setJedinica(String jedinica) {
        this.jedinica = jedinica;
    }

    public Grad getGlavniGrad() {
        return glavniGrad;
    }

    public void setGlavniGrad(Grad glavniGrad) {
        this.glavniGrad = glavniGrad;
    }
}
