# https://leetcode.com/problems/valid-phone-numbers/
sed -n -r '/^(\([0-9]{3}\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$/p' file.txt