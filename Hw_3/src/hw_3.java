public class hw_3 {
    public static void main(String[] args) {

        oneList list = new oneList();
        list.push(1);
        list.push(2);
        list.push(3);

        list.revert();
        list.print();
    }

    public static class oneList {
        private Node head;

        private class Node {
            private int value;
            private Node next;

        }
        void revert() {
            Node current = head;
            Node previous = null;

            while (current != null) {
                Node next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            head = previous;
        }

        void push(int value) {
            Node node = new Node();
            node.value = value;
            node.next = head;
            head = node;
        }

        void print(){
            Node current = head;
            while (current != null){
                System.out.println(current.value);
                current = current.next;
            }
        }
    }
}
