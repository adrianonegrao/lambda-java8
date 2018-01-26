package br.com.estudojava.date;

import org.junit.Test;

import java.time.*;

public class BasicoDeDatas {

    @Test
    public void horaEmNanoSegundos_maisPreciso() throws Exception {
        Instant agora = Instant.now();
        System.out.println(agora);
    }

    @Test
    public void medirQuantidadeTempo() throws Exception {
        Instant inicio = Instant.now();
        Thread.sleep(2000);
        Instant fim = Instant.now();

        Duration duration = Duration.between(inicio, fim);
        long duracaoEmMilisegundos = duration.toMillis();
        System.out.println(duracaoEmMilisegundos);
    }

    @Test
    public void dataParaHumanos_semImportarComHoras() throws Exception {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
    }

    @Test
    public void dataEspecifica() throws Exception {
        LocalDate dataEspecifica = LocalDate.of(2018, 8, 23);
        System.out.println(dataEspecifica);
    }

    @Test
    public void duracaoEntreDuasDatas_comPeriod() throws Exception {
        LocalDate data1 = LocalDate.of(2018, Month.JANUARY, 1);
        LocalDate data2 = LocalDate.of(2018, Month.AUGUST, 23);

        Period periodo = Period.between(data1, data2);
        System.out.printf("%s dias, %s meses, %s anos", periodo.getDays(), periodo.getMonths(), periodo.getYears());
    }

    @Test
    public void localTime_especificaSomenteHorario() throws Exception {
        LocalTime horarioEntrada = LocalTime.of(9, 0);
        System.out.println(horarioEntrada);
    }

    @Test
    public void localDateTime() throws Exception {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }

    @Test
    public void fusoHorario_comZonedDateTime() throws Exception {
        ZoneId fusoHorarioSaoPaulo = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime agoraEmSaoPaulo = ZonedDateTime.now(fusoHorarioSaoPaulo);
        System.out.println(agoraEmSaoPaulo);
    }

    @Test
    public void fusoHorario_datVoo() throws Exception {
        ZoneId fusoHorarioDeSaoPaulo = ZoneId.of("America/Sao_Paulo");
        ZoneId fusoHorarioDeNovaYork = ZoneId.of("America/New_York");

        LocalDateTime saidaDeSaoPauloSemFusoHorario =
                LocalDateTime.of(2014, Month.APRIL, 4, 22, 30);
        LocalDateTime chegadaEmNovaYorkSemFusoHorario =
                LocalDateTime.of(2014, Month.APRIL, 5, 7, 10);

        ZonedDateTime saidaDeSaoPauloComFusoHorario =
                ZonedDateTime.of(saidaDeSaoPauloSemFusoHorario, fusoHorarioDeSaoPaulo);
        System.out.println(saidaDeSaoPauloComFusoHorario); //2014-04-04T22:30-03:00[America/Sao_Paulo]

        ZonedDateTime chegadaEmNovaYorkComFusoHorario =
                ZonedDateTime.of(chegadaEmNovaYorkSemFusoHorario, fusoHorarioDeNovaYork);
        System.out.println(chegadaEmNovaYorkComFusoHorario); //2014-04-05T07:10-04:00[America/New_York]

        Duration duracaoDoVoo =
                Duration.between(saidaDeSaoPauloComFusoHorario, chegadaEmNovaYorkComFusoHorario);
        System.out.println(duracaoDoVoo); //PT9H40M
    }
}
