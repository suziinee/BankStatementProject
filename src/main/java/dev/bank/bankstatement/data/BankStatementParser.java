/* 입출금 내역 데이터를 파싱하는 메소드(사용법)를 가지고 있는 설계도 */
package dev.bank.bankstatement.data;

import java.util.List;

import dev.bank.bankstatement.model.BankTransaction;

public interface BankStatementParser {
    
    /* 메소드의 선언부만 작성하고 구현부(몸체, 실제 코드)는 구현 클래스에서 작성해야함 */
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
