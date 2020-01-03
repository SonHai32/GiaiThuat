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
            System.out.println("9.Thoat");
            
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
        System.out.print("Ban Muon Tao May Node: ");
        int n = input.nextInt();
        
        for(int i = 1 ; i <= n ; i++){
            System.out.print("Nhap Gia Tri Cho Node: ");
            int data = input.nextInt();
            Insert(data);
        }
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

}
