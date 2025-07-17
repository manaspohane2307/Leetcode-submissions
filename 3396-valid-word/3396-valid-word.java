class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        if (n < 3)
            return false;
        int vowel_count = 0, consonant_count = 0;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (Character.isDigit(ch)) {
                continue;
            } else if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ||
                    ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                        vowel_count++;
            }
            else if(Character.isLetter(ch)){
                consonant_count++;
            }
            else{
                return false;//special character
            }
        }
        if(vowel_count >=1 && consonant_count >=1){
            return true;
        }
        return false;
    }
}