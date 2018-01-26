package br.com.estudojava.date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class FormatacaoDatas {

    @Test
    public void formatadorDatas() throws Exception {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println( localDate.format(formatador) );
    }

    @Test
    public void aumentarUmDia() throws Exception {
        LocalDate hoje = LocalDate.now();
        LocalDate amanha = hoje.plusDays(1);
        System.out.println(amanha);
    }

    @Test
    public void descobrirNumeroDeDiasAteUmaData_comUntil() throws Exception {
        MonthDay natal = MonthDay.of(Month.DECEMBER, 25);
        LocalDate natalDesseAno = natal.atYear(Year.now().getValue());

        long diasAteONatal = LocalDate.now().until(natalDesseAno, ChronoUnit.DAYS);
        System.out.println(diasAteONatal);
    }

    @Test
    public void diferenteManeiraManipularMedidaDeTempo() throws Exception {
        TemporalAdjuster ajustadorParaProximaSexta = TemporalAdjusters.next(DayOfWeek.FRIDAY);
        LocalDate proximaSexta = LocalDate.now().with(ajustadorParaProximaSexta);
        System.out.println(proximaSexta);
    }
}
