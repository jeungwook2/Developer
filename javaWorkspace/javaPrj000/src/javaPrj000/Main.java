package javaPrj000;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> lottoNumbers = generateLottoNumbers();
        System.out.println("로또 번호: " + lottoNumbers);
    }

    private static Set<Integer> generateLottoNumbers() {
        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();

        while (numbers.size() < 6) {
            int number = random.nextInt(45) + 1; // 1부터 45까지의 숫자 생성
            numbers.add(number);
        }

        return numbers;
    }
}