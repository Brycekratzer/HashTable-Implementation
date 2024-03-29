/**
 * Class for generating twin prime numbers within a specified range.
 */
public class TwinPrimeGenerator {

    /**
     * Generates a twin prime number within the specified range.
     * @param min the minimum value of the range
     * @param max the maximum value of the range
     * @return a twin prime number if found, -1 otherwise
     */
    public static int generateTwinPrime(int min, int max) {
        for (int number = min; number <= max; number++) {
            if (isPrime(number) && isPrime(number + 2)) {
                return number + 2;
            }
        }
        return -1; // No twin primes found in the range
    }

    /**
     * Checks if a number is prime.
     * @param primeNumCandidate the number to check for primality
     * @return true if the number is prime, false otherwise
     */
    private static boolean isPrime(int primeNumCandidate) {
        if (primeNumCandidate <= 1) {
            return false;
        }
        if (primeNumCandidate % 2 == 0 && primeNumCandidate != 2) {
            return false;
        }
        for (int i = 3; i * i <= primeNumCandidate; i += 2) {
            if (primeNumCandidate % i == 0) return false;
        }
        return true;
    }
}
