/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komputer;

import javax.swing.JOptionPane;


public class DataKomputer implements AppInterface {
    
    private final Komputer[] komputer;

    public DataKomputer() {
        komputer = new Komputer[1000];
    }
    

    @Override
    public int pilihMenu() {
        String p = JOptionPane.showInputDialog(null,""
                +"<html>"
                +"=====Pilihan===================<br>"
                + "1 &rarr; Tambah Data Komputer<br>"
                + "2 &rarr; Cari berdasarkan Brand Komputer<br>"
                + "3 &rarr; cari berdasarkan Model Komputer<br>"
                + "4 &rarr; Keluar Aplikasi"
                + "=============================<br>"
                + "<b>ketik Pilihan Anda</b>"
                + "</html>",
                "Menu Pilihan",
                JOptionPane.QUESTION_MESSAGE);
        int pilihan = Integer.parseInt(p);//casting
        return pilihan;
        
    }

    @Override
    public void add() {
        Komputer kom = new Komputer();
        String brand = JOptionPane.showInputDialog(null,"Ketik Brand",""
                +"Brand",JOptionPane.QUESTION_MESSAGE);
        kom.setBrand(brand);
        String model = JOptionPane.showInputDialog(null,"Ketik model",""
                +"Model",JOptionPane.QUESTION_MESSAGE);
        kom.setModel(model);
        String disk=JOptionPane.showInputDialog(null,"tipe disk (ssd/hardisk): ",""
                +"tipe disk",JOptionPane.QUESTION_MESSAGE);
        kom.setDisk(disk);
        String size =JOptionPane.showInputDialog(null,"kapasitas disk (angka): ",""
                +"kapasitas disk (dalam GB)",JOptionPane.QUESTION_MESSAGE);
        int diskSize = Integer.parseInt(size);// casting
        kom.setDiskSize(diskSize);
        String ram = JOptionPane.showInputDialog(null,"kapasitas RAM (angka) :",""
                +"ukuran RAM (dalam GB)",JOptionPane.QUESTION_MESSAGE);
        int ramSize = Integer.parseInt(ram);//casting
        kom.setRam(ramSize);
        
        for (int i = 1;i <komputer.length;i++){
            if(komputer[i]==null){
                komputer[i] = kom;
                break;
            }
        }
        viewData(kom);
    }

    @Override
    public String keyword(String type) {
       String key = JOptionPane.showInputDialog(null,
               "ketik"+type+"komputer",type,JOptionPane.QUESTION_MESSAGE);
       return key;
    }

    @Override
    public Komputer searchByModel(String model) {
        Komputer komp = null;
        for (Komputer k : komputer){
            if (k!=null && model.equalsIgnoreCase(k.getModel())){
                komp = k;
                break;
            }
        }
        return komp;    }

    @Override
    public Komputer searchByBrand(String brand) {
        Komputer komp = null;
        for (Komputer k : komputer){
            if (k!=null && brand.equalsIgnoreCase(k.getBrand())){
                komp = k;
                break;
            }
        }
        return komp;
    }

    @Override
    public void viewData(Komputer k) {
        if ( k== null){
            JOptionPane.showInputDialog(null,
                    "Brand\t\t: "+ k.getBrand()+
                    "\nmodel\t\t: "+k.getModel()+
                    "\nDisk Type\t\t: "+k.getDisk()+
                    "\ndisk size\t\t: "+k.getDiskSize()+
                    "\n ram size \t\t: "+k.getRam(),
                    "data komputer",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }
    
}
