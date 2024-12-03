package edu.grinnell.csc207.util;

public class BitTreeLeaf implements BitTreeNode{
  /*
   * Fields
   */
  String value;

  /*
   * Methods
   */
  public BitTreeLeaf(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }


  /*
   * Interface methods
   */
  @Override
  public BitTreeInteriorNode getInterior() {
    return null;
  }

  @Override
  public BitTreeLeaf getLeaf() {
    return this;
  }
}
