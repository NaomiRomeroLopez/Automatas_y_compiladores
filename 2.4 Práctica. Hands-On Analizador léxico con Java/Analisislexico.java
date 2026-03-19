/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */package analisislexico;

import java.nio.file.*;
import java.io.IOException;
import java.util.regex.*;
import java.util.*;

public class Analisislexico {

    enum TokenType {
        KEYWORD, IDENTIFIER, OPERATOR, SEPARATOR, WHITESPACE, UNKNOWN,
        FLOATLIT, HEXADECIMALLIT, BINARYLIT, OCTALLIT, INTEGERLIT,
        STRINGLIT, CHARLIT, JAVADOC
    }

    record Token(TokenType type, String lexeme, int line, int column) {
        public String toString() {
            return String.format("[L%-3d C%-3d] %-14s → \"%s\"", line, column, type, lexeme);
        }
    }

    static class LexicalError extends RuntimeException {
        public LexicalError(char c, int line, int col) {
            super(String.format(
                "Error léxico [L%d, C%d]: '%c' (U+%04X)",
                line, col, c, (int) c
            ));
        }
    }

    static final String KW_PATTERN =
        "\\b(abstract|assert|boolean|break|byte|case|catch|char|" +
        "class|const|continue|default|do|double|else|enum|extends|" +
        "final|finally|float|for|if|implements|import|instanceof|" +
        "int|interface|long|new|package|private|protected|public|" +
        "return|short|static|super|switch|synchronized|this|throw|" +
        "throws|try|void|volatile|while|true|false|null)\\b";

    static final Pattern MASTER = Pattern.compile(
        "(?<JAVADOC>/\\*\\*[\\s\\S]*?\\*/)|" +
        "(?<BLOCKCOMMENT>/\\*[\\s\\S]*?\\*/)|" +
        "(?<LINECOMMENT>//[^\\n]*)|" +

        "(?<STRINGLIT>\"([^\"\\\\]|\\\\.)*\")|" +
        "(?<CHARLIT>'([^'\\\\]|\\\\.)')|" +

        "(?<FLOATLIT>[0-9][0-9_]*\\.[0-9][0-9_]*([eE][+-]?[0-9]+)?[fFdD]?)|" +
        "(?<HEXADECIMALLIT>0[xX][0-9a-fA-F][0-9a-fA-F_]*[lL]?)|" +
        "(?<BINARYLIT>0[bB][01][01_]*[lL]?)|" +
        "(?<OCTALLIT>0[0-7]+[lL]?)|" +
        "(?<INTEGERLIT>0|[1-9][0-9_]*[lL]?)|" +

        "(?<KEYWORD>" + KW_PATTERN + ")|" +
        "(?<IDENTIFIER>[a-zA-Z_$][a-zA-Z0-9_$]*)|" +

        "(?<OPERATOR>" +
            "==|!=|<=|>=|&&|\\|\\||<<|>>>|>>|\\+\\+|--|" +
            "\\+=|-=|\\*=|/=|%=|&=|\\|=|\\^=|<<=|>>=|" +
            "[+\\-*/%<>=!&|^~?:]" +
        ")|" +

        "(?<SEPARATOR>[(){}\\[\\];,.])|" +

        "(?<WHITESPACE>[ \\t\\r\\n]+)",

        Pattern.MULTILINE
    );

    public static List<Token> tokenize(String source) {
        List<Token> tokens = new ArrayList<>();
        Matcher m = MASTER.matcher(source);

        int line = 1, col = 1, pos = 0;

        while (m.find()) {

            // ERROR LÉXICO
            if (m.start() > pos) {
                char illegal = source.charAt(pos);
                int errorCol = pos - source.lastIndexOf('\n', pos);
                System.err.println(new LexicalError(illegal, line, errorCol));
                pos++;
                continue;
            }

            String lexeme = m.group();

            if (m.group("WHITESPACE") != null) {
                for (char c : lexeme.toCharArray()) {
                    if (c == '\n') {
                        line++;
                        col = 1;
                    } else {
                        col++;
                    }
                }
            }
            else if (m.group("JAVADOC") != null) {
                tokens.add(new Token(TokenType.JAVADOC, lexeme, line, col));
                col += lexeme.length();
            }
            else if (m.group("BLOCKCOMMENT") != null || m.group("LINECOMMENT") != null) {
                col += lexeme.length();
            }
            else if (m.group("KEYWORD") != null) {
                tokens.add(new Token(TokenType.KEYWORD, lexeme, line, col));
                col += lexeme.length();
            }
            else if (m.group("IDENTIFIER") != null) {
                tokens.add(new Token(TokenType.IDENTIFIER, lexeme, line, col));
                col += lexeme.length();
            }
            else if (m.group("FLOATLIT") != null) {
                tokens.add(new Token(TokenType.FLOATLIT, lexeme, line, col));
                col += lexeme.length();
            }
            else if (m.group("HEXADECIMALLIT") != null) {
                tokens.add(new Token(TokenType.HEXADECIMALLIT, lexeme, line, col));
                col += lexeme.length();
            }
            else if (m.group("BINARYLIT") != null) {
                tokens.add(new Token(TokenType.BINARYLIT, lexeme, line, col));
                col += lexeme.length();
            }
            else if (m.group("OCTALLIT") != null) {
                tokens.add(new Token(TokenType.OCTALLIT, lexeme, line, col));
                col += lexeme.length();
            }
            else if (m.group("INTEGERLIT") != null) {
                tokens.add(new Token(TokenType.INTEGERLIT, lexeme, line, col));
                col += lexeme.length();
            }
            else if (m.group("STRINGLIT") != null) {
                tokens.add(new Token(TokenType.STRINGLIT, lexeme, line, col));
                col += lexeme.length();
            }
            else if (m.group("CHARLIT") != null) {
                tokens.add(new Token(TokenType.CHARLIT, lexeme, line, col));
                col += lexeme.length();
            }
            else if (m.group("OPERATOR") != null) {
                tokens.add(new Token(TokenType.OPERATOR, lexeme, line, col));
                col += lexeme.length();
            }
            else if (m.group("SEPARATOR") != null) {
                tokens.add(new Token(TokenType.SEPARATOR, lexeme, line, col));
                col += lexeme.length();
            }

            pos = m.end();
        }

        return tokens;
    }

    public static void main(String[] args) throws IOException {
        String source = Files.readString(Path.of("C:\\Users\\namis\\OneDrive\\Documentos\\NetBeansProjects\\analisislexico\\src\\analisislexico\\Ejemplo.java"));

        System.out.println("LINE  COL   TYPE            LEXEME");
        System.out.println("----------------------------------------");

        tokenize(source).forEach(System.out::println);
    }
}
