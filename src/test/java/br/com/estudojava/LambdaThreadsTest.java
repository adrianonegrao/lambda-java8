package br.com.estudojava;

import org.junit.Test;

public class LambdaThreadsTest {

    @Test
    public void threads_semLambda() throws Exception {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread com classe interna");
            }
        };
        new Thread(r).start();
    }

    @Test
    public void thread_comLambda() throws Exception {
        Runnable r = () -> System.out.println("Thread com função lambda!");
        new Thread(r).start();
    }

    @Test
    public void thread_comLambda_simplificada() throws Exception {
        new Thread(
                () -> System.out.println("Thread com função lambda simplificada!")
        ).start();
    }

}
