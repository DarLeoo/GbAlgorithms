public class Main {
    public static void main(String[] args) {

                RedBlackTree tree = new RedBlackTree();

                // Добавляем узлы в дерево
                for (int i = 2; i < 100; i+=5) {
                    tree.insert(i);
                }
                tree.insert(33);

                // Выводим дерево в порядке in-order
                tree.printTree();

                System.out.println("Есть ли заданное числов в дереве: " + tree.find(33)); 
            }
        }

