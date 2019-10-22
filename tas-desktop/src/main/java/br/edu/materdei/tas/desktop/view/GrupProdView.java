
package br.edu.materdei.tas.desktop.view;

import br.edu.materdei.tas.desktop.dialog.GenericDialogImpl;
import br.edu.materdei.tas.desktop.dialog.GrupoDialog;
import br.edu.materdei.tas.desktop.dialog.ProdutoDialog;
import br.edu.materdei.tas.desktop.exception.ResponseException;
import br.edu.materdei.tas.desktop.gui.core.TasDialogError;
import br.edu.materdei.tas.desktop.gui.core.TasItemToolBar;
import br.edu.materdei.tas.desktop.gui.renderer.AtivoTableCellRenderer;
import br.edu.materdei.tas.desktop.service.BackendService;
import java.awt.Cursor;
import java.io.IOException;
import java.text.NumberFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.json.JSONObject;


public class GrupProdView extends GenericView {
    private boolean showGrupo;
    private Object[] dados;
    
    public GrupProdView() {
        initComponents();
        
        //Imagens da Toolbar
        toolbar.setImage(new ImageIcon(getClass().getResource("/assets/toolbar/fundoToolbar.png")).getImage());
        btGrupo.setIcon(new ImageIcon(getClass().getResource("/assets/toolbar/grupo.png")));
        btProduto.setIcon(new ImageIcon(getClass().getResource("/assets/toolbar/produto.png")));
        btIncluir.setIcon(new ImageIcon(getClass().getResource("/assets/toolbar/incluir.png")));
        btEditar.setIcon(new ImageIcon(getClass().getResource("/assets/toolbar/editar.png")));
        btExcluir.setIcon(new ImageIcon(getClass().getResource("/assets/toolbar/excluir.png")));
        
        lbAtivo.setIcon(new ImageIcon(getClass().getResource("/assets/system/icons/icon-ativo.png")));
        lbInativo.setIcon(new ImageIcon(getClass().getResource("/assets/system/icons/icon-inativo.png")));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbar = new br.edu.materdei.tas.desktop.gui.core.TasImagePanel();
        acaoGrupProd = new javax.swing.JPanel();
        tbGrupProd = new javax.swing.JPanel();
        btGrupo = new br.edu.materdei.tas.desktop.gui.core.TasItemToolBar();
        tasSeparadorItem2 = new br.edu.materdei.tas.desktop.gui.core.TasSeparadorItem();
        btProduto = new br.edu.materdei.tas.desktop.gui.core.TasItemToolBar();
        divRight1 = new javax.swing.JPanel();
        labelGrupoMenu1 = new javax.swing.JLabel();
        acaoCadastro = new javax.swing.JPanel();
        toolBar = new javax.swing.JPanel();
        btIncluir = new br.edu.materdei.tas.desktop.gui.core.TasItemToolBar();
        btEditar = new br.edu.materdei.tas.desktop.gui.core.TasItemToolBar();
        tasSeparadorItem1 = new br.edu.materdei.tas.desktop.gui.core.TasSeparadorItem();
        btExcluir = new br.edu.materdei.tas.desktop.gui.core.TasItemToolBar();
        divRight = new javax.swing.JPanel();
        labelGrupoMenu = new javax.swing.JLabel();
        container = new javax.swing.JPanel();
        tabTop = new javax.swing.JPanel();
        tabLeft = new javax.swing.JPanel();
        tabRight = new javax.swing.JPanel();
        tabBottom = new javax.swing.JPanel();
        conteudo = new javax.swing.JPanel();
        panelMigalha = new javax.swing.JPanel();
        migalha = new javax.swing.JLabel();
        panelTabela = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        grid = new javax.swing.JTable();
        panelLegenda = new javax.swing.JPanel();
        lbAtivo = new javax.swing.JLabel();
        lbInativo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(246, 246, 246));
        setLayout(new java.awt.BorderLayout());

        toolbar.setMaximumSize(new java.awt.Dimension(32767, 103));
        toolbar.setMinimumSize(new java.awt.Dimension(0, 103));
        toolbar.setPreferredSize(new java.awt.Dimension(540, 103));
        toolbar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 10, 4));

        acaoGrupProd.setMinimumSize(new java.awt.Dimension(155, 99));
        acaoGrupProd.setOpaque(false);
        acaoGrupProd.setPreferredSize(new java.awt.Dimension(118, 99));
        acaoGrupProd.setLayout(new java.awt.BorderLayout());

        tbGrupProd.setMaximumSize(new java.awt.Dimension(32767, 78));
        tbGrupProd.setMinimumSize(new java.awt.Dimension(57, 78));
        tbGrupProd.setOpaque(false);
        tbGrupProd.setPreferredSize(new java.awt.Dimension(57, 78));
        tbGrupProd.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 0, 0));

        btGrupo.setToolTipText("Cadastro de Grupo");
        btGrupo.setLabel("Grupos");
        btGrupo.setMaximumSize(new java.awt.Dimension(52, 78));
        btGrupo.setMinimumSize(new java.awt.Dimension(52, 78));
        btGrupo.setPreferredSize(new java.awt.Dimension(52, 78));
        btGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btGrupoMousePressed(evt);
            }
        });
        tbGrupProd.add(btGrupo);

        javax.swing.GroupLayout tasSeparadorItem2Layout = new javax.swing.GroupLayout(tasSeparadorItem2);
        tasSeparadorItem2.setLayout(tasSeparadorItem2Layout);
        tasSeparadorItem2Layout.setHorizontalGroup(
            tasSeparadorItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        tasSeparadorItem2Layout.setVerticalGroup(
            tasSeparadorItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        tbGrupProd.add(tasSeparadorItem2);

        btProduto.setToolTipText("Cadastro de Produto");
        btProduto.setDoubleBuffered(false);
        btProduto.setLabel("Produtos");
        btProduto.setMaximumSize(new java.awt.Dimension(52, 78));
        btProduto.setMinimumSize(new java.awt.Dimension(52, 78));
        btProduto.setPreferredSize(new java.awt.Dimension(52, 78));
        btProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btProdutoMousePressed(evt);
            }
        });
        tbGrupProd.add(btProduto);

        acaoGrupProd.add(tbGrupProd, java.awt.BorderLayout.CENTER);

        divRight1.setBackground(new java.awt.Color(198, 198, 198));
        divRight1.setPreferredSize(new java.awt.Dimension(1, 100));

        javax.swing.GroupLayout divRight1Layout = new javax.swing.GroupLayout(divRight1);
        divRight1.setLayout(divRight1Layout);
        divRight1Layout.setHorizontalGroup(
            divRight1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        divRight1Layout.setVerticalGroup(
            divRight1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        acaoGrupProd.add(divRight1, java.awt.BorderLayout.EAST);

        labelGrupoMenu1.setFont(new java.awt.Font("Segoe UI Light", 0, 10)); // NOI18N
        labelGrupoMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGrupoMenu1.setText("Grupo e Produto");
        labelGrupoMenu1.setMaximumSize(new java.awt.Dimension(101, 21));
        labelGrupoMenu1.setMinimumSize(new java.awt.Dimension(101, 21));
        labelGrupoMenu1.setPreferredSize(new java.awt.Dimension(101, 21));
        acaoGrupProd.add(labelGrupoMenu1, java.awt.BorderLayout.SOUTH);

        toolbar.add(acaoGrupProd);

        acaoCadastro.setMinimumSize(new java.awt.Dimension(155, 99));
        acaoCadastro.setOpaque(false);
        acaoCadastro.setPreferredSize(new java.awt.Dimension(170, 99));
        acaoCadastro.setLayout(new java.awt.BorderLayout());

        toolBar.setMaximumSize(new java.awt.Dimension(32767, 78));
        toolBar.setMinimumSize(new java.awt.Dimension(57, 78));
        toolBar.setOpaque(false);
        toolBar.setPreferredSize(new java.awt.Dimension(57, 78));
        toolBar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 0, 0));

        btIncluir.setToolTipText("Novo Produto");
        btIncluir.setLabel("Incluir");
        btIncluir.setMaximumSize(new java.awt.Dimension(52, 78));
        btIncluir.setMinimumSize(new java.awt.Dimension(52, 78));
        btIncluir.setPreferredSize(new java.awt.Dimension(52, 78));
        btIncluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btIncluirMousePressed(evt);
            }
        });
        toolBar.add(btIncluir);

        btEditar.setToolTipText("Editar Produto");
        btEditar.setLabel("Editar");
        btEditar.setMaximumSize(new java.awt.Dimension(52, 78));
        btEditar.setMinimumSize(new java.awt.Dimension(52, 78));
        btEditar.setPreferredSize(new java.awt.Dimension(52, 78));
        btEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btEditarMousePressed(evt);
            }
        });
        toolBar.add(btEditar);

        javax.swing.GroupLayout tasSeparadorItem1Layout = new javax.swing.GroupLayout(tasSeparadorItem1);
        tasSeparadorItem1.setLayout(tasSeparadorItem1Layout);
        tasSeparadorItem1Layout.setHorizontalGroup(
            tasSeparadorItem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        tasSeparadorItem1Layout.setVerticalGroup(
            tasSeparadorItem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        toolBar.add(tasSeparadorItem1);

        btExcluir.setToolTipText("Excluir Produto");
        btExcluir.setDoubleBuffered(false);
        btExcluir.setLabel("Excluir");
        btExcluir.setMaximumSize(new java.awt.Dimension(52, 78));
        btExcluir.setMinimumSize(new java.awt.Dimension(52, 78));
        btExcluir.setPreferredSize(new java.awt.Dimension(52, 78));
        btExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btExcluirMousePressed(evt);
            }
        });
        toolBar.add(btExcluir);

        acaoCadastro.add(toolBar, java.awt.BorderLayout.CENTER);

        divRight.setBackground(new java.awt.Color(198, 198, 198));
        divRight.setPreferredSize(new java.awt.Dimension(1, 100));

        javax.swing.GroupLayout divRightLayout = new javax.swing.GroupLayout(divRight);
        divRight.setLayout(divRightLayout);
        divRightLayout.setHorizontalGroup(
            divRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        divRightLayout.setVerticalGroup(
            divRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        acaoCadastro.add(divRight, java.awt.BorderLayout.EAST);

        labelGrupoMenu.setFont(new java.awt.Font("Segoe UI Light", 0, 10)); // NOI18N
        labelGrupoMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGrupoMenu.setText("Ações de Cadastros");
        labelGrupoMenu.setMaximumSize(new java.awt.Dimension(101, 21));
        labelGrupoMenu.setMinimumSize(new java.awt.Dimension(101, 21));
        labelGrupoMenu.setPreferredSize(new java.awt.Dimension(101, 21));
        acaoCadastro.add(labelGrupoMenu, java.awt.BorderLayout.SOUTH);

        toolbar.add(acaoCadastro);

        add(toolbar, java.awt.BorderLayout.NORTH);

        container.setBackground(new java.awt.Color(246, 246, 246));
        container.setLayout(new java.awt.BorderLayout());

        tabTop.setOpaque(false);
        tabTop.setPreferredSize(new java.awt.Dimension(0, 5));

        javax.swing.GroupLayout tabTopLayout = new javax.swing.GroupLayout(tabTop);
        tabTop.setLayout(tabTopLayout);
        tabTopLayout.setHorizontalGroup(
            tabTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        tabTopLayout.setVerticalGroup(
            tabTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        container.add(tabTop, java.awt.BorderLayout.NORTH);

        tabLeft.setOpaque(false);
        tabLeft.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout tabLeftLayout = new javax.swing.GroupLayout(tabLeft);
        tabLeft.setLayout(tabLeftLayout);
        tabLeftLayout.setHorizontalGroup(
            tabLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        tabLeftLayout.setVerticalGroup(
            tabLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        container.add(tabLeft, java.awt.BorderLayout.WEST);

        tabRight.setOpaque(false);
        tabRight.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout tabRightLayout = new javax.swing.GroupLayout(tabRight);
        tabRight.setLayout(tabRightLayout);
        tabRightLayout.setHorizontalGroup(
            tabRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        tabRightLayout.setVerticalGroup(
            tabRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        container.add(tabRight, java.awt.BorderLayout.EAST);

        tabBottom.setOpaque(false);
        tabBottom.setPreferredSize(new java.awt.Dimension(0, 5));

        javax.swing.GroupLayout tabBottomLayout = new javax.swing.GroupLayout(tabBottom);
        tabBottom.setLayout(tabBottomLayout);
        tabBottomLayout.setHorizontalGroup(
            tabBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        tabBottomLayout.setVerticalGroup(
            tabBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        container.add(tabBottom, java.awt.BorderLayout.SOUTH);

        conteudo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(210, 215, 222)));
        conteudo.setOpaque(false);
        conteudo.setLayout(new java.awt.BorderLayout());

        panelMigalha.setBackground(new java.awt.Color(252, 252, 252));
        panelMigalha.setPreferredSize(new java.awt.Dimension(388, 28));
        panelMigalha.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        migalha.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        migalha.setText("Cadastro de Produtos");
        panelMigalha.add(migalha);

        conteudo.add(panelMigalha, java.awt.BorderLayout.NORTH);

        panelTabela.setOpaque(false);

        scroll.setBackground(new java.awt.Color(246, 246, 246));

        grid.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        grid.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        grid.setGridColor(new java.awt.Color(240, 240, 240));
        grid.setRowHeight(22);
        grid.setSelectionBackground(new java.awt.Color(50, 153, 255));
        grid.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        grid.setShowVerticalLines(false);
        grid.getTableHeader().setResizingAllowed(false);
        grid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridMouseClicked(evt);
            }
        });
        scroll.setViewportView(grid);

        javax.swing.GroupLayout panelTabelaLayout = new javax.swing.GroupLayout(panelTabela);
        panelTabela.setLayout(panelTabelaLayout);
        panelTabelaLayout.setHorizontalGroup(
            panelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        panelTabelaLayout.setVerticalGroup(
            panelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        conteudo.add(panelTabela, java.awt.BorderLayout.CENTER);

        panelLegenda.setBorder(javax.swing.BorderFactory.createTitledBorder("Legenda"));
        panelLegenda.setOpaque(false);
        panelLegenda.setPreferredSize(new java.awt.Dimension(528, 45));
        panelLegenda.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 5, 0));

        lbAtivo.setText("Ativo");
        lbAtivo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbAtivo.setMaximumSize(new java.awt.Dimension(80, 80));
        lbAtivo.setPreferredSize(new java.awt.Dimension(60, 20));
        panelLegenda.add(lbAtivo);

        lbInativo.setText("Inativo");
        lbInativo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbInativo.setMaximumSize(new java.awt.Dimension(80, 80));
        lbInativo.setPreferredSize(new java.awt.Dimension(60, 20));
        panelLegenda.add(lbInativo);

        conteudo.add(panelLegenda, java.awt.BorderLayout.SOUTH);

        container.add(conteudo, java.awt.BorderLayout.CENTER);

        add(container, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void gridMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridMouseClicked
        boolean selecionado = grid.getSelectedRow() >= 0;
        btEditar.setEnabled(selecionado);
        btExcluir.setEnabled(selecionado);
    }//GEN-LAST:event_gridMouseClicked

    private void btIncluirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btIncluirMousePressed
        TasItemToolBar item = (TasItemToolBar) evt.getComponent();
        if (item.isEnabled()) {
            this.incluir();
        }
    }//GEN-LAST:event_btIncluirMousePressed

    private void btEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEditarMousePressed
        TasItemToolBar item = (TasItemToolBar) evt.getComponent();
        if (item.isEnabled()) {
            this.editar();
        }
    }//GEN-LAST:event_btEditarMousePressed

    private void btExcluirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExcluirMousePressed
        TasItemToolBar item = (TasItemToolBar) evt.getComponent();
        if (item.isEnabled()) {
            this.excluir();
        }
    }//GEN-LAST:event_btExcluirMousePressed

    private void btGrupoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btGrupoMousePressed
        this.preparaGrupo();
    }//GEN-LAST:event_btGrupoMousePressed

    private void btProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btProdutoMousePressed
        this.preparaProduto();
    }//GEN-LAST:event_btProdutoMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel acaoCadastro;
    private javax.swing.JPanel acaoGrupProd;
    private br.edu.materdei.tas.desktop.gui.core.TasItemToolBar btEditar;
    private br.edu.materdei.tas.desktop.gui.core.TasItemToolBar btExcluir;
    private br.edu.materdei.tas.desktop.gui.core.TasItemToolBar btGrupo;
    private br.edu.materdei.tas.desktop.gui.core.TasItemToolBar btIncluir;
    private br.edu.materdei.tas.desktop.gui.core.TasItemToolBar btProduto;
    private javax.swing.JPanel container;
    private javax.swing.JPanel conteudo;
    private javax.swing.JPanel divRight;
    private javax.swing.JPanel divRight1;
    private javax.swing.JTable grid;
    private javax.swing.JLabel labelGrupoMenu;
    private javax.swing.JLabel labelGrupoMenu1;
    private javax.swing.JLabel lbAtivo;
    private javax.swing.JLabel lbInativo;
    private javax.swing.JLabel migalha;
    private javax.swing.JPanel panelLegenda;
    private javax.swing.JPanel panelMigalha;
    private javax.swing.JPanel panelTabela;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JPanel tabBottom;
    private javax.swing.JPanel tabLeft;
    private javax.swing.JPanel tabRight;
    private javax.swing.JPanel tabTop;
    private br.edu.materdei.tas.desktop.gui.core.TasSeparadorItem tasSeparadorItem1;
    private br.edu.materdei.tas.desktop.gui.core.TasSeparadorItem tasSeparadorItem2;
    private javax.swing.JPanel tbGrupProd;
    private javax.swing.JPanel toolBar;
    private br.edu.materdei.tas.desktop.gui.core.TasImagePanel toolbar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void preinit() {
        preparaGrupo();
    }
    private void preparaGrupo() {
        this.showGrupo = true;
        
        //ToolBar
        btGrupo.setSelected(true);
        btProduto.setSelected(false);
        btIncluir.setToolTipText("Novo Grupo");
        btEditar.setToolTipText("Editar Grupo");
        btEditar.setEnabled(false);
        btExcluir.setToolTipText("Excluir Grupo");
        btExcluir.setEnabled(false);
        labelGrupoMenu.setText("Ações de Cadastros Grupos");
        
        //Migalha
        migalha.setText("Cadastro de Grupo");
        
        //Tabela
        constroiTabelaGrupo();
        
        //Carrega dados
        loadDados();
        
        //Carrega dados no grid
        carregaGridGrupo();
        
        //Legenda
        panelLegenda.setVisible(false);
    }
    private void preparaProduto() {
        this.showGrupo = false;
        
        //ToolBar
        btGrupo.setSelected(false);
        btProduto.setSelected(true);
        btIncluir.setToolTipText("Novo Produto");
        btEditar.setToolTipText("Editar Produto");
        btEditar.setEnabled(false);
        btExcluir.setToolTipText("Excluir Produto");
        btExcluir.setEnabled(false);
        labelGrupoMenu.setText("Ações de Cadastros Produtos");
        
        //Migalha
        migalha.setText("Cadastro de Produto");
        
        //Tabela
        constroiTabelaProduto();
        
        //Carrega Dados
        carregaGridProduto();
        
        //Legenda
        panelLegenda.setVisible(true);
    }
    
    private void constroiTabelaGrupo() {
        //Monta tabela
        grid.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        DefaultTableModel modelo = (DefaultTableModel) grid.getModel();
        modelo.setColumnCount(0);
        
        //Define o título das colunas
        modelo.addColumn("Nome");
        
        //Define largura das colunas
        grid.getColumnModel().getColumn(0).setPreferredWidth(450);
        
        mainframe.setStatus("Pronto!");        
    }
    private void constroiTabelaProduto() {
        loadDados();
        
        //Monta tabela
        grid.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        DefaultTableModel modelo = (DefaultTableModel) grid.getModel();
        modelo.setColumnCount(0);
        
        //Define o título das colunas
        modelo.addColumn("");
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Preço");
        modelo.addColumn("Grupo");
        
        //Define largura das colunas
        grid.getColumnModel().getColumn(0).setPreferredWidth(30);
        grid.getColumnModel().getColumn(1).setPreferredWidth(80);
        grid.getColumnModel().getColumn(2).setPreferredWidth(350);
        grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        grid.getColumnModel().getColumn(4).setPreferredWidth(300);
        
        //Adiciona ícone do certificado digital na primeira coluna
        TableColumnModel columnModel = grid.getColumnModel();
        AtivoTableCellRenderer renderer = new AtivoTableCellRenderer();        
        columnModel.getColumn(0).setCellRenderer(renderer);
        
        mainframe.setStatus("Pronto!");
    }
    
    public void loadDados() {
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        try {
            mainframe.setStatus("Carregando dados. Aguarde...");
            
            try {
                if (showGrupo) {
                    
                    this.dados = BackendService.findAll("grupos");
                            
                } else {
                    
                    this.dados = BackendService.findAll("produtos");
                    
                }

                mainframe.setStatus("Pronto!");   
            } catch (Exception e) {
                TasDialogError dlgError = new TasDialogError(mainframe);
                dlgError.showError(TasDialogError.DANGER_ERROR, 
                                   "<html>Não foi possível carregar os registros. Clique em \"Detalhes\" Para visualizar o problema.</html>", 
                                   e.getMessage());
                this.mainframe.setStatus(new ImageIcon(getClass().getResource("/assets/system/icons/icon-warning-small.png")), 
                                         e.getMessage(), "Ops!");
            }
        } finally {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    private void carregaGridGrupo() {
        DefaultTableModel modelo = (DefaultTableModel) grid.getModel();
        
        mainframe.setStatus("Carregando dados no grid. Aguarde...");
        
        //Alimenta a tabela
        modelo.setNumRows(0);
        
        for (Object dado : this.dados) {
            JSONObject grupo = (JSONObject) dado;
            modelo.addRow(new Object[] {grupo.get("nome")});
        }
        
        grid.setModel(modelo);
        
        mainframe.setStatus("Pronto!");
    }
    private void carregaGridProduto() {
        DefaultTableModel modelo = (DefaultTableModel) grid.getModel();
        
        mainframe.setStatus("Carregando dados no grid. Aguarde...");
        
        //Alimenta a tabela
        modelo.setNumRows(0);
        
        for (Object dado : this.dados) {
            JSONObject produto = (JSONObject) dado; 
            Boolean ativo = produto.get("ativo").toString().equals("S");
            String preco = NumberFormat.getCurrencyInstance().format(produto.get("preco"));             
            JSONObject grupo = (JSONObject) produto.get("grupo");
            modelo.addRow(new Object[] {ativo, produto.get("codigo"), produto.get("nome"), preco, grupo.get("nome")});
        }
        
        grid.setModel(modelo);
        
        mainframe.setStatus("Pronto!");
    }
    
    private void showDialogGrupo(JSONObject grupo) {
        GrupoDialog dialog = new GrupoDialog(mainframe, grupo);
        showDialog(dialog);
        
        if (!dialog.fail) {
            loadDados();
            carregaGridGrupo();
        }
    }
    private void showDialogProduto(JSONObject produto) {
        ProdutoDialog dialog = new ProdutoDialog(mainframe, produto);
        showDialog(dialog);
        
        if (!dialog.fail) {
            loadDados();
            carregaGridProduto();
        }
    }
    private void showDialog(GenericDialogImpl dialog) {
        getRootPane().getGlassPane().setVisible(true);
        
        dialog.dispose();
        dialog.setLocationRelativeTo(this);
        dialog.setUndecorated(true);
        dialog.setVisible(true);
        
        getRootPane().getGlassPane().setVisible(false);
    }
    
    //TOOLBAR
    private void incluir() {
        JSONObject novo = new JSONObject();
        if (showGrupo) {
            novo.put("nome", "");
            showDialogGrupo(novo);
        } else {            
            novo.put("codigo", "");
            novo.put("nome", "");
            novo.put("descricao", "");
            novo.put("preco", 0);
            novo.put("ativo", "S");
            novo.put("grupo", null);
            
            showDialogProduto(novo);
        }
    }
    private void editar() {
        JSONObject object = (JSONObject) this.dados[grid.getSelectedRow()];
        
        if (showGrupo) {
            showDialogGrupo(object);
        } else {
            showDialogProduto(object);
        }
    }
    private void excluir() {
        Object[] options = { "Sim", "Não" };
        
        int opcao = JOptionPane.showOptionDialog(this, "Deseja excluir o registro selecionado?", 
                                                 "Excluir registro", JOptionPane.YES_NO_OPTION, 
                                                 JOptionPane.QUESTION_MESSAGE, null,  
                                                 options, options[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            try {
                mainframe.setStatus("Excluindo registro. Aguarde...");
                try {
                    JSONObject object = (JSONObject) this.dados[grid.getSelectedRow()];
                    if (showGrupo) {
                        
                        BackendService.deleteById("grupos/"+ object.get("id"));
                        loadDados();
                        carregaGridGrupo();
                        
                    } else {
                        
                        BackendService.deleteById("produtos/"+ object.get("id"));
                        loadDados();
                        carregaGridProduto();
                    }
                    
                } catch (IOException | ResponseException e) {
                    TasDialogError dlgError = new TasDialogError(mainframe);
                    dlgError.showError(TasDialogError.DANGER_ERROR, 
                                       "<html>Não foi possível excluir o registro. Clique em \"Detalhes\" Para visualizar o problema.</html>", 
                                       e.getMessage());
                    this.mainframe.setStatus(new ImageIcon(getClass().getResource("/assets/system/icons/icon-warning-small.png")), 
                                             e.getMessage(), "Ops!");
                }                
            } finally {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));    
            }
        }
    }    
}