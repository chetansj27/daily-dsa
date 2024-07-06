package linkedlist;

import java.util.HashMap;
import java.util.Map;

class LFUCache {
    int capacity;
    int size;
    int minFrequency;
    Map<Integer, Node> cache;
    Map<Integer, DLL> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
        this.minFrequency = 0;
        this.frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        // if key not present in cache map return -1
        Node curr = cache.get(key);
        if (curr == null) {
            return -1;
        }
        // increase the frequency of cache by 1
        updateNode(curr);
        return curr.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        /* if key already exist in cache map update the value with
            latest value and increase the frequency by 1
         */
        if (cache.containsKey(key)) {
            Node curr = cache.get(key);
            curr.val = value;
            updateNode(curr);
        } else {
            size++;
            /*
                if size is greater than capacity then
                get the list with least frequency from frequencyMap
                remove it's tail.prev from cache map and list
             */
            if (size > capacity) {
                DLL minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.remove(minFreqList.tail.prev);
                size--;
            }
            /*
               set the min frequency to 1
               get the list from frequencyMap which have 1 frequency
               add the node in cache and frequency map
             */
            minFrequency = 1;
            Node newNode = new Node(key, value);
            DLL currList = frequencyMap.getOrDefault(1, new DLL());
            currList.add(newNode);
            frequencyMap.put(1, currList);
            cache.put(key, newNode);
        }
    }

    public void updateNode(Node currNode) {
        /*
            get list from frequencyMap with currNode frequency
            remove currNode from list
            increase freq of currNode
            get the list from frequencyMap which have currNode frequency
             add the node list and put in frequencyMap
         */
        int currFreq = currNode.frequency;
        DLL currList = frequencyMap.get(currFreq);
        currList.remove(currNode);

        if (currFreq == minFrequency && currList.listSize == 0) {
            minFrequency++;
        }
        currNode.frequency++;

        DLL newList = frequencyMap.getOrDefault(currNode.frequency, new DLL());
        newList.add(currNode);
        frequencyMap.put(currNode.frequency, newList);
    }
}

class Node {
    int key;
    int val;
    int frequency;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.frequency = 1;
    }
}

class DLL {
    int listSize;
    Node head;
    Node tail;

    public DLL() {
        this.listSize = 0;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void add(Node curr) {
        Node temp = head.next;
        curr.next = temp;
        curr.prev = head;
        head.next = curr;
        temp.prev = curr;
        listSize++;
    }

    public void remove(Node curr) {
        Node prevNode = curr.prev;
        Node nextNode = curr.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        listSize--;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
