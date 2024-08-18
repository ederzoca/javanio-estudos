package JavaNIO;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaNIO4 {

    public static void main(String[] args) {

        try {
            // Primeiro utilizar o Path para localizaro o arquivo
            Path path = Paths.get("c:\\rocket\\aula-java.txt");
            List<String> nomes = new ArrayList<>();
            nomes.add("Eder");
            nomes.add("Mariana");

            StringBuilder conteudo = new StringBuilder();
            nomes.forEach(n-> conteudo.append(n + "\n")); // "appendar" é adicionar cada elemento na sua estrutura

            Files.write(path, conteudo.toString().getBytes(StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
