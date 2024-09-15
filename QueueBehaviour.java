public interface QueueBehaviour {
    void takeInQueue(String человек);   // Добавить человека в очередь
    void releaseFromQueue();            // Удалить человека из очереди
    void giveOrder();                   // Выдать заказ
    void takeOrder();                   // Принять заказ
}

