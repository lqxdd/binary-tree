public class Tree {
    Node root;

    public void add(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (data < focusNode.data) {
                    focusNode = focusNode.left;
                    if (focusNode == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.right;
                    if (focusNode == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void sort(Node focusNode) {
        if (focusNode != null) {
            sort(focusNode.left);
            System.out.println(focusNode);
            sort(focusNode.right);
        }
    }

    public Node findNode(int data) {
        Node focusNode = root;
        while (focusNode.data != data) {
            if (data < focusNode.data) {
                focusNode = focusNode.left;
            } else {
                focusNode = focusNode.right;
            }
            if (focusNode == null)
                return null;
        }
        return focusNode;
    }

    public boolean remove(int data) {
        Node focusNode = root;
        Node parent = root;
        boolean isItALeftChild = true;
        while (focusNode.data != data) {
            parent = focusNode;
            if (data < focusNode.data) {
                isItALeftChild = true;
                focusNode = focusNode.left;
            } else {
                isItALeftChild = false;
                focusNode = focusNode.right;
            }
            if (focusNode == null)
                return false;
        }
        if (focusNode.left == null && focusNode.right == null) {
            if (focusNode == root)
                root = null;
            else if (isItALeftChild)
                parent.left = null;
            else
                parent.right = null;
        } else if (focusNode.right == null) {
            if (focusNode == root)
                root = focusNode.left;
            else if (isItALeftChild)
                parent.left = focusNode.left;
            else
                parent.right = focusNode.left;
        } else if (focusNode.left == null) {
            if (focusNode == root)
                root = focusNode.right;
            else if (isItALeftChild)
                parent.left = focusNode.right;
            else
                parent.right = focusNode.right;
        } else {
            Node replacement = getReplacementNode(focusNode);
            if (focusNode == root)
                root = replacement;
            else if (isItALeftChild)
                parent.left = replacement;
            else
                parent.right = replacement;
            replacement.left = focusNode.left;
        }
        return true;
    }

    public boolean removeNegative(int data) {
        Node focusNode = root;
        Node parent = root;
        boolean isItALeftChild = true;
        while (focusNode.data > 0) {
            parent = focusNode;
            if (data < focusNode.data) {
                isItALeftChild = true;
                focusNode = focusNode.left;
            } else {
                isItALeftChild = false;
                focusNode = focusNode.right;
            }
            if (focusNode == null)
                return false;
        }
        if (focusNode.left == null && focusNode.right == null) {
            if (focusNode == root)
                root = null;
            else if (isItALeftChild)
                parent.left = null;
            else
                parent.right = null;
        } else if (focusNode.right == null) {
            if (focusNode == root)
                root = focusNode.left;
            else if (isItALeftChild)
                parent.left = focusNode.left;
            else
                parent.right = focusNode.left;
        } else if (focusNode.left == null) {
            if (focusNode == root)
                root = focusNode.right;
            else if (isItALeftChild)
                parent.left = focusNode.right;
            else
                parent.right = focusNode.right;
        } else {
            Node replacement = getReplacementNode(focusNode);
            if (focusNode == root)
                root = replacement;
            else if (isItALeftChild)
                parent.left = replacement;
            else
                parent.right = replacement;
            replacement.left = focusNode.left;
        }
        return true;
    }


    public Node getReplacementNode(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
        Node focusNode = replacedNode.right;
        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.left;
        }
        if (replacement != replacedNode.right) {
            replacementParent.left = replacement.right;
            replacement.right = replacedNode.right;
        }
        return replacement;
    }
}
