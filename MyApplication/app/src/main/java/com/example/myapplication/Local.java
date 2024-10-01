package com.example.myapplication;

public class Local {
    private String nome;
    private int imagemTopo;
    private int imagemBaixa;
    private String descricao;
    private String site;
    private String telefone;
    private String endereco;

    public Local(String nome, int imagemTopo, int imagemBaixa, String descricao, String site, String telefone, String endereco) {
        this.nome = nome;
        this.imagemTopo = imagemTopo;
        this.imagemBaixa = imagemBaixa;
        this.descricao = descricao;
        this.site = site;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagemTopo() {
        return imagemTopo;
    }

    public int getImagemBaixa() {
        return imagemBaixa;
    }

    public void setImagemTopo(int imagem) {
        this.imagemTopo = imagem;
    }

    public void setImagemBaixa(int imagem) {
        this.imagemBaixa = imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}