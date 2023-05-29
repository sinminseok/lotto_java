package view;

import camp.nextstep.edu.missionutils.Console;


//InputView에선 사용자의 값을 입력 받는 역할만을 구현하자.검증은 Model,Service,Controller 단위에서 구현하자.
public class InputView {

    private final static String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private final static String INPUT_WIN_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    public static String inputPrice() {
        System.out.println(INPUT_PRICE);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

    public String inputWinNumbers() {
        System.out.println(INPUT_WIN_NUMBERS);
        return Console.readLine();
    }

}
