public class LinearSortedArray {
    private int[] array;
    private int size;

    public LinearSortedArray(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    // a) Insert a new element in its correct position in the array.
    public void orderedInsert(int x) {
        if (size == 0) {
            array[0] = x;
            size++;
            return;
        }

        int index = 0;
        while (index < size && array[index] < x) {
            index++;
        }

        // Shift elements to make space for the new element.
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = x;
        size++;
    }

    // b) Iterative binary search to find an element's position.
    public int binarySearchIter(int x) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == x) {
                return mid; // Element found.
            } else if (array[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Element not found.
    }

    // c) Recursive binary search to find an element's position.
    public int binarySearchRec(int x) {
        return binarySearchRec(x, 0, size - 1);
    }

    private int binarySearchRec(int x, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == x) {
                return mid; // Element found.
            } else if (array[mid] < x) {
                return binarySearchRec(x, mid + 1, right);
            } else {
                return binarySearchRec(x, left, mid - 1);
            }
        }

        return -1; // Element not found.
    }

    // d) Delete a specific element from the array.
    public void delete(int x) {
        int index = binarySearchIter(x);
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
    }
}
