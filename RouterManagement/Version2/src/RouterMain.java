import com.router.model.Packet;
import com.router.service.Router;
import com.router.service.RouterFactory;
import com.router.util.DataType;
import com.router.util.PacketSizeCategory;

public class RouterMain {
    public static void main(String[] args) {
        Router router = RouterFactory.getRouter(10, 50);

        Thread threadA = new Thread(()->{
            for(int i=0;i<100;i++) {
                int id = i;
                router.addPackets(new Packet(id+"A", DataType.MANAGEMENT, PacketSizeCategory.LARGE));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread threadB = new Thread(()->{
            for(int i=0;i<100;i++) {
                int id = i;
                router.addPackets(new Packet(id+"B", DataType.USER, PacketSizeCategory.LARGE));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread threadC = new Thread(()->{
            for(int i=0;i<100;i++) {
                int id = i;
                router.addPackets(new Packet(id+"C", DataType.MANAGEMENT, PacketSizeCategory.SMALL));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread threadD = new Thread(()->{
            for(int i=0;i<100;i++) {
                int id = i;
                router.addPackets(new Packet(id+"D", DataType.USER, PacketSizeCategory.SMALL));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadB.start();
        threadA.start();
        threadC.start();
        threadD.start();
    }
}