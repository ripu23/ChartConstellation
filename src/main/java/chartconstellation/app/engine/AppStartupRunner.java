package chartconstellation.app.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import chartconstellation.app.appconfiguration.Configuration;
import chartconstellation.app.util.TextDocsUtil;

@Component
public class AppStartupRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);

    @Autowired
    TextDocsUtil textDocsUtil;

    @Autowired
    Configuration configuration;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Your application started with option names : {}", args.getOptionNames());

        System.out.println(configuration.toString());

        if(configuration.isUpdateData()) {
            textDocsUtil.loadDocs();
        }
    }
}

