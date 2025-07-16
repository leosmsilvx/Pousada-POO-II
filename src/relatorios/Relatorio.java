package relatorios;

import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import connection.Conexao;

public class Relatorio {

    public static void gerarRelatorio(String nomeRelatorioBase, Map<String, Object> parametros) {
        Conexao c = new Conexao();
        c.conectar();
        try {
            JasperCompileManager.compileReportToFile(nomeRelatorioBase + ".jrxml");

            JasperPrint print = JasperFillManager.fillReport(nomeRelatorioBase + ".jasper", parametros, c.conector);

            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

            JasperExportManager.exportReportToPdfFile(print, nomeRelatorioBase + ".pdf");
        } catch (JRException e) {
            throw new RuntimeException("Impossível abrir relatório! ", e);
        } finally {
            if (c.conector != null) {
                c.desconectar();
            }
        }
    }

}
