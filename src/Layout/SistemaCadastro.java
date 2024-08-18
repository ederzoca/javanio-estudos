package Layout;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaCadastro {

    public static void main(String[] args) {

        List<Cadastro> cadastros = new ArrayList<>();
        cadastros.add(new Cadastro("Eder Silveira", "M", 48988704784L, LocalDate.of(2002, 6,21), 1000.0, false));
        cadastros.add(new Cadastro("Mari Michels", "F", 48999875415L, LocalDate.of(2003, 7,1), 2000.0, true));

        //escreverLayoutDelimitado(cadastros);
        escreverLayoutPosicional(cadastros);
    }

    public static void escreverLayoutDelimitado(List<Cadastro> cadastros) {

        System.out.println("***** - LAYOUT DELIMITADO - *****");

        try {
            StringBuilder conteudo = new StringBuilder();

            for (Cadastro cadastro : cadastros) {
                conteudo.append(cadastro.getNome() + ";");
                conteudo.append(cadastro.getSexo() + ";");
                conteudo.append(cadastro.getTelefone() + ";");
                conteudo.append(cadastro.getDataNascimento() + ";");
                conteudo.append(cadastro.getValorSugerido() + ";");
                conteudo.append(cadastro.isCliente());
                conteudo.append(System.lineSeparator());
            }
            System.out.println(conteudo.toString());

            Path arquivoDestino = Paths.get("C:\\rocket\\lista-contatos-modelo-delimitado.csv");

            Files.write(arquivoDestino, conteudo.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Cadastro> lerLayoutDelimitado() {

        List<Cadastro> cadastros = new ArrayList<>();

        try {
            Path arquivoOrigem = Paths.get("C:\\rocket\\lista-contatos-modelo-delimitado.csv");

            List<String> linhas = Files.readAllLines(arquivoOrigem);
            // imprimindo cada linha obtida no arquivo
            for (String linha : linhas) {
                String[] colunas = linha.split("\\;"); // quebra uma linha
                String nome = colunas[0];
                String sexo = colunas[1];
                Long telefone = Long.valueOf(colunas[2]);
                LocalDate dataAniversario = LocalDate.parse(colunas[3]);
                Double valorSugerido = Double.valueOf(colunas[4]);
                boolean cliente = Boolean.valueOf(colunas[5]);

                // Criando um novo cadastro e adicionando na lista de acordo
                cadastros.add(new Cadastro(nome, sexo, telefone, dataAniversario, valorSugerido, cliente));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ao retornar a lista de objetos, poderá ser realizado qualquer ação com a lista retornada

        return cadastros;
    }

    public static void escreverLayoutPosicional(List<Cadastro> cadastros) {

        try {
            System.out.println("***** - LAYOUT DELIMITADO - *****");

            StringBuilder conteudo = new StringBuilder();
            for (Cadastro cadastro : cadastros) {
                String nome = cadastro.getNome();
                // se o nome for maior que 30 caracteres, cortar
                if (nome.length() > 30) {
                    nome = nome.substring(0, 30);
                } else {
                    // se o nome for menor que 30 caracteres, complementar
                    nome = String.format("%-30s", nome);
                }

                conteudo.append(nome);
                conteudo.append(cadastro.getSexo().toUpperCase());
                conteudo.append(cadastro.getTelefone());
                conteudo.append(cadastro.getDataNascimento());

                // formatação para valores
                DecimalFormat decimalFormat = new DecimalFormat("#0000.00");

                String valorFormatado = decimalFormat.format(cadastro.getValorSugerido());
                conteudo.append(valorFormatado.replaceAll("\\;","\\."));
                // 1 para true e 0 para false
                conteudo.append(cadastro.isCliente() ? "1" : "0");

                // nova linha
                conteudo.append(System.lineSeparator());
            }

            System.out.println(conteudo.toString());

            Path arquivoDestino = Paths.get("C:\\rocket\\lista-contatos-modelo-posicional.txt");

            Files.write(arquivoDestino, conteudo.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
