package maven.custom.goal;

import java.io.IOException;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.Test;

public class customgoaltest {
    @Test
    public void shouldAnswerWithTrue()
                    throws MojoFailureException, MojoExecutionException, IOException, InterruptedException {
        final MyMojo tester = new MyMojo();
        tester.executes("C:\\Users\\320074769\\Downloads\\Cerberus\\jscpd.properties.xlsx");
        tester.executes("C:\\Users\\320074769\\Downloads\\Cerberus\\jscpd.propertie.xlsx");
        tester.execute();
    }
}
