package dev.bank.bankstatement;


import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankStatementAnalyzerSimple 
{
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
       
        /* phase 1 : 1번째 기능 요구사항, 모든 거래 내역의 합 계산하기 */

        final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
        
        final List<String> lines = Files.readAllLines(path);

        double total = 0d;
        for (String line : lines) {
            final String[] columns = line.split("\t");
            final double amount = Double.parseDouble(columns[1]); //double type으로 변환
            total += amount;
        }

        System.out.println("총 사용 금액은 " + total + "입니다.");
        
        System.out.println("1월의 총 사용 금액은 " + findTranscationsInJanuary() + "입니다.");
    }


    /* phase 1-1 : 2번째 기능 요구사항 : 특정 달엔 몇 건의 입출금 내역이 발생하였을까? */
    public static double findTranscationsInJanuary() throws IOException {

        final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
        
        final List<String> lines = Files.readAllLines(path);

        double total = 0d;

        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (String line : lines) {
            final String[] columns = line.split("\t");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            
            if (date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
        }
        return total;
    }
}
