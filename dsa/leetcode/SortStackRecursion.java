/**
 *  https://www.geeksforgeeks.org/problems/sort-a-stack/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=sort-a-stack
 */

public class SortStackRecursion {

    public Stack<Integer> sort(Stack<Integer> s) {
        // base case:- stack is empty or stack size is 1 (already sorted)
        if (s.isEmpty() || s.size() == 1) {
            return s;
        }

        //extract top
        int top = s.pop();

        //recursively extract top until sorted
        sort(s);

        // insert top in its right position
        insertSorted(s, top);

        return s;
    }

    public static void insertSorted(Stack<Integer> s, int element) {
        // base case:- stack is empty or el >= top
        if (s.isEmpty() || element >= s.peek()) {
            s.push(element); // insert directly
            return;
        }

        // if el < top
         // extract top
        int top = s.pop();

        // recursively insert element in its right posotion
        insertSorted(s, element);

        // then push that top upper the sorted stack
        s.push(top);

        return;
    }
}