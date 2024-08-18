package JavaNIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaNIO {

    public static void main(String[] args) {

        try {
            // Primeiro utilizar o Path para localizaro o arquivo
            Path path = Paths.get("c:\\rocket\\aula-java.txt");

            // Lendo o path e convertendo todos os caracteres (bytes) de uma só vez
            byte[] bytesArquivo = Files.readAllBytes(path);

            // Como são bytes podemos criar uma String a partir de agora
            String conteudo = new String(bytesArquivo);
            System.out.println(conteudo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
