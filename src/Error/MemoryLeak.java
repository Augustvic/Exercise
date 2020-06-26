package Error;

import java.util.HashMap;

/**
 * Simulate Memory Leak.
 * The first inserted Entry will never be accessed then.
 */
public class MemoryLeak {

    public static void main(String[] args) {
        HashMap<Key, Integer> hm = new HashMap<>();
        Key key = new Key(1, 2, 3);
        hm.put(key, 10);
        System.out.println("Map contains key after insertion? " + hm.containsKey(key));
        key.setA(2);
        System.out.println("Map contains key after first hash update? " + hm.containsKey(key));
        System.out.println("Map size after first hash update? "  + hm.size());
        hm.remove(key);
        System.out.println("Map size after remove key updated? " + hm.size());
        hm.put(key, 20);
        System.out.println("Map size after insert key updated? " + hm.size());
    }

    static class Key {
        private int a;
        private int b;
        private int c;

        public Key(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        public int hashCode() {
            return a + b + c;
        }
    }
}
