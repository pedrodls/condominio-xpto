package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.regex.Pattern;

public class UtilDate {

    public static boolean validarData(String dataString) {
        String regex = "^([0-2][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(dataString).matches();
    }

    // Método para converter string para LocalDate com um formato personalizado
    public static Date stringToDate(String dateString) throws RuntimeException, ParseException {
        try {

            SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");

            Date parsedDate = dataFormat.parse(dateString);

            if (parsedDate.after(new Date()))
                throw new RuntimeException("A data não pode ser maior que a data de hoje.");

            return parsedDate;
        } catch (DateTimeParseException e) {
            throw new RuntimeException(e.getMessage());

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
