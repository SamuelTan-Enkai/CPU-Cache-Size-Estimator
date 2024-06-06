import java.util.Random;

public class CacheSizeEstimate {

    public static void main(String[] args) {
        int steps = 64 * 1024 * 1024; // number of times you're accessing values in array
        int arraySize = 1;
        Random random = new Random();
        int arraySizeLimit = 512 * 1024 * 1024;

        while (arraySize <= arraySizeLimit) {
            int[] array = new int[arraySize]; // init new array
            int lengthMod = array.length - 1;
            long startTime = System.nanoTime(); // record start time
            for (int j = 0; j < steps; j++) {
                array[(j*random.nextInt(16))&lengthMod]++; // fetch and increment random value
                // in array
                //array[(j * 16) & lengthMod]++;
            }
            long endTime = System.nanoTime(); // record end time
            long accessTime = (endTime - startTime); // how long it takes
            // int is 4 bytes in java so the byteSize of an int array is arraysize*4
            long byteSize = arraySize*4;
            System.out.println(byteSize + " " + accessTime);

            arraySize *= 2;


        }

    }

    // public static void main(String[] args) {
    //     int steps = 64 * 1024 * 1024; // number of times you're accessing values in array
    //     int arraySize = 1;
    //     int arraySizeLimit = 512 * 1024 * 1024;
    //     long accessTimesArray[] = new long[128];
        
    //    for(int i =0; i<5;i++){
    //     arraySize =1;
    //     measure(arraySize, arraySizeLimit, steps, accessTimesArray);
    //    }
    //    for(int i = 0; i< accessTimesArray.length && accessTimesArray[i] !=0; i++){
    //     System.out.println((arraySize*4) + " " + (accessTimesArray[i]/10));
    //     arraySize*=2;
    //    }

    // }

    // public static void measure(int arraySize, int arraySizeLimit, int steps, long[] accessTimesArray){
    //     int accessTimesArrayCounter = 0;
    //     Random random = new Random();
    //     while (arraySize <= arraySizeLimit) {
    //         int[] array = new int[arraySize]; // init new array
    //         int lengthMod = array.length - 1;
    //         long startTime = System.nanoTime(); // record start time
    //         for (int j = 0; j < steps; j++) {
    //             //array[(j * 16) & lengthMod]++;
    //             array[(j*random.nextInt(16))&lengthMod]++; // fetch and increment random value
    //         }
    //         long endTime = System.nanoTime(); // record end time
    //         long accessTime = (endTime - startTime); // how long it takes
    //         accessTimesArray[accessTimesArrayCounter] += accessTime;
    //         // int is 4 bytes in java so the byteSize of an int array is arraysize*4
    //         //long byteSize = arraySize*4;
    //         //System.out.println(byteSize + " " + accessTime);

    //         arraySize *= 2;
    //         accessTimesArrayCounter++;

    //     }
    // }
}
