import java.util.Scanner;

public class HammingCode {
    static int getRedundantBits(int n) {
        int r = 0;
        while (Math.pow(2, r) < (n + r + 1)) r++;
        return r;
    }

    static int[] generateCode(int[] data, int r) {
        int total = data.length + r, code[] = new int[total];
        for (int i = 0, j = 0; i < total; i++) 
            code[i] = ((i + 1 & i) == 0) ? 0 : data[j++];
        
        for (int i = 0; i < r; i++) {
            int pos = (1 << i) - 1, parity = 0;
            for (int k = pos; k < total; k += 2 * (pos + 1))
                for (int l = k; l < k + pos + 1 && l < total; l++)
                    parity ^= code[l];
            code[pos] = parity;
        }
        return code;
    }

    static int detectAndCorrect(int[] received) {
        int r = (int) (Math.log(received.length + 1) / Math.log(2)), errorPos = 0;
        for (int i = 0; i < r; i++) {
            int pos = (1 << i) - 1, parity = 0;
            for (int k = pos; k < received.length; k += 2 * (pos + 1))
                for (int l = k; l < k + pos + 1 && l < received.length; l++)
                    parity ^= received[l];
            if (parity != 0) errorPos += pos + 1;
        }
        if (errorPos > 0) received[errorPos - 1] ^= 1;
        return errorPos;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of data bits: ");
        int[] data = new int[sc.nextInt()];
        System.out.println("Enter data bits:");
        for (int i = 0; i < data.length; i++) data[i] = sc.nextInt();
        
        int[] code = generateCode(data, getRedundantBits(data.length));
        System.out.print("Generated Hamming Code: ");
        for (int bit : code) System.out.print(bit + " ");
        
        System.out.println("\nSimulating error at position 3...");
        int[] testRun = code.clone();
        testRun[2] ^= 1;

        int errorPos = detectAndCorrect(testRun);
        System.out.println("Error " + (errorPos > 0 ? "corrected at position: " + errorPos : "not detected."));
        System.out.print("Corrected Code: ");
        for (int bit : testRun) System.out.print(bit + " ");
        
        sc.close();
    }
}
