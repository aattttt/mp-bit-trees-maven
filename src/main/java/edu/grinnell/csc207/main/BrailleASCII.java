package edu.grinnell.csc207.main;

import java.io.IOException;
import java.io.PrintWriter;

import edu.grinnell.csc207.util.BrailleAsciiTables;

/**
 *
 */
public class BrailleASCII {
    // +------+--------------------------------------------------------
    // | Main |
    // +------+

    /**
     *
     */
    public static void main(String[] args) throws IOException {
        PrintWriter pen = new PrintWriter(System.out, true);
        if (args[0].equals("braille")) {
            brailleHandler(pen, args[1]);
        } else if (args[0].equals("ascii")) {
            // call braile
        } else if (args[0].equals("unicode")) {
            // call braile
        } else {
            pen.printf("Invalid character set");
        }
        // STUB
        pen.close();
    } // main(String[]

    public static void brailleHandler(PrintWriter pen, String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            String output = BrailleAsciiTables.toBraille(str.charAt(i));
            pen.printf(output);
        }
    } // brailleHandler(PrintWriter, String)

    public static void asciiHandler(PrintWriter pen, String str) throws IOException {
        if (str.length() % 6 != 0) {
            pen.println("Invalid input: must contain chunks 6 bits long");
            return;
        } else {
            for (int i = 0; i < (str.length() / 6); i++) {
                String chunk = str.substring(i, ((i + 1) * 6));
                String output = BrailleAsciiTables.toAscii(chunk);
                pen.printf(output);
            }
        }
    } // asciiHandler(PrintWriter, String)

    public static void unicodeHandler(PrintWriter pen, String str) throws IOException {
      for (int i = 0; i < str.length(); i++) {
          String chunk = BrailleAsciiTables.toBraille(str.charAt(i));
          String hexChunk = BrailleAsciiTables.toUnicode(chunk);
          int output = Integer.valueOf(hexChunk, 16);
          pen.print((char) output);
      }


  } // brailleHandler(PrintWriter, String)

} // class BrailleASCII
