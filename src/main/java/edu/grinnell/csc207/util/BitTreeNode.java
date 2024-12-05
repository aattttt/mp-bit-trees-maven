package edu.grinnell.csc207.util;

/*
 * This interface is implemented by both types of nodes.
 * @author A.J. Trimble
 */
public interface BitTreeNode {

    BitTreeInteriorNode getInterior();

    BitTreeLeaf getLeaf();

} // interface BitTreeNode
