package init;

public class Lanzador{

    public static void main(String[] args) {
        Producer producer = new Producer();
        for (int i=1; i<=10, i++){
            producer.send("topic_test", "Mensaje generado a las " + LocalDateTime.now() + "para topic_test");
        }
        producer.close();
    }
}