import java.util.Scanner;
public class baion1{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        LinkedList list = new LinkedList();
        
        while(true){
            System.out.println("\n------------------Menu-------------------");
            System.out.println("1.Nhap Danh Sach");
            System.out.println("2.Tim Kiem");
            System.out.println("3.Thoat");
            System.out.print("Nhap Lua Chon: ");
            int chon = input.nextInt();
            
            switch(chon){
                case 1: 
                    list.NhapDanhSach();
                    break;
                case 2: 
                    list.SearchForX();
                    break;
                case 3: 
                    list.Display();
                    break;
                case 4: 
                    System.exit(0);
            }

        }
    }
}


class Node
{
    private int sott;
    private String tennguoi;
    private Node link;

    public Node(int sott, String tennguoi){
        this.sott = sott;
        this.tennguoi = tennguoi;
        link = null;
    }

    public void setLink(Node link){
        this.link = link;
    }

    public Node getLink(){
        return link;
    }

    public int getSott(){
        return sott;
    }

    public String getTen(){
        return tennguoi;
    }
}
class LinkedList
{
    private Node start;
    private Node end ;
    private int size ;

    public LinkedList(){
        start = null;
        end = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    //Kiem Tra X Co Trong Danh Sach Hay k ?
    public void SearchForX(){
        Scanner input = new Scanner(System.in);
        System.out.print("Moi Ban Nhap X : ");
        int x = input.nextInt();
        Node node = start;
        if(SearchForX(x, node))
            System.out.println("Tim Thay" + x + " Trong Danh Sach Lien Ket");
        else
            System.out.println("Ko Tim Thay");

    }

    private boolean SearchForX(int x, Node node){
        boolean find = false;
        if(size != 0){ 
            for(int i = 1 ; i <= size ; i++){
                if(node.getSott() == x){
                    find = true;
                    break;
                }
                node = node.getLink();
            }   
        }

        return find;
    }

    public void NhapDanhSach(){
        Scanner input = new Scanner(System.in);
        System.out.print("Ban Muon Nhap Bao Nhieu Nguoi: ");
        int n = input.nextInt();
        for(int i = 1 ; i <= n ; i++){
            System.out.println("Nhap Nguoi Thu " + i);
            System.out.print("Nhap So TT: ");
            int sott = input.nextInt();
            System.out.print("Nhap Ten : ");
            String ten = input.next();
            InsertAtStart(sott, ten);
        }
    }

    public void InsertAtStart(int sott, String tennguoi){
        Node node = new Node(sott, tennguoi);
        size++;
        if(start == null){
            start = end = node;
        }else{
            node.setLink(start);
            start = node;
        }
    }

    public void Display(){
        if(size == 0)
            System.out.println("Danh Sach Rong"); 
        else{
            Node node = start;
            for(int i = 1 ; i <= size ; i++){
                System.out.print(node.getSott() + "->");
                node = node.getLink();
            }
        }
    }
}
