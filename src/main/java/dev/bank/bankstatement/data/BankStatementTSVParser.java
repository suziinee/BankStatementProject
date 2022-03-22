/* 다른 문제 구현에도 이를 활용할 수 있도록 TSV 파싱 로직을 새로운 클래스로 분리 */  

package dev.bank.bankstatement.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.bankstatement.model.BankTransaction;

@Component 
public class BankStatementTSVParser implements BankStatementParser {
    
    /* 멤버 변수 */
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /* 멤버 메소드 */
    /* 한 줄만 파싱하기, 이 클래스 내에서만 사용하기 때문에 private */
    public BankTransaction parseFrom(final String line) {

        String[] columns = line.split("\t");
        final LocalDate date = LocalDate.parse(columns[0] , DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);
    }


    /* 한 줄만 파싱 후 리스트에 추가 */
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        
        List<BankTransaction> bankTransactions = new ArrayList<>();

        for (String line : lines) {
            bankTransactions.add(parseFrom(line));
        }

        return bankTransactions;
    }
    
}
