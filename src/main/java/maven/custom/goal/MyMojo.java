package maven.custom.goal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This goal will say a message.
 *
 * @goal run-jscpd
 */
public class MyMojo extends AbstractMojo {
    public void executes(final String path) throws MojoExecutionException, IOException, InterruptedException {
        Cell data = null;
        final String excelFilePath = path;
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(new File(excelFilePath));
            final Workbook workbook = WorkbookFactory.create(inputStream);
            final Sheet sheet = workbook.getSheetAt(0);
            data = workbook.getSheetAt(0).getRow(0).getCell(1);
        } catch (final Exception e1) {
            e1.printStackTrace();
        }
        System.out.println("Hello Please Wait");
        final Cell cmd1 = data;
        final ProcessBuilder builder1 = new ProcessBuilder("cmd.exe", "/c",
                        "cd \"C:\\Users\\320074769\\Downloads\\Cerberus\" && git clone " + cmd1);
        final Process p = builder1.start();
        p.waitFor();
        final String cmd2 = "jscpd --min-tokens 50 --reporters html --output \"C:\\Users\\320074769\\Downloads\\Cerberus\" --mode strict  \"C:\\Users\\320074769\\Downloads\\Cerberus\\nnn\"";
        final ProcessBuilder builder2 = new ProcessBuilder("cmd.exe", "/c",
                        "cd \"C:\\Users\\320074769\\Downloads\\Cerberus\" && " + cmd2);
        final Process p1 = builder2.start();
        p1.waitFor();
        final String cmd3 = "start jscpd-report.html";
        final ProcessBuilder builder3 = new ProcessBuilder("cmd.exe", "/c",
                        "cd \"C:\\Users\\320074769\\Downloads\\Cerberus\" && " + cmd3);

        final Process p2 = builder3.start();
        p2.waitFor();
        System.out.println("Got your Report");
    }

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

    }

}