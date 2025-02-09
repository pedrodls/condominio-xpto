package utils;

import java.util.regex.Pattern;

public class Constantes {

        private static final Pattern datePattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        public static final String condominioFIle = "condominio.dat";

        // Menu se não tiver condominio criado!
        public static final String[] novoCondominioMenu = new String[] {
                        "Criar condominio",
                        "Sair",

        };

        // Menu se tiver condominio criado!
        public static final String[] condominioMenu = new String[] {
                        "Fracões",
                        "Proprietários",
                        "Atualizar condominio",
                        "Visualisar condominio",
                        // "Inserir fracção",
                        // "Retirar fracção",
                        // "Listar fracções",
                        "Visualisar valores das despesas",
                        "Calcular  a soma das quotas mensais",
                        "Calcular  a soma das quotas mensais",
                        "Verificar a soma das percentagens das fracções",
                        "Sair",

        };

}
