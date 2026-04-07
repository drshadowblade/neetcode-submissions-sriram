class LFUCache {
    class Node
    {
        int key,value,freq=1;
        Node next,prev;
        Node(int k,int v){key=k;value=v;}
    }
    class DLL
    {
        Node head=new Node(0,0);
        Node tail=new Node(0,0);
        int size=0;

        DLL()
        {
            head.next=tail;
            tail.prev=head;
        }

        public void add(Node n)
        {
            n.next=head.next;
            n.prev=head;
            head.next.prev=n;
            head.next=n;
            size++;
        }

        public void remove(Node n)
        {
            n.next.prev=n.prev;
            n.prev.next=n.next;
            size--;
        }

        public Node removeAtLast()
        {
            if(size==0) return null;
            Node n=tail.prev;
            remove(n);
            return n;
        }
    }
    int cap;
    int minfreq=0;
    HashMap<Integer,Node> map=new HashMap<>();
    HashMap<Integer,DLL> freqMap=new HashMap<>();
    public LFUCache(int capacity) {
        cap=capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node n=map.get(key);
        update(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        if(cap==0) return;

        if(map.containsKey(key))
        {
            Node n=map.get(key);
            n.value=value;
            update(n);
            return;
        }

        if(map.size()==cap)
        {
            Node lru=freqMap.get(minfreq).removeAtLast();
            map.remove(lru.key);
        }

        Node n=new Node(key,value);
        minfreq=1;

        map.put(key,n);
        freqMap.putIfAbsent(1,new DLL());
        freqMap.get(1).add(n);
    }

    public void update(Node n)
    {
        int f=n.freq;
        freqMap.get(f).remove(n);

        if(f==minfreq && freqMap.get(f).size==0)
            minfreq++;
        
        n.freq++;

        freqMap.putIfAbsent(n.freq,new DLL());
        freqMap.get(n.freq).add(n);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */