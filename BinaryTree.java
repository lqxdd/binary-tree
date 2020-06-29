public class BinaryTree {
    public static void main(String[] args) throws InterruptedException {
//              50
//            /    \
//          10      66
//          / \     / \
//        -11  23  59  71
//        /
//      -24
        Tree tree = new Tree();
        tree.add(50);
        tree.add(-11);
        tree.add(71);
        tree.add(59);
        tree.add(-24);
        tree.add(10);
        tree.add(66);
        tree.add(23);
        System.out.println("New Tree: "); Thread.sleep(3000);
        tree.sort(tree.root);
        System.out.println("Looking for element with node  10... "); Thread.sleep(3000);
        System.out.println(tree.findNode(10)+ " is found ");
        System.out.println("Deleting 59 and 23..."); Thread.sleep(3000);
        tree.remove(59); tree.remove(23);
        System.out.println("New Tree: "); Thread.sleep(3000);
        tree.sort(tree.root);
        System.out.println("Deleting all negative numbers..");
        tree.removeNegative(0); tree.removeNegative(0);
        System.out.println("New Tree: "); Thread.sleep(3000);
        tree.sort(tree.root);
        Thread.sleep(1500);
        System.out.println(" ");
    }}
