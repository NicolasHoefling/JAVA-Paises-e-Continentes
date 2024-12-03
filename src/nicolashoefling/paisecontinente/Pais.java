package nicolashoefling.paisecontinente;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String iso;
    private String nome;
    private int populacao;
    private double km2;
    private List<Pais> vizinhos = new ArrayList<>();

    public Pais(String iso, String nome, int populacao, double km2) {
        this.iso = iso;
        this.nome = nome;
        this.populacao = populacao;
        this.km2 = km2;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public double getKm2() {
        return km2;
    }

    public void setKm2(double km2) {
        this.km2 = km2;
    }

    public void adicionarVizinho(Pais pais) {
        if (!vizinhos.contains(pais) && !pais.equals(this)) {
            vizinhos.add(pais);
            pais.getVizinhos().add(this); // Adiciona reciprocamente
        }
    }

    public List<Pais> getVizinhos() {
        return vizinhos;
    }

    public double calcularDensidadePopulacional() {
        return populacao / km2;
    }

    public boolean isIgual(Pais outro) {
        return this.iso.equalsIgnoreCase(outro.getIso());
    }

    public List<Pais> vizinhosComuns(Pais outro) {
        List<Pais> comuns = new ArrayList<>(this.vizinhos);
        comuns.retainAll(outro.getVizinhos());
        return comuns;
    }

    @Override
    public String toString() {
        return nome + " (" + iso + ")";
    }
}

