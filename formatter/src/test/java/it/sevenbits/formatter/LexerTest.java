package it.sevenbits.formatter;

import it.sevenbits.formatter.io.reader.FileReader;
import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.io.reader.ReaderException;
import it.sevenbits.formatter.lexer.ILexer;
import it.sevenbits.formatter.lexer.Lexer;
import it.sevenbits.formatter.lexer.LexerException;
import it.sevenbits.formatter.lexer.Token.IToken;
import org.junit.Assert;
import org.junit.Test;

public class LexerTest {
    private ILexer lexer;
    private IReader reader;

    @Test
    public void shouldWorkCorrectlyAtFirst() throws LexerException {
        try {
            reader = new FileReader("../formatter/src/test/resources/inputTextes/Text1.txt");
        } catch (ReaderException e) {
            e.printStackTrace();
        }
        lexer = new Lexer(reader);

        IToken token = lexer.readToken();
        Assert.assertEquals(token.getLexeme(), "{");

        token = lexer.readToken();
        Assert.assertEquals(token.getLexeme(), "{");
        Assert.assertEquals(token.getName(), "SYMBOL_OPENING_BRACKET");
    }
}
