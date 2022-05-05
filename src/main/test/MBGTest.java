import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shily-zhang
 * @Description
 */
public class MBGTest {
    public static void main(String[] args) throws Exception {

                List<String> warnings = new ArrayList<String>();
                boolean overwrite = true;
                //下一行中的是存放generator配置的路径，切记不要写错
                File configFile = new File("mbg.xml");
                ConfigurationParser cp = new ConfigurationParser(warnings);
                Configuration config = cp.parseConfiguration(configFile);
                DefaultShellCallback callback = new DefaultShellCallback(overwrite);
                MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
                myBatisGenerator.generate(null);
    }
}
