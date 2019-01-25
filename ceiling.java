import java.util.*;

public class ceiling {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int numNodes = sc.nextInt();

        Node[] trees = new Node[n];

        int i, j;

        for (i = 0; i < n; i++)
        {
            Node root = new Node(sc.nextInt());

            for (j = 1; j < numNodes; j++)
            {
                insert(root, sc.nextInt());
            }

            trees[i] = root;
        }

        int count = 1;

        for (i = 1; i < n; i++)
        {
            for (j = 0; j < i; j++)
            {
                if (same(trees[i], trees[j]))
                    break;
            }

            if (i == j)
                count++;
        }

        System.out.println(count);
    }

    public static boolean same(Node a, Node b)
    {
        if (a == null && b == null)
            return true;

        if (a == null || b == null)
            return false;

        if (a.val != b.val)
            return false;

        if ((a.left == null && b.left != null) || (a.left != null && b.left == null))
            return false;

        if ((a.right == null && b.right != null) || (a.right != null && b.right == null))
            return false;


        return same(a.left, b.left) && same(a.right, b.right);
    }

    public static Node insert(Node root, int val) {
        if (root == null)
            return new Node(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}
