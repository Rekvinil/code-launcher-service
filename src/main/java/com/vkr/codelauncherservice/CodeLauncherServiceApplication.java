package com.vkr.codelauncherservice;

import net.openhft.compiler.CompilerUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import net.openhft.compiler.CachedCompiler;

import java.io.File;

//@SpringBootApplication
public class CodeLauncherServiceApplication {

    public static void main(String[] args) {
        //SpringApplication.run(CodeLauncherServiceApplication.class, args);

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
                "        writer.printMessag();\n" +
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

}
