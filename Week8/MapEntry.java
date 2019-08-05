//---------------------------------------------------------------------------
// MapEntry.java              by Dale/Joyce/Weems                   Chapter 8
//
// Provides key, value pairs for use with a Map.
// Keys are immutable.
//---------------------------------------------------------------------------
// package ch08.maps;
import java.util.*;

public class MapEntry<K, V> implements Comparable<MapEntry<K, V>>
{
  public K key;
  public V value;
  
  MapEntry(K k, V v)
  {
    key = k; value = v;
  }
  
  public K getKey()  {return key;}
  public V getValue(){return value;}
  public void setValue(V v){value = v;}

  @Override
  public String toString()
  // Returns a string representing this MapEntry.
  {
    return "Key  : " + key + "\nValue: " + value;
  } // end toString()
  
  public int compareTo(MapEntry<K, V> other)
  {
    Comparable c = (Comparable) (key);
    return c.compareTo(other.getKey());
  
  } // end compareTo
} // end MapEntry
 