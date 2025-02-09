package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UtilDate {

    // Método para converter string para LocalDate com um formato personalizado
    public static LocalDate stringToLocalDate(String dateString) throws RuntimeException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Erro ao parsear a data: " + e.getMessage());

        }
    }

    public static LocalDate LocalDateToString(String dateString) throws RuntimeException {
        try {
            return LocalDate.parse(dateString);
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Erro ao parsear a data: " + e.getMessage());

        }
    }

}
