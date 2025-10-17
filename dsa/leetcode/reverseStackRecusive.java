/**
 *  https://www.geeksforgeeks.org/problems/reverse-a-stack/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reverse-a-stack
 */

public class reverseStackRecusive {
    static void reverse(Stack<Integer> s) {
        // base case:- if stack is empty or stack size is = 1 (as it's can't be reverse)
        if (s.isEmpty() || s.size() == 1) {
            return;
        }

        //extract top
        int top = s.pop();

        // recursively extract top utill the base case
        reverse(s);

        //insert the top to bottom
        insertToBottom(s, top);

        return;
    }

    static void insertToBottom(Stack<Integer> s, int element) {
        // base case:- stack id empty
        if (s.isEmpty()) {
            s.push(element);
            return;
        }

        // stack holds element
        int top = s.pop();

        //push  that element to bottom
        insertToBottom(s, element);

        // push the top
        s.push(top);

        return;
    }
}