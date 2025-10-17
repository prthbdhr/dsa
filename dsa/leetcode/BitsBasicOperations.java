

public class BitsBasicOperations {

    public int XOR(int n, int m) {
        return n ^ m;
    }

    public int check(int a, int b) {
        return (b & (1 << (a - 1))) != 0 ? 1 : 0;
    }

    public int setBit(int c, int d) {
        return d | (1 << c);
    }
}