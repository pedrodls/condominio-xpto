# condominio-xpto

Segue o README formatado para seu projeto em Java, rodando no terminal e usando `RandomAccessFile` para armazenamento. Ele está estruturado para uso no GitHub.

---

# **Gestão de Condomínio XPTO**

## **Descrição do Projeto**
Este projeto é uma aplicação em Java desenvolvida para gerenciar a administração de um condomínio. A solução automatiza tarefas como registro de frações, cálculo de despesas, e controle das contribuições mensais, substituindo os métodos manuais por um sistema eficiente e confiável. Os dados são armazenados localmente usando `RandomAccessFile`, garantindo persistência de informações diretamente em arquivos.

---

## **Funcionalidades**
1. **Gestão de Frações:**
   - Cadastro de frações (apartamentos, garagens, lojas e arrecadações).
   - Atualização da porcentagem ocupada por frações com base na área total.
   - Cálculo das contribuições mensais para despesas gerais e elevadores.

2. **Gestão de Proprietários:**
   - Registro completo de informações dos proprietários, como nome, endereço e contatos.

3. **Controle de Despesas:**
   - Cadastro e atualização das despesas gerais e de elevadores.
   - Garantia de que receitas equilibram as despesas.

4. **Relatórios:**
   - Listagem de frações com seus respectivos dados.
   - Verificação da integridade das porcentagens das frações.

5. **Persistência:**
   - Uso de `RandomAccessFile` para leitura e gravação dos dados em arquivos.

---

## **Requisitos do Sistema**
- **Java**: Versão 11 ou superior.
- **Sistema Operacional**: Qualquer sistema com suporte ao Java Runtime Environment (JRE).

---

## **Estrutura do Projeto**

```
src/
├── dominio/
│   ├── Condominio.java       // Classe principal representando o condomínio.
│   ├── Fracao.java           // Classe base para frações (apartamentos, garagens, lojas,arrecadações).
│   ├── Apartamento.java      // Subclasse de Fracao.
│   ├── Loja.java             // Subclasse de Fracao.
│   ├── Garagem.java          // Subclasse de Fracao.
│   ├── Arrecadacao.java      // Subclasse de Fracao.
│   └── Proprietario.java     // Classe representando o proprietário.
├── persistencia/
│   ├── RandomAccessHandler.java // Classe para manipulação do RandomAccessFile.
├── aplicacao/
│   ├── Main.java             // Ponto de entrada do programa.
│   ├── MenuHandler.java      // Classe que lida com os menus e navegação.
│   └── Servicos.java         // Classe para cálculos e verificações de despesas e porcentagens.
└── utils/
    ├── Formatter.java        // Utilitário para formatação de texto e dados.
    └── Validator.java        // Utilitário para validação de entradas.
```

---

## **Como Rodar o Projeto**

### **1. Compilação**
Certifique-se de que o JDK está instalado e configurado corretamente. Navegue até o diretório `src` e compile o código-fonte usando:

```bash
javac aplicacao/Main.java
```

### **2. Execução**
Após a compilação, execute o programa a partir do terminal com:

```bash
java aplicacao.Main
```

### **3. Uso do Programa**
O programa apresentará um menu no terminal, permitindo interagir com as funcionalidades, como cadastrar frações, calcular despesas, e listar informações.

---

## **Persistência de Dados**
Os dados são armazenados utilizando a classe `RandomAccessFile`. Cada entidade (como frações e proprietários) é serializada em um formato fixo dentro de arquivos binários, permitindo leitura e escrita eficientes.

**Exemplo de Arquivos:**
- `fractions.dat`: Contém os dados de todas as frações cadastradas.
- `owners.dat`: Contém os dados dos proprietários.
- `expenses.dat`: Contém as despesas gerais do condomínio.

**Operações Implementadas:**
- **Gravação:** Armazena as informações em arquivos binários.
- **Leitura:** Recupera os dados para uso em tempo de execução.
- **Atualização:** Modifica os registros diretamente no arquivo.

---

## **Licença**
Este projeto está licenciado sob a **MIT License**. Consulte o arquivo [LICENSE](./LICENSE) para mais detalhes.

---
