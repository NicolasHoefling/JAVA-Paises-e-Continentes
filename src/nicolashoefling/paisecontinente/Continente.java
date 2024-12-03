package nicolashoefling.paisecontinente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Continente {
    private String nome;
    private List<Pais> paises = new ArrayList<>();

    public Continente(String nome) {
        this.nome = nome;
    }

    public void adicionarPais(Pais pais) {
        if (!paises.contains(pais)) {
            paises.add(pais);
        }
    }

    public double calcularDimensaoTotal() {
        return paises.stream().mapToDouble(Pais::getKm2).sum();
    }

    public int calcularPopulacaoTotal() {
        return paises.stream().mapToInt(Pais::getPopulacao).sum();
    }

    public double calcularDensidadePopulacional() {
        double dimensao = calcularDimensaoTotal();
        return dimensao > 0 ? calcularPopulacaoTotal() / dimensao : 0;
    }

    public Pais paisMaiorPopulacao() {
        return paises.stream().max(Comparator.comparingInt(Pais::getPopulacao)).orElse(null);
    }

    public Pais paisMenorPopulacao() {
        return paises.stream().min(Comparator.comparingInt(Pais::getPopulacao)).orElse(null);
    }

    public Pais paisMaiorDimensao() {
        return paises.stream().max(Comparator.comparingDouble(Pais::getKm2)).orElse(null);
    }

    public Pais paisMenorDimensao() {
        return paises.stream().min(Comparator.comparingDouble(Pais::getKm2)).orElse(null);
    }

    public double calcularRazaoTerritorial() {
        Pais maior = paisMaiorDimensao();
        Pais menor = paisMenorDimensao();
        return menor != null && maior != null ? maior.getKm2() / menor.getKm2() : 0;
    }
}


