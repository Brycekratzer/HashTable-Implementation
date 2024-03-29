import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
/**
 * The following is a driver class for examining linear probing and double hashing data structures
 * 
 * @author brycekratzer
 * @see DoubleHashing.java
 * @see LinearProbing.java
 */
public class HashtableExperiment {
    public static void main(String[] args) {
        if (args.length < 2 || args.length > 3) {
            System.out.println("Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]");
            return;
        }

        int dataSource = Integer.parseInt(args[0]);
        double loadFactor = Double.parseDouble(args[1]);
        int debugLevel = args.length == 3 ? Integer.parseInt(args[2]) : 0;
        if(dataSource == 1){
            dataSource1(debugLevel, loadFactor);
        } else if(dataSource == 2){
            dataSource2(debugLevel, loadFactor);
        } else if(dataSource == 3){
            try{
                dataSource3(debugLevel, loadFactor); 
            }catch(IOException e){
                System.out.println("there was an error processing your 'word-list.txt' file");
            }
        } else {
            System.out.println("Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]");
            return;
        }
    }

    /**
     * The following runs a test to examine the efficancy for each type of data structure
     * 
     * @param debugLevel - determines type of layout
     * @param loadFactor - used for boundary for amount of data stored
     */
    public static void dataSource1(int debugLevel, double loadFactor){
        int capacity = TwinPrimeGenerator.generateTwinPrime(95500, 96000);
        LinearProbing linearProbTable = new LinearProbing(capacity, loadFactor);
        DoubleHashing doubleHashTable = new DoubleHashing(capacity, loadFactor);

        Random randomGen = new Random();
        int randomNum;
        int LinearNumOfProbs = 0;
        int DoubleHashNumOfProbs = 0;
        int LinearfreqCount = 0;
        int DoublefreqCount = 0;
        while (linearProbTable.getSize() / (double) capacity < loadFactor || doubleHashTable.getSize() / (double) capacity < loadFactor) {
            randomNum = randomGen.nextInt();
            if (linearProbTable.Hashinsert(randomNum) == -1) {
                LinearfreqCount++;
            }
            if (doubleHashTable.Hashinsert(randomNum) == -1) {
                DoublefreqCount++;
            }
        }
        double avgNumProbsLinear = LinearNumOfProbs / (double)linearProbTable.getSize();
        double avgNumProbsDouble = DoubleHashNumOfProbs / (double)doubleHashTable.getSize();

        if (debugLevel == 0) {
            debugLevel0(capacity, "Random Integers", loadFactor, linearProbTable.getSize(), LinearfreqCount, avgNumProbsLinear, doubleHashTable.getSize(), DoublefreqCount, avgNumProbsDouble);
        } else if(debugLevel == 1){
            debugLevel1(capacity, "Random Integers", loadFactor, linearProbTable.getSize(), linearProbTable, LinearfreqCount, avgNumProbsLinear, doubleHashTable.getSize(), doubleHashTable, DoublefreqCount, avgNumProbsDouble);
        } else if(debugLevel == 2){
            debugLevel2(debugLevel, linearProbTable, doubleHashTable);
        }
    }
    /**
     * The following runs a test to examine the efficancy for each type of data structure
     * 
     * @param debugLevel - determines type of layout
     * @param loadFactor - used for boundary for amount of data stored
     */
    public static void dataSource2(int debugLevel, double loadFactor) {
        int capacity = TwinPrimeGenerator.generateTwinPrime(95500, 96000);
        LinearProbing linearProbTable = new LinearProbing(capacity, loadFactor);
        DoubleHashing doubleHashTable = new DoubleHashing(capacity, loadFactor);
    
        long current = new Date().getTime();  // Get initial time
    
        int LinearNumOfProbs = 0;
        int DoubleHashNumOfProbs = 0;
        int LinearfreqCount = 0;
        int DoublefreqCount = 0;     // Create Date object    

        while (linearProbTable.getSize() / (double) capacity < loadFactor || doubleHashTable.getSize() / (double) capacity < loadFactor) {
            if (linearProbTable.Hashinsert(current) == -1) {
                LinearfreqCount++;
            }
            if (doubleHashTable.Hashinsert(current) == -1) {
                DoublefreqCount++;
            }
            current += 1000;  // Increment current time by 1 second
        }
        LinearNumOfProbs = linearProbTable.getProbeCount();
        DoubleHashNumOfProbs = doubleHashTable.getProbeCount();
    
    
        double avgNumProbsLinear = LinearNumOfProbs / (double)linearProbTable.getSize();
        double avgNumProbsDouble = DoubleHashNumOfProbs / (double)doubleHashTable.getSize();
    
        if (debugLevel == 0) {
            // Assuming you'll update the data source name in debugLevel0
            debugLevel0(capacity, "Date Objects", loadFactor, linearProbTable.getSize(), LinearfreqCount, avgNumProbsLinear, doubleHashTable.getSize(), DoublefreqCount, avgNumProbsDouble);
        } else if(debugLevel == 1){
            debugLevel1(capacity, "Date Objects", loadFactor, linearProbTable.getSize(), linearProbTable, LinearfreqCount, avgNumProbsLinear, doubleHashTable.getSize(), doubleHashTable, DoublefreqCount, avgNumProbsDouble);
        }  else if(debugLevel == 2){
            debugLevel2(debugLevel, linearProbTable, doubleHashTable);
        }
    }
     /**
     * The following runs a test to examine the efficancy for each type of data structure
     * 
     * @param debugLevel - determines type of layout
     * @param loadFactor - used for boundary for amount of data stored
     */
    public static void dataSource3(int debugLevel, double loadFactor) throws IOException {
        int capacity = TwinPrimeGenerator.generateTwinPrime(95500, 96000);
        LinearProbing linearProbTable = new LinearProbing(capacity, loadFactor);
        DoubleHashing doubleHashTable = new DoubleHashing(capacity, loadFactor);

        Scanner scanFile = new Scanner(new FileReader("word-list.txt"));
        
        int LinearNumOfProbs = 0;
        int DoubleHashNumOfProbs = 0;
        int LinearfreqCount = 0;
        int DoublefreqCount = 0;

        while (linearProbTable.getSize() / (double) capacity < loadFactor || doubleHashTable.getSize() / (double) capacity < loadFactor) {
            String word = scanFile.nextLine();
            word = word.trim();

            if (linearProbTable.Hashinsert(word) == -1) {
                LinearfreqCount++;
            }
            if (doubleHashTable.Hashinsert(word) == -1) {
                DoublefreqCount++;
            }
        }
        LinearNumOfProbs = linearProbTable.getProbeCount();
        DoubleHashNumOfProbs = doubleHashTable.getProbeCount();
        scanFile.close();

        double avgNumProbsLinear = LinearNumOfProbs / (double)linearProbTable.getSize();
        double avgNumProbsDouble = DoubleHashNumOfProbs / (double)doubleHashTable.getSize();
        
        if (debugLevel == 0) {
            debugLevel0(capacity, "Words from word-list.txt", loadFactor, linearProbTable.getSize(), LinearfreqCount, avgNumProbsLinear, doubleHashTable.getSize(), DoublefreqCount, avgNumProbsDouble);
        } else if(debugLevel == 1){
            debugLevel1(capacity, "Words from word-list.txt", loadFactor, linearProbTable.getSize(), linearProbTable, LinearfreqCount, avgNumProbsLinear, doubleHashTable.getSize(), doubleHashTable, DoublefreqCount, avgNumProbsDouble);
        }  else if(debugLevel == 2){
            debugLevel2(debugLevel, linearProbTable, doubleHashTable);
        }
    }

    /**
     * Basic layout to show results
     * 
     * Each param is used for print
     * @param capacity
     * @param dataSource
     * @param loadFactor
     * @param linearSize
     * @param LinearfreqCount
     * @param avgNumProbsLinear
     * @param doubleSize
     * @param DoublefreqCount
     * @param avgNumProbsDouble
     */
    public static void debugLevel0(int capacity, String dataSource, double loadFactor, int linearSize, int LinearfreqCount, //
                                    double avgNumProbsLinear, int doubleSize, int DoublefreqCount, double avgNumProbsDouble){
            
        System.out.println("HashtableExperiment: Found a twin prime table capacity: " + capacity);
        System.out.println("HashtableExperiment: Input: " + dataSource + "   Loadfactor: " + loadFactor);
        System.out.println("\tUsing Linear Probing\n" + "HashtableExperiment: size of hash table is " + linearSize);
        System.out.println("\tInserted " + (linearSize + LinearfreqCount) + ", of which " + LinearfreqCount + " were duplicates");
        System.out.println("\tAvg. no. of probes = " +  String.format("%.2f", avgNumProbsLinear));
        System.out.println("\n\tUsing Double Hashing\n" + "HashtableExperiment: size of hash table is " + doubleSize);
        System.out.println("\tInserted " + (doubleSize + DoublefreqCount) + ", of which " + DoublefreqCount + " were duplicates");
        System.out.println("\tAvg. no. of probes = " + String.format("%.2f", avgNumProbsDouble));
    }

    /**
     * Basic layout but also puts the results in a file for user to see each table
     * 
     * Each param is used for printing 
     * @param capacity
     * @param dataSource
     * @param loadFactor
     * @param linearSize
     * @param linearTable
     * @param LinearfreqCount
     * @param avgNumProbsLinear
     * @param doubleSize
     * @param doubleHashTable
     * @param DoublefreqCount
     * @param avgNumProbsDouble
     */
    public static void debugLevel1(int capacity, String dataSource, double loadFactor, int linearSize, Hashtable linearTable, int LinearfreqCount, //
                                    double avgNumProbsLinear, int doubleSize, Hashtable doubleHashTable, int DoublefreqCount, double avgNumProbsDouble){

        System.out.println("HashtableExperiment: Found a twin prime table capacity: " + capacity);
        System.out.println("HashtableExperiment: Input: " + dataSource + "   Loadfactor: " + loadFactor);
        System.out.println("\tUsing Linear Probing\n" + "HashtableExperiment: size of hash table is " + linearSize);
        System.out.println("\tInserted " + (linearSize + LinearfreqCount) + ", of which " + LinearfreqCount + " were duplicates");
        System.out.println("\tAvg. no. of probes = " + String.format("%.2f", avgNumProbsLinear));
        linearTable.dumpToFile("word-list-"+ loadFactor +"-linear-dump.txt");
        System.out.println("HashtableExperiment: Saved dump of hash table");
        System.out.println("\n\tUsing Double Hashing\n" + "HashtableExperiment: size of hash table is " + doubleSize);
        System.out.println("\tInserted " + (doubleSize + DoublefreqCount) + ", of which " + DoublefreqCount + " were duplicates");
        System.out.println("\tAvg. no. of probes = " +  String.format("%.2f", avgNumProbsDouble));
        doubleHashTable.dumpToFile("word-list-"+loadFactor+"-double-dump.txt");
        System.out.println("HashtableExperiment: Saved dump of hash table");
    }

    /**
     * Prints out each table's contents in terminal
     * 
     * @param debugLevel
     * @param linearTable
     * @param doubleTable
     */
    public static void debugLevel2(int debugLevel, LinearProbing linearTable, DoubleHashing doubleTable) {
        System.out.println("\nLinear Probing Table");
        for (int i = 0; i < linearTable.capacity; i++) {  // Use capacity as table size
            HashObject obj = linearTable.hashtable[i];  // Access hashtable directly
            if (obj != null) {
                // Access duplicate count and probe count assuming they're tracked in HashObject
                int duplicateCount = obj.getFrequency();
                int probeCount = obj.getProbe();
                System.out.println("table[" + i + "]: " + obj.getKey() + " " + duplicateCount + " " + probeCount);
            }
        }
    
        System.out.println("\nDouble Hash Table\n");
        for (int i = 0; i < doubleTable.capacity; i++) {  // Use capacity as table size
            HashObject obj = doubleTable.hashtable[i];  // Access hashtable directly
            if (obj != null) {
                // Access duplicate count and probe count assuming they're tracked in HashObject
                int duplicateCount = obj.getFrequency();
                int probeCount = obj.getProbe();
                System.out.println("table[" + i + "]: " + obj.getKey() + " " + duplicateCount + " " + probeCount);
            }
        }
    }
}
    

