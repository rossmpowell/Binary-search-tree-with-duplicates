package programmingAssignment3;

import java.util.LinkedList;

/**
* Represents one node in a Binary Tree where the data is type T. Used Christine Reilley's BTNodeString class in this classes
* design.
* @author rosspowell
*/
public class BTDNode<T> {

    /** The data in this node */
    private LinkedList<T> keyList;

    /** Reference to the left child node */
    private BTDNode<T> left;

    /** Reference to the right child node */
    private BTDNode<T> right;

    /** Reference to the parent of this node */
    private BTDNode<T> parent;

    
    public BTDNode() {
    	setKey(null);
        left = null;
        right = null;
        parent = null;
    }
    /**
    * Initialize the data and set the children nodes to null.
    *
    * @param d The data to put into this node
    */
    public BTDNode(T d) {
        setKey(d);
        left = null;
        right = null;
        parent = null;
    }

    /**
    * Accessor method for the data.
    *
    * @return The data contained by this node
    */
    public T getKey() {
        return getKeyList().getFirst();
    }

    
    public LinkedList<T> getKeyList() {
    	return keyList;
    }
    /**
    * Accessor method for the left child node.
    *
    * @return A reference to the left child node
    */
    public BTDNode<T> getLeft() {
        return left;
    }

    /**
    * Accessor method for the right child node.
    *
    * @return A reference to the right child node
    */
    public BTDNode<T> getRight() {
        return right;
    }

    /**
    * Accessor method for the parent node.
    *
    * @return A reference to the parent node
    */
    public BTDNode<T> getParent() {
        return parent;
    }
    /**
     * Mutator method for the LinkedList of data.
     * 
     * @param d The LinkedList to put into this node
     */
    public void setKeyList(LinkedList<T> d) {
    	if(keyList == null) {
    		keyList = new LinkedList<T>();
    		keyList = d;
    	} else {
    		keyList.clear();
    		keyList = d;
    	}
    }
    /**
    * Mutator method for the data.
    *
    * @param d The data to put into this node
    */
    public void setKey(T d) {
        if (keyList == null) {
        	keyList = new LinkedList<T>();
        	keyList.add(d);
        } else {
        	keyList.clear();
            keyList.add(d);
        }
    }

    /**
    * Mutator method for the left child node.
    *
    * @param l A reference to the node to set as the left child
    */
    public void setLeft(BTDNode<T> l) {
        left = l;
    }

    /**
    * Mutator method for the right child node.
    *
    * @param r A reference to the node to set as the right child
    */
    public void setRight(BTDNode<T> r) {
        right = r;
    }

    /**
    * Mutator method for the parent node.
    *
    * @param r A reference to the node to set as the parent of this node
    */
    public void setParent(BTDNode<T> p) {
        parent = p;
    }

}
