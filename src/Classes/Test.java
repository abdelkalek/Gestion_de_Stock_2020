package Classes;

import Controleur.Conrtoleur_Categorie;
import Controleur.ControleurArticle;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static ArrayList<Article> ListeArticales = new ArrayList<Article>();
    public static ArrayList<Categorie> ListeCategorie = new ArrayList<Categorie>();
    public static ArrayList<Depot> ListeDepot = new ArrayList();

    public static void main(String[] args) {
        ControleurArticle c = new ControleurArticle();
        Conrtoleur_Categorie Cat = new Conrtoleur_Categorie();

        int choixNiv1 ;
        int choixNiv2;

        do {
            System.out.println("/**   BIENVENUE DANS LE Gestion de Stock 2020 **/");
            System.out.println("   1 : GESTION Des Article  ");
            System.out.println("   2 : GESTION Des Categorie  ");
            System.out.println("   3 : GESTION Des Depots  ");
            System.out.println("   4 : QUITTER L'application   ");
            System.out.println("/*******************************/");
            System.out.println(" Taper votre choixNiv1 SVP  ");
            Scanner sc = new Scanner(System.in);
            choixNiv1 = sc.nextInt();
            switch (choixNiv1){
                case 1 :
                    do{
                        System.out.println("/**   BIENVENUE DANS La GESTION Des Articles  **/");
                        System.out.println("   1 : Ajouter un Article  ");
                        System.out.println("   2 : Modifier un Article ");
                        System.out.println("   3 : Supprimer un Article  ");
                        System.out.println("   4 : Afficher la liste des Articles  "); //afficher liste des Articles
                        System.out.println("   5 : Quitter la gestion Des Article  ");
                        System.out.println("/*******************************/");
                        System.out.println(" Taper votre choixNiv2 SVP  ");
                        choixNiv2 = sc.nextInt();
                        switch (choixNiv2) {
                            case 1:

                                Article a= new Article();
                                c.Ajouter(a);
                              break;
                            case 2:
                                System.out.println(" Taper l'id d'article  à modifier  ");
                                int idArticle = sc.nextInt();
                               c.Modify(idArticle);
                                break;
                            case 3:
                                System.out.println(" Taper l'id de l'article à Supprimer  ");
                                int numARSupp = sc.nextInt();
                               c.Supprimer(numARSupp);
                                break;
                            case 4:
                                /*************** Affichier la liste des Articles ****************/
                                if (ListeArticales.isEmpty())
                                {
                                    System.out.println(" Liste des Articles est vide   ");
                                }else{
                                    for (Article ar : ListeArticales)
                                    {
                                        System.out.println(ar+"  ");
                                    }
                                    System.out.println(" *** Fin de Liste des Articles    ");
                                }
                                /*******************************/
                                break;
                            default:
                                if (choixNiv2 != 5)
                                    System.out.println(" Choix invalide  ");
                        }
                    }while( choixNiv2 != 5) ;

                    break;
                case 2 :
                    do{
                        System.out.println("/**   BIENVENUE DANS La GESTION Des Categorie  **/");
                        System.out.println("   1 : Ajouter un Categorie  ");
                        System.out.println("   2 : Modifier un Categorie ");
                        System.out.println("   3 : Supprimer un Categorie  ");
                        System.out.println("   4 : Afficher la liste des Categorie disponible  "); //afficher liste des Categorie
                        System.out.println("   5 : Modifier la liste des Categorie disponible  "); //afficher liste des Categorie
                        System.out.println("   6 : Quitter la gestion Des Categorie  ");
                        System.out.println("/*******************************/");
                        System.out.println(" Taper votre choixNiv2 SVP  ");
                        choixNiv2 = sc.nextInt();
                        switch (choixNiv2) {
                            case 1:
                               Categorie cate = new Categorie();
                               Cat.AjouterC(cate);

                                break;
                            case 2:
                                System.out.println(" Taper l'id de Categorie à modifier  ");
                                int num = sc.nextInt();
                                Cat.ModifyC(num);

                                break;
                            case 3:
                                System.out.println(" Taper le numero de Categorie à Supprimer  ");
                                int numSupp = sc.nextInt();
                              Cat.SupprimerC(numSupp);

                                break;
                            /*************** Affichier liset des Categorie****************/
                            case 4:
                                if (ListeCategorie.isEmpty())
                                {
                                    System.out.println("Liste des Categorie est vide   ");

                                }else{
                                    for (Categorie ca : ListeCategorie)
                                    {
                                        System.out.println(ca+"  ");
                                    }
                                    System.out.println("Fin de Liste des Categorie    ");
                                }

                                break;
                            case 5:
                                System.out.println(" Taper le numero de Categorie à modifier  ");
                                int numADD = sc.nextInt();
                              Cat.ModifyC(numADD);

                                break;
                            default:
                                if (choixNiv2 != 6)
                                    System.out.println(" Choix invalide  ");
                        }
                    }while( choixNiv2 != 6) ;

                    break;
                case 3 :
                    do{
                        System.out.println("/**   BIENVENUE DANS La GESTION Des Depots  **/");
                        System.out.println("   1 : Ajouter un Depots  ");
                        System.out.println("   2 : Modifier un Depots ");
                        System.out.println("   3 : Supprimer un Depots  ");
                        System.out.println("   4 : Afficher les Depots  "); //Afficher les RDV Depots
                        System.out.println("   5 : Quitter la gestion Des Depots  ");
                        System.out.println("/*******************************/");
                        System.out.println(" Taper votre choixNiv2 SVP  ");
                        choixNiv2 = sc.nextInt();
                        switch (choixNiv2) {
                            case 1:

                                break;
                            case 2:
                                System.out.println(" Taper l'id de Depot à modifier  ");

                                break;
                            case 3:
                                System.out.println(" Taper l'id de Depot à Supprimer  ");

                                break;
                            case 4:
                                if (ListeDepot.isEmpty())
                                {
                                    System.out.println("pas des Depot pour pour le moment  ");

                                }else{
                                    for (Depot dep : ListeDepot)
                                    {
                                        System.out.println(dep+" ");
                                    }
                                    System.out.println("Fin LISTE  Depot  ");
                                }

                                break;
                            default:
                                if (choixNiv2 != 5)
                                    System.out.println(" Choix invalide  ");
                        }
                    }while( choixNiv2 != 5) ;

            }
        }while( choixNiv1 !=4);
        System.out.println(" MERCI POUR VOTRE VISITE - Au revoir  ");


    }
}
