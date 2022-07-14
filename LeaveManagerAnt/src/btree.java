
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author AFTAB DUTTA
 */

class node{
    static int [] a=new int[5];   
    static int size;
    static node[] next=new node[4];  //order --> connecting to four child
    static node parent;           //who is my parent?
    node(){
    for(int i = 0; i < 4; i++)
    next[i] = null;
    parent = null;
    size = 0;
    }
    }

public class btree
    {
    static node root=new node();
    public static int findDepth(){
        int level=0;
        node ptr=root;
        while(ptr!=null){

        }
        return 1;
    }
    public static node findLeaf(int key, int level)
        {
            node ptr = root;
            node prevptr = null;
            level = 0;
            int i;
            while (ptr != null)
            {
             i = 0;
              level++;
             while (i < ptr.size-1 && key > ptr.a[i])
             {
                i++;
             }
              prevptr = ptr;
             ptr = ptr.next[i];
            }
            // System.out.println("Level =" +level);
            return prevptr;
        }
    
    public static void updateKey(node parent, node child, int newkey)
        {
              if (parent == null)
              {
            return;
              }
              if (parent.size == 0)
              {
                return;
              }
              int oldkey = child.a[child.size-2];
    
              for (int i = 0; i < parent.size;i++)
              {
              if (parent.a[i] == oldkey)
              {
                 parent.a[i] = newkey;
                 parent.next[i] = child;
              }
              }
        }
    
    public static void search(int key)
        {
               if (root == null)
               {
                  System.out.print("The tree does not exist");
                  System.out.print("\n");
              return;
                       }
                       int level=10;
              node leaf = findLeaf(key,level);
              int flg = 0;
              for (int i = 0; i < leaf.size; i++)
              {
              if (leaf.a[i] == key)
              {
                  flg = 1;
                  System.out.print("The employee ID ");
                  System.out.print(key);
                   System.out.print(" Exists in the B-Tree");
                //   System.out.print(level);
                  System.out.print("\n");
              }
              }
              if (flg == 0)
              {
              System.out.print("The ID Searched for was not found");
              System.out.print("\n");
              }
        }
    
    public static void insert(int key)
        {
            if (root == null)
            {
              root = new node();
              root.a[root.size] = key;
              root.size++;
                      return;
            }
                    int level=0;
            node leaf = findLeaf(key,level);
            int i;
            for (i = 0; i < leaf.size; i++)
            {
            if (leaf.a[i] == key)
            {
                System.out.print("The record to be inserted already exists");
                System.out.print("\n");
                return;
            }
            }
            promote(leaf,key,null);
             System.out.print("---------------\n");
              traverse(root);
              System.out.print("----------------\n");
        }
    
    static void insertIntoNode(node n,int key,node address){
                    int i;
                    if( n == null)
                    return;
                    for(i = 0; i < n.size; i++)
                    if(n.a[i] == key)
                    return;
                        i = n.size-1;
         while(i >= 0 && n.a[i] > key)
                    {
                    n.a[i+1] = n.a[i];
                    n.next[i+1] = n.next[i];
                    i--;
                    }
                    i++;
                    n.a[i] = key;
                    n.next[i] = address;
                    n.size++;
                    if( i == n.size-1)
                    updateKey(n.parent,n,key);
                }
    
    static void promote(node n,int key,node address){
                     if( n == null)
                     return;
                        if(n.size < 4)
                        {
                        insertIntoNode(n,key,address);
                        return;
                        }
                    if( n == root)
                    {
                    root = new node();
                    n.parent = root;
                    }
                    node newptr = split(n);
                    node t;
                    if(key < n.a[0])
                     t = newptr;
                    else
                     t = n;
                    insertIntoNode(t,key,address);
              promote(n.parent,n.a[n.size-1],n);
                    promote(newptr.parent,newptr.a[newptr.size-1],newptr);
                }
    
    static node split(node n){
                    int midpoint = (n.size+1)/2;
                    int newsize = n.size - midpoint;
              node newptr = new node();
                    node child;
                    newptr.parent = n.parent;
                    int i;
                    for(i = 0; i < midpoint; i++)
                    {
                    newptr.a[i] = n.a[i];
                    newptr.next[i] = n.next[i];
                    n.a[i] = n.a[i+midpoint];
                    n.next[i] = n.next[i+midpoint];
                    }
                    n.size = midpoint;
                    newptr.size = newsize;
                    for( i = 0; i < n.size; i++)
                    {
                        child = n.next[i];
                    if(child!= null)
                        child.parent = n;
                    }
                    for( i = 0; i < newptr.size; i++)
                    {
                        child = newptr.next[i];
                    if(child!= null)
                    child.parent = newptr;
                }
        return newptr;
    }
    
    static void traverse(node ptr){
                    if(ptr == null)
                    return;
                    for(int i = 0; i < ptr.size; i++)
                        System.out.print(ptr.a[i]+" ");
                    System.out.println();
                    for(int i = 0; i < ptr.size;i++)
                        traverse(ptr.next[i]);
    }
    btree(){
    root = null;
    }
    }

class bplustree{
        //memeber.txt
        static void makeTree()  {
            try{
            System.out.println("Making the B Plus Tree");
            BufferedReader reader = new BufferedReader(new FileReader("member.txt"));
            String line;
            while((line=reader.readLine())!=null)
            {
                String[] s= line.split("\\,");
                if(s.length<=1) continue;
                String id=s[1];
                btree.insert(Integer.parseInt(id));
            }
            }catch(Exception e){
                System.out.println("Files are yet to be created");
                e.printStackTrace();
            }
        }
}

