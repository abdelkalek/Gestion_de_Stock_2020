package Controleur;
import Classes.Article;
import Classes.Categorie;
import Classes.Test;

import java.util.Scanner;

public class ControleurArticle {
    public void Ajouter(  Article a)
    {

            Scanner scf= new Scanner(System.in);
            System.out.println("/*** Bienvenu dans l'Ajout de L'article ***/");
        System.out.println("Donner l' id de CAtegorie : ");
        int z =scf.nextInt();
        for(Categorie c :Test.ListeCategorie)
        {
         if(c.getId()==z ) {
                a.setC(c);
                System.out.println("add id ");
                a.setId(scf.nextInt());
                System.out.println("add designation ");
                a.setDesignation(scf.next());
                System.out.println("add description: ");
                a.setDescription(scf.next());


            }else
            {
                System.out.println("Pas de Categorie !");

            }
        }

            Test.ListeArticales.add(a);

    }
    public  Article  Chercher(int id)
    {
        try
        {

            for (Article a : Test.ListeArticales){
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
    public boolean Supprimer(int id)
    {
        try
        {

            Test.ListeArticales.remove(this.Chercher(id));
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean Modify(int id)
    {
        try
        {
            if( (Test.ListeArticales.isEmpty()) ){
                System.out.print("La liste est Vide !!");
                return false;
            }else {
                if (this == null){
                    System.out.print("Liste est  null ");
                    return false;
                }else{

                    Scanner scf= new Scanner(System.in);
                    System.out.println("/*** Bienvenu dans la modification de L'article ***/");
                    System.out.println("Nv designation ");
                    this.Chercher(id).setDesignation(scf.next());
                    System.out.println("Nv description: ");
                    this.Chercher(id).setDescription(scf.next());
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
