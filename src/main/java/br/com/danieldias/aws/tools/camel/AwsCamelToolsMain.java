package br.com.danieldias.aws.tools.camel;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.apache.camel.quarkus.main.CamelMainApplication;

@QuarkusMain
public class AwsCamelToolsMain {
    public static void main(String... args) {

        Quarkus.run(CamelMainApplication.class,args);
    }
}

