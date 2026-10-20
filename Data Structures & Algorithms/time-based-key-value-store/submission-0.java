class TimeMap {
    
    HashMap<String, ArrayList<Pair<Integer,String>>> hm;

    public TimeMap() {
        hm  = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        ArrayList<Pair<Integer,String>> al = hm.getOrDefault(key, new ArrayList<Pair<Integer,String>>());
        al.add(new Pair<>(timestamp,value));
        hm.put(key,al);
    }
    
    public String get(String key, int timestamp) {
        

        ArrayList<Pair<Integer,String>> al = hm.get(key);
        if (al == null) {
            return "";
        }

        int low = 0;
        int high = al.size() - 1;
        String res = "";

        while (low <= high) {
            int m  = low + (high - low)/2;
            if (al.get(m).getKey() <= timestamp) {
                res = al.get(m).getValue();
                low = m + 1;        
            } else {
                high = m - 1;
            }
        }
        return res;

    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
