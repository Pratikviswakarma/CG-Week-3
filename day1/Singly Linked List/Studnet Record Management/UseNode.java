class Node{
    int rollNumber;
    String name;
    int age;
    char grade;
    Node next;
    public Node(int rollNumber,String name,int age,char grade){
        this.rollNumber=rollNumber;
        this.name=name;
        this.age=age;
        this.grade=grade;
        this.next=null;
    }
}
class Operations{
    Node head=null;

    public void addAtFirst(int rollnumber,String name,int age,char grade){
        Node f=new Node(rollnumber, name, age,grade);
        f.next=head;
        head=f;
    }
    public void addAtEnd(int rollnumber,String name,int age,char grade){
        Node n=new Node(rollnumber, name, age,grade);
        if(head==null)
        {
        head=n;
        }else{
            Node temp=head;
            while (temp!=null) {
                temp=temp.next;
            }
            temp=n;
        }
    }

    public void addAtPosition(int rollNumber,String name,int age,char grade,int postion){
        Node n=new Node(rollNumber, name, age,grade);
        Node temp=head;
        int index=0;
        if(postion==0){
            n.next=head;
            head=n;
        }
        while(temp!=null && index<postion-1){
            index++;
            temp=temp.next;
        }
        if(temp!=null){
            n.next=temp.next;
            temp.next=n;
        }else{
            System.out.println("Invalid postion");
        }
    }

    public void dispaly(){
        Node temp=head;
        while (temp!=null) {
            System.out.println("Roll number is "+temp.rollNumber);
            System.out.println("Name is "+temp.name);
            System.out.println("Age is "+temp.age);
            System.out.println("Grade is "+temp.age+"\n");
            temp=temp.next;
        }
    }

   // Delete a student record by Roll Number
   public void deleteByRollNumber(int rollNumber)
   {
       if (head == null)
       {   System.out.println("List is empty");
           return;
       }

       if (head.rollNumber == rollNumber)
       {
           head = head.next;
           return;
       }

       Node temp = head;
       while (temp.next != null && temp.next.rollNumber != rollNumber)
       {
           temp = temp.next;
       }

       if (temp.next != null)
       {
           temp.next = temp.next.next;
       }
       else
       {
           System.out.println("Student with roll number " + rollNumber + " not found");
       }
   }

    public void search(int rollNumber){
        Node temp=head;
        boolean flag=false;
        while (temp!=null) {
            if(temp.rollNumber==rollNumber){
                System.out.println("Roll number is "+temp.rollNumber);
                System.out.println("Name is "+temp.name);
                System.out.println("Age is "+temp.age);
                System.out.println("Grade is "+temp.age);
                flag=true;
                break;
            }   
            temp=temp.next;
        }
        if(flag==false){
            System.out.println("Student not Found ");
        }
    }

    public void update(int rollNumber,char grade){
        Node temp=head;
        boolean flag=false;
        while (temp!=null) {
            if(temp.rollNumber==rollNumber){
                temp.grade=grade;
                flag=true;
                break;
            }   
            temp=temp.next;
        }
        if(flag==false){
            System.out.println("Student not Found ");
        }
    }


}

public class UseNode{
    public static void main(String[] args) {
        Operations ob=new Operations();
        ob.addAtFirst(101, "Sudeep", 21, 'B');
        ob.addAtEnd(102, "Abhisek", 18, 'A');
        ob.addAtPosition(103, "Neeraj", 19, 'A', 1);
        ob.dispaly();
        ob.deleteByRollNumber(103);
        ob.search(101);
        ob.update(101, 'A');
        ob.dispaly();
    }
}