package com.vkr.codelauncherservice;

import com.vkr.codelauncherservice.data.web.FileListResult;
import com.vkr.codelauncherservice.launcher.ICodeLauncher;
import com.vkr.codelauncherservice.launcher.OpenHftJavaLauncher;
import net.openhft.compiler.CompilerUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

//@SpringBootApplication
public class CodeLauncherServiceApplication {

    public static void main(String[] args) {
        //SpringApplication.run(CodeLauncherServiceApplication.class, args);

//        String mainPath = "C:\\Users\\Ivan\\Desktop\\m2curs\\SanyaUkhov\\example1\\Main.java";
//        String writerExamplePath = "C:\\Users\\Ivan\\Desktop\\m2curs\\SanyaUkhov\\example1\\packageex\\WriterExample.java";
//        String writerExample2Path = "C:\\Users\\Ivan\\Desktop\\m2curs\\SanyaUkhov\\example1\\packageex\\WriterExample2.java";
//
//        ICodeLauncher codeLauncher = new OpenHftJavaLauncher();
//
//        FileListResult fileListResult = new FileListResult();
//        fileListResult.setUserId("123");
//        fileListResult.setProjectName("testProject");
//        fileListResult.setFileList(new ArrayList<String>());
//        fileListResult.getFileList().add(mainPath);
//        fileListResult.getFileList().add(writerExamplePath);
//        fileListResult.getFileList().add(writerExample2Path);
//
//        codeLauncher.launch(fileListResult);

        String writerClassName = "packageex.WriterExample";
        String writerJavaCode = "package packageex;\n" +
                "\n" +
                "public class WriterExample {\n" +
                "\n" +
                "    private int count = 0;\n" +
                "\n" +
                "    public void printMessage(){\n" +
                "        System.out.println(\"Print the message with count \" + count + \" from writer\");\n" +
                "        count++;\n" +
                "    }\n" +
                "}";
        String writer2ClassName = "packageex.WriterExample2";
        String writer2JavaCode = "package packageex;\n" +
                "\n" +
                "public class WriterExample2 {\n" +
                "\n" +
                "    private int count = 0;\n" +
                "\n" +
                "    public void printMessage(){\n" +
                "        System.out.println(\"Print the message with count \" + count + \" from writer 2\");\n" +
                "        count++;\n" +
                "    }\n" +
                "}";
        String mainClassName = "Main";
        String mainJavaCode = "import packageex.WriterExample;\n" +
                "import packageex.WriterExample2;\n" +
                "\n" +
                "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello world!\");\n" +
                "        WriterExample writer = new WriterExample();\n" +
                "        WriterExample2 writer2 = new WriterExample2();\n" +
                "\n" +
                "        writer.printMessage();\n" +
                "        writer.printMessage();\n" +
                "        writer.printMessage();\n" +
                "\n" +
                "        writer2.printMessage();\n" +
                "    }\n" +
                "}";

        try {
            Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(mainClassName, mainJavaCode);
            Runnable runner = (Runnable) aClass.newInstance();
            runner.run();
        } catch (Exception e) {

        }
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
