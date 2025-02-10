package utils;

import java.util.Scanner;

public class PauseToRead {

    public static void pause() {
        System.out.println("\n Pressione Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Aguarda entrada do usuário
    }
}
