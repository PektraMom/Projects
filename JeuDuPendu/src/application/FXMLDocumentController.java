package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class FXMLDocumentController implements Initializable {
	Scanner Clavier = new Scanner(System.in);
	
	int viesRestantes;
	String nomJoueur, reponse, devineLettre, devineMot;
	    
	    @FXML
	    private Label titreLabel, viesRestantesLabel, viesLabel, motLabel;
	    
	    @FXML
	    private TextField nomJoueurTxtField, scoreTxtField, trouverMotTxtField;

	    @FXML
	    private Button btnDebuterEtat, recommencer;
	    
	    @FXML
	    private Button btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK, 
	    btnL, btnM, btnN, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX,
	    btnY, btnZ;
	    
	    @FXML
	    private Circle Tete;
	    
	    @FXML
	    private Line Corps, brasDroite, brasGauche, jambeDroite, jambeGauche;
	    
		@FXML
	    void btnDebuter(ActionEvent event) {
			nomJoueur();
			viesRestantes--;
			afficherPartieCorps();
	    }
		
		void nouvellePartie() {
			recommencer.setDisable(false);
			if (viesRestantes == 7) {
				System.out.print("Bonjour " + nomJoueurTxtField.getText()
                                 .substring(0, 1).toUpperCase() + 
                                 nomJoueurTxtField.getText().substring(1) + ", ");
				System.out.println("vous avez débuté une nouvelle partie !");
			}
			
			// Vies de l'utilisateur
	    	viesRestantesLabel.setText("Vies restantes:");
            viesLabel.setText("6");
	    	
	    	// scoreTxtField
	    	scoreTxtField.setText("0");
	    	trouverMot();
	    	activerBoutons();
		}
		
		void nomJoueur() {
			String nomJoueur = nomJoueurTxtField.getText();
			     if (nomJoueur == "") {
			    	 System.out.println("Veuillez insérez des lettres !");
			    	 }

				nouvellePartie();
				nomJoueurTxtField.setText(nomJoueur.substring(0, 1).toUpperCase() + 
						nomJoueur.substring(1));
				nomJoueurTxtField.setDisable(true);
			}
		
		void trouverMot() {

			// Liste de mots array
	    	String[] listeMots = {"Mardi", "Ecole", "Chien", "Voiture", 
					"Oiseau", "Livre", "Recette", "Soleil", "Marteau", "Orange"};
	    	
	    	// For loop pour générer les mots dans listeMots
	    	for (int i = 0; i < listeMots.length; i++) {
	    		String motsRandom = listeMots[(int)(Math.random() * listeMots.length)];
	    		char[] lettres = new char[motsRandom.length()];
	    		
	    		// Remplacer les mots par '*' et '_'
	    	    trouverMotTxtField.setText
	    		(motsRandom.replaceAll("[a-zA-Z]", "*"));
	    		motLabel.setText(motsRandom.replaceAll("[a-zA-Z]", "_ "));
	    		btnDebuterEtat.setDisable(true);
	    	}
		}
		
		// Afficher partie du corps relié au nombre de vies restantes
		void afficherPartieCorps() {

			if (viesRestantes == 5) {
				Tete.setVisible(true);
				viesLabel.setText("5");
				System.out.println("Vous avez 5 vies !");
			}
			else if (viesRestantes == 4) {
				Corps.setVisible(true);
				viesLabel.setText("4");
				System.out.println("Vous avez 4 vies !");
			}
			else if (viesRestantes == 3) {
				brasGauche.setVisible(true);
				viesLabel.setText("3");
				System.out.println("Vous avez 3 vies !");
			}
			else if (viesRestantes == 2) {
				brasDroite.setVisible(true);
				viesLabel.setText("2");
				System.out.println("Vous avez 2 vies !");
			}
			else if (viesRestantes == 1) {
				jambeGauche.setVisible(true);
				viesLabel.setText("1");
				System.out.println("Vous avez 1 vie !");
			}
			else if (viesRestantes == 0) {
				jambeDroite.setVisible(true);
				viesLabel.setText("0");
				btnDebuterEtat.setDisable(true);
				trouverMotTxtField.clear();
				motLabel.setText("Vous avez perdu");
				System.out.println("-------------------------------------");
				System.out.println("Vous avez 0 vie !");
                System.out.println("Cliquez sur le bouton 'Recommencer' "
							+ "pour activer le bouton 'Débuter le jeu'");
			}
		}
		
		
		// Boutons (A-Z)
		void activerBoutons() {
			btnA.setDisable(false);
	    	btnB.setDisable(false);
	    	btnC.setDisable(false);
	    	btnD.setDisable(false);
	    	btnE.setDisable(false);
	    	btnF.setDisable(false);
	    	btnG.setDisable(false);
	    	btnH.setDisable(false);
	    	btnI.setDisable(false);
	    	btnJ.setDisable(false);
	    	btnK.setDisable(false);
	    	btnL.setDisable(false);
	    	btnM.setDisable(false);
	    	btnN.setDisable(false);
	    	btnO.setDisable(false);
	    	btnP.setDisable(false);
	    	btnQ.setDisable(false);
	    	btnR.setDisable(false);
	    	btnS.setDisable(false);
	    	btnT.setDisable(false);
	    	btnU.setDisable(false);
	    	btnV.setDisable(false);
	    	btnW.setDisable(false);
	    	btnX.setDisable(false);
	    	btnY.setDisable(false);
	    	btnZ.setDisable(false);
		}
		
		// Effacer bonhomme + TextField, Label et Boutons
		@FXML
	    void btnRecommencer(ActionEvent event) {
			viesRestantes = 7;
			viesRestantesLabel.setText("");
			viesLabel.setText("");
			motLabel.setText("");
			scoreTxtField.clear();
			trouverMotTxtField.clear();
			recommencer.setDisable(true);
			Tete.setVisible(false);
			Corps.setVisible(false);
			brasGauche.setVisible(false);
			brasDroite.setVisible(false);
			jambeGauche.setVisible(false);
			jambeDroite.setVisible(false);
			btnDebuterEtat.setDisable(false);
			activerBoutons();
	    }
		
	    @FXML
	    void btnQuitter(ActionEvent event) {
	    	// Quitter l'application avec clique sur le bouton
	    	System.out.println("-------------------------------------");
	    	System.out.println("Vous avez quitté l'application.");
	    	System.out.println("À bientôt !");
	    	System.out.println("-------------------------------------");
	    	System.out.println("");
	    	System.exit(0);
	    }
	    
	    @FXML
	    void boutonA(ActionEvent event) {
	    	btnA.setDisable(true);
	    }
	    @FXML
	    void boutonB(ActionEvent event) {
	    	btnB.setDisable(true);
	    }
	    @FXML
	    void boutonC(ActionEvent event) {
	    	btnC.setDisable(true);
	    }
	    @FXML
	    void boutonD(ActionEvent event) {
	    	btnD.setDisable(true);
	    }
	    @FXML
	    void boutonE(ActionEvent event) {
	    	btnE.setDisable(true);
	    }
	    @FXML
	    void boutonF(ActionEvent event) {
	    	btnF.setDisable(true);
	    }
	    @FXML
	    void boutonG(ActionEvent event) {
	    	btnG.setDisable(true);
	    }
	    @FXML
	    void boutonH(ActionEvent event) {
	    	btnH.setDisable(true);
	    }
	    @FXML
	    void boutonI(ActionEvent event) {
	    	btnI.setDisable(true);
	    }
	    @FXML
	    void boutonJ(ActionEvent event) {
	    	btnJ.setDisable(true);
	    }
	    @FXML
	    void boutonK(ActionEvent event) {
	    	btnK.setDisable(true);
	    }
	    @FXML
	    void boutonL(ActionEvent event) {
	    	btnL.setDisable(true);
	    }
	    @FXML
	    void boutonM(ActionEvent event) {
	    	btnM.setDisable(true);
	    }
	    @FXML
	    void boutonN(ActionEvent event) {
	    	btnN.setDisable(true);
	    }
	    @FXML
	    void boutonO(ActionEvent event) {
	    	btnO.setDisable(true);
	    }
	    @FXML
	    void boutonP(ActionEvent event) {
	    	btnP.setDisable(true);
	    }
	    @FXML
	    void boutonQ(ActionEvent event) {
	    	btnQ.setDisable(true);
	    }
	    @FXML
	    void boutonR(ActionEvent event) {
	    	btnR.setDisable(true);
	    }
	    @FXML
	    void boutonS(ActionEvent event) {
	    	btnS.setDisable(true);
	    }
	    @FXML
	    void boutonT(ActionEvent event) {
	    	btnT.setDisable(true);
	    }
	    @FXML
	    void boutonU(ActionEvent event) {
	    	btnU.setDisable(true);
	    }
	    @FXML
	    void boutonV(ActionEvent event) {
	    	btnV.setDisable(true);
	    }
	    @FXML
	    void boutonW(ActionEvent event) {
	    	btnW.setDisable(true);
	    }
	    @FXML
	    void boutonX(ActionEvent event) {
	    	btnX.setDisable(true);
	    }
	    @FXML
	    void boutonY(ActionEvent event) {
	    	btnY.setDisable(true);
	    }
	    @FXML
	    void boutonZ(ActionEvent event) {
	    	btnZ.setDisable(true);
	    }

		@Override
		public void initialize(URL url, ResourceBundle rb) {
		}
   
	
}
