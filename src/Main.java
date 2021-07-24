import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] products = {"Клавиатура", "Мышка", "Монитор", "Микрофон"};
        int[] prices = {10000, 8000, 15000, 5000};
        System.out.println("Список возможных товаров для покупки: ");
        int number = 0;
        for (String product : products) {
            System.out.println(number++ + ". " + product);
        }

        Scanner scanner = new Scanner(System.in);
        StringBuilder resultText = new StringBuilder();
        resultText.append(String.format(
                "%-25s%-15s%-15s%-15s\n",
                "Наименование товара",
                "Количество",
                "Цена/за.ед",
                "Общая стоимость"
        ));

        int result = 0;
        while (true) {
            System.out.print("Введите номер желаемого товара и его количество: ");
            String clientWish = scanner.nextLine();
            if (clientWish.equals("end")) {
                break;
            }
            String[] choices = clientWish.split(" ");
            int priceNumber = Integer.parseInt(choices[1]);
            int productNumber = Integer.parseInt(choices[0]);
            result = priceNumber * prices[productNumber];
            resultText.append(String.format("%-25s%-15s%-15s%-15s\n",
                    products[productNumber],
                    priceNumber,
                    prices[productNumber],
                    priceNumber * prices[productNumber]));
        }
        resultText.append("Итого: ").append(result);
        System.out.println(resultText);
    }
}