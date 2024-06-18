package main.java.com.cdal.util;

public class Couple<T,Y> {
    private T premier;
    private Y second;

    public Couple(T premier, Y second) {
        this.premier = premier;
        this.second = second;
    }

    public T getPremier() {
        return premier;
    }

    public void setPremier(T premier) {
        this.premier = premier;
    }

    public Y getSecond() {
        return second;
    }

    public void setSecond(Y second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Couple{" +
                "premier=" + premier +
                ", second=" + second +
                '}';
    }
}
