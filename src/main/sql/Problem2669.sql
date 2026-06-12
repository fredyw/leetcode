-- https://leetcode.com/problems/count-artist-occurrences-on-spotify-ranking-list/description/
SELECT
    artist,
    COUNT(*) AS occurrences
FROM Spotify
GROUP BY artist
ORDER BY occurrences DESC, artist ASC;
