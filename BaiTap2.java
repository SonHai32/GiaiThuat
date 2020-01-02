import java.util.Scanner;
public class BaiTap2{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        LinkedList list = new LinkedList();
        while(true){
            System.out.println("\n----------------Menu---------------"); 
            System.out.println("1.Chen Phan Tu Dau DSLK");
            System.out.println("2.Chen Phan Tu Cuoi DSLK");
            System.out.println("3.Chen Phan Tu Tai Vi Tri x");
            System.out.println("6.Xuat Cac Node Cua DSLK");
            System.out.println("17.Thoat Chuong Trinh");
            System.out.print("Moi Ban Nhap Lua Chon: ");
            int chon = input.nextInt();

            switch(chon){
                case 1: list.nhapVaoDauDS();
                        break;
                case 2: list.nhapVaoCuoiDS();
                        break;
                case 3: System.out.print("Nhap vi tri: ");
                        int position = input.nextInt();
                        System.out.print("Nhap Gia Tri Cho Node: ");
                        int val = input.nextInt();
                        list.InsertAtPos(position, val);
                        break;
                case 4: System.out.println(list.getSize());
                        break;
                case 6: list.showNodeList();
                        break;
                case 17: System.exit(0);
            }
        }
    }
    
}

class Nodes{
    private int data;
    private Nodes link;

    public Nodes(int value, Nodes n){
        data = value;
        link = n;
    }

    public void setLink(Nodes n){
        link = n;
    }

    public Nodes getLink(){
        return link;
    }
    
    public int getData(){
        return data;
    }
}

class LinkedList{
    private Nodes start;
    private Nodes end;
    private int size = 0;

    public LinkedList(){
        start = null;
        end = null;
    }

    public void InsertAtStart(int value){
        Nodes node = new Nodes(value, null);
        size++;
        if(start == null){
            start = end = node;
        }else{
            node.setLink(start);
            start = node;
        }
    }

    public void InsertAtEnd(int value){
        Nodes node = new Nodes(value, null);
        size++;

        if(start == null){
            start = node;
            end = start;
        }
        else{
            end.setLink(node);
            end = node;
        }
    }

    public void InsertAtPos(int k, int value){
        Nodes insertNode = new Nodes(value, null);
        Nodes viTriTruocInsert = start;
        if(k > size || k < 0){
            System.out.println("Vi Tri Nhap Sai !!!");
            return;
        }
        if(k == 1)
            InsertAtStart(value);
        else if(k == size)
            InsertAtEnd(value);
        else{
            k = k - 1; 
            for ( int i = 1 ; i < size ; i++){
                if(i == k){
                    Nodes viTriSauInsert = viTriTruocInsert.getLink();
                    viTriTruocInsert.setLink(insertNode);
                    insertNode.setLink(viTriSauInsert);
                    break;
                }   
                viTriTruocInsert = viTriTruocInsert.getLink();
            }
        }
        size++;
    }

    public void DeleteAtStart(){
        start = start.getLink();
        size--;
        return;
    }

    public void DeleteAtEnd(){
        Nodes tmp1 = start;
        Nodes tmp2 = start;
        while(tmp1 != end){
            tmp2 = tmp1;
            tmp1 = tmp1.getLink();
        }
        end = tmp2;
        end.setLink(null);
        size--;
        return;
    }

    public void DeleteAtPos(int pos){
        if(pos == 1){
            DeleteAtStart();
            return;
        }else if(pos == size){
            DeleteAtEnd();
            return;
        }else{
            pos = pos - 1;
            Nodes ptr = start;
            for(int i = 1 ; i < size - 1 ; i++){
                if(pos == i){
                    Nodes tmp = ptr.getLink();
                    tmp = tmp.getLink();
                    ptr.setLink(tmp);
                    break;
                }
            }
            size--;
        }
    }

    public int getSize(){
        return size;
    }

    public void showNodeList(){
        System.out.println("\nDanh Sach Cac Node");
        Nodes node = start;

        if(start == null){
            System.out.println("Danh Sach Rong");
            return;
        }
        while(node != null){
            System.out.print(node.getData() + "->");
            node =  node.getLink();
        }
    }

    public void nhapVaoDauDS(){
        Scanner input = new Scanner(System.in);
        System.out.print("Ban Muon Tao May Node: ");
        int n = input.nextInt();
        for(int i = 1 ; i <= n; i++){
            System.out.print("Moi Ban Nhap Gia Tri Cho Node: ");
            int x = input.nextInt();
            InsertAtStart(x);
        }
    }

    public void nhapVaoCuoiDS(){
        Scanner input = new Scanner(System.in);
        System.out.print("Ban Muon Tao May Node: ");
        int n = input.nextInt();
        for(int i = 1 ; i <= n; i++){
            System.out.print("Nhap Gia Tri Cho Node: ");
            int x = input.nextInt();
            InsertAtEnd(x);
        }
    }



}





