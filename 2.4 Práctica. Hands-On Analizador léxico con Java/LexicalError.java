/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analisislexico;

/**
 *
 * @author namis
 */
public class LexicalError extends RuntimeException{
    private final int line, column;
    private final char illegal;

    public LexicalError(char c, int line, int col) {
        super(String.format(
            "Error léxico [línea %d, col %d]: carácter ilegal '%c' (U+%04X)",
            line, col, c, (int) c
        ));
        this.line = line; this.column = col; this.illegal = c;
    }
}





