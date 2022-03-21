package dev.bank.bankstatement;

import java.io.IOException;

public class MainApplication {
    
    public static void main(String[] args) throws IOException {
        
        BankStatementFactory bankStatementFactory = new BankStatementFactory();
        BankStatementAnalyzer bankStatementAnalyzer = bankStatementFactory.bankStatementAnalyzer();
        
        bankStatementAnalyzer.analyze("bank-data-simple.csv");
    }
    
}
