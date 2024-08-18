package JavaNIO;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaNIO3 {

    public static void main(String[] args) {

        try {
            // Primeiro utilizar o Path para localizaro o arquivo
            Path path = Paths.get("c:\\rocket\\aula-java.txt");
            String conteudo = "EDER SILVEIRA";
            Files.write(path, conteudo.getBytes(StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
