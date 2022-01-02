import java.util.Arrays;
import java.util.Objects;
/**
 * Java中哈希桶（拉链法）模拟
 * Write On 2021-12-29
 * 当一个格子挂的链表大于8时转化为红黑树，没有完成
 * Last edited on 2021-12-29
 * author is wangfuming
 */


public class HashBucket<K,V> {
    //hash内部需要节点，有key和value数据，以及一个指针
    static class Node<K,V> {
        public K key;
        public V val;
        public Node<K,V> next;
        Node(K key,V val){
            this.key=key;
            this.val=val;
        }
    }

    private Node<K,V>[] array;
    public int size;
    public HashBucket(){
        array=(Node<K,V>[]) new Node[10];
        size=0;
    }
    //存在就更换值，不存在就尾插入链表中
    public void put(K key,V val){
        int hashcode=key.hashCode();
        int index=hashcode% array.length;
        if(array[index]==null){
            array[index]=new Node<K,V>(key,val);
            size++;
            return;
        }
        Node<K,V> cur=array[index];
        Node<K,V> prev=cur;
        while(cur!=null){
            if(cur.key==key){
                cur.val=val;
                return;
            }
            prev=cur;
            cur=cur.next;
        }
        cur=new Node<K,V>(key,val);
        prev.next=cur;
        size++;
        if(loadFactor()>=0.75){
            resize();
        }
    }
    //判断是否需要扩容
    public double loadFactor(){
        return size*1.0/(array.length*2);
    }
    //二倍扩容，并改变原有节点，仍然是尾插
    private void resize(){
        Node<K,V>[] newArray=(Node<K,V>[])new Node[2*array.length];
        Node<K,V>[] last=(Node<K,V>[]) new Node[2*array.length];
        for(int i=0;i < array.length;i++){
            Node<K,V> cur=array[i];
            while(cur!=null){
                Node<K,V> curNext=cur.next;
                int hashcode=cur.key.hashCode();
                int index=hashcode% newArray.length;
                if(newArray[index]==null){
                    newArray[index]=cur;
                    last[index]=cur;
                }else{
                    last[index].next=cur;
                    last[index]=cur;
                }
                cur.next=null;
                cur=curNext;
            }
        }
        this.array=newArray;
    }
    public V get(K key){
        int hashcode=key.hashCode();
        int index=hashcode%array.length;
        Node<K,V> cur=array[index];
        while(cur!=null){
            if(cur.key.equals(key)){
                return cur.val;
            }
            cur=cur.next;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashBucket<?, ?> that = (HashBucket<?, ?>) o;
        return size == that.size && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}
