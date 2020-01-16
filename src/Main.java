import generated.GrammarTemplateLexer;
import generated.GrammarTemplateParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;


import static generator.GeneratorKt.generateFiles;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] inputFileNames = {"calculatorGrammar", "pascalToC"};

        MyGrammarVisitor[] visitors = new MyGrammarVisitor[inputFileNames.length];

        int i = 0;
        for (String inputFileName : inputFileNames) {
            CharStream cs = fromFileName("test/grammar/" + inputFileName);
            GrammarTemplateLexer lexer = new GrammarTemplateLexer(cs);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            GrammarTemplateParser parser = new GrammarTemplateParser(tokenStream);
            MyGrammarVisitor visitor = new MyGrammarVisitor();

            visitor.visit(parser.file());
            visitors[i] = visitor;
            i++;
        }

        generateFiles(visitors, inputFileNames);
    }
}
