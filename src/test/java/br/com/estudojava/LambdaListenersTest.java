package br.com.estudojava;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LambdaListenersTest {

    @Test
    public void listener_semLambda() throws Exception {
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("O botão foi pressionado!");
                //Realiza alguma ação quando o botão for pressionado
            }
        });
    }

    @Test
    public void listener_comLambda() throws Exception {
        JButton button = new JButton();
        button.addActionListener(e -> {
            System.out.println("O botão foi pressionado!");
            //Realiza alguma ação quando o botão for pressionado
        });
    }


}
