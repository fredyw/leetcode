-- https://leetcode.com/problems/dna-pattern-recognition/description/
select sample_id,
       dna_sequence,
       species,
       case when dna_sequence ~ '^ATG' then 1 else 0 end as has_start,
       case when dna_sequence ~ '(TAA|TAG|TGA)$' then 1 else 0 end as has_stop,
       case when dna_sequence ~ '(ATAT)+' then 1 else 0 end as has_atat,
       case when dna_sequence ~ 'GGG+' then 1 else 0 end as has_ggg
from Samples
order by sample_id;
