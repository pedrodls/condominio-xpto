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
                                // "Inserir fracção",
                                // "Retirar fracção",
                                //"Listar fracções" (ESTA COMO OPCAO ZERO NO MENU GERAL, DEPOIS DA OPCAO 8)
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

        public static final String[] despesaMenu = new String[] {
                        "Despesa Geral",
                        "Despesa com o elevador",
                        "Ambas",
                        "Sair"
        };
}
