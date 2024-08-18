package JavaNIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JavaNIO2 {

    public static void main(String[] args) {

        try {
            // Primeiro utilizar o Path para localizaro o arquivo
            Path path = Paths.get("c:\\rocket\\aula-java.txt");

            // Lendo o path e convertendo todos os caracteres (bytes) de uma só vez
            byte[] bytesArquivo = Files.readAllBytes(path);

            // Como são bytes podemos criar uma String a partir de agora
            List<String> linhas = Files.readAllLines(path);
            linhas.forEach(l-> System.out.println(l));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
