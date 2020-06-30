/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import view.TelaPrincipal;

/**
 *
 * @author HEISENBERG
 */
public class EnviarEmail {

   
    String msg;

    public void enviar(String caminho, String descArquivo, String nomeArquivo) {
        //criaçao do objeto de email
        MultiPartEmail email = new MultiPartEmail();
        //conexao com servidor webmail
        email.setHostName("smtp.mail.yahoo.com");//provedor smtp
        email.setSslSmtpPort("465");
        email.setStartTLSRequired(true);
        email.setStartTLSEnabled(true);
        email.setSSLOnConnect(true);
        email.setAuthenticator(new DefaultAuthenticator("klebes.santos@yahoo.com", "nnmgfrmqqgtmbisn"));//email e senha de login

        try {
            email.setFrom("klebes.santos@yahoo.com");

            //email setdebug true;
            email.setSubject("texto");
            email.setMsg("texto2");
            email.addTo("klebes-santos@bol.com.br");//email de quem recebera o email

//anexando arrquivo no email
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(caminho);
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription(descArquivo);
            attachment.setName(nomeArquivo);
            email.attach(attachment);
            email.send();
//msg de conclusao de envio de email
            JOptionPane.showMessageDialog(null, "E-mail enviado e ordem de serviço criado com sucesso!");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

}
