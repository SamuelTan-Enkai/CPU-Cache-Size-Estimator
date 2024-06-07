import java.util.Random;

public class CacheSizeEstimate {

    public static void main(String[] args) {
        int steps = 64 * 1024 * 1024; // number of times you're accessing values in the array
        int arraySize = (1024 * 1024) / 4; // start at 1 MiB
        int arraySizeLimit = 8 * 1024 * 1024; // stops at 32MiB

        while (arraySize <= arraySizeLimit) {
            int[] array = new int[arraySize]; // init new array
            int lengthMod = array.length - 1;
            long totalAccessTime = 0;
            // run it 10 times to get the average
            for (int i = 0; i < 10; i++) {
                long startTime = System.nanoTime(); // record start time
                for (int j = 0; j < steps; j++) {
                    array[(j * 16) & lengthMod]++;
                }
                long endTime = System.nanoTime(); // record end time
                long accessTime = (endTime - startTime); // how long it takes
                totalAccessTime += (accessTime);
            }
            // int is 4 bytes in java so the byteSize of an int array is arraysize*4
            long byteSize = arraySize * 4;
            System.out.println(byteSize + " " + totalAccessTime / 10);
            arraySize += (1024 * 1024) / 4;// increase arraysize by 1 MiB
        }

    }

}
