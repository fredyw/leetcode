-- https://leetcode.com/problems/count-artist-occurrences-on-spotify-ranking-list/description/
select artist, count(*) as occurrences
from Spotify
group by artist
order by occurrences desc, artist asc;
