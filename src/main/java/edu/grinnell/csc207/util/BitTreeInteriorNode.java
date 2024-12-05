package edu.grinnell.csc207.util;

public class BitTreeInteriorNode implements BitTreeNode{
  /*
   * Fields
   */
  BitTreeNode left;

  BitTreeNode right;

  /*
   * Methods
   */



   public void set (BitTreeNode child, char position) {
    if (position == '0') {
      this.left = child;
    } else /*if (position == 1) */ {
      this.right = child;
    }
   }

   public BitTreeNode get (char position) {
    if (position == '0') {
      return this.left;
    } else /*if (position == 1)*/ {
      return this.right;
    } /*else {
      return null;
    }*/
   }

   public boolean hasLeft () {
    return (this.left != null);
   }

   public boolean hasRight () {
    return (this.right != null);
   }

  /*
   * Interface methods
   */
  @Override
  public BitTreeInteriorNode getInterior() {
    return this;
  }

  @Override
  public BitTreeLeaf getLeaf() {
    return null;
  }

}
