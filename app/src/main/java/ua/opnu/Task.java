package ua.opnu;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.TreeMap;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; /* i збільшується всередині циклу */) {
            String s1 = list.get(i);
            String s2 = list.get(i + 1);

            if (s1.length() <= s2.length()) {
                list.remove(i);
                i++;
            } else {
                list.remove(i + 1);
                i++;
            }
        }
    }

    public void stutter(List<String> list) {
        int originalSize = list.size();
        for (int i = originalSize - 1; i >= 0; i--) {
            String s = list.get(i);
            list.add(i, s);
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            Collections.swap(list, i, i + 1);
        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return true;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Queue<Integer> tempQueue = new LinkedList<>();
        boolean isPalindrome = true;

        while (!queue.isEmpty()) {
            int n = queue.remove();
            tempQueue.add(n);
            stack.push(n);
        }

        while (!tempQueue.isEmpty()) {
            int n1 = tempQueue.remove();
            int n2 = stack.pop();

            queue.add(n1);

            if (n1 != n2) {
                isPalindrome = false;
            }
        }

        return isPalindrome;
    }

    public void reorder(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return;
        }

        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            temp.add(queue.remove());
        }

        Collections.sort(temp);

        for (int n : temp) {
            queue.add(n);
        }
    }
    public void rearrange(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return;
        }
        Queue<Integer> oddQueue = new LinkedList<>();

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            if (n % 2 != 0) {
                oddQueue.add(n);
            } else {
                queue.add(n);
            }
        }

        while (!oddQueue.isEmpty()) {
            queue.add(oddQueue.remove());
        }
    }

    public int maxLength(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return 0;
        }

        int maxLen = 0;
        for (String s : set) {
            if (s.length() > maxLen) {
                maxLen = s.length();
            }
        }
        return maxLen;
    }

    public void removeEvenLength(Set<String> set) {
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.length() % 2 == 0) {
                iterator.remove();
            }
        }
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null || list1.isEmpty() || list2.isEmpty()) {
            return 0;
        }

        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);

        set1.retainAll(set2);

        return set1.size();
    }

    public boolean isUnique(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }

        Set<String> values = new HashSet<>(map.values());

        return map.size() == values.size();
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        if (map1 == null || map2 == null) {
            return new HashMap<>();
        }

        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (map2.containsKey(key)) {
                Integer value2 = map2.get(key);
                if (value.equals(value2)) {
                    result.put(key, value);
                }
            }
        }

        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        if (map == null) {
            return new HashMap<>();
        }

        Map<String, Integer> reversedMap = new HashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer originalKey = entry.getKey();
            String originalValue = entry.getValue();

            reversedMap.put(originalValue, originalKey);
        }

        return reversedMap;
    }

    public int rarest(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> valueCounts = new HashMap<>();
        for (int value : map.values()) {
            valueCounts.put(value, valueCounts.getOrDefault(value, 0) + 1);
        }

        int minFrequency = Integer.MAX_VALUE;
        int rarestValue = Integer.MAX_VALUE;

        for (int count : valueCounts.values()) {
            if (count < minFrequency) {
                minFrequency = count;
            }
        }

        for (Map.Entry<Integer, Integer> entry : valueCounts.entrySet()) {
            int value = entry.getKey();
            int frequency = entry.getValue();

            if (frequency == minFrequency) {
                if (value < rarestValue) {
                    rarestValue = value;
                }
            }
        }

        return rarestValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (int number : list) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        int maxCount = 0;
        for (int count : counts.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }
}