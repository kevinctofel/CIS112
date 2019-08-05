//---------------------------------------------------------------------------
// ArrayListMap.java          by Dale/Joyce/Weems                   Chapter 8
//
// Implements a map using an ArrayList.
//
// A map provides (K = key, V = value) pairs, mapping the key onto the value.
// Keys are unique. Keys cannot be null.
//
// Methods throw IllegalArgumentException if passed a null key argument.
//
// Values can be null, so a null value returned by put, get, or remove does 
// not necessarily mean that an entry did not exist.
//---------------------------------------------------------------------------
// package ch08.maps;

import java.util.*;  // Iterator

public class BSTMap<K, V> implements MapInterface<K,V>
{
   protected BinarySearchTree<MapEntry<K, V>> map;

   public BSTMap() 
   {
      map = new BinarySearchTree<MapEntry<K, V>>();
   }

   public V put(K k, V v)
    // If an entry in this map with key k already exists then the value 
    // associated with that entry is replaced by value v and the original
    // value is returned; otherwise, adds the (k, v) pair to the map and
    // returns null.
   {
      if (k == null)
         throw new IllegalArgumentException("Maps do not allow null keys.");
      
      MapEntry<K, V> entry = new MapEntry<K,V>(k, v);
      MapEntry<K, V> temp = map.get(entry);
      
      if(temp == null)
      {
         map.add(entry);
         return null ;
      } 
      else 
      {
         V oldValue = temp.getValue();
         temp.setValue(v);
         return oldValue;
      }
   }

   public V get(K k)
    // If an entry in this map with a key k exists then the value associated 
    // with that entry is returned; otherwise null is returned.
   {
      if (k == null)
         throw new IllegalArgumentException("Maps do not allow null keys.");
         
      for (MapEntry<K,V> temp: map)
         if (temp.getKey().equals(k))
         return temp.getValue();
         return null;
   }  // end get

   public V remove(K k)
    // If an entry in this map with key k exists then the entry is removed
    // from the map and the value associated with that entry is returned;
    // otherwise null is returned.
   {
      if (k == null)
         throw new IllegalArgumentException("Maps do not allow null keys.");
             
      for (MapEntry<K,V> temp: map)
         if (temp.getKey().equals(k))
         {
            map.remove(temp);
            return temp.getValue();
         }
            return null;
    }
   

  

//     if (map.contains(entry))
//     {
//       remove(entry.key);
//       return temp.getValue();
//     }
//     else
//       return null;

    //  MapEntry<K,V> temp;
// 
//     Iterator<MapEntry<K,V>> search = map.iterator(); // Arraylist iterator
//     while (search.hasNext())
//     {
//       temp = search.next();
//       if (temp.getKey().equals(k))
//       {
//         search.remove();
//         return temp.getValue();    // k found, exits method
//       }
//     }
//     
//     //No entry is associated with k.
//     return null;
//   }

   public boolean contains(K k)
    // Returns true if an entry in this map with key k exists;
    // Returns false otherwise.
   {
      if (k == null)
         throw new IllegalArgumentException("Maps do not allow null keys.");
   
      for (MapEntry<K,V> temp: map)
         if (temp.getKey().equals(k))
            return true;     // k found, exits method
      
      // No entry is associated with k.
      return false;
   }
    
   public boolean isEmpty()
    // Returns true if this map is empty; otherwise, returns false.
   {
      return (map.size() == 0);   // uses ArrayList size
   }
   
   public boolean isFull()
    // Returns true if this map is full; otherwise, returns false.
   {
      return false;  // An ArrayListMap is never full
   }

   public int size()
    // Returns the number of entries in this map.
   {
      return map.size();   // uses ArrayList size
   }
   
   @Override
   public Iterator<MapEntry<K,V>> iterator()
    // Returns the Iterator provided by ArrayList.
   {
      return map.iterator();  // returns ArrayList iterator
   }
}