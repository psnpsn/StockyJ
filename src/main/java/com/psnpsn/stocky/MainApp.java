package com.psnpsn.stocky;

import com.psnpsn.stocky.model.Fournisseur;
import com.psnpsn.stocky.service.FournisseurService;
import com.psnpsn.stocky.utils.AppConfig;
import com.psnpsn.stocky.utils.StageManager;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
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
     
    public static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class) ; 
     
    public static double xOffset = 0;
    public static double yOffset = 0;
    private static final BorderPane root = new BorderPane();
    public static Stage stage;
    
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
        root.setStyle("-fx-border-size:2px");
        
        URL content = getClass().getResource("/fxml/login.fxml");
        AnchorPane middle = FXMLLoader.load(content);
        URL menu = getClass().getResource("/fxml/loginMenu.fxml");
        AnchorPane left = FXMLLoader.load(menu);
        root.setCenter(middle);
        root.setLeft(left);
        
        Scene scene = new Scene(root,1200,600);
        
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
        
        launch(args);
       
//      context =   new AnnotationConfigApplicationContext(AppConfig.class);
//      FournisseurService fournService = context.getBean(FournisseurService.class);
//      UserService usrService = context.getBean(UserService.class);
//      ProduitService prdService = context.getBean(ProduitService.class);
//      CategoriePrdService ctgService = context.getBean(CategoriePrdService.class);
//      MagasinService magService = context.getBean(MagasinService.class);
   
//      Fournisseur F = fournService.find(28);
//      fournService.create(new Fournisseur("FTOU7","EM, ENtity",2234,"EntityManager","HIBERNATE",9981232,9928222,"fat7ici@ftou7x.com"));
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
//      System.exit(0);
      
    }
    
 }


