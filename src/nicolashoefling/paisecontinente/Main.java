package nicolashoefling.paisecontinente;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#,###");// formatar a saida

        Pais brasil = new Pais("BRA", "Brasil", 209469323, 8515767);
        Pais argentina = new Pais("ARG", "Argentina", 44361150, 2780400);
        Pais paraguai = new Pais("PAR", "Paraguai", 6703799, 406752);
        Pais uruguai = new Pais("URU", "Uruguai",3426260, 176215);
        Pais chile = new Pais("CHI", "Chile",18729160, 756950);
        Pais colombia = new Pais("COL", "Colombia",51516562, 1141748);
        Pais equador = new Pais("EQU", "Equador",17797737, 283969);
        Pais peru = new Pais("PER", "Peru", 33715471, 1285216);//

        Continente americaDoSul = new Continente("América do Sul");
        americaDoSul.adicionarPais(brasil);
        americaDoSul.adicionarPais(argentina);
        americaDoSul.adicionarPais(paraguai);
        americaDoSul.adicionarPais(uruguai);
        americaDoSul.adicionarPais(chile);
        americaDoSul.adicionarPais(colombia);
        americaDoSul.adicionarPais(equador);
        americaDoSul.adicionarPais(peru);

        brasil.adicionarVizinho(argentina);
        brasil.adicionarVizinho(paraguai);
        brasil.adicionarVizinho(uruguai);
        brasil.adicionarVizinho(colombia);
        brasil.adicionarVizinho(peru);

        argentina.adicionarVizinho(paraguai);
        argentina.adicionarVizinho(uruguai);
        argentina.adicionarVizinho(chile);

        peru.adicionarVizinho(equador);
        peru.adicionarVizinho(colombia);

        chile.adicionarVizinho(peru);

        equador.adicionarVizinho(colombia);


        System.out.println("\n----- VIZINHOS -----");
        System.out.println("lista de vizinhos comuns aos dois países: ");
        for (Pais vizinho : brasil.vizinhosComuns(chile)) {
            System.out.println(vizinho);
        }//pais com parametro para saber os vizinhos
        System.out.println("\n----- CONTINENTE -----");
        System.out.println("Dimensão total do Continente: "+ df.format(americaDoSul.calcularDimensaoTotal())+ " km²");
        System.out.println("População total da Continente: "+ df.format(americaDoSul.calcularPopulacaoTotal())+ " habitantes");
        System.out.println("Densidade populacional do continente: " + df.format(americaDoSul.calcularDensidadePopulacional())+ " hab/km²");
        System.out.println("\n----- POPULAÇÂO -----");
        System.out.println("País de Maior população: " + americaDoSul.paisMaiorPopulacao()+ " com: " + df.format(americaDoSul.paisMaiorPopulacao().getPopulacao()) + " habitantes");
        System.out.println("País de Menor população: " + americaDoSul.paisMenorPopulacao()+ " com: " + df.format(americaDoSul.paisMenorPopulacao().getPopulacao()) + " habitantes");
        System.out.println("\n----- DIMENSÃO -----");
        System.out.println("País de Maior dimensão: " + americaDoSul.paisMaiorDimensao() + " com: " + df.format(americaDoSul.paisMaiorDimensao().getKm2()) + " KM²");
        System.out.println("País de Menor dimensão: " + americaDoSul.paisMenorDimensao() + " com: " + df.format(americaDoSul.paisMenorDimensao().getKm2()) + " KM²");
        System.out.println("\nRazão territorial maior/menor: " + df.format(americaDoSul.calcularRazaoTerritorial()));
    }
}

