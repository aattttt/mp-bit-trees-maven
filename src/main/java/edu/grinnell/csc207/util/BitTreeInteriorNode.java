package edu.grinnell.csc207.util;


/*
 * This class is used for the interior nodes. They hold no values, but can have children.
 * @author A.J. Trimble
 */
public class BitTreeInteriorNode implements BitTreeNode {

    /*
   * Fields
     */
    BitTreeNode left;

    BitTreeNode right;

    /*
   * Methods
     */
    public void set(BitTreeNode child, char position) {
        if (position == '0') {
            this.left = child;
        } else /*if (position == 1) */ {
            this.right = child;
        } // else
    } // set(BitTreeNode, char)

    public BitTreeNode get(char position) {
        if (position == '0') {
            return this.left;
        } else {
            return this.right;
        } // else
    } // get(char)

    public boolean hasLeft() {
        return (this.left != null);
    } // hasLeft()

    public boolean hasRight() {
        return (this.right != null);
    } // hasRight()

    /*
   * Interface methods
     */
    @Override
    public BitTreeInteriorNode getInterior() {
        return this;
    } // getInterior()

    @Override
    public BitTreeLeaf getLeaf() {
        return null;
    } // getLeaf()

} // class BitTreeInteriorNode
