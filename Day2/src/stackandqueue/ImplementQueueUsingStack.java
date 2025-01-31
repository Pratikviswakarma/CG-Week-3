package stackandqueue;

import java.util.Stack;

public class ImplementQueueUsingStack {
    Stack<Integer> s=new Stack<>();
    Stack<Integer> s2=new Stack<>();

    public void enqueue(int ele){
        s.push(ele);
    }

    public int dequeue(){
        int temp;
       while(!s.isEmpty()){
           s2.push(s.pop());
       }
         temp= s2.peek();
         s2.pop();
        while(!s2.isEmpty())
        {
            s.push(s2.pop());
        }
        return temp;
    }

    public static void main(String[] args) {
        ImplementQueueUsingStack iqs=new ImplementQueueUsingStack();
        iqs.enqueue(10);
        iqs.enqueue(20);
        iqs.enqueue(30);
        iqs.enqueue(40);
        System.out.println(iqs.dequeue());
        System.out.println(iqs.dequeue());
        System.out.println(iqs.dequeue());
        System.out.println(iqs.dequeue());

    }
}
