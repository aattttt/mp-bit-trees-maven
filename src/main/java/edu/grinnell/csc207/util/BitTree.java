package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length 
 * sequences of bits and corresponding values.
 *
 * @author A.J. Trimble
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  BitTreeNode root = new BitTreeInteriorNode();

  int length;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   *
   */
  public BitTree(int n) {
    this.length = n;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   *
   */
  public void set(String bits, String value) {
    if (bits.length() != this.length ) {
      throw new IndexOutOfBoundsException("The given string is the wrong length");
    } // if
    for (int i = 0; i < bits.length(); i++) {
      if (bits.charAt(i) != '0' && bits.charAt(i) != '1') {
        throw new IndexOutOfBoundsException("The given string contains something other than a 0 or a 1");
      } // if
    } // for
    BitTreeInteriorNode start = this.root.getInterior();
    for (int i = 0; i < bits.length() - 1; i++) {
        BitTreeNode child = new BitTreeInteriorNode();
        if (start.get(bits.charAt(i)) == null) {
          start.set(child, bits.charAt(i));
        } // if
        start = start.get(bits.charAt(i)).getInterior();
    } // for
    BitTreeNode leaf = new BitTreeLeaf(value);
    start.set(leaf, bits.charAt(bits.length() - 1));
  } // set(String, String)

  /**
   *
   */
  public String get(String bits) {
    if (bits.length() != this.length ) {
      throw new IndexOutOfBoundsException("The given string is the wrong length");
    } // if
    for (int i = 0; i < bits.length(); i++) {
      if (bits.charAt(i) != '0' && bits.charAt(i) != '1') {
        throw new IndexOutOfBoundsException("The given string contains something other than a 0 or a 1");
      } // if  
    } // for

    BitTreeNode start = this.root;
    for (int i = 0; i < bits.length(); i++) {
        if (start == null) {
          throw new IndexOutOfBoundsException("The given path doesn't lead to a value");
        } // if
        start = start.getInterior().get(bits.charAt(i));
    } // for
    if (start == null) {
      throw new IndexOutOfBoundsException("The given path doesn't lead to a value2");
    } // if
    return start.getLeaf().getValue();
  } // get(String)

  /**
   *
   */
  public void dump(PrintWriter pen) {
    dump(pen, this.root, "");
  } // dump(PrintWriter)

  void dump(PrintWriter pen, BitTreeNode child, String code) {
    // base case
    BitTreeLeaf finish = child.getLeaf();
    if (finish != null) {
      pen.printf(code + "," + finish.getValue() + '\n');
    } else {
      // recursive case
      BitTreeInteriorNode interior = child.getInterior();
      if (interior.hasLeft()) {
        code = code + "0";
        dump(pen, interior.get('0'), code);
      } // if
      if (interior.hasRight()) {
        code = code + "1";
        dump(pen, interior.get('1'), code);
      } // if
    } // else
  } // dump(PrintWriter, BitTreeNode, String)

  /**
   *
   */
  public void load(InputStream source) throws IOException {
    InputStreamReader streamEyes = new InputStreamReader(source);
    BufferedReader eyes = new BufferedReader(streamEyes);
    String line = eyes.readLine();
    for (; line != null; line = eyes.readLine()) {
     String[] lineChunk = line.split(",");
     this.set(lineChunk[0], lineChunk[1]);
    } // for
  } // load(InputStream)
} // class BitTree
