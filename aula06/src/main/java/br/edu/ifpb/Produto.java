package br.edu.ifpb;

public class Produto {
    private int id; 
    private String nomeProduto;
    private String tamanho;
    private String marca;
    public Produto(){}
    public Produto(int id, String nomeProduto, String tamanho, String marca){
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.tamanho = tamanho;
        this.marca = marca;
    }
    public int getId(){
        return this.id;
    }

    public String getNomeProduto(){
        return this.nomeProduto;
    }

    public String getTamanho(){
        return this.tamanho;
    }

    public String getMarca(){
        return this.marca;
    }

    public void setID(int id){
        this.id = id;
    }

    public void setNomeUsuario(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }
    public void setTamanho(String tamanho){
        this.tamanho = tamanho;
    }
    public void setmarca(String marca){
        this.marca = marca;
    }
}
