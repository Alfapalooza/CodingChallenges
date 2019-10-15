package coding.ctci.challenges;

import coding.ctci.structures.mutable.CustomArrayList;
import coding.ctci.structures.mutable.CustomBitVector;

import java.util.HashMap;
import java.util.Optional;

public class ArrayListChallenge {
    public boolean hasAllUnique(String str) {
        return hasAllUnique2(new CustomArrayList(toCharacterArray(str)));
    }

    //T: O(N), S: O(N)
    private boolean hasAllUnique(CustomArrayList<Character> str) {
        assert(str.isNonEmpty());

        HashMap<Character, Boolean> hm = new HashMap<>();

        for (int i = 0; i < str.size() - 1; ++i) {
            Optional<Character> currChar = str.get(i);
            Boolean hmCharEncountered = currChar.map(hm::get).orElse(false);

            if (hmCharEncountered)
                return false;
            else
                currChar.ifPresent(character -> hm.put(character, true));
        }

        return true;
    }

    private boolean hasAllUnique2(String str) {
        return hasAllUnique2(new CustomArrayList(toCharacterArray(str)));
    }

    //T: O(N), S: O(1)
    private boolean hasAllUnique2(CustomArrayList<Character> str) {
        assert(str.isNonEmpty() && str.forAll(Character::isAlphabetic));

        //Not technically a data structure
        CustomBitVector bits = new CustomBitVector();

        for (int i = 0; i < str.size() - 1; ++i) {
            Optional<Integer> currChar = str.get(i).map(innerChar -> innerChar - 'a');

            if (currChar.filter(bits::isFlagSet).isPresent())
                return false;
            else
                currChar.ifPresent(bits::setFlag);
        }

        return true;
    }

    //Permutation: one string contains all or subset of all of the characters found in the other
    public boolean isPermutation(String str1, String str2) {
        return isPermutation(new CustomArrayList(toCharacterArray(str1)), new CustomArrayList(toCharacterArray(str2)));
    }

    //T: O(N^2), S: O(1)
    private boolean isPermutation(CustomArrayList<Character> str1, CustomArrayList<Character> str2) {
        if (str1.size() != str2.size())
            return str1.forAll(str2::contains);
        else
            return str2.forAll(str1::contains);
    }

    public String urlify(String string) {
        return urlify(new CustomArrayList(toCharacterArray(string.trim())));
    }

    //T: O(N), S: O(1)
    private String urlify(CustomArrayList<Character> str1) {
        CustomArrayList.Mapper mapper =
            new CustomArrayList.Mapper<Character, String>() {
                @Override
                public String apply(Character item) {
                    if (item == ' ') {
                        return "%20";
                    } else {
                        return item.toString();
                    }
                }
            };

        return str1.map(mapper).mkString();
    }

    private boolean isPalindromePermutation(String str1, String str2) {
        return removeAllWhitespace(str1).length() == removeAllWhitespace(str2).length();
    }

    private String removeAllWhitespace(String str) {
        return str.replaceAll(" ", "");
    }

    private Character[] toCharacterArray(String str) {
        Character[] tmp = new Character[str.length()];

        for (int i = 0; i < str.length(); ++i) {
            tmp[i] = str.charAt(i);
        }

        return tmp;
    }
}
