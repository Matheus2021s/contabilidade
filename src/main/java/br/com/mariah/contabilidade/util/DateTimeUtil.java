package br.com.mariah.contabilidade.util;

import br.com.mariah.contabilidade.exceptions.UnparsableValueException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static final String DATA_HORA_PATTERN = "dd/MM/yyyy-HH:mm";

    public static LocalDateTime toLocalDateTime(String dataHorario) {
        if (dataHorario == null || "".equals(dataHorario)) {
            return null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATA_HORA_PATTERN);
            return LocalDateTime.parse(dataHorario, formatter);
        } catch (Exception e) {
            throw new UnparsableValueException("Não foi possivel parsear o valor %s".formatted(dataHorario));
        }
    }
}
