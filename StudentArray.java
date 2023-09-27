public class StudentArray {
    private Student[] array;
    private int size;

    public StudentArray(int capacity) {
        array = new Student[capacity];
        size = 0;
    }

    public class Student {
        private String firstName;
        private String lastName;
        private int id;

        public Student(String firstName, String lastName, int id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        // Getters and setters for firstName, lastName, and id go here.

        @Override
        public String toString() {
            return "Student{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", id=" + id +
                    '}';
        }

        public int getId() {
            return 0;
        }
    }

    public void insertLast(Student student) {
        if (size < array.length) {
            array[size] = student;
            size++;
        } else {
            // Handle the case when the array is full and needs to be resized.
            // You can implement resizing logic here.
        }
    }

    public int linearSearch(int id) {
        for (int i = 0; i < size; i++) {
            if (array[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int id) {
        int indexToDelete = linearSearch(id);
        if (indexToDelete != -1) {
            for (int i = indexToDelete; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = null;
            size--;
        }
    }
}
