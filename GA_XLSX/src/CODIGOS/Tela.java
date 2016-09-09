/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CODIGOS;

import static CODIGOS.Planilha.PS;
import static CODIGOS.Planilha.lerPlanilha;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.Timer;

/**
 *
 * @author Ismael Ribeiro
 */
public class Tela extends javax.swing.JFrame {
    
    public void play(String nomeDoAudio){
        
        URL url = getClass().getResource(nomeDoAudio+".wav");//wav
        AudioClip audio = Applet.newAudioClip(url);
        audio.play();
}
    
    public void chamar_Tecnico(String OPCAO){
        ////////////////////////////////////////////////////////////////////////
        /*SE NENHUM BOTAO ESTIVER HABILITADO*/
        if((BTN1.isSelected() && BTN2.isSelected() && BTN3.isSelected() && BTN4.isSelected() && BTN5.isSelected()) ||
          (!BTN1.isEnabled() && !BTN2.isEnabled() && !BTN3.isEnabled() && !BTN4.isEnabled() && !BTN5.isEnabled())){
            JOptionPane.showMessageDialog(null,"Habilite pelo menos um Técnico.","Aviso",JOptionPane.WARNING_MESSAGE);
        }////////////////////////////////////////////////////////////////////////
        else{
            
        int tentativas = 1;
        
        if(solicitar_senha == true){
        
        do{
            
        JPasswordField jpf = new JPasswordField();
            
        JOptionPane.showConfirmDialog(null,new Object[]{ jpf}, tentativas+"ª Tentativa, Digite a senha :",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        senha_digitada = new String(jpf.getPassword());
        
        if(senha_digitada.equals(senha_de_chamada)){
            funcao_principal();
        }else
        if(!senha_digitada.equals(senha_de_chamada) && !senha_digitada.equals("")){
            JOptionPane.showMessageDialog(null,"Senha incorreta.","                                    "+
                     "Warning",JOptionPane.WARNING_MESSAGE);
            tentativas++;
        }else
        if(senha_digitada.equals("")){
            JOptionPane.showMessageDialog(null,"Digite algo ....","                                    "+
                     "Warning",JOptionPane.WARNING_MESSAGE);
            tentativas++;
        }
        }while(!senha_digitada.equals(senha_de_chamada));
            
        }else{
            
            funcao_principal();
            
            contador_chamar_novamente = 0;
            
            try {
                Robot bot = new Robot();
                bot.delay(3000);
            } catch (AWTException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println(v);
            
            if(falar_situacao == true){
                opcao = "";
                
                opcao = OPCAO;
                
            
            if(opcao.equals("0")){
                play("/CODIGOS/Sons/checklist");
            }else
            if(opcao.equals("1")){
                play("/CODIGOS/Sons/recarga_de_cartucho");
            }else
            if(opcao.equals("2")){
                play("/CODIGOS/Sons/situacao_diferenciada");
            }else
            if(opcao.equals("3")){
                play("/CODIGOS/Sons/tirar_duvida_de_cliente");
            }else
            if(opcao.equals("4")){
                play("/CODIGOS/Sons/atendimento_para_gerar_credito");//GERAR CREDITO
            }else
            if(opcao.equals("5")){
                play("/CODIGOS/Sons/troca_em_garantia");
            }else
            if(opcao.equals("6")){
                play("/CODIGOS/Sons/atendimento_para_plus");
            }
            }
                
        }
            
        }
    }
    
    public static String[] PSL2;
    public static String[] PSL3;
    public static String[] PSL4;
    public static String[] PSL5;
    public static String[] PSL6;
    
    public int v;//Vez
    public int TDA;//Total de Atendimentos
    public int AT1;//Atendimentos Técnico 1
    public int AT2;//Atendimentos Técnico 2
    public int AT3;//Atendimentos Técnico 3
    public int AT4;//Atendimentos Técnico 4
    public int AT5;//Atendimentos Técnico 5
    public static int contador, contador_piada, contador_chamar_novamente;
    public int QDT;
    
    public int HCT1;
    public int MCT1;
    public int HST1;
    public int MST1;
    public String ET1;
    public String ST1;
    
    public int HCT2;
    public int MCT2;
    public int HST2;
    public int MST2;
    public String ET2;
    public String ST2;
    
    public int HCT3;
    public int MCT3;
    public int HST3;
    public int MST3;
    public String ET3;
    public String ST3;
    
    public int HCT4;
    public int MCT4;
    public int HST4;
    public int MST4;
    public String ET4;
    public String ST4;
    
    public int HCT5;
    public int MCT5;
    public int HST5;
    public int MST5;
    public String ET5;
    public String ST5;
    
    public int hora, minuto, segundo;
    public String horas;
    public String opcao;
    public Calendar now;
    public Timer timer;
    
    public String segundos;
    public String minutos;
    public String HC;//HORARIO CRONOMETRO
    public int minutos_int;
    public int horas_int;
    
    public String arquivo = "CONFIG4";
    public String senha_de_chamada = "19216811";
    public String Senha = "CP1318RMKLZ";
    public String senha_digitada = "";
    public boolean solicitar_senha = false;
    public boolean habilitar_som = true;
    public boolean habilitar_piadas = true;
    public boolean habilitar_alarme = true;
    public boolean falar_situacao = true;
    
    public MenuSobre about;
   
    /**
     * Creates new form Tela
     */
    public Tela() {
        
        initComponents();
        
        about = new MenuSobre();
        
    }
    
    public void inicioVisibilidadeBotoes(Boolean t1, Boolean t2, Boolean t3, Boolean t4, Boolean t5){
        BTN1.setVisible(t1);
        BTN2.setVisible(t2);
        BTN3.setVisible(t3);
        BTN4.setVisible(t4);
        BTN5.setVisible(t5);
    }
    
    public void inicioNomeBotoes(String N1, String N2, String N3, String N4, String N5){
        BTN1.setText(N1);
        BTN2.setText(N2);
        BTN3.setText(N3);
        BTN4.setText(N4);
        BTN5.setText(N5);
    }
    
    public void obterHoras(){
        now = Calendar.getInstance();
        horas = String.format("%1$tH:%1$tM:%1$tS", now);//HORAS NO FORMATO 13:00:00
        hora = Integer.parseInt(String.format("%1$tH", now));//HORAS 13
        minuto = Integer.parseInt(String.format("%1$tM", now));//MINUTO 00
        segundo = Integer.parseInt(String.format("%1$tS", now));//SEGUNDO
    }
    
    public void funcao_principal(){
        switch (QDT) {
            case 5:
                BOTAO_ZERAR.setEnabled(true);//Ao primeiro clique habilita o botão zerar
                v++;//A cada clique incrementa +1
                ////////////////////////////////////////////////////////////////////////
                /*SE NENHUM BOTAO ESTIVER HABILITADO*/
                if((BTN1.isSelected() && BTN2.isSelected() && BTN3.isSelected() && BTN4.isSelected() && BTN5.isSelected()) ||
                        (!BTN1.isEnabled() && !BTN2.isEnabled() && !BTN3.isEnabled() && !BTN4.isEnabled() && !BTN5.isEnabled())){
                    JOptionPane.showMessageDialog(null,"Habilite pelo menos um Técnico.","Aviso",JOptionPane.WARNING_MESSAGE);
                }       ////////////////////////////////////////////////////////////////////////
                /*SE APENAS O 5° TÉCNICO ESTIVER HABILITADO*/
                if((BTN1.isSelected() && BTN2.isSelected() && BTN3.isSelected() && BTN4.isSelected() && !BTN5.isSelected()) ||
                        (!BTN1.isEnabled() && !BTN2.isEnabled() && !BTN3.isEnabled() && !BTN4.isEnabled() && BTN5.isEnabled())){
                    v = 5;
                }       if(v == 1 && (BTN1.isSelected() && BTN2.isSelected() && BTN3.isSelected() && BTN4.isSelected() && !BTN5.isSelected()) || 
                        (!BTN1.isEnabled() && !BTN2.isEnabled() && !BTN3.isEnabled() && !BTN4.isEnabled() && BTN5.isEnabled())){
                    
                    TEXTO_NOME_DA_VEZ.setText(PSL6[0]+" - "+PSL6[1]);
                    AT5++;
                    BTN5.setText(PSL6[0]+" - "+AT5);
                    TDA++;
                    
                }
                //POSSIVEL SOLUCAO PARA O ERRO GRAVE DO DIA 31/08/2016
                /*AO INICIAR COM O ARQUIVO CONFIG5 E COM O 2º E 3º TÉCNICO DESABILITADO O ÚLTIMO TÉCNICO NÃO ERA CHAMADO, MESMO 
                ESTANDO HABILITADO PARA SER CHAMADO.
                A SOLUCAO PARCIAL FOI DEIXAR COMO COMENTARIO O CODIGO QUE INICIAVA O 3º TECNICO COMO DESABILITADO SE NAO ESTIVESSE
                NO HORARIO DE TRABALHO, FAZENDO ASSIM 
                COM QUE, MESMO INICIANDO EM VERMELHO ERA POSSIVEL HABILITAR O MESMO.*/
                ////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////
                /*SE APENAS O 2º E O 3º TÉCNICO ESTIVEREM DESABILITADOS*/
                if(v == 5 && !BTN1.isSelected() && BTN2.isSelected() && BTN3.isSelected() && !BTN4.isSelected() && !BTN5.isSelected()){
                    
                    TEXTO_NOME_DA_VEZ.setText(PSL6[0]+" - "+PSL6[1]);
                    AT5++;
                    BTN5.setText(PSL6[0]+" - "+AT5);
                    TDA++;
                    
                    v = 0;
                }
                ////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////
                /*SE APENAS O 2º O 3º E O 4º TÉCNICO ESTIVEREM HABILITADOS*/
                if(v == 5 && !BTN2.isSelected() && !BTN3.isSelected() && BTN1.isSelected() && !BTN4.isSelected() && BTN5.isSelected()){
                    v = v - 4;
                }       ////////////////////////////////////////////////////////////////////////
                /*SE APENAS O 3º E O 4º TÉCNICO ESTIVEREM HABILITADOS*/
                if(v == 5 && BTN2.isSelected() && !BTN3.isSelected() && BTN1.isSelected() && !BTN4.isSelected() && BTN5.isSelected()){
                    v = v - 3;
                }       ////////////////////////////////////////////////////////////////////////
                /*SE APENAS O 2º E O 3º TÉCNICO ESTIVEREM HABILITADOS*/
                if(v == 4 && !BTN2.isSelected() && !BTN3.isSelected() && BTN1.isSelected() && BTN4.isSelected() && BTN5.isSelected()){
                    v = v - 2;
                }       ////////////////////////////////////////////////////////////////////////
                /*SE APENAS O 2º E O 4º TÉCNICO ESTIVEREM HABILITADOS*/
                if(v == 5 && !BTN2.isSelected() && BTN3.isSelected() && BTN1.isSelected() && !BTN4.isSelected() && BTN5.isSelected()){
                    v = v - 3;
                }       ////////////////////////////////////////////////////////////////////////
                /*NA VEZ DO TÉCNICO E O MESMO ESTIVER DESABILITADO*/
                if(v == 1 && BTN1.isSelected() || v == 1 && !BTN1.isEnabled()){
                    v++;
                }       if(v == 2 && BTN2.isSelected() || v == 2 && !BTN2.isEnabled()){
                    v++;
                }       if(v == 3 && BTN3.isSelected() || v == 3 && !BTN3.isEnabled()){
                    v++;
                }       if(v == 4 && BTN4.isSelected() || v == 4 && !BTN4.isEnabled()){
                    v++;
                }       if(v == 5 && BTN5.isSelected() || v == 5 && !BTN3.isEnabled()){
                    v=1;
                }       ////////////////////////////////////////////////////////////////////////
                /*SE APENAS O 2º TÉCNICO ESTIVER HABILITADO*/
                if(BTN1.isSelected() && BTN3.isSelected() && BTN4.isSelected() && BTN5.isSelected()){
                    v=2;
                }       ////////////////////////////////////////////////////////////////////////
                /*SE APENAS O 3º TÉCNICO ESTIVER HABILITADO*/
                if(BTN1.isSelected() && BTN2.isSelected() && BTN4.isSelected() && BTN5.isSelected()){
                    v=3;
                }       ////////////////////////////////////////////////////////////////////////
                /*SE APENAS O 4º TÉCNICO ESTIVER HABILITADO*/
                if(BTN1.isSelected() && BTN2.isSelected() && BTN3.isSelected() && BTN5.isSelected()){
                    v=4;
                }       ////////////////////////////////////////////////////////////////////////
                /*NA VEZ DO TÉCNICO E O MESMO ESTIVER HABILITADO*/
                if(v == 1 && !BTN1.isSelected()){
                    
                    TEXTO_NOME_DA_VEZ.setText(PSL2[0]+" - "+PSL2[1]);
                    AT1++;
                    BTN1.setText(PSL2[0]+" - "+AT1);
                    TDA++;
                    
                }       if(v == 2 && !BTN2.isSelected()){
                    
                    TEXTO_NOME_DA_VEZ.setText(PSL3[0]+" - "+PSL3[1]);
                    AT2++;
                    BTN2.setText(PSL3[0]+" - "+AT2);
                    TDA++;
                    
                }       if(v == 3 && !BTN3.isSelected()){ 
                    
                    TEXTO_NOME_DA_VEZ.setText(PSL4[0]+" - "+PSL4[1]);
                    AT3++;
                    BTN3.setText(PSL4[0]+" - "+AT3);
                    TDA++;
                    
                }       if(v == 4 && !BTN4.isSelected()){ 
                    
                    TEXTO_NOME_DA_VEZ.setText(PSL5[0]+" - "+PSL5[1]);
                    AT4++;
                    BTN4.setText(PSL5[0]+" - "+AT4);
                    TDA++;
                    
                }       if(v == 5 && !BTN5.isSelected()){ 
                    
                    TEXTO_NOME_DA_VEZ.setText(PSL6[0]+" - "+PSL6[1]);
                    AT5++;
                    BTN5.setText(PSL6[0]+" - "+AT5);
                    TDA++;
                    
                    v = 0;
                }       ////////////////////////////////////////////////////////////////////////
                /*NA VEZ DO ÚLTIMO TÉCNICO E O MESMO ESTIVER DESABILITADO*/
                if(v == 5 && BTN5.isSelected() || v == 5 && !BTN5.isEnabled()){ 
                    v = 0;
                }       ////////////////////////////////////////////////////////////////////////
                TEXTO_TOTAL.setText("Atendimentos : "+TDA);
                
                break;
        /**********************************************************************/
            case 4:
                BOTAO_ZERAR.setEnabled(true);//Ao primeiro clique habilita o botão zerar
                v++;//A cada clique incrementa +1
                ////////////////////////////////////////////////////////////////////////
                /*SE NENHUM BOTAO ESTIVER HABILITADO*/
                if((BTN1.isSelected() && BTN2.isSelected() && BTN3.isSelected() && BTN4.isSelected()) ||
                        (!BTN1.isEnabled() && !BTN2.isEnabled() && !BTN3.isEnabled() && !BTN4.isEnabled())){
                    JOptionPane.showMessageDialog(null,"Habilite pelo menos um Técnico.","Aviso",JOptionPane.WARNING_MESSAGE);
                }       /*SE APENAS O 2º TÉCNICO ESTIVER HABILITADO*/
                if(BTN1.isSelected() && BTN3.isSelected() && BTN4.isSelected()){
                    v=2;
                }       /*SE APENAS O 3º TÉCNICO ESTIVER HABILITADO*/
                if(BTN1.isSelected() && BTN2.isSelected() && BTN4.isSelected()){
                    v=3;
                }       /*SE APENAS O 2º E O 3º TÉCNICO ESTIVEREM HABILITADOS*/
                if(v == 4 && !BTN2.isSelected() && !BTN3.isSelected() && BTN1.isSelected() && BTN4.isSelected()){
                    v = v - 2;
                }       ////////////////////////////////////////////////////////////////////////
                /*NA VEZ DO TÉCNICO E O MESMO ESTIVER DESABILITADO*/
                if(v == 1 && BTN1.isSelected() || v == 1 && !BTN1.isEnabled()){
                    v++;
                }       if(v == 2 && BTN2.isSelected() || v == 2 && !BTN2.isEnabled()){
                    v++;
                }       if(v == 3 && BTN3.isSelected() || v == 3 && !BTN3.isEnabled()){
                    v++;
                }       if(v == 4 && BTN4.isSelected() || v == 4 && !BTN4.isEnabled()){
                    v=1;
                }       ////////////////////////////////////////////////////////////////////////
                /*NA VEZ DO TÉCNICO E O MESMO ESTIVER HABILITADO*/
                if(v == 1 && !BTN1.isSelected()){
                    
                    if(habilitar_som == true){
                        play("/CODIGOS/Sons/002228");
                    }
                    TEXTO_NOME_DA_VEZ.setText(PSL2[0]+" - "+PSL2[1]);
                    AT1++;
                    BTN1.setText(PSL2[0]+" - "+AT1);
                    TDA++;
                    
                }       if(v == 2 && !BTN2.isSelected()){
                    
                    if(habilitar_som == true){
                        play("/CODIGOS/Sons/002583");
                    }
                    TEXTO_NOME_DA_VEZ.setText(PSL3[0]+" - "+PSL3[1]);
                    AT2++;
                    BTN2.setText(PSL3[0]+" - "+AT2);
                    TDA++;
                    
                }       if(v == 3 && !BTN3.isSelected()){ 
                    
                    if(habilitar_som == true){
                        play("/CODIGOS/Sons/002423");
                    }
                    TEXTO_NOME_DA_VEZ.setText(PSL4[0]+" - "+PSL4[1]);
                    AT3++;
                    BTN3.setText(PSL4[0]+" - "+AT3);
                    TDA++;
                    
                }       if(v == 4 && !BTN4.isSelected()){ 
                    
                    if(habilitar_som == true){
                        play("/CODIGOS/Sons/003263");
                    }
                    TEXTO_NOME_DA_VEZ.setText(PSL5[0]+" - "+PSL5[1]);
                    AT4++;
                    BTN4.setText(PSL5[0]+" - "+AT4);
                    TDA++;
                    v=0;
                }       ////////////////////////////////////////////////////////////////////////
                /*NA VEZ DO ÚLTIMO TÉCNICO E O MESMO ESTIVER DESABILITADO*/
                if(v == 4 && BTN4.isSelected() || v == 4 && !BTN4.isEnabled()){
                    v = 0;
                }       ////////////////////////////////////////////////////////////////////////
                TEXTO_TOTAL.setText("Atendimentos : "+TDA);
                
                break;
        /**********************************************************************/
            case 3:
                BOTAO_ZERAR.setEnabled(true);//Ao primeiro clique habilita o botão zerar
                v++;//A cada clique incrementa +1
                ////////////////////////////////////////////////////////////////////////
                /*SE NENHUM BOTAO ESTIVER HABILITADO*/
                if(BTN2.isSelected() && BTN3.isSelected() && BTN4.isSelected() ||
                        !BTN2.isEnabled() && !BTN3.isEnabled() && !BTN4.isEnabled()){
                    JOptionPane.showMessageDialog(null,"Habilite pelo menos um Técnico.","Aviso",JOptionPane.WARNING_MESSAGE);
                }       ////////////////////////////////////////////////////////////////////////
                /*SE A VEZ FOR DO 1º E O MESMO ESTIVER DESABILITADO*/
                if(v == 1 && BTN2.isSelected() || v == 1 && !BTN2.isEnabled()){
                    v++;
                }       ////////////////////////////////////////////////////////////////////////
                /*SE A VEZ FOR DO 2º E O MESMO ESTIVER DESABILITADO*/
                if(v == 2 && BTN3.isSelected() || v == 2 && !BTN3.isEnabled()){
                    v++;
                }       ////////////////////////////////////////////////////////////////////////
                /*SE A VEZ FOR DO 3º E O MESMO ESTIVER DESABILITADO*/
                if(v == 3 && BTN4.isSelected() || v == 3 && !BTN4.isEnabled()){
                    v=1;
                }       ////////////////////////////////////////////////////////////////////////
                /*SE APENAS O 2º BOTAO ESTIVER HABILITADO*/
                if(BTN2.isSelected() && BTN4.isSelected()){
                    v=3;
                }       ////////////////////////////////////////////////////////////////////////
                /*SE A VEZ FOR DO 1º E O MESMO ESTIVER HABILITADO*/
                if(v == 1 && !BTN2.isSelected()){
                    
                    if(habilitar_som == true){
                        play("/CODIGOS/Sons/002228");
                    }
                    TEXTO_NOME_DA_VEZ.setText(PSL2[0]+" - "+PSL2[1]);
                    AT1++;
                    BTN2.setText(PSL2[0]+" - "+AT1);
                    TDA++;
                    
                }       ////////////////////////////////////////////////////////////////////////
                /*SE A VEZ FOR DO 2º E O MESMO ESTIVER HABILITADO*/
                if(v == 2 && !BTN3.isSelected()){
                    
                    if(habilitar_som == true){
                        play("/CODIGOS/Sons/002583");
                    }
                    TEXTO_NOME_DA_VEZ.setText(PSL3[0]+" - "+PSL3[1]);
                    AT2++;
                    BTN3.setText(PSL3[0]+" - "+AT2);
                    TDA++;
                    
                }       ////////////////////////////////////////////////////////////////////////
                /*SE A VEZ FOR DO 3º E O MESMO ESTIVER HABILITADO*/
                if(v == 3 && !BTN4.isSelected()){
                    
                    if(habilitar_som == true){
                        play("/CODIGOS/Sons/002423");
                    }
                    TEXTO_NOME_DA_VEZ.setText(PSL4[0]+" - "+PSL4[1]);
                    AT3++;
                    BTN4.setText(PSL4[0]+" - "+AT3);
                    TDA++;
                    
                    v = 0;
                }       ////////////////////////////////////////////////////////////////////////
                /*SE A VEZ FOR DO 3º E O MESMO ESTIVER DESABILITADO*/
                if(v == 3 && BTN4.isSelected() || v == 3 && !BTN4.isEnabled()){
                    v = 2;
                }       ////////////////////////////////////////////////////////////////////////
                /*SE APENAS O 2º TÉCNICO ESTIVER HABILITADO*/
                if(BTN4.isSelected() && BTN2.isSelected() && !BTN3.isSelected()){
                    
                    if(habilitar_som == true){
                        play("/CODIGOS/Sons/002583");
                    }
                    TEXTO_NOME_DA_VEZ.setText(PSL3[0]+" - "+PSL3[1]);
                    AT2++;
                    BTN3.setText(PSL3[0]+" - "+AT2);
                    TDA++;
                    
                    v = 0;
                }       ////////////////////////////////////////////////////////////////////////
                TEXTO_TOTAL.setText("Atendimentos : "+TDA);
                
                break;
            default:
                break;
        }     
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JanelaInternaPrincipal = new javax.swing.JDesktopPane();
        BTN1 = new javax.swing.JToggleButton();
        BTN2 = new javax.swing.JToggleButton();
        BTN3 = new javax.swing.JToggleButton();
        BTN4 = new javax.swing.JToggleButton();
        BTN5 = new javax.swing.JToggleButton();
        TEXTO_NOME_DA_VEZ = new javax.swing.JLabel();
        BOTAO_ZERAR = new javax.swing.JButton();
        TEXTO_TOTAL = new javax.swing.JLabel();
        TEXTO_HORA = new javax.swing.JLabel();
        TEXTO_DESENVOLVEDOR = new javax.swing.JLabel();
        TEXTO_CRONOMETRO = new javax.swing.JLabel();
        BOTAO_SOLICITAR_SENHA = new javax.swing.JToggleButton();
        BOTAO_SOM = new javax.swing.JToggleButton();
        BOTAO_PIADAS = new javax.swing.JToggleButton();
        BOTAO_CHAMAR_NOVAMENTE = new javax.swing.JButton();
        BTN_CHECKLIST = new javax.swing.JButton();
        BTN_RECARGA = new javax.swing.JButton();
        BTN_SITU_DIFE = new javax.swing.JButton();
        BTN_TIRA_DUVI = new javax.swing.JButton();
        BTN_GERAR_CRED = new javax.swing.JButton();
        BTN_TROCA_GARAN = new javax.swing.JButton();
        BTN_PLUS = new javax.swing.JButton();
        PAPEL_DE_PAREDE = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuConfigurar = new javax.swing.JMenu();
        jMenuItemConfigurar = new javax.swing.JMenuItem();
        jMenuSobre = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Atendimento");
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JanelaInternaPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTN1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BTN1.setText("Técnico 1");
        BTN1.setContentAreaFilled(false);
        BTN1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN1MouseEntered(evt);
            }
        });
        JanelaInternaPrincipal.add(BTN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, -1, -1));

        BTN2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BTN2.setText("Técnico 2");
        BTN2.setContentAreaFilled(false);
        BTN2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN2MouseEntered(evt);
            }
        });
        JanelaInternaPrincipal.add(BTN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, -1, -1));

        BTN3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BTN3.setText("Técnico 3");
        BTN3.setContentAreaFilled(false);
        BTN3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN3MouseEntered(evt);
            }
        });
        JanelaInternaPrincipal.add(BTN3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, -1, -1));

        BTN4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BTN4.setText("Técnico 4");
        BTN4.setBorderPainted(false);
        BTN4.setContentAreaFilled(false);
        BTN4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN4MouseEntered(evt);
            }
        });
        JanelaInternaPrincipal.add(BTN4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, -1, -1));

        BTN5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BTN5.setText("Técnico 5");
        BTN5.setContentAreaFilled(false);
        BTN5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN5MouseEntered(evt);
            }
        });
        JanelaInternaPrincipal.add(BTN5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, -1, -1));

        TEXTO_NOME_DA_VEZ.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        TEXTO_NOME_DA_VEZ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JanelaInternaPrincipal.add(TEXTO_NOME_DA_VEZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 680, 90));

        BOTAO_ZERAR.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BOTAO_ZERAR.setText("ZERAR");
        BOTAO_ZERAR.setContentAreaFilled(false);
        BOTAO_ZERAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOTAO_ZERARActionPerformed(evt);
            }
        });
        JanelaInternaPrincipal.add(BOTAO_ZERAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        TEXTO_TOTAL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TEXTO_TOTAL.setText("Atendimentos : ");
        JanelaInternaPrincipal.add(TEXTO_TOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        TEXTO_HORA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TEXTO_HORA.setText("00:00:00");
        JanelaInternaPrincipal.add(TEXTO_HORA, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, -1, -1));

        TEXTO_DESENVOLVEDOR.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TEXTO_DESENVOLVEDOR.setText("Desenvolvedor : Ismael Ribeiro                                                                                                                               Versão: 020920161624");
        JanelaInternaPrincipal.add(TEXTO_DESENVOLVEDOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        TEXTO_CRONOMETRO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TEXTO_CRONOMETRO.setText("00:00:00");
        JanelaInternaPrincipal.add(TEXTO_CRONOMETRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));

        BOTAO_SOLICITAR_SENHA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CODIGOS/Imagens/chave_1.png"))); // NOI18N
        BOTAO_SOLICITAR_SENHA.setToolTipText("Habilitar / Desabilitar Solicitação de Senha");
        BOTAO_SOLICITAR_SENHA.setBorder(null);
        BOTAO_SOLICITAR_SENHA.setBorderPainted(false);
        BOTAO_SOLICITAR_SENHA.setContentAreaFilled(false);
        BOTAO_SOLICITAR_SENHA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOTAO_SOLICITAR_SENHAActionPerformed(evt);
            }
        });
        JanelaInternaPrincipal.add(BOTAO_SOLICITAR_SENHA, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, -1));

        BOTAO_SOM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CODIGOS/Imagens/som_habilitado.png"))); // NOI18N
        BOTAO_SOM.setToolTipText("Habilitar / Desabilitar Som");
        BOTAO_SOM.setBorder(null);
        BOTAO_SOM.setBorderPainted(false);
        BOTAO_SOM.setContentAreaFilled(false);
        BOTAO_SOM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOTAO_SOMActionPerformed(evt);
            }
        });
        JanelaInternaPrincipal.add(BOTAO_SOM, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, -1));

        BOTAO_PIADAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CODIGOS/Imagens/joker_icon.png"))); // NOI18N
        BOTAO_PIADAS.setBorder(null);
        BOTAO_PIADAS.setContentAreaFilled(false);
        BOTAO_PIADAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOTAO_PIADASActionPerformed(evt);
            }
        });
        JanelaInternaPrincipal.add(BOTAO_PIADAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        BOTAO_CHAMAR_NOVAMENTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CODIGOS/Imagens/repeat_icon.png"))); // NOI18N
        BOTAO_CHAMAR_NOVAMENTE.setToolTipText("");
        BOTAO_CHAMAR_NOVAMENTE.setBorder(null);
        BOTAO_CHAMAR_NOVAMENTE.setContentAreaFilled(false);
        BOTAO_CHAMAR_NOVAMENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOTAO_CHAMAR_NOVAMENTEActionPerformed(evt);
            }
        });
        JanelaInternaPrincipal.add(BOTAO_CHAMAR_NOVAMENTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, -1, -1));

        BTN_CHECKLIST.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BTN_CHECKLIST.setText("CHECKLIST");
        BTN_CHECKLIST.setBorder(null);
        BTN_CHECKLIST.setContentAreaFilled(false);
        BTN_CHECKLIST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CHECKLISTActionPerformed(evt);
            }
        });
        JanelaInternaPrincipal.add(BTN_CHECKLIST, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        BTN_RECARGA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BTN_RECARGA.setText("RECARGA DE CARTUCHO");
        BTN_RECARGA.setBorder(null);
        BTN_RECARGA.setContentAreaFilled(false);
        BTN_RECARGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_RECARGAActionPerformed(evt);
            }
        });
        JanelaInternaPrincipal.add(BTN_RECARGA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        BTN_SITU_DIFE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BTN_SITU_DIFE.setText("SITUAÇÃO DIFERENCIADA");
        BTN_SITU_DIFE.setBorder(null);
        BTN_SITU_DIFE.setContentAreaFilled(false);
        BTN_SITU_DIFE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SITU_DIFEActionPerformed(evt);
            }
        });
        JanelaInternaPrincipal.add(BTN_SITU_DIFE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        BTN_TIRA_DUVI.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BTN_TIRA_DUVI.setText("TIRAR DÚVIDA DE CLIENTE");
        BTN_TIRA_DUVI.setBorder(null);
        BTN_TIRA_DUVI.setContentAreaFilled(false);
        BTN_TIRA_DUVI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_TIRA_DUVIActionPerformed(evt);
            }
        });
        JanelaInternaPrincipal.add(BTN_TIRA_DUVI, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        BTN_GERAR_CRED.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BTN_GERAR_CRED.setText("GERAR CRÉDITO");
        BTN_GERAR_CRED.setBorder(null);
        BTN_GERAR_CRED.setContentAreaFilled(false);
        BTN_GERAR_CRED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_GERAR_CREDActionPerformed(evt);
            }
        });
        JanelaInternaPrincipal.add(BTN_GERAR_CRED, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        BTN_TROCA_GARAN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BTN_TROCA_GARAN.setText("TROCA EM GARANTIA");
        BTN_TROCA_GARAN.setBorder(null);
        BTN_TROCA_GARAN.setContentAreaFilled(false);
        BTN_TROCA_GARAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_TROCA_GARANActionPerformed(evt);
            }
        });
        JanelaInternaPrincipal.add(BTN_TROCA_GARAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        BTN_PLUS.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BTN_PLUS.setText("PLUS");
        BTN_PLUS.setBorder(null);
        BTN_PLUS.setContentAreaFilled(false);
        BTN_PLUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PLUSActionPerformed(evt);
            }
        });
        JanelaInternaPrincipal.add(BTN_PLUS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        PAPEL_DE_PAREDE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CODIGOS/Imagens/vistamizer-windows-vista-wallpaper-pack-14.jpg"))); // NOI18N
        PAPEL_DE_PAREDE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PAPEL_DE_PAREDEMouseClicked(evt);
            }
        });
        JanelaInternaPrincipal.add(PAPEL_DE_PAREDE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(JanelaInternaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuConfigurar.setText("Arquivo");

        jMenuItemConfigurar.setText("Configurar");
        jMenuItemConfigurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConfigurarActionPerformed(evt);
            }
        });
        jMenuConfigurar.add(jMenuItemConfigurar);

        jMenuBar1.add(jMenuConfigurar);

        jMenuSobre.setText("Ajuda");

        jMenuItem2.setText("Sobre");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuSobre.add(jMenuItem2);

        jMenuBar1.add(jMenuSobre);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        lerPlanilha(arquivo);
        
        /*QDT*/
        QDT = Integer.parseInt(PS[0]);
        
        if(QDT == 3){
            
        PSL2 = new String[8];
        PSL3 = new String[8];
        PSL4 = new String[8];
        
        /*    NOME    */
        PSL2[0] = PS[6];
        PSL3[0] = PS[12];
        PSL4[0] = PS[18];
        
        /*EM*/
        PSL2[1] = PS[7];
        PSL3[1] = PS[13];
        PSL4[1] = PS[19];
        
        /*HORA ENTRADA*/
        PSL2[2] = PS[8];
        PSL3[2] = PS[14];
        PSL4[2] = PS[20];
        
        /*MINUTO ENTRADA*/
        PSL2[3] = PS[9];
        PSL3[3] = PS[15];
        PSL4[3] = PS[21];
        
        /*HORA SAIDA*/
        PSL2[4] = PS[10];
        PSL3[4] = PS[16];
        PSL4[4] = PS[22];
        
        /*MINUTO ENTRADA*/
        PSL2[5] = PS[11];
        PSL3[5] = PS[17];
        PSL4[5] = PS[23];
        
        /*   ENTRADA   */
        if(Integer.parseInt(PS[8]) < 10 && Integer.parseInt(PS[9]) < 10){
        PSL2[6] = "0"+PS[8]+":0"+PS[9]+":00";
        }else
        if(Integer.parseInt(PS[8]) > 9 && Integer.parseInt(PS[9]) > 9){
        PSL2[6] = PS[8]+":"+PS[9]+":00";
        }else
        if(Integer.parseInt(PS[8]) < 10 && Integer.parseInt(PS[9]) > 9){
        PSL2[6] = "0"+PS[8]+":"+PS[9]+":00";
        }else
        if(Integer.parseInt(PS[8]) > 9 && Integer.parseInt(PS[9]) < 10){
        PSL2[6] = PS[8]+":0"+PS[9]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[14]) < 10 && Integer.parseInt(PS[15]) < 10){
        PSL3[6] = "0"+PS[14]+":0"+PS[15]+":00";
        }else
        if(Integer.parseInt(PS[14]) > 9 && Integer.parseInt(PS[15]) > 9){
        PSL3[6] = PS[14]+":"+PS[15]+":00";
        }else
        if(Integer.parseInt(PS[14]) < 10 && Integer.parseInt(PS[15]) > 9){
        PSL3[6] = "0"+PS[14]+":"+PS[15]+":00";
        }else
        if(Integer.parseInt(PS[14]) > 9 && Integer.parseInt(PS[15]) < 10){
        PSL3[6] = PS[14]+":0"+PS[15]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[20]) < 10 && Integer.parseInt(PS[21]) < 10){
        PSL4[6] = "0"+PS[20]+":0"+PS[21]+":00";
        }else
        if(Integer.parseInt(PS[20]) > 9 && Integer.parseInt(PS[21]) > 9){
        PSL4[6] = PS[20]+":"+PS[21]+":00";
        }else
        if(Integer.parseInt(PS[20]) < 10 && Integer.parseInt(PS[21]) > 9){
        PSL4[6] = "0"+PS[20]+":"+PS[21]+":00";
        }else
        if(Integer.parseInt(PS[20]) > 9 && Integer.parseInt(PS[21]) < 10){
        PSL4[6] = PS[20]+":0"+PS[21]+":00";
        }
        
        /*   SAIDA   */
        if(Integer.parseInt(PS[10]) < 10 && Integer.parseInt(PS[11]) < 10){
        PSL2[7] = "0"+PS[10]+":0"+PS[11]+":00";
        }else
        if(Integer.parseInt(PS[10]) > 9 && Integer.parseInt(PS[11]) > 9){
        PSL2[7] = PS[10]+":"+PS[11]+":00";
        }else
        if(Integer.parseInt(PS[10]) > 9 && Integer.parseInt(PS[11]) < 10){
        PSL2[7] = PS[10]+":0"+PS[11]+":00";
        }else
        if(Integer.parseInt(PS[10]) < 10 && Integer.parseInt(PS[11]) > 9){
        PSL2[7] = "0"+PS[10]+":"+PS[11]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[16]) < 10 && Integer.parseInt(PS[17]) < 10){
        PSL3[7] = "0"+PS[16]+":0"+PS[17]+":00";
        }else
        if(Integer.parseInt(PS[16]) > 9 && Integer.parseInt(PS[17]) > 9){
        PSL3[7] = PS[16]+":"+PS[17]+":00";
        }else
        if(Integer.parseInt(PS[16]) > 9 && Integer.parseInt(PS[17]) < 10){
        PSL3[7] = PS[16]+":0"+PS[17]+":00";
        }else
        if(Integer.parseInt(PS[16]) < 10 && Integer.parseInt(PS[17]) > 9){
        PSL3[7] = "0"+PS[16]+":"+PS[17]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[22]) < 10 && Integer.parseInt(PS[23]) < 10){
        PSL4[7] = "0"+PS[22]+":0"+PS[23]+":00";
        }else
        if(Integer.parseInt(PS[22]) > 9 && Integer.parseInt(PS[23]) > 9){
        PSL4[7] = PS[22]+":"+PS[23]+":00";
        }else
        if(Integer.parseInt(PS[22]) > 9 && Integer.parseInt(PS[23]) < 10){
        PSL4[7] = PS[22]+":0"+PS[23]+":00";
        }else
        if(Integer.parseInt(PS[22]) < 10 && Integer.parseInt(PS[23]) > 9){
        PSL4[7] = "0"+PS[22]+":"+PS[23]+":00";
        }
        
        }
        
        if(QDT == 4){
        
        PSL2 = new String[8];
        PSL3 = new String[8];
        PSL4 = new String[8];
        PSL5 = new String[8];
        
        /*    NOME    */
        PSL2[0] = PS[6];
        PSL3[0] = PS[12];
        PSL4[0] = PS[18];
        PSL5[0] = PS[24];
        
        /*EM*/
        PSL2[1] = PS[7];
        PSL3[1] = PS[13];
        PSL4[1] = PS[19];
        PSL5[1] = PS[25];
        
        /*HORA ENTRADA*/
        PSL2[2] = PS[8];
        PSL3[2] = PS[14];
        PSL4[2] = PS[20];
        PSL5[2] = PS[26];
        
        /*MINUTO ENTRADA*/
        PSL2[3] = PS[9];
        PSL3[3] = PS[15];
        PSL4[3] = PS[21];
        PSL5[3] = PS[27];
        
        /*HORA SAIDA*/
        PSL2[4] = PS[10];
        PSL3[4] = PS[16];
        PSL4[4] = PS[22];
        PSL5[4] = PS[28];
        
        /*MINUTO SAIDA*/
        PSL2[5] = PS[11];
        PSL3[5] = PS[17];
        PSL4[5] = PS[23];
        PSL5[5] = PS[29];
        
        /*   ENTRADA   */
        if(Integer.parseInt(PS[8]) < 10 && Integer.parseInt(PS[9]) < 10){
        PSL2[6] = "0"+PS[8]+":0"+PS[9]+":00";
        }else
        if(Integer.parseInt(PS[8]) > 9 && Integer.parseInt(PS[9]) > 9){
        PSL2[6] = PS[8]+":"+PS[9]+":00";
        }else
        if(Integer.parseInt(PS[8]) < 10 && Integer.parseInt(PS[9]) > 9){
        PSL2[6] = "0"+PS[8]+":"+PS[9]+":00";
        }else
        if(Integer.parseInt(PS[8]) > 9 && Integer.parseInt(PS[9]) < 10){
        PSL2[6] = PS[8]+":0"+PS[9]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[14]) < 10 && Integer.parseInt(PS[15]) < 10){
        PSL3[6] = "0"+PS[14]+":0"+PS[15]+":00";
        }else
        if(Integer.parseInt(PS[14]) > 9 && Integer.parseInt(PS[15]) > 9){
        PSL3[6] = PS[14]+":"+PS[15]+":00";
        }else
        if(Integer.parseInt(PS[14]) < 10 && Integer.parseInt(PS[15]) > 9){
        PSL3[6] = "0"+PS[14]+":"+PS[15]+":00";
        }else
        if(Integer.parseInt(PS[14]) > 9 && Integer.parseInt(PS[15]) < 10){
        PSL3[6] = PS[14]+":0"+PS[15]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[20]) < 10 && Integer.parseInt(PS[21]) < 10){
        PSL4[6] = "0"+PS[20]+":0"+PS[21]+":00";
        }else
        if(Integer.parseInt(PS[20]) > 9 && Integer.parseInt(PS[21]) > 9){
        PSL4[6] = PS[20]+":"+PS[21]+":00";
        }else
        if(Integer.parseInt(PS[20]) < 10 && Integer.parseInt(PS[21]) > 9){
        PSL4[6] = "0"+PS[20]+":"+PS[21]+":00";
        }else
        if(Integer.parseInt(PS[20]) > 9 && Integer.parseInt(PS[21]) < 10){
        PSL4[6] = PS[20]+":0"+PS[21]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[26]) < 10 && Integer.parseInt(PS[27]) < 10){
        PSL5[6] = "0"+PS[26]+":0"+PS[27]+":00";
        }else
        if(Integer.parseInt(PS[26]) > 9 && Integer.parseInt(PS[27]) > 9){
        PSL5[6] = PS[26]+":"+PS[27]+":00";
        }else
        if(Integer.parseInt(PS[26]) < 10 && Integer.parseInt(PS[27]) > 9){
        PSL5[6] = "0"+PS[26]+":"+PS[27]+":00";
        }else
        if(Integer.parseInt(PS[26]) > 9 && Integer.parseInt(PS[27]) < 10){
        PSL5[6] = PS[26]+":0"+PS[27]+":00";
        }
        
        /*   SAIDA   */
        if(Integer.parseInt(PS[10]) < 10 && Integer.parseInt(PS[11]) < 10){
        PSL2[7] = "0"+PS[10]+":0"+PS[11]+":00";
        }else
        if(Integer.parseInt(PS[10]) > 9 && Integer.parseInt(PS[11]) > 9){
        PSL2[7] = PS[10]+":"+PS[11]+":00";
        }else
        if(Integer.parseInt(PS[10]) > 9 && Integer.parseInt(PS[11]) < 10){
        PSL2[7] = PS[10]+":0"+PS[11]+":00";
        }else
        if(Integer.parseInt(PS[10]) < 10 && Integer.parseInt(PS[11]) > 9){
        PSL2[7] = "0"+PS[10]+":"+PS[11]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[16]) < 10 && Integer.parseInt(PS[17]) < 10){
        PSL3[7] = "0"+PS[16]+":0"+PS[17]+":00";
        }else
        if(Integer.parseInt(PS[16]) > 9 && Integer.parseInt(PS[17]) > 9){
        PSL3[7] = PS[16]+":"+PS[17]+":00";
        }else
        if(Integer.parseInt(PS[16]) > 9 && Integer.parseInt(PS[17]) < 10){
        PSL3[7] = PS[16]+":0"+PS[17]+":00";
        }else
        if(Integer.parseInt(PS[16]) < 10 && Integer.parseInt(PS[17]) > 9){
        PSL3[7] = "0"+PS[16]+":"+PS[17]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[22]) < 10 && Integer.parseInt(PS[23]) < 10){
        PSL4[7] = "0"+PS[22]+":0"+PS[23]+":00";
        }else
        if(Integer.parseInt(PS[22]) > 9 && Integer.parseInt(PS[23]) > 9){
        PSL4[7] = PS[22]+":"+PS[23]+":00";
        }else
        if(Integer.parseInt(PS[22]) > 9 && Integer.parseInt(PS[23]) < 10){
        PSL4[7] = PS[22]+":0"+PS[23]+":00";
        }else
        if(Integer.parseInt(PS[22]) < 10 && Integer.parseInt(PS[23]) > 9){
        PSL4[7] = "0"+PS[22]+":"+PS[23]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[28]) < 10 && Integer.parseInt(PS[29]) < 10){
        PSL5[7] = "0"+PS[28]+":0"+PS[29]+":00";
        }else
        if(Integer.parseInt(PS[28]) > 9 && Integer.parseInt(PS[29]) > 9){
        PSL5[7] = PS[28]+":"+PS[29]+":00";
        }else
        if(Integer.parseInt(PS[28]) > 9 && Integer.parseInt(PS[29]) < 10){
        PSL5[7] = PS[28]+":0"+PS[29]+":00";
        }else
        if(Integer.parseInt(PS[28]) < 10 && Integer.parseInt(PS[29]) > 9){
        PSL5[7] = "0"+PS[28]+":"+PS[29]+":00";
        }
            
        }
        
        if(QDT == 5){
        
        PSL2 = new String[8];
        PSL3 = new String[8];
        PSL4 = new String[8];
        PSL5 = new String[8];
        PSL6 = new String[8];
        
        /*    NOME    */
        PSL2[0] = PS[6];
        PSL3[0] = PS[12];
        PSL4[0] = PS[18];
        PSL5[0] = PS[24];
        PSL6[0] = PS[30];
        
        /*EM*/
        PSL2[1] = PS[7];
        PSL3[1] = PS[13];
        PSL4[1] = PS[19];
        PSL5[1] = PS[25];
        PSL6[1] = PS[31];
        
        /*HORA ENTRADA*/
        PSL2[2] = PS[8];
        PSL3[2] = PS[14];
        PSL4[2] = PS[20];
        PSL5[2] = PS[26];
        PSL6[2] = PS[32];
        
        /*MINUTO ENTRADA*/
        PSL2[3] = PS[9];
        PSL3[3] = PS[15];
        PSL4[3] = PS[21];
        PSL5[3] = PS[27];
        PSL6[3] = PS[33];
        
        /*HORA SAIDA*/
        PSL2[4] = PS[10];
        PSL3[4] = PS[16];
        PSL4[4] = PS[22];
        PSL5[4] = PS[28];
        PSL6[4] = PS[34];
        
        /*MINUTO SAIDA*/
        PSL2[5] = PS[11];
        PSL3[5] = PS[17];
        PSL4[5] = PS[23];
        PSL5[5] = PS[29];
        PSL6[5] = PS[35];
        
        /*   ENTRADA   */
        if(Integer.parseInt(PS[8]) < 10 && Integer.parseInt(PS[9]) < 10){
        PSL2[6] = "0"+PS[8]+":0"+PS[9]+":00";
        }else
        if(Integer.parseInt(PS[8]) > 9 && Integer.parseInt(PS[9]) > 9){
        PSL2[6] = PS[8]+":"+PS[9]+":00";
        }else
        if(Integer.parseInt(PS[8]) < 10 && Integer.parseInt(PS[9]) > 9){
        PSL2[6] = "0"+PS[8]+":"+PS[9]+":00";
        }else
        if(Integer.parseInt(PS[8]) > 9 && Integer.parseInt(PS[9]) < 10){
        PSL2[6] = PS[8]+":0"+PS[9]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[14]) < 10 && Integer.parseInt(PS[15]) < 10){
        PSL3[6] = "0"+PS[14]+":0"+PS[15]+":00";
        }else
        if(Integer.parseInt(PS[14]) > 9 && Integer.parseInt(PS[15]) > 9){
        PSL3[6] = PS[14]+":"+PS[15]+":00";
        }else
        if(Integer.parseInt(PS[14]) < 10 && Integer.parseInt(PS[15]) > 9){
        PSL3[6] = "0"+PS[14]+":"+PS[15]+":00";
        }else
        if(Integer.parseInt(PS[14]) > 9 && Integer.parseInt(PS[15]) < 10){
        PSL3[6] = PS[14]+":0"+PS[15]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[20]) < 10 && Integer.parseInt(PS[21]) < 10){
        PSL4[6] = "0"+PS[20]+":0"+PS[21]+":00";
        }else
        if(Integer.parseInt(PS[20]) > 9 && Integer.parseInt(PS[21]) > 9){
        PSL4[6] = PS[20]+":"+PS[21]+":00";
        }else
        if(Integer.parseInt(PS[20]) < 10 && Integer.parseInt(PS[21]) > 9){
        PSL4[6] = "0"+PS[20]+":"+PS[21]+":00";
        }else
        if(Integer.parseInt(PS[20]) > 9 && Integer.parseInt(PS[21]) < 10){
        PSL4[6] = PS[20]+":0"+PS[21]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[26]) < 10 && Integer.parseInt(PS[27]) < 10){
        PSL5[6] = "0"+PS[26]+":0"+PS[27]+":00";
        }else
        if(Integer.parseInt(PS[26]) > 9 && Integer.parseInt(PS[27]) > 9){
        PSL5[6] = PS[26]+":"+PS[27]+":00";
        }else
        if(Integer.parseInt(PS[26]) < 10 && Integer.parseInt(PS[27]) > 9){
        PSL5[6] = "0"+PS[26]+":"+PS[27]+":00";
        }else
        if(Integer.parseInt(PS[26]) > 9 && Integer.parseInt(PS[27]) < 10){
        PSL5[6] = PS[26]+":0"+PS[27]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[32]) < 10 && Integer.parseInt(PS[33]) < 10){
        PSL6[6] = "0"+PS[32]+":0"+PS[33]+":00";
        }else
        if(Integer.parseInt(PS[32]) > 9 && Integer.parseInt(PS[33]) > 9){
        PSL6[6] = PS[32]+":"+PS[33]+":00";
        }else
        if(Integer.parseInt(PS[32]) < 10 && Integer.parseInt(PS[33]) > 9){
        PSL6[6] = "0"+PS[32]+":"+PS[33]+":00";
        }else
        if(Integer.parseInt(PS[32]) > 9 && Integer.parseInt(PS[33]) < 10){
        PSL6[6] = PS[32]+":0"+PS[33]+":00";
        }
        
        /*   SAIDA   */
        if(Integer.parseInt(PS[10]) < 10 && Integer.parseInt(PS[11]) < 10){
        PSL2[7] = "0"+PS[10]+":0"+PS[11]+":00";
        }else
        if(Integer.parseInt(PS[10]) > 9 && Integer.parseInt(PS[11]) > 9){
        PSL2[7] = PS[10]+":"+PS[11]+":00";
        }else
        if(Integer.parseInt(PS[10]) > 9 && Integer.parseInt(PS[11]) < 10){
        PSL2[7] = PS[10]+":0"+PS[11]+":00";
        }else
        if(Integer.parseInt(PS[10]) < 10 && Integer.parseInt(PS[11]) > 9){
        PSL2[7] = "0"+PS[10]+":"+PS[11]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[16]) < 10 && Integer.parseInt(PS[17]) < 10){
        PSL3[7] = "0"+PS[16]+":0"+PS[17]+":00";
        }else
        if(Integer.parseInt(PS[16]) > 9 && Integer.parseInt(PS[17]) > 9){
        PSL3[7] = PS[16]+":"+PS[17]+":00";
        }else
        if(Integer.parseInt(PS[16]) > 9 && Integer.parseInt(PS[17]) < 10){
        PSL3[7] = PS[16]+":0"+PS[17]+":00";
        }else
        if(Integer.parseInt(PS[16]) < 10 && Integer.parseInt(PS[17]) > 9){
        PSL3[7] = "0"+PS[16]+":"+PS[17]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[22]) < 10 && Integer.parseInt(PS[23]) < 10){
        PSL4[7] = "0"+PS[22]+":0"+PS[23]+":00";
        }else
        if(Integer.parseInt(PS[22]) > 9 && Integer.parseInt(PS[23]) > 9){
        PSL4[7] = PS[22]+":"+PS[23]+":00";
        }else
        if(Integer.parseInt(PS[22]) > 9 && Integer.parseInt(PS[23]) < 10){
        PSL4[7] = PS[22]+":0"+PS[23]+":00";
        }else
        if(Integer.parseInt(PS[22]) < 10 && Integer.parseInt(PS[23]) > 9){
        PSL4[7] = "0"+PS[22]+":"+PS[23]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[28]) < 10 && Integer.parseInt(PS[29]) < 10){
        PSL5[7] = "0"+PS[28]+":0"+PS[29]+":00";
        }else
        if(Integer.parseInt(PS[28]) > 9 && Integer.parseInt(PS[29]) > 9){
        PSL5[7] = PS[28]+":"+PS[29]+":00";
        }else
        if(Integer.parseInt(PS[28]) > 9 && Integer.parseInt(PS[29]) < 10){
        PSL5[7] = PS[28]+":0"+PS[29]+":00";
        }else
        if(Integer.parseInt(PS[28]) < 10 && Integer.parseInt(PS[29]) > 9){
        PSL5[7] = "0"+PS[28]+":"+PS[29]+":00";
        }
        ////////////////////////////////////////////////////////////////////////
        if(Integer.parseInt(PS[34]) < 10 && Integer.parseInt(PS[35]) < 10){
        PSL6[7] = "0"+PS[34]+":0"+PS[35]+":00";
        }else
        if(Integer.parseInt(PS[34]) > 9 && Integer.parseInt(PS[35]) > 9){
        PSL6[7] = PS[34]+":"+PS[35]+":00";
        }else
        if(Integer.parseInt(PS[34]) > 9 && Integer.parseInt(PS[35]) < 10){
        PSL6[7] = PS[34]+":0"+PS[35]+":00";
        }else
        if(Integer.parseInt(PS[34]) < 10 && Integer.parseInt(PS[35]) > 9){
        PSL6[7] = "0"+PS[34]+":"+PS[35]+":00";
        }
            
        }
        
        if(QDT == 3){
        HCT1 = Integer.parseInt(PSL2[2]);//Hora Chegada Técnico 1
        MCT1 = Integer.parseInt(PSL2[3]);//Minuto chegada Técnico 1
        HST1 = Integer.parseInt(PSL2[4]);//Hora Saida Técnico 1
        MST1 = Integer.parseInt(PSL2[5]);//Minuto Saida Técnico 1
        ET1 = PSL2[6];//Entrada Técnico 1
        ST1 = PSL2[7];//Saida Técnico 1
        
        HCT2 = Integer.parseInt(PSL3[2]);//Hora Chegada Técnico 2
        MCT2 = Integer.parseInt(PSL3[3]);//Minuto Chegada Técnico 2
        HST2 = Integer.parseInt(PSL3[4]);//Hora Saida Técnico 2
        MST2 = Integer.parseInt(PSL3[5]);//Minuto Saida Técnico 2
        ET2 = PSL3[6];//Entrada Técnico 2
        ST2 = PSL3[7];//Saida Técnico 2
        
        HCT3 = Integer.parseInt(PSL4[2]);//Hora Chegada Técnico 3
        MCT3 = Integer.parseInt(PSL4[3]);//Minuto Chegada Técnico 3
        HST3 = Integer.parseInt(PSL4[4]);//Hora Saida Técnico 3
        MST3 = Integer.parseInt(PSL4[5]);//Minuto Saida Técnico 3
        ET3 = PSL4[6];//Entrada Técnico 3
        ST3 = PSL4[7];//Saida Técnico 3
        }
        ////////////////////////////////////////////////////////////////////////
        if(QDT == 4){
        HCT1 = Integer.parseInt(PSL2[2]);//Hora Chegada Técnico 1
        MCT1 = Integer.parseInt(PSL2[3]);//Minuto chegada Técnico 1
        HST1 = Integer.parseInt(PSL2[4]);//Hora Saida Técnico 1
        MST1 = Integer.parseInt(PSL2[5]);//Minuto Saida Técnico 1
        ET1 = PSL2[6];//Entrada Técnico 1
        ST1 = PSL2[7];//Saida Técnico 1
        
        HCT2 = Integer.parseInt(PSL3[2]);//Hora Chegada Técnico 2
        MCT2 = Integer.parseInt(PSL3[3]);//Minuto Chegada Técnico 2
        HST2 = Integer.parseInt(PSL3[4]);//Hora Saida Técnico 2
        MST2 = Integer.parseInt(PSL3[5]);//Minuto Saida Técnico 2
        ET2 = PSL3[6];//Entrada Técnico 2
        ST2 = PSL3[7];//Saida Técnico 2
        
        HCT3 = Integer.parseInt(PSL4[2]);//Hora Chegada Técnico 3
        MCT3 = Integer.parseInt(PSL4[3]);//Minuto Chegada Técnico 3
        HST3 = Integer.parseInt(PSL4[4]);//Hora Saida Técnico 3
        MST3 = Integer.parseInt(PSL4[5]);//Minuto Saida Técnico 3
        ET3 = PSL4[6];//Entrada Técnico 3
        ST3 = PSL4[7];//Saida Técnico 3
        
        HCT4 = Integer.parseInt(PSL5[2]);//Hora Chegada Técnico 4
        MCT4 = Integer.parseInt(PSL5[3]);//Minuto Chegada Técnico 4
        HST4 = Integer.parseInt(PSL5[4]);//Hora Saida Técnico 4
        MST4 = Integer.parseInt(PSL5[5]);//Minuto Saida Técnico 4
        ET4 = PSL5[6];//Entrada Técnico 4
        ST4 = PSL5[7];//Saida Técnico 4
        
        }
        ////////////////////////////////////////////////////////////////////////
        if(QDT == 5){
        HCT1 = Integer.parseInt(PSL2[2]);//Hora Chegada Técnico 1
        MCT1 = Integer.parseInt(PSL2[3]);//Minuto chegada Técnico 1
        HST1 = Integer.parseInt(PSL2[4]);//Hora Saida Técnico 1
        MST1 = Integer.parseInt(PSL2[5]);//Minuto Saida Técnico 1
        ET1 = PSL2[6];//Entrada Técnico 1
        ST1 = PSL2[7];//Saida Técnico 1
        
        HCT2 = Integer.parseInt(PSL3[2]);//Hora Chegada Técnico 2
        MCT2 = Integer.parseInt(PSL3[3]);//Minuto Chegada Técnico 2
        HST2 = Integer.parseInt(PSL3[4]);//Hora Saida Técnico 2
        MST2 = Integer.parseInt(PSL3[5]);//Minuto Saida Técnico 2
        ET2 = PSL3[6];//Entrada Técnico 2
        ST2 = PSL3[7];//Saida Técnico 2
        
        HCT3 = Integer.parseInt(PSL4[2]);//Hora Chegada Técnico 3
        MCT3 = Integer.parseInt(PSL4[3]);//Minuto Chegada Técnico 3
        HST3 = Integer.parseInt(PSL4[4]);//Hora Saida Técnico 3
        MST3 = Integer.parseInt(PSL4[5]);//Minuto Saida Técnico 3
        ET3 = PSL4[6];//Entrada Técnico 3
        ST3 = PSL4[7];//Saida Técnico 3
        
        HCT4 = Integer.parseInt(PSL5[2]);//Hora Chegada Técnico 4
        MCT4 = Integer.parseInt(PSL5[3]);//Minuto Chegada Técnico 4
        HST4 = Integer.parseInt(PSL5[4]);//Hora Saida Técnico 4
        MST4 = Integer.parseInt(PSL5[5]);//Minuto Saida Técnico 4
        ET4 = PSL5[6];//Entrada Técnico 4
        ST4 = PSL5[7];//Saida Técnico 4
        
        HCT5 = Integer.parseInt(PSL6[2]);//Hora Chegada Técnico 5
        MCT5 = Integer.parseInt(PSL6[3]);//Minuto Chegada Técnico 5
        HST5 = Integer.parseInt(PSL6[4]);//Hora Saida Técnico 5
        MST5 = Integer.parseInt(PSL6[5]);//Minuto Saida Técnico 5
        ET5 = PSL6[6];//Entrada Técnico 5
        ST5 = PSL6[7];//Saida Técnico 5
        }
        
        obterHoras();//OBTEM A HORA EM QUE O PROGRAMA É ABERTO
        BOTAO_ZERAR.setEnabled(false);
        TEXTO_HORA.setForeground(Color.yellow);
        TEXTO_TOTAL.setForeground(Color.yellow);
        TEXTO_CRONOMETRO.setForeground(Color.yellow);
        
        timer = new Timer(1000, (ActionEvent e) -> {
            
            contador++;
            
            if(habilitar_piadas == true){
               
               contador_piada++;
            
            if(contador_piada == 1800){// 1 HORA: 3600 MEIA/HORA: 1800
               contador_piada = 0;
               Random numero_aleatorio = new Random();
               int na = numero_aleatorio.nextInt(14);//1 A MAIS QUE O ULTIMO NUMERO DAS PIADAS
               play("/CODIGOS/Piadas/"+na);
               System.out.println(na);
            }
            
            }
            
            /////////////////////////SEGUNDOS/////////////////////////
                if(contador < 10){
                    segundos = "0"+contador;
                }
                if(contador > 9){
                    segundos = ""+contador;
                }
                if(contador == 60){
                    contador = 0;
                    segundos = "0"+contador;
                    minutos_int++;
                }
                /////////////////////////SEGUNDOS/////////////////////////
                /////////////////////////MINUTOS/////////////////////////
                if(minutos_int == 0){
                    minutos = "00";
                }
                if(minutos_int < 10){
                    minutos = "0"+minutos_int;
                }
                if(minutos_int > 9){
                    minutos = ""+minutos_int;
                }
                if(minutos_int == 60){
                    minutos_int = 0;
                    minutos = "0"+minutos_int;
                    horas_int++;
                }
                /////////////////////////MINUTOS/////////////////////////
                /////////////////////////HORAS/////////////////////////
                if(horas_int == 0){
                    HC = "00";
                }
                if(horas_int < 10){
                    HC = "0"+horas_int;
                }
                if(horas_int > 9){
                    HC = ""+horas_int;
                }
                if(horas_int == 24){
                    horas_int = 0;
                    HC = "0"+horas_int;
                }
                /////////////////////////HORAS/////////////////////////
                
                TEXTO_CRONOMETRO.setText(""+HC+":"+minutos+":"+segundos);
            
            
            obterHoras();

            TEXTO_HORA.setText(horas);
            
            if(QDT == 5){
                ////////////////////////////////////////////////////////////////////
            /*TÉCNICOS HABILITADOS NA HORA E MINUTO DEFINIDOS*/
            if(horas.equals(ET1)){
                BTN1.setEnabled(true);
                BTN1.setSelected(false);
                BTN1.setForeground(Color.black);
            }
            if(horas.equals(ET2)){
                BTN2.setEnabled(true);
                BTN2.setSelected(false);
                BTN2.setForeground(Color.black);
            }
            if(horas.equals(ET3)){
                BTN3.setEnabled(true);
                BTN3.setSelected(false);
                BTN3.setForeground(Color.black);
            }
            if(horas.equals(ET4)){
                BTN4.setEnabled(true);
                BTN4.setSelected(false);
                BTN4.setForeground(Color.black);
            }
            if(horas.equals(ET5)){
                BTN5.setEnabled(true);
                BTN5.setSelected(false);
                BTN5.setForeground(Color.black);
            }
                ////////////////////////////////////////////////////////////////////
            /*TÉCNICOS DESABILITADOS NA HORA E MINUTO DEFINIDOS*/
            if(horas.equals(ST1)){
                BTN1.setEnabled(false);
                BTN1.setSelected(true);
                BTN1.setForeground(Color.red);
            }
            if(horas.equals(ST2)){
                BTN2.setEnabled(false);
                BTN2.setSelected(true);
                BTN2.setForeground(Color.red);
            }
            if(horas.equals(ST3)){
                BTN3.setEnabled(false);
                BTN3.setSelected(true);
                BTN3.setForeground(Color.red);
            }
            if(horas.equals(ST4)){
                BTN4.setEnabled(false);
                BTN4.setSelected(true);
                BTN4.setForeground(Color.red);
            }
            if(horas.equals(ST5)){
                BTN5.setEnabled(false);
                BTN5.setSelected(true);
                BTN5.setForeground(Color.red);
            }
            }///////////////////////////////////////////////////////////////////
            if(QDT == 4){
                ////////////////////////////////////////////////////////////////////
            /*TÉCNICOS HABILITADOS NA HORA E MINUTO DEFINIDOS*/
            if(horas.equals(ET1)){
                BTN1.setEnabled(true);
                BTN1.setSelected(false);
                BTN1.setForeground(Color.black);
            }
            if(horas.equals(ET2)){
                BTN2.setEnabled(true);
                BTN2.setSelected(false);
                BTN2.setForeground(Color.black);
            }
            if(horas.equals(ET3)){
                BTN3.setEnabled(true);
                BTN3.setSelected(false);
                BTN3.setForeground(Color.black);
            }
            if(horas.equals(ET4)){
                BTN4.setEnabled(true);
                BTN4.setSelected(false);
                BTN4.setForeground(Color.black);
            }
                ////////////////////////////////////////////////////////////////////
            /*TÉCNICOS DESABILITADOS NA HORA E MINUTO DEFINIDOS*/
            if(horas.equals(ST1)){
                BTN1.setEnabled(false);
                BTN1.setSelected(true);
                BTN1.setForeground(Color.red);
            }
            if(horas.equals(ST2)){
                BTN2.setEnabled(false);
                BTN2.setSelected(true);
                BTN2.setForeground(Color.red);
            }
            if(horas.equals(ST3)){
                BTN3.setEnabled(false);
                BTN3.setSelected(true);
                BTN3.setForeground(Color.red);
            }
            if(horas.equals(ST4)){
                BTN4.setEnabled(false);
                BTN4.setSelected(true);
                BTN4.setForeground(Color.red);
            }
            
            }///////////////////////////////////////////////////////////////////
            if(QDT == 3){
                    ////////////////////////////////////////////////////////////////////
            /*TÉCNICOS HABILITADOS NA HORA E MINUTO DEFINIDOS*/
            if(horas.equals(ET1)){
                BTN2.setEnabled(true);
                BTN2.setSelected(false);
                BTN2.setForeground(Color.black);
            }
            if(horas.equals(ET2)){
                BTN3.setEnabled(true);
                BTN3.setSelected(false);
                BTN3.setForeground(Color.black);
            }
            if(horas.equals(ET3)){
                BTN4.setEnabled(true);
                BTN4.setSelected(false);
                BTN4.setForeground(Color.black);
            }
                ////////////////////////////////////////////////////////////////////
            /*TÉCNICOS DESABILITADOS NA HORA E MINUTO DEFINIDOS*/
            if(horas.equals(ST1)){
                BTN2.setEnabled(false);
                BTN2.setSelected(true);
                BTN2.setForeground(Color.red);
            }
            if(horas.equals(ST2)){
                BTN3.setEnabled(false);
                BTN3.setSelected(true);
                BTN3.setForeground(Color.red);
            }
            if(horas.equals(ST3)){
                BTN4.setEnabled(false);
                BTN4.setSelected(true);
                BTN4.setForeground(Color.red);
            }
            
            ////////////////////////////////////////////////////////////////////
            /*ALARMES*/
            if(horas.equals("15:30:00")){
                play("/CODIGOS/Sons/hora_da_pizza");
            }
            
            ////////////////////////////////////////////////////////////////////
            
            }
            
            
            ////////////////////////////////////////////////////////////////////
        });
        
        timer.start();
       
        if(QDT == 3){
        
        /*DEFINE SE O BOTAO INICIARÁ VISIVEL*/
        inicioVisibilidadeBotoes(false, true, true, true, false);
        
        /*DEFINE O NOME DOS TÉCNICOS*/
        inicioNomeBotoes("", PSL2[0], PSL3[0], PSL4[0], "");
        
        /*DEFINE SE O BOTAO INICIARÁ HABILITADO*/
        BTN1.setEnabled(false);
        BTN2.setEnabled(true);
        BTN3.setEnabled(true);
        BTN4.setEnabled(true);
        BTN5.setEnabled(false);
        
         ////////////////////////////////////////////////////////////////////////
        /*DEPOIS DO HORARIO DE CHEGADA O BOTAO INICIA HABILITADO ||| */
        if((hora >= HCT1 && minuto >= MCT1) && (hora > HCT1 && minuto <60) && (hora <= HST1 && minuto <= MST1)){
            BTN2.setSelected(false);
            BTN2.setForeground(Color.black);
        }
        if((hora >= HCT2 && minuto >= MCT2) && (hora > HCT2 && minuto <60) && (hora <= HST2 && minuto <= MST2)){
            BTN3.setSelected(false);
            BTN3.setForeground(Color.black);
        }
        if((hora >= HCT3 && minuto >= MCT3) ||
           (hora > HCT3)){
            BTN4.setSelected(false);
            BTN4.setForeground(Color.black);
        }
         ////////////////////////////////////////////////////////////////////////
        /*DEPOIS DO HORARIO DE SAIDA O BOTAO INICIA DESABILITADO ||| */
        if(hora == HST1 && minuto == MST1 || hora == HST1 && minuto >  MST1 || hora > HST1){
            BTN2.setEnabled(false);
            BTN2.setSelected(true);
            BTN2.setForeground(Color.red);
            BTN2.setText(""+PSL2[0]);//CORRETO
        }
        if(hora == HST2 && minuto == MST2 || hora == HST2 && minuto >  MST2 || hora > HST2){
            BTN3.setEnabled(false);
            BTN3.setSelected(true);
            BTN3.setForeground(Color.red);
            BTN3.setText(""+PSL3[0]);//CORRETO
        }
        if(hora == HST3 && minuto == MST3 || hora == HST3 && minuto >  MST3 || hora > HST3){
            BTN4.setEnabled(false);
            BTN4.setSelected(true);
            BTN4.setForeground(Color.red);
            BTN4.setText(""+PSL4[0]);//CORRETO
        }
        ////////////////////////////////////////////////////////////////////////
        /*ANTES DO HORARIO O BOTAO INICIA DESABILITADO*/
        if(hora < HCT1 || hora == HCT1 && minuto < MCT1){
            BTN2.setEnabled(false);
            BTN2.setSelected(true);
            BTN2.setForeground(Color.red);
            BTN2.setText(""+PSL2[0]);
        }
        if(hora < HCT2 || hora == HCT2 && minuto < MCT2){
            BTN3.setEnabled(false);
            BTN3.setSelected(true);
            BTN3.setForeground(Color.red);
            BTN3.setText(""+PSL3[0]);
        }
        if(hora < HCT3 || hora == HCT3 && minuto < MCT3){
            BTN4.setEnabled(false);
            BTN4.setSelected(true);
            BTN4.setForeground(Color.red);
            BTN4.setText(""+PSL4[0]);
        }
        ////////////////////////////////////////////////////////////////////////
        
        }else
        if(QDT == 5){
        
        /*DEFINE SE O BOTAO INICIARÁ VISIVEL*/
        inicioVisibilidadeBotoes(true, true, true, true, true);
        
        /*DEFINE O NOME DOS TÉCNICOS*/
        inicioNomeBotoes(PSL2[0], PSL3[0], PSL4[0], PSL5[0], PSL6[0]);
        
        /*DEFINE SE O BOTAO INICIARÁ HABILITADO*/
        BTN1.setEnabled(true);
        BTN2.setEnabled(true);
        BTN3.setEnabled(true);
        BTN4.setEnabled(true);
        BTN5.setEnabled(true);
        
         ////////////////////////////////////////////////////////////////////////
        /*DEPOIS DO HORARIO DE CHEGADA O BOTAO INICIA HABILITADO*/
        if((hora >= HCT1 && minuto >= MCT1) ||
           (hora > HCT1)){
            BTN1.setSelected(false);
            BTN1.setForeground(Color.black);
        }
        if((hora >= HCT2 && minuto >= MCT2) ||
           (hora > HCT2)){
            BTN2.setSelected(false);
            BTN2.setForeground(Color.black);
        }
        if((hora >= HCT3 && minuto >= MCT3) ||
           (hora > HCT3)){
            BTN3.setSelected(false);
            BTN3.setForeground(Color.black);
        }
        if((hora >= HCT4 && minuto >= MCT4) ||
           (hora > HCT4)){
            BTN4.setSelected(false);
            BTN4.setForeground(Color.black);
        }
        if((hora >= HCT5 && minuto >= MCT5) ||
           (hora > HCT5)){
            BTN5.setSelected(false);
            BTN5.setForeground(Color.black);
        }
        /*ANTES DO HORARIO O BOTAO INICIA DESABILITADO*/
        if(hora < HCT1 || hora == HCT1 && minuto < MCT1){
            BTN1.setEnabled(false);
            BTN1.setSelected(true);
            BTN1.setForeground(Color.red);
            BTN1.setText(""+PSL2[0]);
        }
        if(hora < HCT2 || hora == HCT2 && minuto < MCT2){
            BTN2.setEnabled(false);
            BTN2.setSelected(true);
            BTN2.setForeground(Color.red);
            BTN2.setText(""+PSL3[0]);
        }
        if(hora < HCT3 || hora == HCT3 && minuto < MCT3){
            BTN3.setEnabled(false);
            BTN3.setSelected(true);
            BTN3.setForeground(Color.red);
            BTN3.setText(""+PSL4[0]);
        }
        if(hora < HCT4 || hora == HCT4 && minuto < MCT4){
            BTN4.setEnabled(false);
            BTN4.setSelected(true);
            BTN4.setForeground(Color.red);
            BTN4.setText(""+PSL5[0]);
        }
        if(hora < HCT5 || hora == HCT5 && minuto < MCT5){
            BTN5.setEnabled(false);
            BTN5.setSelected(true);
            BTN5.setForeground(Color.red);
            BTN5.setText(""+PSL6[0]);
        }
         ////////////////////////////////////////////////////////////////////////
        /*DEPOIS DO HORARIO DE SAIDA O BOTAO INICIA DESABILITADO ||||| */
        if(hora == HST1 && minuto == MST1 || hora == HST1 && minuto >  MST1 || hora > HST1){
            BTN1.setEnabled(false);
            BTN1.setSelected(true);
            BTN1.setForeground(Color.red);
        }
        if(hora == HST2 && minuto == MST2 || hora == HST2 && minuto >  MST2 || hora > HST2){
            BTN2.setEnabled(false);
            BTN2.setSelected(true);
            BTN2.setForeground(Color.red);
        }
        if(hora == HST3 && minuto == MST3 || hora == HST3 && minuto >  MST3 || hora > HST3){
            ////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////
            BTN3.setEnabled(false);//APARECEU UM ERRO GRAVE NO DIA 31/08/2016
            BTN3.setSelected(true);
            BTN3.setForeground(Color.red);
            ////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////
        }
        if(hora == HST4 && minuto == MST4 || hora == HST4 && minuto >  MST4 || hora > HST4){
            BTN4.setEnabled(false);
            BTN4.setSelected(true);
            BTN4.setForeground(Color.red);
        }
        if(hora == HST5 && minuto == MST5 || hora == HST5 && minuto >  MST5 || hora > HST5){
            BTN5.setEnabled(false);
            BTN5.setSelected(true);
            BTN5.setForeground(Color.red);
        }
//        
        }
        ////////////////////////////////////////////////////////////////////////
        else
        if(QDT == 4){
        
        /*DEFINE SE O BOTAO INICIARÁ VISIVEL*/
        inicioVisibilidadeBotoes(true, true, true, true, false);
        
        /*DEFINE O NOME DOS TÉCNICOS*/
        inicioNomeBotoes(PSL2[0], PSL3[0], PSL4[0], PSL5[0], "");
        
        /*DEFINE SE O BOTAO INICIARÁ HABILITADO*/
        BTN1.setEnabled(true);
        BTN2.setEnabled(true);
        BTN3.setEnabled(true);
        BTN4.setEnabled(true);
        BTN5.setEnabled(false);
        
         ////////////////////////////////////////////////////////////////////////
        /*DEPOIS DO HORARIO DE CHEGADA O BOTAO INICIA HABILITADO*/
        if((hora >= HCT1 && minuto >= MCT1) ||
           (hora > HCT1)){
            BTN1.setSelected(false);
            BTN1.setForeground(Color.black);
        }
        if((hora >= HCT2 && minuto >= MCT2) ||
           (hora > HCT2)){
            BTN2.setSelected(false);
            BTN2.setForeground(Color.black);
        }
        if((hora >= HCT3 && minuto >= MCT3) ||
           (hora > HCT3)){
            BTN3.setSelected(false);
            BTN3.setForeground(Color.black);
        }
        if((hora >= HCT4 && minuto >= MCT4) ||
           (hora > HCT4)){
            BTN4.setSelected(false);
            BTN4.setForeground(Color.black);
        }
        
        /*ANTES DO HORARIO O BOTAO INICIA DESABILITADO*/
        if(hora < HCT1 || hora == HCT1 && minuto < MCT1){
            BTN1.setEnabled(false);
            BTN1.setSelected(true);
            BTN1.setForeground(Color.red);
            BTN1.setText(""+PSL2[0]);
        }
        if(hora < HCT2 || hora == HCT2 && minuto < MCT2){
            BTN2.setEnabled(false);
            BTN2.setSelected(true);
            BTN2.setForeground(Color.red);
            BTN2.setText(""+PSL3[0]);
        }
        if(hora < HCT3 || hora == HCT3 && minuto < MCT3){
            BTN3.setEnabled(false);
            BTN3.setSelected(true);
            BTN3.setForeground(Color.red);
            BTN3.setText(""+PSL4[0]);
        }
        if(hora < HCT4 || hora == HCT4 && minuto < MCT4){
            BTN4.setEnabled(false);
            BTN4.setSelected(true);
            BTN4.setForeground(Color.red);
            BTN4.setText(""+PSL5[0]);
        }
        
         ////////////////////////////////////////////////////////////////////////
        /*DEPOIS DO HORARIO DE SAIDA O BOTAO INICIA DESABILITADO ||||| */
        if(hora == HST1 && minuto == MST1 || hora == HST1 && minuto >  MST1 || hora > HST1){
            BTN1.setEnabled(false);
            BTN1.setSelected(true);
            BTN1.setForeground(Color.red);
        }
        if(hora == HST2 && minuto == MST2 || hora == HST2 && minuto >  MST2 || hora > HST2){
            BTN2.setEnabled(false);
            BTN2.setSelected(true);
            BTN2.setForeground(Color.red);
        }
        if(hora == HST3 && minuto == MST3 || hora == HST3 && minuto >  MST3 || hora > HST3){
            BTN3.setEnabled(false);
            BTN3.setSelected(true);
            BTN3.setForeground(Color.red);
        }
        if(hora == HST4 && minuto == MST4 || hora == HST4 && minuto >  MST4 || hora > HST4){
            BTN4.setEnabled(false);
            BTN4.setSelected(true);
            BTN4.setForeground(Color.red);
        }
        
        
        }///////////////////////////////////////////////////////////////////////
        
    }//GEN-LAST:event_formWindowOpened

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:   
        
    }//GEN-LAST:event_formMouseClicked

    private void BOTAO_ZERARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOTAO_ZERARActionPerformed
        // TODO add your handling code here:
        
        Object[] options = { "Sim", "Não" };   
        int opcao = JOptionPane.showOptionDialog(null,"Deseja zerar a contagem ?","Aviso",
        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);   
  
        if (opcao != 0){
        //JOptionPane.showMessageDialog(null,"");
        }else{
              
            String senha = "";
            int tentativas = 3;//Define o número de tentativas que o usuário terá para acertar a senha.
            
            for(int i=0;i<tentativas;i++)
            {
                if(!senha.equals(Senha))      
                {
                    
                    if(habilitar_som == true){
                        if(i == 0){
                            play("/CODIGOS/Sons/primeira_tentativa");
                        }else
                        if(i == 1){
                            play("/CODIGOS/Sons/segunda_tentativa");
                        }else
                        if(i == 2){
                            play("/CODIGOS/Sons/terceira_tentativa");
                        }
                    }
                    
                    JPasswordField jpf = new JPasswordField();
            
                    JOptionPane.showConfirmDialog(null,new Object[]{ jpf},"Warning "+(i+1)+"ª tentativa.",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        
                    senha = new String(jpf.getPassword());
                    
                }    
            }
            if (!senha.equals(Senha) || senha.equals(null))    
            {
                if(habilitar_som == true){
                    play("/CODIGOS/Sons/senha_incorreta_ou_operacao_cancelada");//executa o arquivo wav
                }
                JOptionPane.showMessageDialog(null,"Senha incorreta ou operação cancelada","Aviso",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                if(QDT == 5){
                v = 0;
                TDA = 0;
                AT1 = 0;
                AT2 = 0;
                AT3 = 0;
                AT4 = 0;
                AT5 = 0;
                TEXTO_TOTAL.setText("Atendimentos : ");
                TEXTO_NOME_DA_VEZ.setText("");
                BTN1.setText(""+PSL2[0]);
                BTN2.setText(""+PSL3[0]);
                BTN3.setText(""+PSL4[0]);
                BTN4.setText(""+PSL5[0]);
                BTN5.setText(""+PSL6[0]);
                BOTAO_ZERAR.setEnabled(false);
                }else
                if(QDT == 4){
                v = 0;
                TDA = 0;
                AT1 = 0;
                AT2 = 0;
                AT3 = 0;
                AT4 = 0;
                TEXTO_TOTAL.setText("Atendimentos : ");
                TEXTO_NOME_DA_VEZ.setText("");
                BTN1.setText(""+PSL2[0]);
                BTN2.setText(""+PSL3[0]);
                BTN3.setText(""+PSL4[0]);
                BTN4.setText(""+PSL5[0]);
                BOTAO_ZERAR.setEnabled(false);
                }else
                if(QDT == 3){
                v = 0;
                TDA = 0;
                AT1 = 0;
                AT2 = 0;
                AT3 = 0;
                TEXTO_TOTAL.setText("ATENDIMENTOS : ");
                TEXTO_NOME_DA_VEZ.setText("");
                BTN2.setText(""+PSL2[0]);
                BTN3.setText(""+PSL3[0]);
                BTN4.setText(""+PSL4[0]);
                BOTAO_ZERAR.setEnabled(false);
                }
            }
        }
        
    }//GEN-LAST:event_BOTAO_ZERARActionPerformed

    private void PAPEL_DE_PAREDEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PAPEL_DE_PAREDEMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_PAPEL_DE_PAREDEMouseClicked

    private void BTN1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN1MouseClicked
        // TODO add your handling code here:
        if(BTN1.isSelected()){
            BTN1.setSelected(true);
            BTN1.setForeground(Color.red);
        }else{
            BTN1.setSelected(false);
            BTN1.setForeground(Color.black);
        }
    }//GEN-LAST:event_BTN1MouseClicked

    private void BTN2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN2MouseClicked
        // TODO add your handling code here:
        if(BTN2.isSelected()){
            BTN2.setSelected(true);
            BTN2.setForeground(Color.red);
        }else{
            BTN2.setSelected(false);
            BTN2.setForeground(Color.black);
        }
    }//GEN-LAST:event_BTN2MouseClicked

    private void BTN3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN3MouseClicked
        // TODO add your handling code here:
         if(BTN3.isSelected()){
            BTN3.setSelected(true);
            BTN3.setForeground(Color.red);
        }else{
            BTN3.setSelected(false);
            BTN3.setForeground(Color.black);
        }
    }//GEN-LAST:event_BTN3MouseClicked

    private void BTN4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN4MouseClicked
        // TODO add your handling code here:
        if(BTN4.isSelected()){
            BTN4.setSelected(true);
            BTN4.setForeground(Color.red);
        }else{
            BTN4.setSelected(false);
            BTN4.setForeground(Color.black);
        }
    }//GEN-LAST:event_BTN4MouseClicked

    private void BTN5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN5MouseClicked
        // TODO add your handling code here:
         if(BTN5.isSelected()){
            BTN5.setSelected(true);
            BTN5.setForeground(Color.red);
        }else{
            BTN5.setSelected(false);
            BTN5.setForeground(Color.black);
        }
    }//GEN-LAST:event_BTN5MouseClicked

    private void jMenuItemConfigurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConfigurarActionPerformed
        // TODO add your handling code here:
        Object[] options = { "Sim", "Não" };   
        int opcao = JOptionPane.showOptionDialog(null,"Deseja alterar as configurações ?","Aviso",
        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);   
  
        if (opcao != 0){
            
        }else{
              
            String senha = "";
            int tentativas = 3;//Define o número de tentativas que o usuário terá para acertar a senha.
            
            for(int i=0;i<tentativas;i++)
            {
                if(!senha.equals(Senha))      
                {
                    
                    senha = JOptionPane.showInputDialog(null,"Password: ","Warning "+(i+1)+"ª tentativa.",JOptionPane.OK_CANCEL_OPTION);
                    
                }    
            }
            if (!senha.equals(Senha) || senha.equals(null))    
            {
                JOptionPane.showMessageDialog(null,"Senha incorreta ou operação cancelada","Aviso",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                if(QDT == 3){
                    JOptionPane.showMessageDialog(null,"A função solicitada ainda está sendo desenvolvida.","Aviso",JOptionPane.WARNING_MESSAGE);
                }else
                if(QDT == 4){
                     /*PAPEL_DE_PAREDE.add(cf);
                     cf.setVisible(true);*/
                     JOptionPane.showMessageDialog(null,"A função solicitada ainda está sendo desenvolvida.","Aviso",JOptionPane.WARNING_MESSAGE);
                }else
                if(QDT == 5){
                     /*PAPEL_DE_PAREDE.add(cf);
                     cf.setVisible(true);*/
                     JOptionPane.showMessageDialog(null,"A função solicitada ainda está sendo desenvolvida.","Aviso",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jMenuItemConfigurarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        PAPEL_DE_PAREDE.add(about);
        about.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void BTN1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN1MouseEntered
        // TODO add your handling code here:
        if(QDT == 5){
            BTN1.setToolTipText(ET1+" às "+ST1);
        }
        if(QDT == 4){
            BTN1.setToolTipText(ET1+" às "+ST1);
        }
    }//GEN-LAST:event_BTN1MouseEntered

    private void BTN2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN2MouseEntered
        // TODO add your handling code here:
        if(QDT == 5){
            BTN2.setToolTipText(ET2+" às "+ST2);
        }
        if(QDT == 4){
            BTN2.setToolTipText(ET2+" às "+ST2);
        }
        if(QDT == 3){
            BTN2.setToolTipText(ET1+" às "+ST1);
        }
    }//GEN-LAST:event_BTN2MouseEntered

    private void BTN3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN3MouseEntered
        // TODO add your handling code here:
        if(QDT == 5){
            BTN3.setToolTipText(ET3+" às "+ST3);
        }
        if(QDT == 4){
            BTN3.setToolTipText(ET3+" às "+ST3);
        }
        if(QDT == 3){
            BTN3.setToolTipText(ET2+" às "+ST2);
        }
    }//GEN-LAST:event_BTN3MouseEntered

    private void BTN4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN4MouseEntered
        // TODO add your handling code here:
        if(QDT == 5){
            BTN4.setToolTipText(ET4+" às "+ST4);
        }
        if(QDT == 4){
            BTN4.setToolTipText(ET4+" às "+ST4);
        }
        if(QDT == 3){
            BTN4.setToolTipText(ET3+" às "+ST3);
        }
    }//GEN-LAST:event_BTN4MouseEntered

    private void BTN5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN5MouseEntered
        // TODO add your handling code here:
        if(QDT == 5){
            BTN5.setToolTipText(ET5+" às "+ST5);
        }
    }//GEN-LAST:event_BTN5MouseEntered

    private void BOTAO_SOLICITAR_SENHAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOTAO_SOLICITAR_SENHAActionPerformed
        // TODO add your handling code here:
        
        Object[] options = { "Sim", "Não" };   
        int opcao = JOptionPane.showOptionDialog(null,"Deseja ATIVAR/DESATIVAR senha para chamar cada Técnico ?","Aviso",
        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);   
  
        if (opcao != 0){
        //JOptionPane.showMessageDialog(null,"");
        }else{
              
            String senha = "";
            int tentativas = 3;//Define o número de tentativas que o usuário terá para acertar a senha.
            
            for(int i=0;i<tentativas;i++)
            {
                if(!senha.equals(Senha))      
                {
                    
                    if(habilitar_som == true){
                        if(i == 0){
                            play("/CODIGOS/Sons/primeira_tentativa");
                        }else
                        if(i == 1){
                            play("/CODIGOS/Sons/segunda_tentativa");
                        }else
                        if(i == 2){
                            play("/CODIGOS/Sons/terceira_tentativa");
                        }
                    }
                    
                    JPasswordField jpf = new JPasswordField();
            
                    JOptionPane.showConfirmDialog(null,new Object[]{ jpf},"Warning "+(i+1)+"ª tentativa.",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        
                    senha = new String(jpf.getPassword());
                    
                }    
            }
            if (!senha.equals(Senha) || senha.equals(null))    
            {
                if(habilitar_som == true){
                    play("/CODIGOS/Sons/senha_incorreta_ou_operacao_cancelada");//executa o arquivo wav
                }
                JOptionPane.showMessageDialog(null,"Senha incorreta ou operação cancelada","Aviso",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                  
             if(solicitar_senha == false){
                solicitar_senha = true;
                BOTAO_SOLICITAR_SENHA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CODIGOS/Imagens/padlock.png"))); // NOI18N
             }else
             if(solicitar_senha == true){
                solicitar_senha = false;
                BOTAO_SOLICITAR_SENHA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CODIGOS/Imagens/chave_1.png")));
             }
                
            }
        }
        
    }//GEN-LAST:event_BOTAO_SOLICITAR_SENHAActionPerformed

    private void BOTAO_SOMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOTAO_SOMActionPerformed
        // TODO add your handling code here:
        
        Object[] options = { "Sim", "Não" };   
        int opcao = JOptionPane.showOptionDialog(null,"Deseja ATIVAR/DESATIVAR o som para chamar cada Técnico ?","Aviso",
        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);   
  
        if (opcao != 0){
        //JOptionPane.showMessageDialog(null,"");
        }else{
              
            String senha = "";
            int tentativas = 3;//Define o número de tentativas que o usuário terá para acertar a senha.
            
            for(int i=0;i<tentativas;i++)
            {
                if(!senha.equals(Senha))      
                {
                    
                    if(habilitar_som == true){
                        if(i == 0){
                            play("/CODIGOS/Sons/primeira_tentativa");
                        }else
                        if(i == 1){
                            play("/CODIGOS/Sons/segunda_tentativa");
                        }else
                        if(i == 2){
                            play("/CODIGOS/Sons/terceira_tentativa");
                        }
                    }
                    
                    JPasswordField jpf = new JPasswordField();
            
                    JOptionPane.showConfirmDialog(null,new Object[]{ jpf},"Warning "+(i+1)+"ª tentativa.",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        
                    senha = new String(jpf.getPassword());
                    
                }    
            }
            if (!senha.equals(Senha) || senha.equals(null))    
            {
                if(habilitar_som == true){
                    play("/CODIGOS/Sons/senha_incorreta_ou_operacao_cancelada");//executa o arquivo wav
                }
                JOptionPane.showMessageDialog(null,"Senha incorreta ou operação cancelada","Aviso",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                  
             if(habilitar_som == false){
                habilitar_som = true;
                play("/CODIGOS/Sons/som_habilitado");//executa o arquivo wav
                BOTAO_SOM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CODIGOS/Imagens/som_habilitado.png"))); // NOI18N
             }else
             if(habilitar_som == true){
                habilitar_som = false;
                play("/CODIGOS/Sons/som_desabilitado");//executa o arquivo wav
                BOTAO_SOM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CODIGOS/Imagens/som_desabilitado.png"))); // NOI18N
             }
                
            }
        }
        
    }//GEN-LAST:event_BOTAO_SOMActionPerformed

    private void BOTAO_PIADASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOTAO_PIADASActionPerformed
        // TODO add your handling code here:
        
        Object[] options = { "Sim", "Não" };   
        int opcao = JOptionPane.showOptionDialog(null,"Deseja ATIVAR/DESATIVAR as piadas ?","Aviso",
        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);   
  
        if (opcao != 0){
        //JOptionPane.showMessageDialog(null,"");
        }else{
              
            String senha = "";
            int tentativas = 3;//Define o número de tentativas que o usuário terá para acertar a senha.
            
            for(int i=0;i<tentativas;i++)
            {
                if(!senha.equals(Senha))      
                {
                    
                    if(habilitar_som == true){
                        if(i == 0){
                            play("/CODIGOS/Sons/primeira_tentativa");
                        }else
                        if(i == 1){
                            play("/CODIGOS/Sons/segunda_tentativa");
                        }else
                        if(i == 2){
                            play("/CODIGOS/Sons/terceira_tentativa");
                        }
                    }
                    
                    JPasswordField jpf = new JPasswordField();
            
                    JOptionPane.showConfirmDialog(null,new Object[]{ jpf},"Warning "+(i+1)+"ª tentativa.",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        
                    senha = new String(jpf.getPassword());
                    
                }    
            }
            if (!senha.equals(Senha) || senha.equals(null))    
            {
                if(habilitar_som == true){
                    play("/CODIGOS/Sons/senha_incorreta_ou_operacao_cancelada");//executa o arquivo wav
                }
                JOptionPane.showMessageDialog(null,"Senha incorreta ou operação cancelada","Aviso",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                  
             if(habilitar_piadas == false){
                habilitar_piadas = true;
                contador_piada = 0;
                play("/CODIGOS/Sons/piadas_habilitadas");//executa o arquivo wav
                BOTAO_PIADAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CODIGOS/Imagens/joker_icon.png"))); // NOI18N
             }else
             if(habilitar_piadas == true){
                habilitar_piadas = false;
                play("/CODIGOS/Sons/piadas_desabilitadas");//executa o arquivo wav
                BOTAO_PIADAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CODIGOS/Imagens/joker-48.png"))); // NOI18N
             }
                
            }
        }
        
    }//GEN-LAST:event_BOTAO_PIADASActionPerformed

    private void BOTAO_CHAMAR_NOVAMENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOTAO_CHAMAR_NOVAMENTEActionPerformed
        // TODO add your handling code here:
        
        contador_chamar_novamente++;
        
        if(contador_chamar_novamente == 1){
            
             if(BOTAO_ZERAR.isEnabled()){
            
            if(habilitar_som == true){
            if(QDT == 4){
                if(v == 1){
                play("/CODIGOS/Sons/002228");
                }else
                if(v == 2){
                play("/CODIGOS/Sons/002583");
                }else
                if(v == 3){
                play("/CODIGOS/Sons/002423");
                }else
                if(v == 0){
                play("/CODIGOS/Sons/003263");
                }
            }
            try {
                Robot bot = new Robot();
                bot.delay(4000);
            } catch (AWTException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(opcao.equals("0")){
                play("/CODIGOS/Sons/checklist");
            }else
            if(opcao.equals("1")){
                play("/CODIGOS/Sons/recarga_de_cartucho");
            }else
            if(opcao.equals("2")){
                play("/CODIGOS/Sons/situacao_diferenciada");
            }else
            if(opcao.equals("3")){
                play("/CODIGOS/Sons/tirar_duvida_de_cliente");
            }else
            if(opcao.equals("4")){
                play("/CODIGOS/Sons/atendimento_para_gerar_credito");//GERAR CREDITO
            }else
            if(opcao.equals("5")){
                play("/CODIGOS/Sons/troca_em_garantia");
            }else
            if(opcao.equals("6")){
                play("/CODIGOS/Sons/atendimento_para_plus");
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"O som está desabilitado.","Aviso",JOptionPane.WARNING_MESSAGE);
        }
            
        }else{
            JOptionPane.showMessageDialog(null,"Inicie o atendimento.","Aviso",JOptionPane.WARNING_MESSAGE);
        }
            
        }
        
    }//GEN-LAST:event_BOTAO_CHAMAR_NOVAMENTEActionPerformed

    private void BTN_CHECKLISTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CHECKLISTActionPerformed
        // TODO add your handling code here:
        chamar_Tecnico("0");
    }//GEN-LAST:event_BTN_CHECKLISTActionPerformed

    private void BTN_RECARGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_RECARGAActionPerformed
        // TODO add your handling code here:
        chamar_Tecnico("1");
    }//GEN-LAST:event_BTN_RECARGAActionPerformed

    private void BTN_SITU_DIFEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SITU_DIFEActionPerformed
        // TODO add your handling code here:
        chamar_Tecnico("2");
    }//GEN-LAST:event_BTN_SITU_DIFEActionPerformed

    private void BTN_TIRA_DUVIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_TIRA_DUVIActionPerformed
        // TODO add your handling code here:
        chamar_Tecnico("3");
    }//GEN-LAST:event_BTN_TIRA_DUVIActionPerformed

    private void BTN_GERAR_CREDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GERAR_CREDActionPerformed
        // TODO add your handling code here:
        chamar_Tecnico("4");
    }//GEN-LAST:event_BTN_GERAR_CREDActionPerformed

    private void BTN_TROCA_GARANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_TROCA_GARANActionPerformed
        // TODO add your handling code here:
        chamar_Tecnico("5");
    }//GEN-LAST:event_BTN_TROCA_GARANActionPerformed

    private void BTN_PLUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PLUSActionPerformed
        // TODO add your handling code here:
        chamar_Tecnico("6");
    }//GEN-LAST:event_BTN_PLUSActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BOTAO_CHAMAR_NOVAMENTE;
    private javax.swing.JToggleButton BOTAO_PIADAS;
    private javax.swing.JToggleButton BOTAO_SOLICITAR_SENHA;
    private javax.swing.JToggleButton BOTAO_SOM;
    private javax.swing.JButton BOTAO_ZERAR;
    private javax.swing.JToggleButton BTN1;
    private javax.swing.JToggleButton BTN2;
    private javax.swing.JToggleButton BTN3;
    private javax.swing.JToggleButton BTN4;
    private javax.swing.JToggleButton BTN5;
    private javax.swing.JButton BTN_CHECKLIST;
    private javax.swing.JButton BTN_GERAR_CRED;
    private javax.swing.JButton BTN_PLUS;
    private javax.swing.JButton BTN_RECARGA;
    private javax.swing.JButton BTN_SITU_DIFE;
    private javax.swing.JButton BTN_TIRA_DUVI;
    private javax.swing.JButton BTN_TROCA_GARAN;
    private javax.swing.JDesktopPane JanelaInternaPrincipal;
    private javax.swing.JLabel PAPEL_DE_PAREDE;
    private javax.swing.JLabel TEXTO_CRONOMETRO;
    private javax.swing.JLabel TEXTO_DESENVOLVEDOR;
    private javax.swing.JLabel TEXTO_HORA;
    private javax.swing.JLabel TEXTO_NOME_DA_VEZ;
    private javax.swing.JLabel TEXTO_TOTAL;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuConfigurar;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemConfigurar;
    private javax.swing.JMenu jMenuSobre;
    // End of variables declaration//GEN-END:variables
}
