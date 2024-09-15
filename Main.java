public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        // Пример работы
        market.acceptToMarket("Иван");
        market.acceptToMarket("Мария");

        market.takeInQueue("Иван");
        market.takeInQueue("Мария");

        market.update();  // Иван делает заказ и получает его, покидает очередь
        market.update();  // Мария делает заказ и получает его, покидает очередь
    }
}
