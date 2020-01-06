import java.util.Scanner;
public class bai6{
    public static void main(String[] args){
        BSTTree tree = new BSTTree();
        Scanner input = new Scanner(System.in);
        //Menu
        while(true){
            System.out.println("\n---------------------Menu------------------");
            System.out.println("1.Tao Cay");
            System.out.println("2.Duyet Theo NLR");
            System.out.println("3.Duyet Theo LNR");
            System.out.println("4.Duyet Theo LRN");
            System.out.println("5.So Node Co 1 con");
            System.out.println("6.So Node Co 2 con");
            System.out.println("7.Tinh Tong Cua Cac Node Co 2 Con");
            System.out.println("8.Tinh Tong Cua Cac La");
            System.out.println("9.Tinh Chieu Cao Cua Cay");
            System.out.println("10.Tim Node Lon Nhat");
            System.out.println("11.Tim Node Nho Nhat");
            System.out.println("12.Dem So Node Chi Co Cay Con Ben Phai");
            System.out.println("13.Dem So Node Chi Co Cay Con Ben Trai");
            System.out.println("14.Tinh Do Dai Duong Di X");
            System.out.println("15.In Node Theo Tung Muc");
            System.out.println("16.Dem Node Chan");
            System.out.println("17.Tong Cac Node Muc Le");
            System.out.println("18.Thoat");
            
            System.out.print("Nhap Lua Chon: ");
            int chon = input.nextInt();

            switch(chon){
                case 1:
                    tree.TaoCay();
                    break;
                case 2:
                    tree.NLR();
                    break;
                case 3:
                    tree.LNR();
                    break;
                case 4: 
                    tree.LRN();
                    break;
                case 5: 
                    tree.Node1Child();
                    break;
                case 6: 
                    tree.Node2Child();
                    break;
                case 7:
                    tree.SumNode2Child();
                    break;
                case 8: 
                    tree.SumNodeLeaf();
                    break;
                case 9:
                    tree.Height();
                    break;
                case 10:
                    tree.SearchNodeMax();
                    break;
                case 11:
                    tree.SearchNodeMin();
                    break;
                case 12: 
                    tree.CountNode1RightChild();
                    break;
                case 13:
                    tree.CountNode1LeftChild();
                    break;
                case 14:
                    tree.DoDaiDuongDiX();
                    break;
                case 15:
                    tree.InNodeTheoMuc();
                    break;
                case 16:
                    tree.DemNodeChan();
                    break;
                case 17:
                    tree.TongNodeMucLe();
                    break;
                case 18:
                    System.exit(0);
            }
        }
    }    
}

class BSTNodes{
    private int Data;
    protected BSTNodes left, right;
    public BSTNodes(int Data){
        this.Data = Data;
    }

   
    public int getData(){
        return Data;
    }
}

class BSTTree{
    private BSTNodes root;
    public BSTTree(){
        root = null;
    }
    public void Insert(int Data){
        root = Insert(root, Data);
    }

    public BSTNodes Insert(BSTNodes node, int data){
        if(node == null){
            node = new BSTNodes(data);
        }else{
            if(data <= node.getData())
                node.left = Insert(node.left, data);
            else
                node.right = Insert(node.right, data);
        }

        return node;
    }

    public void TaoCay(){
        Scanner input = new Scanner(System.in);
        int [] node = {25,37,10,18,29,50,3,1,6,5,12,20,35,13,32,41};
        for(int i : node){
            Insert(i);
        }
        //System.out.print("Ban Muon Tao May Node: ");
        //int n = input.nextInt();
        
        /*for(int i = 1 ; i <= n ; i++){
            System.out.print("Nhap Gia Tri Cho Node: ");
            int data = input.nextInt();
            Insert(data);
        }*/
    }

    public void NLR(){
        NLR(root);
    }

    private void NLR(BSTNodes node){
        if(node != null){
            System.out.print(node.getData() + " , ");
            NLR(node.left);
            NLR(node.right);
        }
    }
   
    public void LNR(){
        LNR(root);
    }

    private void LNR(BSTNodes node){
        if(node != null){
            LNR(node.left);
            System.out.print(node.getData() + " , ");
            LNR(node.right);
        }
    }
    public void LRN(){
        LRN(root);
    }

    private void LRN(BSTNodes node){
        if(node != null){    
            LRN(node.left);
            LRN(node.right);
            System.out.print(node.getData() + " , ");
        }   
    }

    public void Node1Child(){
        System.out.println("So Node co 1 co: " + Node1Child(root));
    }

    private int Node1Child(BSTNodes root){
        if(root == null)
            return 0;
        else if(root.left == null && root.right == null)
            return 0;
        else if(root.left == null)
            return 1 + Node1Child(root.right);
        else if(root.right == null)
            return 1 + Node1Child(root.left);
        else
            return Node1Child(root.left) + Node1Child(root.right);
    }

    public void Node2Child(){
        System.out.println("So Node co 2 con : " + Node2Child(root));
    }

    private int Node2Child(BSTNodes root){
        if(root == null)
            return 0;
        else if(root.left == null && root.right == null)
            return 0;
        else if(root.left == null)
            return Node2Child(root.right);
        else if (root.right == null)
            return Node2Child(root.left);
        else
            return 1 + Node2Child(root.left) + Node2Child(root.right);
    }

    public void SumNode2Child(){
        System.out.println("Tong cua cac node co 2 con : " + SumNode2Child(root));
    }

    private int SumNode2Child(BSTNodes root){
        if(root == null)
            return 0;
        else if(root.left == null && root.right == null)
            return 0;
        else if(root.left == null)
            return SumNode2Child(root.right);
        else if(root.right == null)
            return SumNode2Child(root.left);
        else 
            return root.getData() + SumNode2Child(root.left) + SumNode2Child(root.right);
    }

    public void SumNodeLeaf(){
        System.out.println("Tong So Cac La : " + SumNodeLeaf(root));
    }

    private int SumNodeLeaf(BSTNodes root){
        if(root == null)
            return 0;
        else if(root.left == null && root.right == null)
            return root.getData() + SumNodeLeaf(root.left) + SumNodeLeaf(root.right);
        else 
            return SumNodeLeaf(root.left) + SumNodeLeaf(root.right);
    }

    public void CountNodeLeaf(){
        System.out.println("So La : " + CountNodeLeaf(root));
    }

    private int CountNodeLeaf(BSTNodes root){
        if(root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return 1 + CountNodeLeaf(root.left) + CountNodeLeaf(root.right);
        else 
            return CountNodeLeaf(root.left) + CountNodeLeaf(root.right);
    }

    public void Height(){
        System.out.println("Cay Co Do Cao: " + (Height(root)+1));
    }

    private int Height(BSTNodes root){
        if(root == null)
            return -1;
        else{
            int lHeight = Height(root.left);
            int rHeight = Height(root.right);
            if(lHeight > rHeight)
                return lHeight + 1;
            else
                return rHeight + 1;
        }
    }

    public void SearchNodeMax(){
        System.out.println("Node Lon Nhat La : " + SearchNodeMax(root));
    }

    private int  SearchNodeMax(BSTNodes root){
        int max = -1; 
        if(root != null){
            max = root.getData();
            while(root.right != null){
                max = root.right.getData();
                root = root.right;
            }
        }

        return max;
    }

    public void SearchNodeMin(){
        System.out.println("Node Nho Nhat La : " + SearchNodeMin(root));
    }

    private int  SearchNodeMin(BSTNodes root){
        int min = -1;
            
        if(root != null){
            min = root.getData();
            while(root.left != null){
                min = root.left.getData();
                root = root.left;
            }
        }

        return min;
    }

    public void CountNode1LeftChild(){
        System.out.println("So Nut Co Cay Con Ben Trai La: " + CountNode1LeftChild(root));
    }

    private int CountNode1LeftChild(BSTNodes root){
        if(root == null)
            return 0;
        else if(root.left != null && root.right == null)
            return 1 + CountNode1LeftChild(root.left);
        else 
            return CountNode1LeftChild(root.left) + CountNode1LeftChild(root.right);
    }

    public void CountNode1RightChild(){
        System.out.println("So Nut Co Cay Con Ben Phai La: " + CountNode1RightChild(root));
    }

    private int CountNode1RightChild(BSTNodes root){
       if(root == null)
           return 0;
       else if(root.right != null && root.left == null)
           return 1 + CountNode1RightChild(root.right);
       else 
           return CountNode1RightChild(root.left) + CountNode1RightChild(root.right);
    }

    public void DoDaiDuongDiX(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap X: ");
        int x = input.nextInt();

        System.out.println("Do Dai Duong Di X : " + DoDaiDuongDiX(x,root)); 
    }

    private int DoDaiDuongDiX(int x, BSTNodes root){
        if(root == null)
            return -1;
        int dem  = 0;
        int dem2 = 0;
        boolean flag = false;
        while(root != null && flag == false){
            dem++;
            
            if(x < root.getData())
                root = root.left;
            else if(x > root.getData())
                root = root.right;
            else if(x == root.getData()){
                dem2 = dem;
                flag = true;
                break;
            }
        }
        return dem2;
    }

    public void InNodeTheoMuc(){
        for(int i = 1 ; i <= Height(root) + 1 ; i++){
            InNodeTheoMuc(root, i);
        } 
    }

    private void InNodeTheoMuc(BSTNodes root, int level){
        if(root == null)
            return;
        else{
            if(level == 1)
                System.out.println(root.getData() + " , ");
            else if(level > 1 ){
                InNodeTheoMuc(root.left, level - 1);
                InNodeTheoMuc(root.right, level -1);
            }
        }
    }

    public void TongNodeMucLe(){
        System.out.println("Tong Node Muc Le: " + TongNodeMucLe(root, 1));
    }

    private int TongNodeMucLe(BSTNodes root, int level){
        if(root == null)
             return 0;
        return ((level)%2==1 ?root.getData() : 0 ) + TongNodeMucLe(root.left, level + 1 ) + TongNodeMucLe(root.right, level + 1);
    }

    public void DemNodeChan(){
        System.out.print("So Node Chan: " + DemNodeChan(root));
    }

    private int DemNodeChan(BSTNodes root){
        if(root == null)
            return 0;
        return ((root.getData() % 2) == 0 ? 1 : 0) + DemNodeChan(root.left) + DemNodeChan(root.right);
    }
}
