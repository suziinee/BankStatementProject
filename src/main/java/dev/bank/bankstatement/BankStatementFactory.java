package dev.bank.bankstatement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.bank.bankstatement.data.BankStatementCSVParser;

@Configuration //이 클래스가 bean 구성 정보로 활용될 수 있도록 지정
public class BankStatementFactory {
    
    @Bean //bean 구성정보 내 등록되어 있는 bean
    public BankStatementAnalyzer bankStatementAnalyzer() {

        BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer(bankStatementCSVParser());
        return bankStatementAnalyzer;
    }

    @Bean
    public BankStatementCSVParser bankStatementCSVParser() {
        return new BankStatementCSVParser();
    }

}
