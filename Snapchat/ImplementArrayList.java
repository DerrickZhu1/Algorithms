import java.util.Arrays;

public class MyList<E> {
        private int size = 0;
        private static final int DEFAULT_CAPACITY = 10;
        private Object elements[];

        public MyList() {
                elements = new Object[DEFAULT_CAPACITY];
        }

        public void add(E e) {
                if (size == elements.length) {
                        ensureCapa();
                }
                elements[size++] = e;
        }


        private void ensureCapa() {
                int newSize = elements.length * 2;
                elements = Arrays.copyOf(elements, newSize);
        }

        @SuppressWarnings("unchecked")
        public E get(int i) {
                if (i >= size || i < 0) {
                        throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
                }
                return (E) elements[i];
        }
}

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MyListTest {


        @Test(expected=IndexOutOfBoundsException.class)
        public void testMyList() {
                MyList<Integer> list = new MyList<Integer>();
                list.add(1);
                list.add(2);
                list.add(3);
                list.add(3);
                list.add(4);
                assertTrue(4 == list.get(4));
                assertTrue(2 == list.get(1));
                assertTrue(3 == list.get(2));

                list.get(6);
        }


        @Test(expected=IndexOutOfBoundsException.class)
        public void testNegative() {
                MyList<Integer> list = new MyList<Integer>();
                list.add(1);
                list.add(2);
                list.add(3);
                list.add(3);
                list.add(4);
                list.get(-1);
        }

        @Test(expected=IndexOutOfBoundsException.class)
        public void testList() {
                List<Integer> list = new ArrayList<Integer>();
                list.add(1);
                list.add(2);
                list.add(3);
                list.add(3);
                list.add(4);
                assertTrue(4 == list.get(4));
                assertTrue(2 == list.get(1));
                assertTrue(3 == list.get(2));

                list.get(6);
        }

}