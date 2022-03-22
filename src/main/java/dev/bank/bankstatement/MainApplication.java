package dev.bank.bankstatement;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {
    
    public static void main(String[] args) throws IOException {
        
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BankStatementFactory.class);
        BankStatementAnalyzer bankStatementAnalyzer = applicationContext.getBean(BankStatementAnalyzer.class);

        bankStatementAnalyzer.analyze("bank-data-simple.csv");
    }

}
