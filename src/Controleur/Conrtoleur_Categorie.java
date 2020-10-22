package Controleur;

import Classes.Article;
import Classes.Categorie;
import Classes.Test;

import java.util.Scanner;

public class Conrtoleur_Categorie {
    public boolean AjouterC(  Categorie c)
    {

        Scanner scf= new Scanner(System.in);

        System.out.println("/*** Bienvenu dans l'Ajout de Categorie ***/");
        System.out.println("add id ");
        c.setId(scf.nextInt());
        System.out.println("add designation ");
        c.setDesigantion(scf.next());
        System.out.println("add description: ");
        c.setDescription(scf.next());
        Test.ListeCategorie.add(c);
        return  true ;

    }
    public  Categorie  ChercherC(int id)
    {
        try
        {

            for (Categorie a : Test.ListeCategorie){
                if (a.getId() ==id){
                    return a;

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
    public boolean SupprimerC(int id)
    {
        try
        {
  Test.ListeCategorie.remove(this.ChercherC(id));
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
            if( (Test.ListeCategorie.isEmpty()) ){
                System.out.print("La liste est Vide !!");
                return false;
            }else {
                if (this == null){
                    System.out.print("Liste est  vide ");
                    return false;
                }else{

                    Scanner scf= new Scanner(System.in);
                    System.out.println("/*** Bienvenu dans la modification de Categorie***/");
                    System.out.println("Nv designation ");
                    this.ChercherC(id).setDesigantion(scf.next());
                    System.out.println("Nv description: ");
                    this.ChercherC(id).setDescription(scf.next());
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
