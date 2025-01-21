package helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class HelperDate {

    // Método para converter string para LocalDate com um formato personalizado
    public static LocalDate stringToLocalDate(String dateString) throws Error {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            throw new Error("Erro ao parsear a data: " + e.getMessage());

        }
    }

}
