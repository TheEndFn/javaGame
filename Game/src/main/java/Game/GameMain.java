package Game;  // Pacote do arquivo 

import javax.swing.SwingUtilities; // Importanto o SwingUtilities do Swing

public class GameMain { // Definindo minha classe Principal
    
    public static void main(String[] args) { // Main, ponto de entrada do Programa
       
        // Iniciando dentro do SwingUtilities para evitar problemas de performance
        SwingUtilities.invokeLater(() -> new TelaInicial());            // Inicia o JFrame TelaInicial
        
    }
    
}
