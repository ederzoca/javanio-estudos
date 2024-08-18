package Layout;

import java.time.LocalDate;

public class Cadastro {

    private String nome;
    private String sexo;
    private Long telefone;
    private LocalDate dataNascimento;
    private Double valorSugerido;
    private boolean cliente;

    public Cadastro(String nome, String sexo, Long telefone, LocalDate dataNascimento, Double valorSugerido, boolean cliente) {
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.valorSugerido = valorSugerido;
        this.cliente = cliente;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public Long getTelefone() {
        return telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Double getValorSugerido() {
        return valorSugerido;
    }

    public boolean isCliente() {
        return cliente;
    }
}
