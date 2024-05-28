import java.util.LinkedList;
import java.util.Queue;
public class Sliding_Win_proto {
    private int windowSize;
    private Queue<Integer> window;

    public Sliding_Win_proto(int size) {
        this.windowSize = size;
        this.window = new LinkedList<>();
    }

    public void sendPacket(int packet) {
        if (window.size() < windowSize) {
            window.add(packet);
            System.out.println("Sent packet: " + packet);
        } else {
            System.out.println("Window full. Cannot send packet: " + packet);
        }
    }

    public void receiveAct(int ack) {
        if (window.contains(ack)) {
            while (!window.isEmpty() && window.peek() <= ack) {
                System.out.println("Acknowledged packet: " + window.poll());
            }
        }
    }

    public static void main(String[] args) {
        Sliding_Win_proto sw = new Sliding_Win_proto(4);
        for (int i=1;i<=10;i++) {
            sw.sendPacket(i);
        }
        sw.receiveAct(2);
        sw.sendPacket(11);
        sw.receiveAct(5);
        sw.sendPacket(12);

            }
        }

