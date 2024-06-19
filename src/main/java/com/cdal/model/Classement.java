package main.java.com.cdal.model;


public class Classement extends Pays {
    private Integer position;
    private String nom;
    private Integer or;
    private Integer argent;
    private Integer bronze;
    private Integer total;


    public Classement(Integer pos, String nom, Integer or, Integer argent, Integer bronze, Integer total) {
        super(nom);
        this.position = pos;
        this.nom = nom;
        this.or = or;
        this.argent = argent;
        this.bronze = bronze;
        this.total = total;
    }


    public Integer getPosition() {
        return position;
    }


    public void setPosition(Integer position) {
        this.position = position;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public Integer getOr() {
        return or;
    }


    public void setOr(Integer or) {
        this.or = or;
    }


    public Integer getArgent() {
        return argent;
    }


    public void setArgent(Integer argent) {
        this.argent = argent;
    }


    public Integer getBronze() {
        return bronze;
    }


    public void setBronze(Integer bronze) {
        this.bronze = bronze;
    }


    public Integer getTotal() {
        return total;
    }


    public void setTotal(Integer total) {
        this.total = total;
    }



    
}