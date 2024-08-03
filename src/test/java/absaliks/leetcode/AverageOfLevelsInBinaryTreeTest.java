package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

// Average of Levels in Binary Tree
// https://leetcode.com/problems/average-of-levels-in-binary-tree
// CPU 1ms | Beats 99.92%
// RAM 45.75MB | Beats 26.00%
public class AverageOfLevelsInBinaryTreeTest {
    private final ArrayList<Long> sum = new ArrayList<>();
    private final ArrayList<Integer> count = new ArrayList<>();

    // 10:55
    public List<Double> averageOfLevels(TreeNode root) {
        traverse(root, 0);

        var avg = new ArrayList<Double>(sum.size());
        for (int i = 0; i < sum.size(); i++)
            avg.add((double) sum.get(i) / count.get(i));
        return avg;
    }

    private void traverse(TreeNode node, int level) {
        if (sum.size() == level) {
            sum.add((long) node.val);
            count.add(1);
        } else {
            sum.set(level, sum.get(level) + node.val);
            count.set(level, count.get(level) + 1);
        }
        if (node.left != null) {
            traverse(node.left, level + 1);
        }
        if (node.right != null) {
            traverse(node.right, level + 1);
        }
    }

    @Test
    void example1() {
        TreeNode lower = new TreeNode(20, 15, 7);
        TreeNode upper = new TreeNode(3, new TreeNode(9), lower);

        assertEquals(doubles(3, 14.5, 11), averageOfLevels(upper));
    }

    @Test
    void example2() {
        TreeNode lower = new TreeNode(9, 15, 7);
        TreeNode upper = new TreeNode(3, lower, new TreeNode(20));

        assertEquals(doubles(3, 14.5, 11), averageOfLevels(upper));
    }

    @Test
    void example3() {
        TreeNode node = new TreeNode(2147483647, 2147483647, 2147483647);

        assertEquals(doubles(2147483647, 2147483647), averageOfLevels(node));
    }

    private List<Double> doubles(double... values) {
        return Arrays.stream(values).boxed().toList();
    }
}
