-- https://leetcode.com/problems/patients-with-a-condition/
SELECT
    patient_id,
    patient_name,
    conditions
FROM patients
WHERE REGEXP_LIKE(conditions, '(^D| D)IAB1');
