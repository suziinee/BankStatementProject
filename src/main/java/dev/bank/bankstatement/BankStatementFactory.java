package dev.bank.bankstatement;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //이 클래스가 bean 구성 정보로 활용될 수 있도록 지정
@ComponentScan //root package를 scanning하다가 Component annotation이 있는 곳을 자동으로 bean으로 인식 후 등록
public class BankStatementFactory {
    
}
