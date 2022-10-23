

public class LinSort {

//////////////////////////////////////////////////////////////////////////////LSD//////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
    public static int[] sort_LSD(int[] elements) {
        int max = getMaximum(elements);
        int numberOfDigits = getNumberOfDigits(max);

        for (int digitIndex = 0; digitIndex < numberOfDigits; digitIndex++) {
            sortByDigit_LSD(elements, digitIndex);
        }

        return elements;
    }

    private static void sortByDigit_LSD(int[] elements, int digitIndex) {
        Bucket[] buckets = partition(elements, digitIndex);
        collect(buckets, elements);
    }

/////////////////////////////////////////////////////////////////////////////////////////////MSD///////////////////////////////////////////////////////////////////////////////////////////
    public static void sort_MSD(int[] elements) {
        int max = getMaximum(elements);
        int numberOfDigits = getNumberOfDigits(max);

        sortByDigit_MSD(elements, numberOfDigits - 1);
    }

    private static void sortByDigit_MSD(int[] elements, int digitIndex) {
        Bucket[] buckets = partition(elements, digitIndex);


        if (digitIndex > 0) {
            for (Bucket bucket : buckets) {
                if (bucket.needsToBeSorted()) {
                    sortByDigit_MSD(bucket.getElements(), digitIndex - 1);
                }
            }
        }

        collect(buckets, elements);
    }

/////////////////////////////////////////////////////////////////////////////////////////////Counting///////////////////////////////////////////////////////////////////////////////////////////

    public static void sort_Count(int[] elements) {
        int max = getMaximum(elements);
        int numberOfDigits = getNumberOfDigits(max);

        // Remember input array
        int[] inputArray = elements;

        for (int digitIndex = 0; digitIndex < numberOfDigits; digitIndex++) {
            elements = sortByDigit_Count(elements, digitIndex);
        }

        // Copy sorted elements back to input array
        System.arraycopy(elements, 0, inputArray, 0, elements.length);
    }

    private static int[] sortByDigit_Count(int[] elements, int digitIndex) {
        int[] counts = countDigits(elements, digitIndex);
        int[] prefixSums = calculatePrefixSums(counts);
        return collectElements(elements, digitIndex, prefixSums);
    }

    private static int[] calculatePrefixSums(int[] counts) {
        int[] prefixSums = new int[10];
        prefixSums[0] = counts[0];
        for (int i = 1; i < 10; i++) {
            prefixSums[i] = prefixSums[i - 1] + counts[i];
        }
        return prefixSums;
    }

    private static int[] collectElements(int[] elements, int digitIndex, int[] prefixSums) {
        int divisor = calculateDivisor(digitIndex);
        int[] target = new int[elements.length];
        for (int i = elements.length - 1; i >= 0; i--) {
            int element = elements[i];
            int digit = element / divisor % 10;
            target[--prefixSums[digit]] = element;
        }
        return target;
    }
/////////////////////////////////////////////////////////////////////////////////////////////Help_function///////////////////////////////////////////////////////////////////////////////////////////

    private static class Bucket {
        private final int[] elements;
        private int addIndex;

        private Bucket(int size) {
        elements = new int[size];
        }

        private void add(int element) {
        elements[addIndex] = element;
        addIndex++;
        }

        private int[] getElements() {
        return elements;
        }

        private boolean needsToBeSorted() {
        return elements.length > 1;
        }
    }

    private static int calculateDivisor(int digitIndex) {
        int divisor = 1;
        for (int i = 0; i < digitIndex; i++) {
            divisor *= 10;
        }
        return divisor;
    }

    private static int getNumberOfDigits(int number) {
        int numberOfDigits = 1;
        while (number >= 10) {
            number /= 10;
            numberOfDigits++;
        }
        return numberOfDigits;
    }

    private static int getMaximum(int[] elements) {
        int max = 0;
        for (int element : elements) {
            if (element > max) {
            max = element;
            }
        }
        return max;
    }

    private static int[] countDigits(int[] elements, int digitIndex) {
        int[] counts = new int[10];
        int divisor = calculateDivisor(digitIndex);
        for (int element : elements) {
            int digit = element / divisor % 10;
            counts[digit]++;
        }
        return counts;
    }

    private static Bucket[] createBuckets(int[] counts) {
        Bucket[] buckets = new Bucket[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new Bucket(counts[i]);
        }
        return buckets;
    }

    private static Bucket[] partition(int[] elements, int digitIndex) {
        int[] counts = countDigits(elements, digitIndex);
        Bucket[] buckets = createBuckets(counts);
        distributeToBuckets(elements, digitIndex, buckets);
        return buckets;
    }

    private static void distributeToBuckets(int[] elements, int digitIndex, Bucket[] buckets) {
        int divisor = calculateDivisor(digitIndex);

        for (int element : elements) {
            int digit = element / divisor % 10;
            buckets[digit].add(element);
        }
    }

    private static void collect(Bucket[] buckets, int[] elements) {
        int targetIndex = 0;
        for (Bucket bucket : buckets) {
            for (int element : bucket.getElements()) {
                elements[targetIndex] = element;
                targetIndex++;
            }
        }
    }
}