import java.util.ArrayList;
public class anagram_list {
    private final ArrayList<String> anagrams;

    public anagram_list(String word)
    {
      anagrams = new ArrayList<String>();
      // call complete anagrams with empty start, word as end
      completeAnagrams("", word);
      sortAnagrams();
    }
  
    private void completeAnagrams(String start, String end)
    {
      /* Base case: when 1 letter remains in end this is appended to
       * start and added to anagrams.
       */
      if(end.length() <= 1)
      {
        anagrams.add(start + end);
      }
  
      /* Other cases: the remaining letters in the parameter end are
       * looped through in turn. For each unique letter a new call is
       * made to completeAnagrams with the start and end parameters
       * changed by removing this letter from end and appending it to
       * start.
       */
      else
      {
        for(int i = 0; i < end.length(); i++)
        {
          /* This if statement ensures duplicate anagrams are not
           * created: if the letter has already appeared in end,
           * then a call has already been made for this letter.
           */
          if(end.substring(0,i).indexOf(end.substring(i,i+1)) < 0)
          {
            completeAnagrams(start + end.substring(i, i+1), end.substring(0,i) + end.substring(i+1));
          }
        }
      }
    }
  
    // Implements an insertion sort algorithm on anagrams
    private void sortAnagrams()
    {
      for(int i = 1; i < anagrams.size(); i++)
      {
        int pos = i;
        while(pos > 0 && anagrams.get(i).compareTo(anagrams.get(pos-1)) < 0)
        {
          pos--;
        }
        anagrams.add(pos, anagrams.remove(i));
      }
    }
  
    // Implements a binary search algorithm on anagrams
    public int searchAnagrams(String target)
    {
      for(int i = 0; i < anagrams.size(); i++)
      {
        if(anagrams.get(i).equals(target))
        {
          return i;
        }
      }
      return -1;
    }
  
    // Used to get list of anagrams externally, do not remove
    public ArrayList<String> getAnagrams()
    {
      return anagrams;
    }
  }    

