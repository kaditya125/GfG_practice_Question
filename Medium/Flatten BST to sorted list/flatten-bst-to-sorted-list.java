//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class GFG
{
    public static void printList(Node head) {
        while (head != null) {
            if (head.left != null)
                System.out.print("-1 ");
            System.out.print(head.data + " ");
            head = head.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String str = sc.nextLine();
            Node root = buildTree(str);
            Solution ob = new Solution();
            Node ans = ob.flattenBST(root);
            printList(ans);
        }
        sc.close();
    }

    private static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N')
            return null;

        String[] ip = str.split("\\s+");
        int index = 0;

        Node root = new Node(Integer.parseInt(ip[index++]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty() && index < ip.length) {
            Node currNode = queue.poll();

            String currVal = ip[index++];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            if (index >= ip.length)
                break;
            currVal = ip[index++];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
        }

        return root;
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public Node flattenBST(Node root) {
        // Code here
        Node dummy = new Node(-1);

        // Pointer to previous element
        Node[] prev = {dummy};

        // List to store the inorder traversal of the binary tree
        List<Integer> traversal = new ArrayList<>();
        inorder(traversal, root);

        // Forming the sorted list from the list obtained
        form(0, traversal, prev, dummy);

        Node ret = dummy.right;

        // Delete dummy node
        dummy = null;
        return ret;
    }

    // Inorder traversal to populate the list
    private void inorder(List<Integer> traversal, Node root) {
        if (root != null) {
            inorder(traversal, root.left);
            traversal.add(root.data);
            inorder(traversal, root.right);
        }
    }

    // Forming the sorted list from the list obtained
    private void form(int index, List<Integer> traversal, Node[] prev, Node dummy) {
        if (index < traversal.size()) {
            Node current = new Node(traversal.get(index));
            prev[0].right = current;
            prev[0] = current;
            form(index + 1, traversal, prev, dummy);
        }
    }
}
