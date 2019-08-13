//---------------------------------------------------------------------------
// BinarySearchTree.java          by Dale/Joyce/Weems               Chapter 7
//
// Defines all constructs for a reference-based BST.
// Supports three traversal orders Preorder, Postorder & Inorder ("natural")
//---------------------------------------------------------------------------

// package ch07.trees;

import java.util.*;   // Iterator, Comparator

import ch04.queues.*;
import ch02.stacks.*;
     

public class BinarySearchTree<T> implements BSTInterface<T>
{
   protected Node<T> root;      // reference to the root of this BST
   protected Comparator<T> comp;   // used for all comparisons

   protected boolean found;   // used by remove

   public BinarySearchTree(Node T) 
    // Precondition: T implements Comparable
    // Creates an empty BST object - uses the natural order of elements.
   {
      
      root = T;
      comp = new Comparator<T>()
         {
            public int compare(T element1, T element2)
            {
               return ((Comparable)element1).compareTo(element2);
            }
         };
   }

   public BinarySearchTree(Comparator<T> comp) 
    // Creates an empty BST object - uses Comparator comp for order
    // of elements.
   {
      root = null;
      this.comp = comp;
   }

   public boolean isFull()
    // Returns false; this link-based BST is never full.
   {
      return false;
   }

   public boolean isEmpty()
    // Returns true if this BST is empty; otherwise, returns false.
   {
      return (root == null);
   }

   public T min()
    // If this BST is empty, returns null;
    // otherwise returns the smallest element of the tree.
   {
      if (isEmpty())
         return null;
      else
      {
         Node<T> node = root;
         while (node.getLeft() != null)
            node = node.getLeft();
         return node.getInfo();
      }
   }

   public T max()
    // If this BST is empty, returns null;
    // otherwise returns the largest element of the tree.
   {
      if (isEmpty())
         return null;
      else
      {
         Node<T> node = root;
         while (node.getRight() != null)
            node = node.getRight();
         return node.getInfo();
      }
   }

   private int recSize(Node<T> node)
    // Returns the number of elements in subtree rooted at node.
   {
      if (node == null)    
         return 0;
      else
         return 1 + recSize(node.getLeft()) + recSize(node.getRight());
   }

   public int size()
    // Returns the number of elements in this BST.
   {
      return recSize(root);
   }

   public int size2()
    // Returns the number of elements in this BST.
   {
      int count = 0;
      if (root != null)
      {
         LinkedStack<Node<T>> nodeStack = new LinkedStack<Node<T>>();
         Node<T> currNode;
         nodeStack.push(root);
         while (!nodeStack.isEmpty())
         {
            currNode = nodeStack.top();
            nodeStack.pop();
            count++;
            if (currNode.getLeft() != null)
               nodeStack.push(currNode.getLeft());
            if (currNode.getRight() != null)
               nodeStack.push(currNode.getRight());
         }
      }
      return count;
   }

   private boolean recContains(T target, Node<T> node)
    // Returns true if the subtree rooted at node contains info i such that 
    // comp.compare(target, i) == 0; otherwise, returns false.
   {
      if (node == null)
         return false;       // target is not found
      else if (comp.compare(target, node.getInfo()) < 0)
         return recContains(target, node.getLeft());   // Search left subtree
      else if (comp.compare(target, node.getInfo()) > 0)
         return recContains(target, node.getRight());  // Search right subtree
      else
         return true;        // target is found
   }

   public boolean contains (T target)
    // Returns true if this BST contains a node with info i such that 
    // comp.compare(target, i) == 0; otherwise, returns false.
   {
      return recContains(target, root);
   }

   
   private T recGet(T target, Node<T> node)
    // Returns info i from the subtree rooted at node such that 
    // comp.compare(target, i) == 0; if no such info exists, returns null.
   {
      if (node == null)
         return null;             // target is not found
      else if (comp.compare(target, node.getInfo()) < 0)
         return recGet(target, node.getLeft());         // get from left subtree
      else
         if (comp.compare(target, node.getInfo()) > 0)
            return recGet(target, node.getRight());        // get from right subtree
         else
            return node.getInfo();  // target is found
   }

   public T get(T target)
    // Returns info i from node of this BST where comp.compare(target, i) == 0;
    // if no such node exists, returns null.
   {
      return recGet(target, root);
   }

   private Node<T> recAdd(T element, Node<T> node)
    // Adds element to tree rooted at node; tree retains its BST property.
   {
      if (node == null)
         // Addition place found
         node = new Node<T>(element);
      else if (comp.compare(element, node.getInfo()) <= 0)
         node.setLeft(recAdd(element, node.getLeft()));    // Add in left subtree
      else
         node.setRight(recAdd(element, node.getRight()));   // Add in right subtree
      return node;
   }

   public boolean add (T element)
    // Adds element to this BST. The tree retains its BST property.
   {
      root = recAdd(element, root);
      return true;
   }


//    public boolean add (T element)
//    // Adds element to this BST. The tree retains its BST property.
//    {
//      Node<T> newNode = new Node<T>(element);
//      Node<T> prev = null, curr = null;
//      
//      if (root == null)
//        root = newNode;
//      else
//      {
//        curr = root;
//        while (curr != null)
//        {
//          if (comp.compare(element, curr.getInfo()) <= 0)
//          {
//            prev = curr;
//            curr = curr.getLeft();
//          }
//          else
//          {
//            prev = curr;
//            curr = curr.getRight();
//          }
//        }
//        if (comp.compare(element, prev.getInfo()) <= 0)
//          prev.setLeft(newNode);
//        else
//          prev.setLeft(newNode);
//      }
//      return true;
//    }


   private T getPredecessor(Node<T> subtree)
    // Returns the information held in the rightmost node of subtree
   {
      Node<T> temp = subtree;
      while (temp.getRight() != null)
         temp = temp.getRight();
      return temp.getInfo();
   }

   private Node<T> removeNode(Node<T> node)
    // Removes the information at node from the tree. 
   {
      T data;
      if (node.getLeft() == null)
         return node.getRight();
      else if (node.getRight() == null) 
         return node.getLeft();
      else
      {
         data = getPredecessor(node.getLeft());
         node.setInfo(data);
         node.setLeft(recRemove(data, node.getLeft()));  
         return node;
      }
   }

   private Node<T> recRemove(T target, Node<T> node)
    // Removes element with info i from tree rooted at node such that
    // comp.compare(target, i) == 0 and returns true; 
    // if no such node exists, returns false. 
   {
      if (node == null)
         found = false;
      else if (comp.compare(target, node.getInfo()) < 0)
         node.setLeft(recRemove(target, node.getLeft()));
      else if (comp.compare(target, node.getInfo()) > 0)
         node.setRight(recRemove(target, node.getRight()));
      else  
      {
         node = removeNode(node);
         found = true;
      }
      return node;
   }

   public boolean remove (T target)
    // Removes a node with info i from tree such that comp.compare(target,i) == 0
    // and returns true; if no such node exists, returns false.
   {
      root = recRemove(target, root);
      return found;
   }

   public Iterator<T> getIterator(BSTInterface.Traversal orderType)
    // Creates and returns an Iterator providing a traversal of a "snapshot" 
    // of the current tree in the order indicated by the argument.
    // Supports Preorder, Postorder, and Inorder traversal.
   {
      final LinkedQueue<T> infoQueue = new LinkedQueue<T>();
      if (orderType == BSTInterface.Traversal.Preorder)
         preOrder(root, infoQueue);
      else
         if (orderType == BSTInterface.Traversal.Inorder)
            inOrder(root, infoQueue);
         else
            if (orderType == BSTInterface.Traversal.Postorder)
               postOrder(root, infoQueue);
   
      return 
         new Iterator<T>()
         {
            public boolean hasNext()
            // Returns true if the iteration has more elements; otherwise returns false.
            {
               return !infoQueue.isEmpty();
            }
          
            public T next()
            // Returns the next element in the iteration.
            // Throws NoSuchElementException - if the iteration has no more elements
            { 
               if (!hasNext())
                  throw new IndexOutOfBoundsException("illegal invocation of next " + 
                                            " in BinarySearchTree iterator.\n");
               return infoQueue.dequeue();
            }
         
            public void remove()
            // Throws UnsupportedOperationException.
            // Not supported. Removal from snapshot iteration is meaningless.
            {
               throw new UnsupportedOperationException("Unsupported remove attempted on " 
                                                    + "BinarySearchTree iterator.\n");
            }
         };
   }

   private void preOrder(Node<T> node, LinkedQueue<T> q)
    // Enqueues the elements from the subtree rooted at node into q in preOrder.
   {
      if (node != null)
      {
         q.enqueue(node.getInfo());
         preOrder(node.getLeft(), q);
         preOrder(node.getRight(), q);
      }
   }

   private void inOrder(Node<T> node, LinkedQueue<T> q)
    // Enqueues the elements from the subtree rooted at node into q in inOrder.  
   {
      if (node != null)
      {
         inOrder(node.getLeft(), q);
         q.enqueue(node.getInfo());
         inOrder(node.getRight(), q);
      }
   }

   private void postOrder(Node<T> node, LinkedQueue<T> q)
    // Enqueues the elements from the subtree rooted at node into q in postOrder.  
   {
      if (node != null)
      {
         postOrder(node.getLeft(), q);
         postOrder(node.getRight(), q);
         q.enqueue(node.getInfo());
      }
   }
   
   public Iterator<T> iterator()
    // InOrder is the default, "natural" order.
   {
      return getIterator(BSTInterface.Traversal.Inorder);
   }
   
   public boolean isMirror(Node node1, Node node2)  
    { 
        // if both trees are empty, then they are mirror image 
        if (node1 == null && node2 == null) 
            return true; 
   
        // For two trees to be mirror images, the following three 
        // conditions must be true 
        // 1 - Their root node's key must be same 
        // 2 - left subtree of left tree and right subtree 
        //      of right tree have to be mirror images 
        // 3 - right subtree of left tree and left subtree 
        //      of right tree have to be mirror images 
        if (node1 != null && node2 != null && comp.compare((T)node1.info,(T)node2.info) == 0)
            return (isMirror(node1.left, node2.right) 
                    && isMirror(node1.right, node2.left)); 
        else
   
        // if neither of the above conditions is true then 
        // root1 and root2 are mirror images 
        return false; 
    } 
}