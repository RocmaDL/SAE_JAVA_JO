package main.java.com.cdal.model;

public class Utilisateur {

    private String nom;
    private String email;
    private String mdp;
    private String role;

    public Utilisateur(String nom, String email, String mdp, String role) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
    }

    public String getNom() {
        return this.nom;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMdp() {
        return this.mdp;
    }

    public String getRole() {
        return this.role;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString() {
        return "Utilisateur [nom=" + this.nom + ", email=" + this.email + ", mdp=" + this.mdp + ", role=" + this.role
                + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Utilisateur other = (Utilisateur) obj;
        if (this.email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!this.email.equals(other.email)) {
            return false;
        }
        if (this.mdp == null) {
            if (other.mdp != null) {
                return false;
            }
        } else if (!this.mdp.equals(other.mdp)) {
            return false;
        }
        if (this.nom == null) {
            if (other.nom != null) {
                return false;
            }
        } else if (!this.nom.equals(other.nom)) {
            return false;
        }
        if (this.role == null) {
            if (other.role != null) {
                return false;
            }
        } else if (!this.role.equals(other.role)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
        result = prime * result + ((this.mdp == null) ? 0 : this.mdp.hashCode());
        result = prime * result + ((this.nom == null) ? 0 : this.nom.hashCode());
        result = prime * result + ((this.role == null) ? 0 : this.role.hashCode());
        return result;
    }
}