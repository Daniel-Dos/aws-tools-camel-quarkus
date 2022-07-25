package br.com.danieldias.aws.tools.camel.util;

import org.apache.camel.FluentProducerTemplate;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class GenericCamelTemplateProducer {

    public static <T> T getFluentProducerTemplateResponse(FluentProducerTemplate fluentProducerTemplate,
                                                          String url, Class clazz) {

        var response = fluentProducerTemplate.to(url)
                .send()
                .getMessage()
                .getBody(clazz);
        return (T) response;
    }
}
