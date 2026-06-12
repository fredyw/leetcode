-- https://leetcode.com/problems/bitwise-user-permissions-analysis/description/
SELECT
    BIT_AND(permissions) AS common_perms,
    BIT_OR(permissions) AS any_perms
FROM user_permissions;
