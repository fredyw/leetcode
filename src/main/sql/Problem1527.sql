-- https://leetcode.com/problems/patients-with-a-condition/
select patient_id, patient_name, conditions
from patients
where regexp_like(conditions, '(^D| D)IAB1');