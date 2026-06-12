-- https://leetcode.com/problems/accepted-candidates-from-the-interviews/
SELECT c.candidate_id
FROM Candidates c
WHERE
    c.years_of_exp >= 2
    AND (
        SELECT SUM(score)
        FROM Rounds r
        WHERE r.interview_id = c.interview_id
    ) > 15;
