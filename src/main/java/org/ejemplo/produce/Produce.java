package org.ejemplo.produce;

import com.google.gson.Gson;
import org.ejemplo.model.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;

@ApplicationScoped
public class Produce {

    @Inject
    ConnectionFactory connectionFactory;

    Gson gson = new Gson();

    public String sendMessage(Student student){
        try {
           JMSContext context = connectionFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE);
           context.createProducer().send(context.createQueue("test"),gson.toJson(student));
           String respuesta="Mensaje enviado";
           context.close();
           return respuesta;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
