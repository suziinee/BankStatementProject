package dev.bank.bankstatement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import dev.bank.bankstatement.data.BankStatementTSVParser;
import dev.bank.bankstatement.model.BankTransaction;

public class BankStatementAnalyzer {
    
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        
        //파일 입출력
        final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
        final List<String> lines = Files.readAllLines(path);

        //데이터 파싱
        BankStatementTSVParser bankStatementTSVParser = new BankStatementTSVParser(); 
        List<BankTransaction> bankTransactions = bankStatementTSVParser.parseLinesFromTSV(lines);

        //입출금 내역 연산 및 출력
        System.out.println("입출력 내역의 총합은 " + calculateTotalAmount(bankTransactions) + "입니다.");

        /* 2번째 요구사항, 월 별 입출금 내역 구하기 */
        System.out.println("1월의 입출금 내역은 " + selectInMonth(bankTransactions, Month.JANUARY));
    }


    public static double calculateTotalAmount(List<BankTransaction> bankTransactions) {

        double total = 0d;

        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }

        return total;
    }


    /* findTransactionsInJanuary()에서 다른 월도 조회할 수 있도록 변경 */
    public static List<BankTransaction> selectInMonth(List<BankTransaction> bankTransactions, Month month) {

        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();

        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) 
                bankTransactionsInMonth.add(bankTransaction);
        }

        return bankTransactionsInMonth;
    }
}
