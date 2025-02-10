package utils;

import java.util.regex.Pattern;

public class Constantes {

        private static final Pattern DATA_PATTERN = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        public static final String CONDOMINIO_FILE = "condominio.dat";

        // Menu se não tiver condominio criado!
        public static final String[] NOVO_CONDOMINIO_MENU = new String[] {
                        "Criar condominio",
                        "Sair",

        };

        // Menu se tiver condominio criado!
        public static final String[] CONDOMINIO_MENU = new String[] {
                        "Fracões",
                                // "Inserir fracção",
                                // "Retirar fracção",
                                //"Listar fracções" (ESTA COMO OPCAO ZERO NO MENU GERAL, DEPOIS DA OPCAO )
                        "Proprietários",
                        "Atualizar condominio",
                        "Visualisar condominio",
                        "Visualisar os valores das despesas",
                        "Actualizar os valores das despesas",
                        "Calcular  a soma das quotas mensais",
                        "Verificar a soma das percentagens das fracções",
                        "Excluir condomínio",
                        "Sair",

        };

        public static final String[] DESPESA_MENU = new String[] {
                        "Despesa Geral",
                        "Despesa com o elevador",
                        "Ambas",
                        "Sair"
        };
}
