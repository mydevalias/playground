package playground.leetcode;

import java.util.*;

public class RemoveSubFoldersFilesystem {

    public List<String> removeSubfolders(String[] folder) {
        List<String> strings = Arrays.asList(folder);
        strings.sort(Comparator.comparingInt(String::length));
        Set<String> paths = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (String path : strings) {
            String prefix = path;
            boolean subFolder = false;
            while (!prefix.isEmpty()) {
                int pos = prefix.lastIndexOf('/');
                if (pos == -1) break;
                prefix = prefix.substring(0, pos);
                if (paths.contains(prefix)) {
                    subFolder = true;
                    break;
                }
            }
            if (!subFolder) {
                result.add(path);
                paths.add(path);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveSubFoldersFilesystem().removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}));
    }
}
