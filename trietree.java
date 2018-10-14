import java.util.*;



public class trietree {

    static class TrieNode
    {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < 26; i++)
                children[i] = null;
        }
 static TrieNode root;
    public void insert(String key)
    {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }
     public boolean search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null)
                return false;


            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }
    }
    public void solve(String A, ArrayList<String> B) {

    String ar[]=A.split("_");
    TrieNode n=new TrieNode();
        int i;
    for(i=0;i<ar.length;i++)
    {
        n.insert(ar[i]);
    }
    }
}

                                           