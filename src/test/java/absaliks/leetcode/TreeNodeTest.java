package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class TreeNodeTest {
            /*1


lvl	sz	lC	mI
1	1	1	0
2	3	2	1
3	7	4	3
4	15	8	7
5	31	16	15
6	63	32	31
7	127	64	63
8	255	128	127

              Expected :{{2} ← 1 → {3}}
              Actual   :{1 → {2}}
              */

    public record TreeNode(int val, TreeNode left, TreeNode right) {

        public static TreeNode of(Integer value) {
            return value != null ? new TreeNode(value, null, null) : null;
        }

        public static TreeNode of(Integer... values) {

            int depth = getDepth(values.length);
            TreeNode[] nodes = new TreeNode[nodesCountAtLevel(depth)];
            for (int y = depth; y > 0; y--) {
                int count = nodesCountAtLevel(y);
                int valueDelta = treeSize(y - 1);
                for (int wCursor = 0; wCursor < count; wCursor++) {
                    if (y < depth) {
                        var left = nodes[wCursor * 2];
                        var right = nodes[wCursor * 2 + 1];
                        nodes[wCursor] = new TreeNode(values[wCursor + valueDelta], left, right);
                    } else
                        nodes[wCursor] = TreeNode.of(values[wCursor + valueDelta]);
                }
            }
            return nodes[0];
        }

        @Override
        public String toString() {
            var ls = left == null ? "" :  left + " ← ";
            var rs = right == null ? "" :  " → " + right;
            return "{" + ls + val + rs + '}';
        }
    }

    @Test
    void name() {
        System.out.println("lvl\tsz\tlC\tmI");
        IntStream.range(1, 9).forEach(depth -> {
            var nodes = treeSize(depth);
            assertEquals(depth, getDepth(nodes));
            int countAtLevel = nodesCountAtLevel(depth);
            System.out.println(depth + "\t" + nodes + "\t"  + countAtLevel + "\t"  + minIndex(depth));
        });
    }

    private static int minIndex(int depth) {
        return depth == 0 ? 0 : treeSize(depth - 1);
    }

    private static int treeSize(int depth) {
        return (int) Math.pow(2, depth) - 1;
    }

    private static int nodesCountAtLevel(int depth) {
        return (int) Math.pow(2, depth - 1);
    }

    private static int getDepth(double nodes) {
        return (int) Math.floor(Math.log(nodes) / Math.log(2)) + 1;
    }

    @Test void depth2_complete() {
        assertEquals(tree(1, 2, 3), TreeNode.of(1, 2, 3));
    }

    @Test void depth2_noLeft() {
        assertEquals(tree(1, null, 3), TreeNode.of(1, null, 3));
    }

    @Test void depth2_noRight() {
        assertEquals(tree(1, 2, null), TreeNode.of(1, 2, null));
    }

    @Test void depth3_complete() {
        var middleLeft = tree(2, 4, 5);
        var middleRight = tree(3, 6, 7);
        var expectedRoot = tree(1, middleLeft, middleRight);

        assertEquals(expectedRoot, TreeNode.of(1,2,3,4,5,6,7));
        System.out.println(expectedRoot);
    }

    @Test void depth4_partial() {
        var level3a = tree(11, 7, 2);
        var level3c = TreeNode.of(13);
        var level3d = tree(4, null, 1);

        var level2Left = tree(4, level3a, null);
        var level2Right = tree(8, level3c, level3d);
        var expectedRoot = tree(5, level2Left, level2Right);

        TreeNode actual = TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1);
        assertEquals(expectedRoot, actual);
        System.out.println(expectedRoot);
    }

    private static TreeNode tree(int root) {
        return new TreeNode(root, null, null);
    }

    private static TreeNode tree(int root, Integer left, Integer right) {
        return new TreeNode(root, TreeNode.of(left), TreeNode.of(right));
    }

    private static TreeNode tree(int root, TreeNode left, TreeNode right) {
        return new TreeNode(root, left, right);
    }
}