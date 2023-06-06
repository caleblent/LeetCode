package thePackage;

import java.util.ArrayList;

public class DesignHashMap {
	
	ArrayList<KeyValuePair> hashMapList;
	
	/**
	 *  initializes the object with an empty map
	 */
	public DesignHashMap() {
		hashMapList = new ArrayList<KeyValuePair>();
	}

	/**
	 *  inserts a (key, value) pair into the HashMap. 
	 *  If the key already exists in the map, update 
	 *  the corresponding value
	 *  
	 * @param key
	 * @param value
	 */
	public void put(int key, int value) {
		for (int i = 0; i < hashMapList.size(); i++) {
			if (hashMapList.get(i).key == key) {
				hashMapList.get(i).val = value;
				return;
			}
		}
		hashMapList.add(new KeyValuePair(key, value));
	}

	/**
	 * returns the value to which the specified key 
	 * is mapped, or -1 if this map contains no mapping 
	 * for the key
	 * 
	 * @param key
	 * @return integer
	 */
	public int get(int key) {
		for (int i = 0; i < hashMapList.size(); i++) {
			if (hashMapList.get(i).key == key) {
				return hashMapList.get(i).val;
			}
		}
		return -1;
	}

	/**
	 * removes the key and its corresponding value 
	 * if the map contains the mapping for the key
	 * 
	 * @param key
	 */
	public void remove(int key) {
		for (int i = 0; i < hashMapList.size(); i++) {
			if (hashMapList.get(i).key == key) {
				hashMapList.remove(i);
			}
		}
	}
	
	class KeyValuePair {
		int key;
		int val;
		public KeyValuePair(int key, int val) { 
			this.key = key; this.val = val; 
		}
	}
}
