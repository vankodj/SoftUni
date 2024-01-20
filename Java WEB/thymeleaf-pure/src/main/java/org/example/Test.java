package org.example;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.StringWriter;

public class Test {
    public static void main(String[] args) {
        ITemplateEngine engine = createeEngine();
        Context context = new Context();
        context.setVariable("name","Pesho");
        StringWriter sw = new StringWriter();
        engine.process("test.html",context,sw);
        System.out.println(sw.toString());
    }
        private static ITemplateEngine createeEngine(){
            TemplateEngine engine = new TemplateEngine();
            engine.setTemplateResolver(new ClassLoaderTemplateResolver());
            return engine;
        }


}
