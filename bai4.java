import java.util.Scanner;
public class bai4{
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        LinkedList nodeList = new LinkedList();
       
                
        while(true){
            System.out.println("\n-----------------Menu--------------"); 
            System.out.println("1.Chen phan tu dau DSLK"); 
            System.out.println("2.Chen phan tu cuoi DSLK"); 
            System.out.println("3.Chen phan tu tai vi tri bat ky"); 
            System.out.println("4.Xoa phan tu tai vi tri bat ki"); 
            System.out.println("5.Tinh kich thuoc DSLK"); 
            System.out.println("6.Xuat DSLK"); 
            System.out.println("7.Tim Node Co Gia Tri Lon Nhat"); 
            System.out.println("8.Tim Node Co Gia Tri X"); 
            System.out.println("9.In Cac Node Co Gia Tri Chan"); 
            System.out.println("10.Tim Node Am Co Tri Nho Nhat"); 
            System.out.println("11.Tim Node Duong Co Gia Tri Lon Nhat"); 
            System.out.println("12.Sap Xep Tang Dan"); 
            System.out.println("13.Thoat"); 
            System.out.print("Moi Ban Nhap Lua Chon: ");
            int chon = input.nextInt();
            switch(chon){
                case 1 :
                    nodeList.nhapDauDS();
                    break;
                case 2 : 
                    nodeList.nhapCuoiDS();
                    break;
                case 3 :
                    nodeList.chenNodeVaoViTri();
                    break;
                case 4 : 
                    nodeList.DeleteNode();
                    break;
                case 5 : 
                    System.out.println("Danh Sach Lien Ket Co Kich Thuoc : " + nodeList.getSize());
                    break;
                case 6 :
                    nodeList.DisplayNodes();
                    break;
                case 7 :
                    nodeList.findMax();
                    break;
                case 8 :
                    nodeList.timNode();
                    break;
                case 9 : 
                    nodeList.DisplayEvenNodes();
                    break;
                case 10 : 
                    nodeList.FindMinNagative();
                    break;
                case 11 : 
                    nodeList.FindMaxPositive();
                    break;
                case 12 : 
                    nodeList.Sort();
                    break;
                case 13: 
                    System.exit(0);
            }
        }
    }
}

class Nodes{
    private Nodes link;
    private int data;

    public Nodes(int data, Nodes link){
        this.data = data;
        this.link = link;
    }

    public void setLink(Nodes link){
        this.link = link;
    }

    public Nodes getLink(){
        return link;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }
}

class LinkedList{
    private Nodes start;
    private Nodes end;
    private int size;

    public LinkedList(){
        start = null;     
        end = null;     
        size = 0;
    }
    
    public int getSize(){
        return size;
    }

    public void InsertAtStart(int data){
        Nodes node = new Nodes(data, null);
        
        size++;
        if(start == null){
            start = end = node;
            return;
        }

        node.setLink(start);
        start = node;
    }

    public void InsertAtEnd(int data){
        Nodes node = new Nodes(data, null); 
        size++;
        if(start == null){
            start = end = node;
            return;
        }

        end.setLink(node);
        end = node;
    }

    public void nhapDauDS(){
        Scanner input = new Scanner(System.in);
        System.out.print("Ban Muon Tao Bao Nhieu Node: ");
        int n = input.nextInt();
        
        for(int i = 1 ; i <= n ; i++){
            System.out.print("\nNhap gia tri cho node thu " + i + " : ");
            int data = input.nextInt();
            InsertAtStart(data);
        }
    }    
    public void nhapCuoiDS(){
        Scanner input = new Scanner(System.in);
        System.out.print("Ban Muon Tao Bao Nhieu Node: ");
        int n = input.nextInt();
        
        for(int i = 1 ; i <= n ; i++){
            System.out.print("\nNhap gia tri cho node thu " + i + " : ");
            int data = input.nextInt();
            InsertAtEnd(data);
        }
    } 

    public void chenNodeVaoViTri(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap vi tri can chen: ");
        int pos = input.nextInt();
        System.out.print("Nhap Gia Tri Cho Node: ");
        int value = input.nextInt();

        InsertAtPos(pos,value);

    }

    public void InsertAtPos(int pos, int data){
        if(pos == size){
            InsertAtEnd(data);
            return;
        }

        if(pos == 1){
            InsertAtStart(data);
            return;
        }
    
        if(pos < 1 || pos > size+1){
            System.out.println("Vi Tri Chen Khong Hop Le ");
            return;
        }

        size++;
        Nodes node = new Nodes(data,null);
        Nodes tmp1 = start;
        pos = pos - 1;
        
        for(int i = 1; i < size ; i++ ){
            Nodes tmp2 = tmp1.getLink();
            if(i == pos){
                tmp1.setLink(node);
                node.setLink(tmp2);
                break;
            }
            tmp1 = tmp1.getLink();
        }
    }
    
    public void DeleteAtPos(int pos){
        if(pos == 1){
            start = start.getLink();
            size--;
            return;
        }
        if(pos == size){
            Nodes tmp1 = start;
            Nodes tmp2 = start;

            while(tmp1 != end){
                tmp2 = tmp1;
                tmp1 = tmp1.getLink();
            }

            end = tmp2;
            size--;
            return;
        }
        size--;
        Nodes tmp1 = start;   
        for(int i = 1 ; i < size ; i++){
            Nodes tmp2 = tmp1.getLink(); 
            if(i == pos){
                tmp1.setLink(tmp2);
                break;
            }

            tmp1 = tmp1.getLink();
        }
    }

    public void DeleteNode(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap vi tri can xoa: ");
        int pos = input.nextInt();
        DeleteAtPos(pos);
    }
    
    public void findMax(){
       if(size == 0){    
        System.out.println("\nDanh Sach Rong");
        return;
       } 
       
       Nodes node = start;
       int max = node.getData();

       for(int i = 2 ; i <= size ; i++){
            if(node.getData() > max){
                max = node.getData();
            }
            node = node.getLink();
       }

       System.out.println("Node Co  Gia Tri Lon Nhat La: " + max);
    }

    public void findX(int x){
        if(size == 0 ){
            System.out.println("\nDanh Sach Rong");
            return;
        } 
        Nodes node = start;
        for(int i = 1 ; i <= size ; i++){
            if(node.getData() == x){
                System.out.println("Tim Thay " + x + "Trong DSLK");
                return;
            }
            node = node.getLink();
        }
        System.out.println("Khong tim thay");
    }
    
    public void timNode(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap so can tim: ");
        int x = input.nextInt();
        findX(x);
    }
    
    public void DisplayEvenNodes(){
        if(size == 0){
            System.out.println("\nDanh Sach Rong");
            return;
        }

        Nodes node = start;            
        for(int i = 1 ; i <= size ; i++){
            if((node.getData() % 2 ) == 0 ){
                System.out.print("\t" + node.getData() + "\t");
            }
            node = node.getLink();
        }
        System.out.println();
    }
    
    public void OddNodesAverage(){
        if(size == 0){
            System.out.println("\nDanh Sach Rong");
            return;
        }
        
        int sum = 0;
        int count = 0;
        Nodes node = start;

        for(int i = 1 ; i < size ; i++){
            if((node.getData() % 2 ) == 0){
                sum+=node.getData();
                count++;
            }
            node = node.getLink();
        }
        
        float Avg = sum / count;
        System.out.println("Trung Binh Cac Node Le : " + Avg);

    }

    public void FindMinNagative(){
        if(size == 0){
            System.out.println("\nDanh Sach Rong");
            return;
        }
        Nodes node = start;
        int min = 0;

        for(int i = 1 ; i <= size ; i++){
            if(node.getData() < 0){
                min = node.getData();
                break;
            }
            node = node.getLink();
        }
       
        node = start;
        for(int i = 1 ; i <= size ; i++){
            if(node.getData() < 0){
                if(node.getData() < min){
                    min = node.getData();
                }
            }
            node = node.getLink();
        }
        
        if(min == 0){
            System.out.println("Danh Sach Khong Co So Am");
            return;
        }
        
        System.out.println("So Am Lon Nhat La: " + min);
    }//So Am

    public void FindMaxPositive(){   
        if(size == 0){
            System.out.println("\nDanh Sach Rong");
            return;
        }
        Nodes node = start;
        int max = 0;
        for(int i = 1 ; i <= size ; i++){
            if(node.getData() > 0){
                max = node.getData();
                break;
            } 
            node = node.getLink();
        }
        node = start;
        for(int i = 1 ; i <= size ; i++){
            if(node.getData() > max){
                max = node.getData();
            } 
            node = node.getLink();
        }

        if(max == 0 ){
            System.out.print("Danh Sach Khong Co So Duong");
            return;
        }
        
        System.out.println("So Duong Lon Nhat La : " + max);
    }//So Duong

    public void Sort(){
        if(size == 0 ){
            System.out.println("Danh Sach Rong");
            return;
        }
        
        Nodes node1 = start;
        
        
        for(int i = 1 ; i <=size ; i++){
            Nodes node2 = start;
            for(int j = 1 ; j < size ; j++){
                if(node2.getData() > node1.getData()){
                   Swap(node1, node2); 
                } 
                node2 = node2.getLink();
            }

            node1 = node1.getLink();
        }
    }

    public void Swap(Nodes node1, Nodes node2){
        if(node1 == null || node2 == null){
            return;
        }
        int tmpData = node1.getData();
        node1.setData(node2.getData());
        node2.setData(tmpData);
    }
        
    public void DisplayNodes(){
        if(start == null){
            System.out.println("\nDanh Sach Rong");
            return;
        }
        Nodes node = start; 
        for(int i = 1; i <= size; i++){
            System.out.print(node.getData() + "->");
            node = node.getLink();
        }
        System.out.println("null");
    }
}
