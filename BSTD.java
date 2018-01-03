package programmingAssignment3;

/**
 * This class represents a Binary search tree that can take duplicate values of an object <T>
 * @author rosspowell
 */
public class BSTD<T extends Comparable<T>> {
    /** The root node of this tree */
    private BTDNode<T> root;

    /**
    * Constructor creates an empty tree
    */
    public BSTD() {
        root = null;
    }

    /**
    * Returns true if the tree is empty, false otherwise.
    *
    * @return true if the tree is empty, false otherwise
    */
    public boolean isEmpty() {
        return(root == null);
    }
    /**
     * Inserts the desired key into the tree
     * @param key The key we will be inserting
     */
    public void insert(T key) {
    	BTDNode<T> nodeToInsert = new BTDNode<T>(key);
    	BTDNode<T> searchNode = search(key);
    	if(isEmpty()) {
            // If tree is empty, set the root to be this new node
            root = nodeToInsert;
        } else if(searchNode != null) {
        	searchNode.getKeyList().add(key);
        } else {
        	insert(nodeToInsert, root);
        }
    }
    /**
    * Inserts the key into the tree. This is the recursive implementation.
    *
    * @param key The key to insert into the tree
    */
    private void insert(BTDNode<T> node, BTDNode<T> stRoot) {
         if(stRoot.getKey().compareTo(node.getKey()) > 0) {
             // search key belongs in the left subtree
             
        	 if(stRoot.getLeft() == null) {
        		 //inserting the node into the tree
        		 stRoot.setLeft(node);
        		 node.setParent(stRoot);
        	 } else {
        		// Recursively call this method.
        		insert(node, stRoot.getLeft());
        	 }
         } else if (stRoot.getKey().compareTo(node.getKey()) < 0){
        	 // search key belongs in the right subtree
        	 
        	 if(stRoot.getRight() == null) {
        		 //inserting the node into the tree
        		 stRoot.setRight(node);
        		 node.setParent(stRoot);
        	 } else {
        		// Recursively call this method.
        		insert(node, stRoot.getRight());
        	 }
         } else if (stRoot.getKey().compareTo(node.getKey()) == 0) {
        	 //Dont insert any node if the value already exists
        	 stRoot.getKeyList().add(node.getKey());
         } else {
        	 
         }
            
        
  }
        
     // end of insert method

    /**
    * Search the tree for the given key.
    *
    * @param key The value to search for
    * @return The node where the key is found, or null if the key is not found
    */
    public BTDNode<T> search(T key) {
        // Begin the search at the root
        return search(key, root);
    }

    /**
    * Search a subtree for the given key. Uses recursion.
    *
    * @param key The value to search for
    * @param stRoot The root node of the subtree to search
    * @return The node where the key is found, or null if the key is not found
    */
    private BTDNode<T> search(T key, BTDNode<T> stRoot) {
        if(stRoot == null) {
            // The key was not found in this subtree, return null
            return null;
        }
        else {
            // Keep searching for the key
            if(stRoot.getKey().equals(key)) {
                // This subtree root node's key matches the search key
                // Return this subtree root node
                return stRoot;
            } else {
                // Decide whether to look left or right
                if(stRoot.getKey().compareTo(key) > 0) {
                    // search key belongs in the left subtree
                    // Recursively call this method.
                    BTDNode<T> result = search(key, stRoot.getLeft());
                    return result;
                } else {
                    // search key belongs in the right subtree
                    // Recursively call this method.
                    BTDNode<T> result = search(key, stRoot.getRight());
                    return result;
                }
            }
        }
    } // end of search method

    /**
     * Search the tree for the given key.
     *
     * @param key The value to search for
     * @return The node where the key is found, or the next lowest value if the key is not found
     */
     public BTDNode<T> search2(T key) {
         // Begin the search at the root
         return search2(key, root.getLeft(), root);
     }

     /**
     * Search a subtree for the given key. Uses recursion.
     *
     * @param key The value to search for
     * @param stRoot The root node of the subtree to search
     * @return The node where the key is found, or null if the key is not found
     */
     private BTDNode<T> search2(T key, BTDNode<T> stRoot, BTDNode<T> prevNode) {
         if(stRoot == null) {
             // The key was not found in this subtree, return null
             return prevNode;
         }
         else {
             // Keep searching for the key
             if(stRoot.getKey().equals(key)) {
                 // This subtree root node's key matches the search key
                 // Return this subtree root node
                 return stRoot;
             } else {
                 // Decide whether to look left or right
                 if(stRoot.getKey().compareTo(key) > 0) {
                     // search key belongs in the left subtree
                     // Recursively call this method.
                	 prevNode = stRoot;
                     BTDNode<T> result = search2(key, stRoot.getLeft(), prevNode);
                     return result;
                 } else {
                     // search key belongs in the right subtree
                     // Recursively call this method.
                	 prevNode = stRoot;
                     BTDNode<T> result = search2(key, stRoot.getRight(), prevNode);
                     return result;
                 }
             }
         }
     } // end of search method

    /**
    * Print the keys using the in-order algorithm.
    */
    public void inOrderPrint() {
    	
        // Call the recursive inOrderPrint method
        inOrderPrint(root);
    }

    /**
    * Recursive method for the in-order print.
    *
    * @param stRoot The root of the sub-tree to print
    */
    private void inOrderPrint(BTDNode<T> stRoot) {
        if(stRoot != null) {
        	
            // Recursively call method to print the left sub-tree
            inOrderPrint(stRoot.getLeft());
      
            // Print the sub-tree root, and all of its duplicates
            for(int i = 0; i < stRoot.getKeyList().size(); i++) {
            	System.out.println(stRoot.getKey());
            }
            
            // Recursively call method to print the right sub-tree
            inOrderPrint(stRoot.getRight());
        }

        // Base case is stRoot == null; method will return.
    } // end inOrderPrint method
    
    /**
     * Print the keys using the in-order algorithm.
     */
     public void inOrderPrint2() {
     	
         // Call the recursive inOrderPrint method
         inOrderPrint(root);
     }

     /**
     * Recursive method for the in-order print.
     *
     * @param stRoot The root of the sub-tree to print
     */
     private void inOrderPrint2(BTDNode<T> stRoot, T high) {
    	 
         if((stRoot != null)) {
         	
             // Recursively call method to print the left sub-tree
             inOrderPrint(stRoot.getLeft());
       
             // Print the sub-tree root and all of its duplicates if it's less than the high value
             if (stRoot.getKey().compareTo(high) <= 0) {
            	 for(int i = 0; i < stRoot.getKeyList().size(); i++) {
            		 System.out.println(stRoot.getKey());
            	 }
             //return the method if the current node is greater than the high node
             } else {
            	 return;
             }
             // Recursively call method to print the right sub-tree
             inOrderPrint(stRoot.getRight());
         }

         // Base case is stRoot == null; method will return.
     } // end inOrderPrint method
    /**
     * Method prints all of the values of T between the two parameter values, calls the private method
     * @param low The maximum parameter value
     * @param high The minimum parameter value
     */
    public void printInRange(T low, T high) {
    	BTDNode<T> lowestNode = search2(low);
    	printInRange(lowestNode, high);
    }
  
    
    /**
     * This method prints out all values within a certain key type T to another key type T within the tree
     * @param node	The node that we are recursing through in order to find the specified types of data
     * @param high The upper bound of data type T
     */
    private void printInRange(BTDNode<T> node,  T high) {
    	//If the lowest value is to the left of the root node 
    	if (root.getKey().compareTo(high) <= 0) {
    		//print out starting node
    		for (int i = 0; i < node.getKeyList().size(); i++ ) {
    			System.out.println(node.getKey());
    		}
    		//call different inOrderPrint method to stop when the current node is equal to the high value
    		if (node.getRight() != null) {
    			node = node.getRight();
    			inOrderPrint2(node, high);	
    		
    		} 
    	
    		//go back to the root node
    		while(node != root) {
    			node = node.getParent();
    		}
    		//print the root node and its duplicates
    		for (int i = 0; i < node.getKeyList().size(); i++ ) {
    			System.out.println(node.getKey());
    		}
    		//recurse through right subtree
    		if (node.getRight() != null) {
    			node = node.getRight();
    			//call different inOrderPrint method to stop when the current node is equal to the high value
    			inOrderPrint2(node, high);	
    		
    		}
    	//low is to the right of root
    	} else {
    		//print out the root node and its duplicates
    		for (int i = 0; i < node.getKeyList().size(); i++ ) {
    			System.out.println(node.getKey());
    		}
    		//recurse through right subtree
    		if (node.getRight() != null) {
    			node = node.getRight();
    			//call different inOrderPrint method to stop when the current node is equal to the high value
    			inOrderPrint2(node, high);	
    		
    		}
    	}
    } 
    
    
    
    
    /**
    * Deletes a node from the BST.
    *
    * @param key The key of the node to delete
    * @return true if the node is successfully deleted; false if the key is not found in the tree
    */
    public boolean delete(T key) {
        if(isEmpty()) {
            // Tree is empty, there is nothing to delete
            return false;
        }
        BTDNode<T> foundNode = search(key);
        // Use the search method to get the node
        if(foundNode == null) {
            // No node in the tree has the given key value
            return false;
        }
        
        //If the keyList of the desired item is greater than one, take one of the duplicates away from the keyList.
        if(foundNode.getKeyList().size() > 1) {
        	this.search(key).getKeyList().remove(1);
        	return true;
        }

        // Delete the node
        if(foundNode == root && foundNode.getLeft() == null && foundNode.getRight() == null) {
            // Node is the root and is the only node in the tree. Removing this node results in an empty tree.
            root = null;
        } else {
            if(foundNode == root) {
                // Node is the root and has at least one child
                if(foundNode.getLeft() != null) {
                    // foundNode has a left sub-tree. Implement delete by moving
                    // the data from the right-most node in the left sub-tree to
                    // foundNode, then removing the right-most node in the left
                    // sub-tree from the tree

                    // Get the right-most node in the left sub-tree
                    BTDNode<T> rightMostInLeft = getRightMostInLeftST(foundNode);

                    // Replace the foundNode (the one we're deleting) data with
                    // the data from rightMostInLeft
                    foundNode.setKeyList(rightMostInLeft.getKeyList());

                    if(rightMostInLeft.getParent().getLeft() == rightMostInLeft) {
                        rightMostInLeft.getParent().setLeft(rightMostInLeft.getLeft());
                        if(rightMostInLeft.getLeft() != null) {
                            rightMostInLeft.getLeft().setParent(rightMostInLeft.getParent());
                        }
                    } else {
                        // Remove the right-most node in the left sub-tree
                        rightMostInLeft.getParent().setRight(rightMostInLeft.getLeft());
                        if(rightMostInLeft.getLeft() != null) {
                            rightMostInLeft.getLeft().setParent(rightMostInLeft.getParent());
                        }
                    }
                }
                else {
                    // found node does not have a left sub-tree. Set the root
                    // of the right sub-tree to be the new tree root.
                    root = foundNode.getRight();
                    root.setParent(null);
                }

            } else {
                // Node is not the root
                if(foundNode.getLeft() == null && foundNode.getRight() == null) {
                    // Node is a leaf. Delete by setting parent's reference to this
                    // node to null.

                    if(foundNode.getParent().getLeft() == foundNode) {
                        // foundNode is the left child
                        foundNode.getParent().setLeft(null);
                    } else {
                        // foundNode is the right child
                        foundNode.getParent().setRight(null);
                    }
                } else {
                    // foundNode is somewhere in the middle of the tree
                    if(foundNode.getLeft() != null) {
                        // foundNode has a left sub-tree. Implement delete by moving
                        // the data from the right-most node in the left sub-tree to
                        // foundNode, then removing the right-most node in the left
                        // sub-tree from the tree

                        // Get the right-most node in the left sub-tree
                        BTDNode<T> rightMostInLeft = getRightMostInLeftST(foundNode);

                        // Replace the foundNode (the one we're deleting) data with
                        // the data from rightMostInLeft
                        foundNode.setKeyList(rightMostInLeft.getKeyList());

                        if(rightMostInLeft.getParent().getLeft() == rightMostInLeft) {
                            rightMostInLeft.getParent().setLeft(rightMostInLeft.getLeft());
                            if(rightMostInLeft.getLeft() != null) {
                                rightMostInLeft.getLeft().setParent(rightMostInLeft.getParent());
                            }
                        } else {
                            // Remove the right-most node in the left sub-tree
                            rightMostInLeft.getParent().setRight(rightMostInLeft.getLeft());
                            if(rightMostInLeft.getLeft() != null) {
                                rightMostInLeft.getLeft().setParent(rightMostInLeft.getParent());
                            }
                        }
                    } else {
                        // found node does not have a left sub-tree. Set parent
                        // to refer to found node's right child
                        if(foundNode.getParent().getLeft() == foundNode) {
                            // foundNode is its parent's left child
                            foundNode.getParent().setLeft(foundNode.getRight());
                        } else {
                            // foundNode is its parent's right child
                            foundNode.getParent().setRight(foundNode.getRight());
                        }
                    }
                    // If node had a right child, set that child's parent to
                    // be foundNode's parent.
                    if(foundNode.getRight() != null) {
                        foundNode.getRight().setParent(foundNode.getParent());
                    }
                }
            }
        }

        // Node was found and deleted
        return true;
    } // end of delete method

    /**
    * Returns the right-most node in the left sub-tree. Used as part of the delete method.
    *
    * @param n The root node of the sub-tree
    * @return The right-most node in the left sub-tree of n
    */
    private BTDNode<T> getRightMostInLeftST(BTDNode<T> n) {
        if(n.getLeft() == null) {
            // There is no left sub-tree
            return null;
        }
        BTDNode<T> temp = n.getLeft(); // root of the left sub-tree of n

        while(temp.getRight() != null) {
            // set temp to the right child
            temp = temp.getRight();
        }

        // temp is the right-most node of the left sub-tree
        return temp;
    } // end getRightMostInLeftST method
   
    /**
    * Returns the height of the tree (number of edges from root to the deepest
    * leaf).
    * @return the max height of a tree's leaf from the root
    */
    public int height() {
    	//if no nodes, return 0 nodes
    	if (isEmpty()) {
    		return 0;
    	//if the only node is the head node, return 1
    	} else if (root.getLeft() == null && root.getRight() == null) {
    		return 1;
    	}
    	//else add one to the total (for the root) and count up the rest of the subtree
        return 1 + height(root); 

    }
    /**
     * 
     * @param node the node we are currently finding the height of
     * @return the max of the right and left comparisons + 1 for every increase in the stack
     */
    private int height(BTDNode<T> node) {
    	if (node == null) {
    		return -1;
    	}
    	return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    	
    }
    /**
     * Searches for the lowest value in the tree
     * @return lowest value for type T in the Tree
     */
    public T getMinimumKey() {
    	return getMinimumKey(root).getKey();
    }
    /**
     * Recursively go through the left side of the tree and return the lowest value
     * @param node the node we will be recursively searching the left side of
     * @return the lowest value key
     */
    private BTDNode<T> getMinimumKey(BTDNode<T> node) {
    	if (node.getLeft() != null) {
    		node = getMinimumKey(node.getLeft());
    	} 
    	return node;
    }
    /**
     * Searches for the lowest value in the tree
     * @return highest value for type T in the Tree
     */
    public T getMaximumKey() {
    	return getMaximumKey(root).getKey();
    }
    /**
     * Recursively go through the right side of the tree and return the highest value
     * @param node the node we will be recursively searching the right side of
     * @return the lowest value key
     */
    public BTDNode<T> getMaximumKey(BTDNode<T> node) {
    	if (node.getRight() != null) {
    		node = getMaximumKey(node.getRight());
    	} 
    	return node;
    }
    
    
}

