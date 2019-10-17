/*

Space Complexity - O(n)
T.C. to create - O(nlogn)
T.C. to update - O(logn)
T.C. to get prefix sum - O(logn)
*/

public class fenwickTree {

	/*
	For updating the value in tree, we start from index + 1 and we keep adding the value for next nodes,
	till we reach an outside range of trees.
	*/

	public void updateBinaryIndexedTree(int binaryIndexedTree[], int val, int index) {
		while (index < binaryIndexedTree.length) {
			binaryIndexedTree[index] += val; // adding to original value in node
			index = getNext(index); // getting next index

		}
	}

	/*
	To get sum from (0, index), we start from index + 1 node and keep going up
	via parent to reach 0.
	*/

	public int getSum(int binaryIndexedTree[], int index) {
		index = index + 1;
		int sum = 0;
		while (index > 0) {
			sum = sum + binaryIndexedTree[index];
			index = getParent(index);
		} 
		return sum;
	}

	/*
	Creating the Fenwick tree is like updating fenwick tree for every value in the array.
	*/

	public int[] createTree(int[] input) {
		int binaryIndexedTree[] = new int[input.length + 1];
		for (int i=1; i<= input.length; i++) {
			updateBinaryIndexedTree(binaryIndexedTree, input[i-1], i); // 0th index value of input, will be stored at 1
		}
		return binaryIndexedTree;
	}

	/*
	To get parent 
	1) Get 2's complement (Flip all bits and add 1) (minus of index)
	2) AND it with current INDEX
	3) SUBTRACT it from the index
	*/

	public int getParent(int index) {
		return index - (index & -index);
	}

	/*
	To get next
	1) Get 2's complement (minus of index)
	2) AND it with current INDEX
	3) ADD it to the index
	*/

	public int getNext(int index) {
		return index + (index & -index);
	}

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7};
		fenwickTree ft = new fenwickTree();
		int[] binaryIndexedTree = ft.createTree(input);
		assert 1 == ft.getSum(binaryIndexedTree, 0);
		assert 3 == ft.getSum(binaryIndexedTree, 1);
		assert 6 == ft.getSum(binaryIndexedTree, 2);
	}
}