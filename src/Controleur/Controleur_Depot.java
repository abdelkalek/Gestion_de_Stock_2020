package Controleur;

import Classes.Categorie;
import Classes.Depot;
import Classes.Test;

import java.util.Scanner;

public class Controleur_Depot {
    public boolean AjouterD(Depot d)
    {

        Scanner scf= new Scanner(System.in);

        System.out.println("/*** Bienvenu dans l'Ajout de nouvaux depot ***/");
        System.out.println("add id ");
        d.setId(scf.nextInt());
        System.out.println("add designation ");
         d.setDesignation(scf.next());
        System.out.println("add description: ");
        d.setDescription(scf.next());
        System.out.println("add Numero de depot: ");
        d.setNumero(scf.nextInt());
        Test.ListeDepot.add(d);
        return  true ;

    }
    public  Depot  ChercherD(int id)
    {
        try
        {

            for (Depot d : Test.ListeDepot){
                if (d.getId() ==id){
                    return d;

                }else
                {
                    return  null;
                }

            }
            return null ;

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return  null;
        }

    }
    public boolean Supprimerd(int id)
    {
        try
        {
            Test.ListeDepot.remove(this.ChercherD(id));
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean ModifyC(int id)
    {
        try
        {
            if( (Test.ListeDepot.isEmpty()) ){
                System.out.print("La liste Depot est Vide !!");
                return false;
            }else {
                if (this == null){
                    System.out.print("Liste Depot est  vide ");
                    return false;
                }else{

                    Scanner scf= new Scanner(System.in);
                    System.out.println("/*** Bienvenu dans la modification DE depot ***/");
                    System.out.println("Nv designation ");
                    this.ChercherD(id).setDesignation(scf.next());
                    System.out.println("Nv description: ");
                    this.ChercherD(id).setDescription(scf.next());
                    System.out.println("Nv Numero: ");
                    this.ChercherD(id).setNumero(scf.nextInt());
                    return true;
                }
            }}

        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }

    }
}
