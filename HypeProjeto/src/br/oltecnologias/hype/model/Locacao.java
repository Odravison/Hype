package br.oltecnologias.hype.model;

import java.util.List;
import java.util.Calendar;

public class Locacao {

    private int id;
    private Cliente cliente;
    private List<ProdutoDeLocacao> produtos;
    private float valor;
    private Calendar dataLocacao;
    private Calendar dataDevolucao;
    private Contrato contrato;

    public Contrato formularContrato() {
            return null; // AQUI É ONDE VAI SER GERADO O PDF E ONDE VAI SER ADICIONADO AO MESMO AS INFORMAÇÕES.
    }

    public void exportarContrato() {

    }

    public void imprimirContrato() {

    }

}
