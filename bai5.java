import java.util.Scanner;
public class bai5{
    public static void main(String[] args){
        Scanner input  = new Scanner(System.in);
        LinkedList listStudent = new LinkedList();
        while(true){
            System.out.println("----------------Menu---------------");
            System.out.println("1.Nhap Danh Sach SV");
            System.out.println("2.Xuat Danh Sach SV");
            System.out.println("3.Tim SV");
            System.out.println("4.Sinh Vien Co Diem TB Cao Nhat");
            System.out.println("7.Thoat");
            System.out.print("Moi Ban Nhap Lua Chon: ");
            int chon = input.nextInt();

            switch(chon){
                case 1: listStudent.nhapDS();
                        break;
                case 2: listStudent.xuatDS();
                        break;
                case 3: listStudent.timSV();
                        break;
                case 4: listStudent.findMax();
                        break;
                case 5: listStudent.findMin();
                        break;
                case 6 : listStudent.sort();
                         break;
                case 7: 
                        System.exit(0);
            }
        }
    }
}

class Nodes{
    private Nodes link;
    private String masv, hoTen, gioiTinh, ngaySinh;
    private float diemTB;
    public Nodes(String masv, String hoTen, String gioiTinh, String ngaySinh, float diemTB, Nodes link){
        this.link = link;
        this.masv = masv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diemTB = diemTB;
    }

    public void setLink(Nodes link){
        this.link = link;
    }
    
    public void setMasv(String masv){
        this.masv = masv;
    }
    
    public void setHoTen(String hoTen){
        this.hoTen = hoTen;
    }
    
    public void setGioiTinh(String gioiTinh){
        this.gioiTinh = gioiTinh;
    }
    
    public void setNgaySinh(String ngaySinh){
        this.ngaySinh = ngaySinh;
    }
  
    public void setDiemTB(float diemTB){
        this.diemTB = diemTB;
    }
    
    public Nodes getLink(){
        return link;
    }

    public String getMasv(){
        return masv;
    }
         
    public String getHoTen(){
        return hoTen;
    }

    public String getGioiTinh(){
        return gioiTinh;
    }
    
    public String getNgaySinh(){
        return ngaySinh;
    }

    public float getDiemTB(){
        return diemTB;
    }
}

class LinkedList{
    private Nodes start;
    private Nodes end;
    private int size;

    public LinkedList(){
        start = end = null;
        size = 0;
    }

    public void insertAtStart(String masv, String hoTen, String gioiTinh, String ngaySinh, float diemTB){
        Nodes student = new Nodes(masv, hoTen, gioiTinh, ngaySinh, diemTB, null);
        size++;
        if(size == 0){
            start = end = student;
        }else{
            student.setLink(start);
            start = student;
        }
    }

    public void nhapDS(){
        Scanner input = new Scanner(System.in);
        System.out.print("Ban Muon Nhap Bao Nhieu Sinh Vien: ");
        int n = input.nextInt();
        for(int i = 1; i <= n; i++){
            System.out.println("\nNhap Thong Tin Sinh Vien Thu `` " + i);
            System.out.print("\nNhap MASV: ");
            String masv = input.next();
            System.out.print("\nNhap Ho Ten: ");
            String hoTen = input.next();
            System.out.print("\nNhap Ngay Sinh: ");
            String ngaySinh = input.next();
            System.out.print("\nNhap Gioi Tinh: ");
            String gioiTinh = input.next();
            System.out.print("\nNhap Diem TB: ");
            float diemTB = input.nextFloat();
            insertAtStart(masv, hoTen,ngaySinh,gioiTinh,diemTB);
        }
    }

    public void timSV(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nNhap MaSv Can Tim: ");
        String masv = input.next();

        if(size == 0){
            System.out.println("Danh Sach Rong");
            return;
        }

        if(start.getMasv().equals(masv)){
            System.out.println(start.getMasv() + "\t" + start.getHoTen() + "\t" + start.getNgaySinh() + "\t" + start.getGioiTinh() + "\t" + start.getDiemTB() + "\n"); 
            return;
        }

        Nodes student = start.getLink();
        while(student.getLink() != null){
            if(student.getMasv().equals(masv)){
                System.out.println(student.getMasv() + "\t" + student.getHoTen() + "\t" + student.getNgaySinh() + "\t" + student.getGioiTinh() + "\t" + student.getDiemTB() + "\n"); 
                return;
            }
            student = student.getLink();
        }

        if(student.getMasv().equals(masv)){
            System.out.println(student.getMasv() + "\t" + student.getHoTen() + "\t" + student.getNgaySinh() + "\t" + student.getGioiTinh() + "\t" + student.getDiemTB() + "\n"); 
            return;
        }else{
            System.out.println("Khong tim thay");
        }

    }

    public void findMax(){
        if(size == 0){
            System.out.println("Danh Sach Rong");
            return;
        }
        if(start.getLink() == null){
            System.out.println(start.getMasv() + "\t" + start.getHoTen() + "\t" + start.getNgaySinh() + "\t" + start.getGioiTinh() + "\t" + start.getDiemTB() + "\n"); 
            return;
        }//just 1 node
        float max = start.getDiemTB();
        Nodes tmp = start;
        Nodes student = start.getLink();
        while(student.getLink() != null){
            if(student.getDiemTB() > max){
                max = student.getDiemTB();
                tmp = student;
            }
            student = student.getLink();
        }
        if(tmp.getDiemTB() < student.getDiemTB()) //compare last node
            tmp = student;

        System.out.println(tmp.getMasv() + "\t" + tmp.getHoTen() + "\t" + tmp.getNgaySinh() + "\t" + tmp.getGioiTinh() + "\t" + tmp.getDiemTB() + "\n"); 
    } 
    public void findMin(){
        if(size == 0){
            System.out.println("Danh Sach Rong");
            return;
        }
        if(start.getLink() == null){
            System.out.println(start.getMasv() + "\t" + start.getHoTen() + "\t" + start.getNgaySinh() + "\t" + start.getGioiTinh() + "\t" + start.getDiemTB() + "\n"); 
            return;
        }//just 1 node
        float min = start.getDiemTB();
        Nodes tmp = start;
        Nodes student = start.getLink();
        while(student.getLink() != null){
            if(student.getDiemTB() < min){
                min = student.getDiemTB();
                tmp = student;
            }
            student = student.getLink();
        }
        if(tmp.getDiemTB() > student.getDiemTB()) //compare last node
            tmp = student;

        System.out.println(tmp.getMasv() + "\t" + tmp.getHoTen() + "\t" + tmp.getNgaySinh() + "\t" + tmp.getGioiTinh() + "\t" + tmp.getDiemTB() + "\n"); 
    } 
    public void xuatDS(){
        if(size == 0){
            System.out.println("Danh Sach Rong");
            return;
        }

        Nodes student = start;
         
        System.out.println(start.getMasv() + "\t" + start.getHoTen() + "\t" + start.getNgaySinh() + "\t" + start.getGioiTinh() + "\t" + start.getDiemTB() + "\n"); 
        student = start.getLink();

        while(student.getLink() != null){ 
            System.out.println(student.getMasv() + "\t" + student.getHoTen() + "\t" + student.getNgaySinh() + "\t" + student.getGioiTinh() + "\t" + student.getDiemTB() + "\n"); 
            student = student.getLink();
        }

        System.out.println(student.getMasv() + "\t" + student.getHoTen() + "\t" + student.getNgaySinh() + "\t" + student.getGioiTinh() + "\t" + student.getDiemTB() + "\n"); 
    }

    public void swap(Nodes data1, Nodes data2){
        Nodes tmp = data1;
        data1.setMasv(data2.getMasv());
        data1.setHoTen(data2.getHoTen());
        data1.setNgaySinh(data2.getNgaySinh());
        data1.setGioiTinh(data2.getGioiTinh());
        data1.setDiemTB(data2.getDiemTB());

        data2.setMasv(tmp.getMasv());
        data2.setHoTen(tmp.getHoTen());
        data2.setNgaySinh(tmp.getNgaySinh());
        data2.setGioiTinh(tmp.getGioiTinh());
        data2.setDiemTB(tmp.getDiemTB());
                
    }

    public void sort(){ 
        if(size == 0){
            System.out.println("Danh Sach Rong");
            return;
        }

        Nodes tmp1 = start;
 
        for(int i = 1; i < size; i++){
            Nodes tmp2 = tmp1.getLink();
            if(tmp2.getDiemTB() < tmp1.getDiemTB()){
                swap(tmp2, tmp1);
            }
            tmp1 = tmp1.getLink();
        }
        
    }



}
