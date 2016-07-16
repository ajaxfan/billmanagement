import java.applet.Applet;
import java.net.URL;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * 配置单打印
 * 
 * @author Ajaxfan
 */
public class ClientApplet extends Applet {
    /***/
    private static final long serialVersionUID = 3007717280460840364L;

    /**
     * 打印报表对象
     * @param reportName
     */
    public void ppr(String reportName) {
        String urlbase = "/reportService?";

        try {
            URL url = new URL(getCodeBase(), urlbase + "name=" + reportName);

            JasperPrintManager.printReport((JasperPrint) JRLoader.loadObject(url), false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "打印执行失败，更多信息请查看运行日志");
            e.printStackTrace();
        }
    }
}
