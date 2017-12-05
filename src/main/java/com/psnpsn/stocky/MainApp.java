package com.psnpsn.stocky;

import com.psnpsn.stocky.utils.AppConfig;
import com.psnpsn.stocky.utils.StageManager;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

 @ComponentScans(value = { 
      @ComponentScan("com.psnpsn.stocky.dao"),
      @ComponentScan("com.psnpsn.stocky.service") 
    })
public class MainApp extends Application {
     
    public static AnnotationConfigApplicationContext context ; 
     
    public static double xOffset = 0;
    public static double yOffset = 0;
    private static final BorderPane root = new BorderPane();
    public static Stage stage;
    public static StageManager stager = new StageManager();
    
    public static BorderPane getRoot() {
        return root;
    }
    
    public static AnnotationConfigApplicationContext getContext(){
        return MainApp.context;
    }
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        stage=primaryStage;
        
        primaryStage.initStyle(StageStyle.UNDECORATED);
        root.setStyle("-fx-border-style:solid solid solid solid");
        root.setStyle("-fx-border-color:grey");
        
        URL content = getClass().getResource("/fxml/login.fxml");
        AnchorPane middle = FXMLLoader.load(content);
        root.setCenter(middle);
        
        Scene scene = new Scene(root,1200,680);
        
        primaryStage.setTitle("STOCKY");
        primaryStage.setScene(scene);
        primaryStage.show();


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
        context =   new AnnotationConfigApplicationContext(AppConfig.class);
        launch(args);
       
//
//      FournisseurService fournService = context.getBean(FournisseurService.class);
//      UserService usrService = context.getBean(UserService.class);
//      ProduitService prdService = context.getBean(ProduitService.class);
//      CategoriePrdService ctgService = context.getBean(CategoriePrdService.class);
//      MagasinService magService = context.getBean(MagasinService.class);
//      
//      Fournisseur F = fournService.find(28);
//      CategoriePrd C = ctgService.find(37);
//      Magasin M = magService.find(41);
//      System.out.println(""+F.getNom());
//      
//      Produit P = prdService.find(54);
//      System.out.println(""+P.getFourn().getId());
//      System.out.println(""+P.getFourn().getId());
//      System.out.println(""+P.getFourn().getId());
      
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


