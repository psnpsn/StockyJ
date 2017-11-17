package com.psnpsn.stocky;

import com.psnpsn.stocky.model.CategoriePrd;
import com.psnpsn.stocky.model.Fournisseur;
import com.psnpsn.stocky.model.Magasin;
import com.psnpsn.stocky.model.Produit;
import com.psnpsn.stocky.model.User;
import com.psnpsn.stocky.service.CategoriePrdService;
import com.psnpsn.stocky.service.FournisseurService;
import com.psnpsn.stocky.service.MagasinService;
import com.psnpsn.stocky.service.ProduitService;
import com.psnpsn.stocky.service.UserService;
import com.psnpsn.stocky.utils.AppConfig;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

 @ComponentScans(value = { 
      @ComponentScan("com.psnpsn.stocky.dao"),
      @ComponentScan("com.psnpsn.stocky.service") 
    })
public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
//        
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/Styles.css");
//        
//        stage.setTitle("JavaFX and Maven");
//        stage.setScene(scene);
//        stage.show();


    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    
   
    public static void main(String[] args) {
//        launch(args);
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      FournisseurService fournService = context.getBean(FournisseurService.class);
      UserService usrService = context.getBean(UserService.class);
      ProduitService prdService = context.getBean(ProduitService.class);
      CategoriePrdService ctgService = context.getBean(CategoriePrdService.class);
      MagasinService magService = context.getBean(MagasinService.class);
      
      Fournisseur F = fournService.find(28);
      CategoriePrd C = ctgService.find(37);
      Magasin M = magService.find(41);
      System.out.println(""+F.getNom());
      
      Produit P = prdService.find(54);
      System.out.println(""+P.getFourn().getId());
      System.out.println(""+P.getFourn().getId());
      System.out.println(""+P.getFourn().getId());
      
//      fournService.create(new Fournisseur("FAT7I","Napoli, BennaRus",2234,"BennaCity","Tungland",9981232,9928222,"fat7ici@ftou7x.com"));
//      usrService.create(new User("USER","USER",0) );
//      ctgService.create(new CategoriePrd("BEEF","PRIME QUALITY BEEF"));
//      ctgService.create(new CategoriePrd("BEEF","GOOD QUALITY BEEF"));
//      ctgService.create(new CategoriePrd("FISH","PRIME QUALITY FISH"));
//      ctgService.create(new CategoriePrd("SEAFOOD","GOOD QUALITY SEAFOOD"));
//      magService.create(new Magasin("SEA HUNTERESS","There, Nowhere"));
//     
//      
//      ObservableList<Fournisseur> listf = fournService.getAll();
//      for (Fournisseur fourn : listf){
//           System.out.println("Num = "+fourn.getId());
//         System.out.println("Nom = "+fourn.getNom());
//         System.out.println("Pays = "+fourn.getPays());
//         System.out.println("Email = "+fourn.getEmail());
//         System.out.println();
//      }
//      
//      ObservableList<User> listu = usrService.getAll();
//      for (User usr : listu){
//           System.out.println("Id = "+usr.getId());
//         System.out.println("Login = "+usr.getLogin());
//         System.out.println("Pw = "+usr.getPwd());
//         System.out.println();
//      }
//      
//      ObservableList<CategoriePrd> listctg = ctgService.getAll();
//      for (CategoriePrd ctg : listctg){
//           System.out.println("Id = "+ctg.getId());
//         System.out.println("Nom = "+ctg.getNom());
//         System.out.println("Desc = "+ctg.getDesc());
//         System.out.println();
//      }
//      
//      ObservableList<Magasin> listm = magService.getAll();
//      for (Magasin mag : listm){
//           System.out.println("Id = "+mag.getId());
//         System.out.println("Nom = "+mag.getNom());
//         System.out.println("Addresse = "+mag.getAddr());
//         System.out.println();
//      }
      
      System.exit(0);
      
    }
    
 }


