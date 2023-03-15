# add-a-gram

_An "add-a-gram" is a sequence of words formed by starting with a 3-letter word,_ 
_adding a letter and rearranging to form a 4-letter word, and so on._ 
_For example, here are add-a-grams of the words "CREDENTIALS" and "ANACHRONISM":_

_ail + s =_
_sail + n =_
_nails + e =_
_aliens + t =_
_salient + r =_
_entrails + c =_
_clarinets + e =_
_interlaces + d = CREDENTIALS (length 11)_

_mar + c =_
_cram + h =_
_march + s =_
_charms + o =_
_chromas + n =_
_monarchs + i =_
_harmonics + a = maraschino + n = ANACHRONISM (length 11)_

_Test your own credentials: given the dictionary found here, what is the longest_
_add-a-gram?_

## Solution

This was an ITA puzzle that was used between December 01 and April 02. 

     (time (get-longest-add-a-gram))
     "Elapsed time: 363.542542 msecs"
     =>
     ([\i "not"]
     [\n "into"]
     [\s "niton"]
     [\e "nitons"]
     [\m "intones"]
     [\a "mentions"]
     [\i "nominates"]
     [\r "antinomies"]
     [\t "nitrosamine"]
     [\d "terminations"]
     [\e "antimodernist"]
     [\i "determinations"]
     [\n "intermediations"]
     [nil "indeterminations"])
     (count "indeterminations")
     => 16

The solution is not unique. Another solution is "underestimations", which is 
also 16 letters long.

This seems to be one of ITA's easier puzzles. My solution clocks in at around
50 lines of Clojure and runs in 360ms on my machine. Machines were slower and
technology less advanced 20 years ago, but I am sure I could have solved it
in Common Lisp or Java with a run time under 10 secs.




