#!/bin/sh

diff=`which diff`
grep=`which grep`

file=""
lines=100
sleep=1
i=0

while [ 1 ]; do
    # tail newly generated lines in $file
    tail -n $lines $file > /tmp/a.txt
    sleep $sleep
    tail -n $lines $file > /tmp/b.txt
    # extract newly generated lines using a filter
    ans=`$diff -u /tmp/a.txt /tmp/b.txt | $grep "^+" | $grep -c -v "+++"`
    i=`expr $i + 1`
    echo "$i : $ans"
done
