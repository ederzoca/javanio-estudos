package JavaNIO;

import java.io.File;
import java.io.IOException;

public class JavaFileIO {

    public static void main(String[] args) {

        File diretorio = new File("c:\\rocket\\curso-java");
        System.out.println("O diretório existe? " + diretorio.exists());

        if (!diretorio.exists()) {
            diretorio.mkdir(); // Criando o diretório caso ele não exista
            System.out.println("Diretório criado");
        }


        try {
            File arquivo = new File(diretorio,"aula-java.txt");
            arquivo.exists();
            arquivo.createNewFile();
            arquivo.exists();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
