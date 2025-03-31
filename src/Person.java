class Person {
    String prenume;
    String nume;
    int varsta;

    public Person(String prenume, String nume, int varsta) {
        this.prenume = prenume;
        this.nume = nume;
        this.varsta = varsta;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    @Override
    public String toString() {
        return prenume + " " + nume + " " + varsta;
    }
}