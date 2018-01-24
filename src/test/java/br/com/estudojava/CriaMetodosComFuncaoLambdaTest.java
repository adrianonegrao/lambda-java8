package br.com.estudojava;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class CriaMetodosComFuncaoLambdaTest {

    @Test
    public void personalizacao1() throws Exception {
        System.out.println("Cria a lista com os elementos que serão realizadas operações");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        System.out.println("Imprime todos os números:");
        avaliaExpressao(list, (n)->true);

        System.out.println("Não imprime nenhum número:");
        avaliaExpressao(list, (n)->false);

        System.out.println("Imprime apenas número pares:");
        avaliaExpressao(list, (n)-> n%2 == 0 );

        System.out.println("Imprime apenas números impares:");
        avaliaExpressao(list, (n)-> n%2 == 1 );

        System.out.println("Imprime apenas números maiores que 5:");
        avaliaExpressao(list, (n)-> n > 5 );

        System.out.println("Imprime apenas números maiores que 5 e menores que 10:");
        avaliaExpressao(list, (n)-> n > 5 && n < 10);
    }

    public static void avaliaExpressao(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(n -> {
            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        });
    }

    @Test
    public void personalizacao2() throws Exception {
        System.out.println("Cria a lista com os elementos que serão realizadas operações");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        System.out.println("Multiplica todos os elementos da lista por 5:");
        realizaOperacao(list, (n)-> n * 5);

        System.out.println("Calcula o quadrado de todos os elementos da lista:");
        realizaOperacao(list, (n)-> n * n);


        System.out.println("Soma 3 em todos os elementos da lista:");
        realizaOperacao(list, (n)-> n + 3);

        System.out.println("Coloca 0 em todos os elementos da lista:");
        realizaOperacao(list, (n)-> 0);

    }

    public static void realizaOperacao(List<Integer> list, IntFunction<Integer> function) {
        list.forEach(n -> {
            n = function.apply(n);
            System.out.println(n + " ");
        });
    }
}
