package edu.grinnell.csc207.util;

/*
 * This class is used for the leaf nodes. They hold hold a value and have no children.
 * @author A.J. Trimble
 */
public class BitTreeLeaf implements BitTreeNode {

    /*
   * Fields
     */
    String value;

    /*
   * Methods
     */
    public BitTreeLeaf(String value) {
        this.value = value;
    } // BitTreeLeaf(String)

    public String getValue() {
        return this.value;
    } // getValue()


    /*
   * Interface methods
     */
    @Override
    public BitTreeInteriorNode getInterior() {
        return null;
    } // getInterior()

    @Override
    public BitTreeLeaf getLeaf() {
        return this;
    } // getLeaf()
} // class BitTreeLeaf
