public class RedBlackTree {
        private Node root;
        private static boolean RED = true;
        private static boolean BLACK = false;

        private class Node {
            int key;
            Node left, right;
            boolean color;

            public Node(int key, boolean color) {
                this.key = key;
                this.color = color;
            }
        }

        public void insert(int key) {
            root = insert(root, key);
            root.color = BLACK;
        }

        // Добавления нового узла в дерево
        private Node insert(Node node, int key) {
            if (node == null)
                return new Node(key, RED);
            if (key < node.key)
                node.left = insert(node.left, key);
            else if (key > node.key)
                node.right = insert(node.right, key);

            if (isRed(node.right) && !isRed(node.left))
                node = leftRotate(node);
            if (isRed(node.left) && isRed(node.left.left))
                node = rightRotate(node);
            if (isRed(node.left) && isRed(node.right))
                swapColors(node);

            return node;
        }
        // Смена цвета узлов
        private void swapColors(Node node) {
            node.color = RED;
            node.left.color = BLACK;
            node.right.color = BLACK;
        }
        // Проверка узла
        private boolean isRed(Node node) {
            if (node == null)
                return false;
            return node.color == RED;
        }
    // Правый малый поворот
        private Node rightRotate(Node node) {
            Node current = node.left;
            node.left = current.right;
            current.right = node;
            current.color = node.color;
            node.color = RED;
            return current;
        }

        // Левый малый поворот
        private Node leftRotate(Node node) {
            Node current = node.right;
            node.right = current.left;
            current.left = node;
            current.color = node.color;
            node.color = RED;
            return current;
        }

        public void printTree() {
            printTree(root);
        }

        // Печать дерева
        private void printTree(Node node) {
            if (node == null)
                return;
            printTree(node.right);

            if (node.color == RED)
                System.out.println("\033[31m" + node.key + "\033[0m");
            else
                System.out.println("\033[30m" + node.key + "\033[0m");

            printTree(node.left);
        }


        public boolean find(int key) {
            return find(root, key);
        }

        // Поиска элемента в дереве
        private boolean find(Node node, int key) {
            if (node == null)
                return false;

            if (key < node.key)
                return find(node.left, key);
            else if (key > node.key)
                return find(node.right, key);
            else
                return true;
        }

    }
