package com.dneonline.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RealizarUnaOperacion implements Task {
    private String operation;
    private int numUno;
    private int numDos;

    public RealizarUnaOperacion(String operation, int numUno, int numDos) {
        this.operation = operation;
        this.numUno = numUno;
        this.numDos = numDos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("?op=" + operation).
                with(request -> request.header("Content-Type", "text/xml").
                        body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                                "   <soapenv:Header/>\n" +
                                "   <soapenv:Body>\n" +
                                "      <tem:" + operation + ">\n" +
                                "         <tem:intA>" + numUno + "</tem:intA>\n" +
                                "         <tem:intB>" + numDos + "</tem:intB>\n" +
                                "      </tem:" + operation + ">\n" +
                                "   </soapenv:Body>\n" +
                                "</soapenv:Envelope>"))
        );
    }

    public static Performable enElServicio(String operation, int numUno, int numDos) {
        return instrumented(RealizarUnaOperacion.class, operation, numUno, numDos);
    }

}
