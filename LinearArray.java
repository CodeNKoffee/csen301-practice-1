public class LinearArray {
    private int[] array;
    private int size;

    public LinearArray(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public void insertLast(int x) {
        if (size < array.length) {
            array[size] = x;
            size++;
        } else {
            // Handle the case when the array is full and needs to be resized.
            // You can implement resizing logic here.
        }
    }

    public void insertFirst(int x) {
        if (size < array.length) {
            for (int i = size; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = x;
            size++;
        } else {
            // Handle the case when the array is full and needs to be resized.
            // You can implement resizing logic here.
        }
    }

    public int linearSearch(int x) {
        for (int i = 0; i < size; i++) {
            if (array[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int x) {
        int indexToDelete = linearSearch(x);
        if (indexToDelete != -1) {
            for (int i = indexToDelete; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = 0; // Optional: Set the last element to 0.
            size--;
        }
    }
}
