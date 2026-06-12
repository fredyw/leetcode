-- https://leetcode.com/problems/ads-performance/
SELECT
    ad_id,
    CASE
        WHEN
            SUM(CASE WHEN action = 'Clicked' THEN 1 ELSE 0 END)
            + SUM(CASE WHEN action = 'Viewed' THEN 1 ELSE 0 END) = 0 THEN 0
        ELSE ROUND(
            CAST(SUM(CASE WHEN action = 'Clicked' THEN 1 ELSE 0 END) AS decimal)
            / (
                CAST(
                    SUM(
                        CASE WHEN action = 'Clicked' THEN 1 ELSE 0 END
                    ) AS decimal
                )
                + CAST(
                    SUM(
                        CASE WHEN action = 'Viewed' THEN 1 ELSE 0 END
                    ) AS decimal
                )
            ) * 100, 2
        )
    END AS ctr
FROM ads
GROUP BY ad_id
ORDER BY ctr DESC, ad_id ASC;
