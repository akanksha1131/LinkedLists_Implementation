import java.util.*;
public class Lists {
    static class Node {
        int data;
        Node next;
        Node head;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    static class DLL {

        Node head;

//         static class Node {
//             int data;
//             Node next;
//             Node head;
//             Node prev;
//
//             Node(int data) {
//                 this.data = data;
//                 this.next = null;
//                 this.prev = null;
//             }
//         }

        public static DLL append(DLL list, int data1) {
            int data = data1;
            Node last = list.head;
            Node new_node = new Node(data);
            if (list.head == null) {
                list.head = new_node;

            } else if (last.next == null) {
                last.next = new_node;
                new_node.prev = last;
                new_node.next = null;

            } else {

                while (last.next != null) {
                    last = last.next;
                }
                last.next = new_node;
                new_node.prev = last;
                new_node.next = null;
            }
            return list;
        }

        public static DLL insertathead(DLL list, int data1) {
            int data = data1;
            Node new_node = new Node(data);

            //if list.head==null
            //if list.head.next==null
            // else
            if (list.head == null) {
                list.head = new_node;
            } else if (list.head.next == null) {
                Node last = list.head;
                last.next = new_node;
                new_node.prev = last;
                new_node.next = null;
            } else {
                Node last = list.head;
                last.prev = new_node;
                new_node.next = last;
                list.head = new_node;
                new_node.prev = null;
            }
            return list;
        }

        public static DLL insertatend(DLL list, int data1) {

            // list.head=null
            // list.head.next=null
            int data = data1;
            Node new_node = new Node(data);
            Node last = list.head;
            if (list.head == null) {
                list.head = new_node;
            } else {
                while (last.next != null) {
                    last = last.next;
                }
                last.next = new_node;
                new_node.prev = last;
                new_node.next = null;
            }

            return list;
        }

        public static DLL addbydata(DLL list, int datanode, int datanewnode) {


            Node new_node = new Node(datanewnode);
            Node last = list.head;
            if (list.head == null) {
                System.out.println("Empty list");

            } else {
                while (last.data != datanode && last.next != null) {
                    last = last.next;
                }
                if (last.data == datanode && last.next == null) {
                    //chosen node is last node
                    last.next = new_node;
                    new_node.prev = last;
                    new_node.next = null;
                } else if (last.data != datanode && last.next == null) {
                    System.out.println("Data entered is not present in anynode of linked list");
                } else {
                    new_node.next = last.next;
                    last.next.prev = new_node;
                    last.next = new_node;
                    new_node.prev = last;
                }
            }
            return list;
        }

        public static DLL addbyposition(DLL list, int data1, int position,
                                        int cardinality) {
            //position>cardinality
            //position=1 or position=last
            Node new_node = new Node(data1);
            Node last = list.head;
            if (position > cardinality) {
                System.out.println("Position out of bounds");
            } else if (position == 1) {
                last.next = list.head;
                list.head.prev = last;
                last.prev = null;
                list.head = last;
            }
            // after oosition, node to be added
            else {
                int counter = 1;
                while (counter != position && last.next != null) {
                    last = last.next;
                    counter++;
                }
                if (counter == position) {
                    new_node.next = last.next;
                    last.next.prev = new_node;
                    new_node.prev = last;
                    last.next = new_node;
                }

            }

            return list;
        }

        public static DLL deletebydata(DLL list, int datanode) {

            Node last = list.head;
            if (list.head == null) {
                System.out.println("Empty list");

            } else {
                while (last.data != datanode && last.next != null) {
                    last = last.next;
                }
                if (last.data == datanode && last.next == null) {
                    list.head = null;
                } else if (last.data == datanode && last.next.next == null) {
                    last.prev.next = last.next;
                    last.next.prev = last.prev;
                    last.next = null;
                    last.prev = null;
                } else if (last.data != datanode && last.next == null) {
                    System.out.println("Data entered is not present in any node of linked list");
                } else {
                    last.prev.next = last.next;
                    last.next.prev = last.prev;
                    last.next = null;
                    last.prev = null;
                }
            }
            return list;
        }

        public static DLL deletebyposition(DLL list, int position, int
                cardinality) {
            Node last = list.head;
            if (position > cardinality) {
                System.out.println("Position out of bounds");
            }
            // only head node exists
            if (position == 1 && list.head.next == null) {
                list.head = null;
            }
            //delete head node
            else if (position == 1 && list.head.next != null) {
                list.head = list.head.next;
                list.head.prev = null;
                last.next = null;
                last.next = null;
            }
            //delete last node
            else if (position == cardinality) {
                while (last.next.next != null) {
                    last = last.next;

                }
                last.next.prev = null;
                last.next = null;
            } else {
                int counter = 1;
                while (counter != position - 1) {
                    last = last.next;
                    counter++;
                }
                Node del = last.next;
                last.next = del.next;
                del.next.prev = last;
                del.next = null;
                del.prev = null;
            }
            //delete in between

            return list;
        }

        public static int cardinality(DLL list) {
            int card = 1;
            Node last = list.head;
            if (list.head == null) {
                card = 0;
            } else if (list.head.next == null) {
                card = 1;
            } else {
                while (last.next != null) {
                    card++;
                    last = last.next;
                }
            }

            return card;
        }

        public static void reverse(DLL list) {
            System.out.println("--------------------------------------");
            Node last = list.head;
            if (list.head == null) {
                System.out.println("empty list");
            } else if (list.head.next == null) {
                System.out.println("[" + last.data + "]");
            } else {
                while (last.next != null) {
                    last = last.next;
                }
                while (last != null) {
                    System.out.print("[" + last.data + "]");
                    last = last.prev;
                }

            }
            System.out.println("--------------------------------------\n");
        }

        public static void print(DLL list) {
            int counter = 1;
            Node last = list.head;
            if (last == null) {
                System.out.print("Empty list in print method");
                System.out.println();
            } else {
                System.out.println("--------------------------------------");
                while (last != null) {
                    System.out.print("[" + last.data + "]");
                    last = last.next;
                    counter++;

                }
                System.out.println();
                System.out.println("--------------------------------------");
            }
        }


    }


    static class LinkedList {
        Node head;

//        static class Node {
//            int data;
//            Node next;
//
//            Node(int data) {
//                this.data = data;
//                this.next = null;
//            }
    }
    //inserting using data
    public static LinkedList insertathead(LinkedList list,int data1){
        int data=data1;
        Node new_node=new Node(data);
        if(list.head==null){
            list.head=new_node;
        }
        else{
            new_node.next=list.head;
            list.head=new_node;
        }
        return list;

    }
    public static LinkedList insertatend(LinkedList list,int data1){
        int data=data1;
        Node new_node=new Node(data);
        if(list.head==null){
            list.head=new_node;
        }
        else{
            Node last=list.head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=new_node;

        }
        return list;
    }




    public static LinkedList insert(LinkedList list, int data){

        Node new_node=new Node(data);
        if(list.head==null){
            list.head=new_node;
        }
        else{
            Node last=list.head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=new_node;
        }
        return list;
    }
    //inserting node AFTER a specific node whose data is given
    public static LinkedList addbydata(LinkedList list, int data1, int
            node_data1){
        int  data=data1;
        int node_data=node_data1;
        Node new_node=new Node(data);
        Node last=list.head;

        if(list.head==null){
            list.head=last;
        }
        else  {
            while (last.data != node_data && last.next.next!=null) {
                last = last.next;
            }
            if(last.next.next==null&& last.next.data == node_data){
                last=last.next;
                new_node.next = last.next;
                last.next = new_node;
            }
            else if(last.next.next==null&& last.next.data != node_data){
                System.out.println("Data entereed is not present in linked list");
            }
            else {
                new_node.next = last.next;
                last.next = new_node;
            }

        }


        return list;

    }
    public static int numberofnodes(LinkedList list){
        int num=1;
        Node last=list.head;
        if(list.head==null){
            num=0;
        }
        else{
            while(last.next!=null)  {
                last=last.next;
                num++;
            }
        }
        return num;
    }
    public static LinkedList addbyposition(LinkedList list, int data1,
                                           int position,int card1){
        int data=data1;
        int cardinality=card1;

        Node new_node=new Node(data);
        if(position>cardinality){
            System.out.println("Position out of bounds");
        }
        else if(list.head==null){
            list.head=new_node;
        }
        else if(position==1){
            new_node.next=list.head;
            list.head=new_node;
        }
        else if(position==cardinality){
            Node last=list.head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=new_node;
        }
        else{
            Node last=list.head;
            int counter=1;
            while(counter!=position){
                last=last.next;
                counter++;

            }
            new_node.next=last.next;
            last.next=new_node;

        }
        ;        return list;
    }
    public static LinkedList deletebyposition(LinkedList list,int
            position1,int card1){
        int position=position1;
        int cardinality=card1;
        Node last=list.head;    ///

        if(position>cardinality){
            System.out.println("Position out of bounds");
        }
        else if(position==1){

            list.head=last.next;
            last.next=null;
        }
        else  if(position==cardinality){


            int counter=1;
            while(counter!=position-1){
                last=last.next;
                counter++;

            }
            last.next=null;
        }
        else{

            int counter=1;
            while(counter!=position-1){
                last=last.next;
                counter++;
            }
            Node del=last.next;
            last.next=del.next; //
            del.next=null;

        }

        return list;
    }

    public static void printlist(LinkedList list){
        Node current_node=list.head;
        System.out.println("-------------------------------------------");
        while(current_node!=null){
            System.out.print("["+current_node.data+" "+"]");
            current_node=current_node.next;

        }
        System.out.println();
        System.out.println("-------------------------------------------");
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\nEnter choice:\n1. Doubly LinkedList Operations\n2. Singly LinkedList Operations\n3. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Doubly Linked List Operations:");
                    DLL list1 = new DLL();
                    int ch, number_of_elements, data;
                    do {

                        System.out.print("Enter choice : \n(1) Append or Create\n(2) Insert at head \n(3) Insert at end \n(4) Add by data \n(5) Add by position \n(6) Delete by data \n(7) Delete by position \n(8) Reverse \n(9) Print \n(10)Exit  ");
                        ch = sc.nextInt();
                        switch (ch) {
                            case 1:
                                System.out.println("How many nodes do you want to add ?");
                                number_of_elements = sc.nextInt();
                                for (int i = 0; i < number_of_elements; i++) {
                                    System.out.println("Give data of node");
                                    data = sc.nextInt();
                                    ;
                                    list1 = list1.append(list1, data);
                                }
                                list1.print(list1);
                                break;
                            case 2:
                                System.out.println("Give data of node");
                                data = sc.nextInt();
                                ;
                                list1 = list1.insertathead(list1, data);
                                list1.print(list1);
                                break;
                            case 3:
                                System.out.println("Give data of node");
                                data = sc.nextInt();
                                ;
                                list1 = list1.insertatend(list1, data);
                                list1.print(list1);
                                break;
                            case 4:
                                System.out.println("Give data of node after which new node is to be added");
                                int dataofnode = sc.nextInt();
                                System.out.println("Give data of new node");
                                data = sc.nextInt();
                                list1 = list1.addbydata(list1, dataofnode, data);
                                list1.print(list1);
                                break;
                            case 5:
                                System.out.println("Give position after which new node is to be added");
                                int position = sc.nextInt();
                                ;
                                System.out.println("Give data of node");
                                data = sc.nextInt();
                                ;
                                list1 = list1.addbyposition(list1, data, position, list1.cardinality(list1));
                                list1.print(list1);
                                break;
                            case 6:
                                System.out.println("Give data of node to be deleted");
                                data = sc.nextInt();
                                ;
                                list1 = list1.deletebydata(list1, data);
                                list1.print(list1);
                                break;
                            case 7:
                                System.out.println("Give position of node to be deleted");
                                int position1 = sc.nextInt();
                                ;
                                list1 = list1.deletebyposition(list1, position1, list1.cardinality(list1));
                                list1.print(list1);
                                break;
                            case 8:
                                list1.reverse(list1);
                                break;
                            case 9:
                                list1.print(list1);
                                break;
                            case 10:
                                System.out.print("Exiting Doubly Linked List Operations ");
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;

                        }
                    }
                    while (ch != 10);

                    break;
                case 2:
                    System.out.println("\nSingly Linked List Operations:");
                    LinkedList list2 = new LinkedList();
                    int ch2 = 0;
                    int card1;
                    do {
                        System.out.println("Enter choice: \n1.Exit \n2.Create or insert node \n3.Insert at head \n4.Insert at end " + "\n5.Add using data \n6.Add by position \n7.Show cardinality \n8.Delete by position\n9.Print list");
                        ch2 = sc.nextInt();
                        switch (ch2) {
                            case 1:
                                System.out.print("Exiting Singly Linked List Operations ");
                                break;
                            case 2:
                                System.out.print("How many nodes do you want to insert ?");
                                card1 = sc.nextInt();
                                for (int i = 0; i < card1; i++) {
                                    System.out.print("Inserting node, give data: ");
                                    int data2 = sc.nextInt();
                                    list2 = insert(list2, data2);
                                }

                                printlist(list2);
                                break;
                            case 3:
                                System.out.print("Inserting node at list head, give data: ");

                                int data3 = sc.nextInt();
                                list2 = insertathead(list2, data3);
                                printlist(list2);
                                break;
                            case 4:
                                System.out.print("Inserting node at list end, give data: ");
                                int data4 = sc.nextInt();
                                list2 = insertatend(list2, data4);
                                printlist(list2);
                                break;
                            case 5:
                                printlist(list2);
                                System.out.print("Add node after node whose data is:");
                                int data5 = sc.nextInt();
                                System.out.print("Data of node to be added:");
                                int datab = sc.nextInt();

                                list2 = addbydata(list2, datab, data5);
                                printlist(list2);
                                break;
                            case 6:
                                System.out.print("Add node after node whose position is: ");
                                int data6 = sc.nextInt();
                                System.out.print("Add data of new node to be added: ");
                                int data6b = sc.nextInt();
                                list2 = addbyposition(list2, data6b, data6,
                                        numberofnodes(list2));
                                printlist(list2);
                                break;
                            case 7:
                                int card = numberofnodes(list2);
                                System.out.println("Number of nodes in linked list= " + card);
                                break;
                            case 8:
                                System.out.print("Delete node which is at position: ");
                                int data7 = sc.nextInt();
                                list2 = deletebyposition(list2, data7, numberofnodes(list2));
                                printlist(list2);
                                break;
                            case 9:
                                printlist(list2);
                                break;
                            default:
                                System.out.print("Invalid choice");
                                break;
                        }
                    }
                    while (ch2 != 1);
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;

            }
        }
        while (choice != 3);
    }}