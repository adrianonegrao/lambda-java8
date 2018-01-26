package br.com.estudojava.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaCollectionsTest {

    @Test
    public void imprimindo_ListaComLambda() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.forEach( n -> System.out.println(n));
    }

    @Test
    public void imprimindo_NumerosPares() throws Exception {
        //Para mais de um comando, necessario { }
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.forEach( n -> {
            if( n % 2 == 0 ){
                System.out.println(n);
            }
        });
    }

    @Test
    public void imprimindo_QuadradoDosElementos() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.forEach( n -> System.out.println( n * n ));
    }

    @Test
    public void ordenando_pessoas_semLambda() throws Exception {
        System.out.println("Ordendando pessoas por nome");
        List<Pessoa> listPessoas = Arrays.asList(new Pessoa("Eduardo", 40), new Pessoa("Luiz", 32), new Pessoa("Bruna", 26));
        Collections.sort(listPessoas, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa p1, Pessoa p2) {
                return p1.getNome().compareTo(p2.getNome());
            }
        });
        listPessoas.forEach( p -> System.out.println(p.getNome()));

        System.out.println("Ordenando pessoas por idade");
        Collections.sort(listPessoas, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa p1, Pessoa p2) {
                return p1.getIdade().compareTo(p2.getIdade());
            }
        });
        listPessoas.forEach( p -> System.out.println(p.getNome()));
    }

    @Test
    public void ordenando_pessoas_comLambda() throws Exception {
        List<Pessoa> listPessoas = Arrays.asList(new Pessoa("Eduardo", 40), new Pessoa("Luiz", 32), new Pessoa("Bruna", 26));
        System.out.println("Ordenando pessoas pelo nome:");
        Collections.sort(listPessoas, (Pessoa p1, Pessoa p2) -> p1.getNome().compareTo(p2.getNome()));
        listPessoas.forEach( p -> System.out.println(p.getNome()));

        System.out.println("Ordenando pessoas pela idade:");
        Collections.sort(listPessoas, (Pessoa p1, Pessoa p2) -> p1.getIdade().compareTo(p2.getIdade()));
        listPessoas.forEach( p -> System.out.println(p.getNome()));
    }

    @Test
    public void ordenando_pessoas_comLambda_simplificado() throws Exception {
        List<Pessoa> listPessoas = Arrays.asList(new Pessoa("Eduardo", 40), new Pessoa("Luiz", 32), new Pessoa("Bruna", 26));
        System.out.println("Ordenando pessoas pelo nome:");
        listPessoas.sort(Comparator.comparing( p -> p.getNome()));
        listPessoas.forEach( p -> System.out.println(p.getNome()));
    }

    @Test
    public void filtro_pessoas_maisDe30Anos() throws Exception {
        List<Pessoa> listPessoas = Arrays.asList(new Pessoa("Eduardo", 40), new Pessoa("Luiz", 32), new Pessoa("Bruna", 26));
        System.out.println("Pessoas com mais de 30 anos");
        List<Pessoa> maiores30anos = listPessoas.stream().filter(p -> p.getIdade() > 30).collect(Collectors.toList());
        maiores30anos.forEach( p -> System.out.println(p.getNome()));
    }
}
