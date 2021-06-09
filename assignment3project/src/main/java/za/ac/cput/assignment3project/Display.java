/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3project;

import java.util.*;
import java.io.*;

/**
 *
 * @author raeec
 */
public class Display extends CreateStakeholderSer {
    Customer c = new Customer();
    Supplier s = new Supplier();
        ArrayList<Customer> cList = new ArrayList<Customer>();
        ArrayList<Supplier> sList = new ArrayList<Supplier>();
        public void readSer(){
            System.out.println("Getting info");
            
            try{
            String fileName = "stakeholder.ser";
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            
            Customer c1 = (Customer)in.readObject();
            Supplier s1 = (Supplier)in.readObject();
            Customer c2 = (Customer)in.readObject();
            Supplier s2 = (Supplier)in.readObject();
            Supplier s3 = (Supplier)in.readObject();
            Customer c3 = (Customer)in.readObject();
            Customer c4 = (Customer)in.readObject();
            Supplier s4 = (Supplier)in.readObject();
            Supplier s5 = (Supplier)in.readObject();
            Customer c5 = (Customer)in.readObject();
            Customer c6 = (Customer)in.readObject();
            
            cList.add(c1);
            cList.add(c2);
            cList.add(c3);
            cList.add(c4);
            cList.add(c5);
            cList.add(c6);
            
            sList.add(s1);
            sList.add(s2);
            sList.add(s3);
            sList.add(s4);
            sList.add(s5);
            
            
            
            //sort Customer content
            String[] sortContent = new String[cList.size()];
            ArrayList<Customer> Array = new ArrayList<Customer>();
            int length = cList.size();
            
            
            for(int x = 0;x< length;x++) {
                sortContent[x] = cList.get(x).getStHolderId();
            }
            
            
            
            for(int b = 0;b< length;b++){
                for(int a = 0;a < length;a++){
                    if(sortContent[b].equals(cList.get(a).getStHolderId())){
                        Array.add(cList.get(a));
                    }
                }
            }
            
            
            cList.clear();
            cList = Array;
            for(int i = 0;i<cList.size();i++){
                
                if(c.getCredit()<260){
                
                    System.out.println("you can rent");
                }
                
               /* 
            LocalDate today = LocalDate.now();
            LocalDate birthday = LocalDate.parse(c.getDateOfBirth());
            Period.between(birthday, today);
            */
                System.out.println(cList.get(i));
            }
            
            in.close();
            } catch(IOException ioe){
                System.out.println("error opening " + ioe.getMessage());
            } catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            }
        }
        
        public void CreatefileCustomer(){
            File file = new File("CustomerDetails.txt");
            try{
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===============Customers Details===================");
            pw.println("ID      Name        Surname     DateofBirth     Age");
            pw.println("===================================================");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            BufferedWriter out1 = new BufferedWriter(fw);
            /*
            for (int l = 0; l > cList.size();l++){
                out1.write(cList.get(l).toString() + "/n");
            }
            */
               oos.writeObject(cList);
               out1.close();
               pw.close();
               //oos.close();
               
            
                System.out.println("Customer List printed");
                
           
        
            } catch(IOException ioe){
                ioe.printStackTrace();
            }
        
        }
        
        
        
        public void CreateFileSupplier(){
           File file = new File("SupplierDetails.txt");
            try{
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("===============Supplier Details===================");
            pw.println("ID      Name                ProductType    Description");
            pw.println("===================================================");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            BufferedWriter out2 = new BufferedWriter(fw);
            /*
            for (int v = 0; v > sList.size();v++){
                out2.write(cList.get(v).toString() + "/n");
            }
            */
               oos.writeObject(sList);
               out2.close();
               pw.close();
               //oos.close();
               
            
                System.out.println("Supplier List printed");
                
           
        
            } catch(IOException ioe){
                ioe.printStackTrace();
            }
           }
        
        //public ArrayList<Customer> sortAscending(){
        //cList.sort(c);
        //return sort();
        
        //}
        public static void main(String[] args) {
        Display obj = new Display();
        obj.readSer();
        obj.CreatefileCustomer();
        obj.CreateFileSupplier();
        
    }
    
}
