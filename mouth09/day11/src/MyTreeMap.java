import java.util.*;

public class MyTreeMap<K, V> {
    public static class Entry<K, V> {
        private K key;
        private V value;

        Entry<K, V> left;
        Entry<K, V> right;

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Entry<K, V> root;
    //比较器
    private Comparator<K> comparator = null;

    public MyTreeMap() {
    }

    public MyTreeMap(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    public V put(K key, V value) {
        //判断在插入之前 TreeMap 是不是空树
        if (root == null) {
            root = new Entry<>();
            root.key = key;
            root.value = value;
            return null;
        }

        Entry<K, V> parent = null;
        Entry<K, V> cur = root;
        //用来记录需要插入结点的 key 和 this 结点的 key 值通过比较后的结果
        //-1 -> 要插入节点的key小于this结点的key
        //0 -> 要插入节点的key等于this结点的key
        //1 -> 要插入节点的key大于this结点的key
        int tmp2 = 0;


        while (cur != null) {
            //选择用传入的外部比较器或者插入的类型实现的内部比较器去比较两者key的大小
            if (comparator != null) {
                tmp2 = comparator.compare(key, cur.key);
            } else {
                Comparable<K> kComparable = (Comparable<K>) key;
                tmp2 = kComparable.compareTo(cur.key);
            }

            if (tmp2 == 0) {
                cur.value = value;
            } else if (tmp2 < 0) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }

        //当插入的结点为一个之前没有的结点时会走到这步
        Entry<K, V> entry = new Entry<>();
        entry.key = key;
        entry.value = value;

       /* int tmp;
        if(comparator != null) {
            tmp = comparator.compare(key, parent.key);
        } else {
            Comparable<K> kComparable = (Comparable<K>)key;
            tmp = kComparable.compareTo(parent.key);
        }*/

        if (tmp2 == 0) {
            return null;
        } else if (tmp2 < 0) {
            parent.left = entry;
        } else {
            parent.right = entry;
        }
        return null;
    }

    public V get(K key) {
        Entry<K, V> cur = root;
        while (cur != null) {
            int tmp;
            if (comparator != null) {
                tmp = comparator.compare(key, cur.key);
            } else {
                Comparable<K> kComparable = (Comparable<K>) key;
                tmp = kComparable.compareTo(cur.key);
            }

            if (tmp == 0) {
                return cur.value;
            } else if (tmp < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return null;
    }

    public V getOrDefault(K key, V value) {
        Entry<K, V> cur = root;
        while (cur != null) {
            int tmp ;
            if (comparator != null) {
                tmp = comparator.compare(key, cur.key);
            } else {
                Comparable<K> kComparable = (Comparable<K>) key;
                tmp = kComparable.compareTo(cur.key);
            }

            if (tmp == 0) {
                return cur.value;
            } else if (tmp < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return value;
    }

    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        //如果TreeMap为空的话直接返回空的Set
        if (root == null) {
            return set;
        }
        //利用队列按照层序遍历TreeMap中的每一个结点，将每个结点的 K 值添加入创建好的 set 中
        Queue<Entry> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<K, V> front = queue.remove();
            set.add(front.key);
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
        return set;
    }

    public V remove(K key) {
        Entry<K, V> parent = null;
        Entry<K, V> cur = root;
        int tmp ;
        while(cur != null) {
            if (comparator != null) {
                tmp = comparator.compare(key, cur.key);
            } else {
                Comparable<K> kComparable = (Comparable<K>) key;
                tmp = kComparable.compareTo(cur.key);
            }
            if(tmp == 0) {
                V oldValue = cur.value;
                deleteNode(parent, cur);
                return oldValue;
            } else if(tmp < 0) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        return null;
    }

    private void deleteNode(Entry<K,V> parent, Entry<K,V> cur) {
        if(cur.left == null) {
            if(parent == root) {
                root = cur.right;
            } else if(parent.left == cur) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if(cur.right == null) {
            if(parent == null) {
                root = cur.left;
            } else if(parent.left == cur) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            //当要删除的结点左右子树时，找到左子树中的K值最大或者右子树中的K值最小
            //以下找了左子树中K值最大的结点，将该节点的key和value赋予cur
            //然后再将左子树中key值最大的节点删除
            Entry<K, V> goat = cur.left;
            Entry<K, V> goatParent = cur;
            while(goat.right != null) {
                goatParent = goat;
                goat = goat.right;
            }

            cur.key = goat.key;
            cur.value = goat.value;

            //当goat没有右子节点时说明该值是cur结点左子树中K值最大的结点。
            //得判断goat是否具有左节点，如果有左节点必须得让goatParent指向goat的左节点
            //如果goat没有左节点时代表这个结点时叶子结点直接让goatParen指向goat的右节点即null
            if(goat == goatParent.left) {
                goatParent.left = goat.left;
            } else {
                goatParent.right = goat.left;
            }
        }
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        if(root == null) {
            return set;
        }

        Queue<Entry<K, V>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Entry<K, V> front = queue.remove();
            Entry<K, V> entry = new Entry<>();
            entry.key = front.key;
            entry.value = front.value;
            set.add(entry);
            if(front.left != null) {
                queue.add(front.left);
            }
            if(front.right != null) {
                queue.add(front.right);
            }
        }
        return set;
    }

    public boolean containsKey(K key) {
        Set<Entry<K, V>> set = this.entrySet();
        for(Entry e : set) {
            if((e.key).equals(key))
                return true;
        }
        return false;
    }
    public boolean containsValue(V value) {
        Set<Entry<K, V>> set = this.entrySet();
        for(Entry e : set) {
            if((e.value).equals(value))
                return true;
        }
        return false;
    }
}