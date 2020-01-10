public class main
{
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread consumer = new Thread(new Consumer(buffer));
        Thread producer = new Thread(new Producer(buffer));
        consumer.start();
        producer.start();

    }
}
