package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readDate() {
        OutputView.printAskVisitDate();
        return Console.readLine();
    }

    public static String readMenu() {
        OutputView.printAskOrdersMenu();
        return Console.readLine();
    }
}
