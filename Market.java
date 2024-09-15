import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Market implements QueueBehaviour, MarketBehaviour {
    private ArrayList<String> людиВМагазине;
    private Queue<String> очередь;

    public Market() {
        this.людиВМагазине = new ArrayList<>();
        this.очередь = new LinkedList<>();
    }

    // Реализация методов QueueBehaviour
    @Override
    public void takeInQueue(String человек) {
        System.out.println(человек + " встал в очередь.");
        очередь.add(человек);
    }

    @Override
    public void releaseFromQueue() {
        if (!очередь.isEmpty()) {
            String человек = очередь.poll();
            System.out.println(человек + " покинул очередь.");
        } else {
            System.out.println("Очередь пуста.");
        }
    }

    @Override
    public void giveOrder() {
        if (!очередь.isEmpty()) {
            System.out.println(очередь.peek() + " получил свой заказ.");
        } else {
            System.out.println("Некому давать заказ, очередь пуста.");
        }
    }

    @Override
    public void takeOrder() {
        if (!очередь.isEmpty()) {
            System.out.println(очередь.peek() + " сделал заказ.");
        } else {
            System.out.println("Некому принимать заказ, очередь пуста.");
        }
    }

    // Реализация методов MarketBehaviour
    @Override
    public void acceptToMarket(String человек) {
        System.out.println(человек + " вошел в магазин.");
        людиВМагазине.add(человек);
    }

    @Override
    public void releaseFromMarket(String человек) {
        if (людиВМагазине.contains(человек)) {
            людиВМагазине.remove(человек);
            System.out.println(человек + " покинул магазин.");
        } else {
            System.out.println(человек + " не найден в магазине.");
        }
    }

    // Метод update
    public void update() {
        // Принять заказы от тех, кто в очереди
        takeOrder();

        // Выдать заказы тем, кто в очереди
        giveOrder();

        // Убрать из очереди того, кто получил заказ
        if (!очередь.isEmpty()) {
            String освобожденный = очередь.poll();
            if (освобожденный != null) {
                releaseFromMarket(освобожденный);
            }
        }
    }
}
