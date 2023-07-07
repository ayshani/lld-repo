import com.hashing.service.ConsistentHashing;

public class ConsistentHashingMain {
    public static void main(String[] args) {
        System.out.println("Consistent hashing --------");

        ConsistentHashing consistentHashing = new ConsistentHashing(3);
        consistentHashing.addServer("server1");
        consistentHashing.addServer("server2");
        consistentHashing.addServer("server3");

        System.out.println("Key1 is present in server : "+ consistentHashing.getServer("key1"));
        System.out.println("key67890 is present in server : "+ consistentHashing.getServer("key67890"));

        consistentHashing.removeServer("server1");
        System.out.println("After removing server1 ----");

        System.out.println("Key1 is present in server : "+ consistentHashing.getServer("key1"));
        System.out.println("key67890 is present in server : "+ consistentHashing.getServer("key67890"));

    }
}