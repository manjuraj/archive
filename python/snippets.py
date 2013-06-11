** status
 4: variables and names -- done
 5: more variables and printing -- done
 6: Strings And Text -- done
 7: more printing -- done
 8: printing, printing, printing -- done
 9: printing, printing, pringing -- done
10: what was that? -- done
11: asking questions -- done
12: prompting people -- done
13: Packing, Unpacking and Variables -- done
14: Reading Files -- done
15: Reading and Writing files -- done
16: More Files -- done
17: Names, Variables, Code, Functions -- done
18: Functions And variables -- done
19: Functions And files -- done
20: Functions can return something -- done

manj@ubuntu:~ $ python -V
Python 2.6.4

manj@ubuntu:~ $ which python
/usr/bin/python

manj@ubuntu:~ $ ls -l /usr/bin/python*
lrwxrwxrwx 1 root root       9 2010-11-18 13:54 /usr/bin/python -> python2.6
lrwxrwxrwx 1 root root       9 2010-09-27 15:08 /usr/bin/python2 -> python2.6
-rwxr-xr-x 1 root root 2230352 2009-12-07 11:38 /usr/bin/python2.6

#!/usr/bin/python

x = 10
y = 'hello'
print "variable x has a value", x, "and variable y has a value", y

manj@ubuntu:~ $ ./snippet.py
variable x has a value 10 and variable y has a value hello

#!/usr/bin/python

my_name = 'Manju Rajashekhar'
my_age = 28
my_height = 173 # cms
my_weight = 175 # lbs
my_eyes = 'Brown'
my_teeth = 'White'
my_hair = 'Black and Curly'

print "Let's talk about %s" % my_name
print "He's %d inches tall" % my_height
print "He's %d pounds heavy" %my_weight
print "Actually that is not too heavy"
print "He's got %s eyes and %s hair" % (my_eyes, my_hair)
print "His teeth are usually %s depending on the coffee" % my_teeth
print "If I add %d, %d, and %d I get %d" % (my_age, my_height, my_weight, my_age + my_height + my_weight)

manj@ubuntu:~ $ ./snippet.py
Let's talk about Manju Rajashekhar
He's 173 inches tall
He's 175 pounds heavy
Actually that is not too heavy
He's got Brown eyes and Black and Curly hair
His teeth are usually White depending on the coffee
If I add 28, 173, and 175 I get 376

Try more format characters. %r is a very useful one, it’s like saying “print this no matter what”.
Google: "Python format characters"

#!/usr/bin/python

x = "There are %d types of people" % 10
binary = "binary"
do_not = "don't"
y = "Those who know %s and those who %s" % (binary, do_not)

print x
print y

print "I said: %r" % x
print "I also said: '%s'" % y

hilarious = False
joke_evaluation = "Isn't that joke so funny?! %r"
print joke_evaluation % hilarious

w = "This is the left side of ..."
e = "a string with a right side"
print w + e

manj@ubuntu:~ $ ./snippet.py
There are 10 types of people
Those who know binary and those who don't
I said: 'There are 10 types of people'
I also said: 'Those who know binary and those who don't'
Isn't that joke so funny?! False
This is the left side of ...a string with a right side

#!/usr/bin/python

formatter = "%r %r %r %r"
print formatter % (1, 2, 3, 4)
print formatter % ("one", "two", "three", "four")
print formatter % (True, False, False, True)
print formatter % (formatter, formatter, formatter, formatter)
print formatter % (
    "I had this thing",
    "That you could type up right",
    "But it didn't sing",
    "So I said goodnight"
    )


manj@ubuntu:~ $ ./snippet.py
1 2 3 4
'one' 'two' 'three' 'four'
True False False True
'%r %r %r %r' '%r %r %r %r' '%r %r %r %r' '%r %r %r %r'
'I had this thing' 'That you could type up right' "But it didn't sing" 'So I said goodnight'

#!/usr/bin/python

days = "Mon Tue Wed Thu Fri Sat Sun"
months = "Jan\nFeb\nMar\nApr\nMay\nJun\nJul\nAug\nSep\nOct\nNov\nDec"

print "Here are the days: ", days
print "Here are the months: ", months

print """
There's something going on here.
With the three double quotes.
We'll be able to type as much as we like
"""

manj@ubuntu:~ $ ./snippet.py 
Here are the days:  Mon Tue Wed Thu Fri Sat Sun
Here are the months:  Jan
Feb
Mar
Apr
May
Jun
Jul
Aug
Sep
Oct
Nov
Dec

There's something going on here.
With the three double quotes.
We'll be able to type as much as we like

#!/usr/bin/python

tall = "I am 5'9\" tall"        # escape double quotes inside a string
print tall
tall = 'I am 5\'9" tall'        # escape single quotes inside a string
print tall
tall = """I am 5'9" tall"""     # escape single and double quote by a triple quote
print tall

manj@ubuntu:~ $ ./snippet.py
I am 5'9" tall
I am 5'9" tall
I am 5'9" tall

#!/usr/bin/python

print "How old are you?",
age = raw_input()
print "How tall are you?",
tall = raw_input()
print "How much do you weigh?",
weight = raw_input()
print "So, you're %r old, %r tall and %r heavy" % (age, tall, weight)

manj@ubuntu:~ $ ./snippet.py
How old are you? 10
How tall are you? 5'9''
How much do you weigh? 140
So, you're '10' old, "5'9''" tall and '140' heavy

#!/usr/bin/python

from sys import argv

# unpack argv into variables script, first, second and third
script, first, second, third = argv

print "This script is called: ", script
print "Your first variable is: %r" %first
print "Your second variable is: ",  second
print "Your third variable is: ", third

manj@ubuntu:~ $ ./snippet.py 1 2 3
This script is called:  /home/manj/snippet.py
Your first variable is: '1'
Your second variable is:  2
Your third variable is:  3

manj@ubuntu:~ $ ./snippet.py 1 2
Traceback (most recent call last):
  File "/home/manj/snippet.py", line 5, in <module>
    script, first, second, third = argv
ValueError: need more than 2 values to unpack

manj@ubuntu:~ $ ./snippet.py 1 2 3 4
Traceback (most recent call last):
  File "/home/manj/snippet.py", line 5, in <module>
    script, first, second, third = argv
ValueError: too many values to unpack

#!/usr/bin/python

from sys import argv

script, user_name = argv
prompt = '> '

print "Hi %s, I'm the %s script" % (user_name, script)
print "I'd like to ask you a few questions."
print "Do you like me %s" % user_name
likes = raw_input(prompt)

print "Where do you live %s" % user_name
lives = raw_input(prompt)

print "what kind of computer do you have?"
computer = raw_input(prompt)

print """
Alright, so you said %s about liking me.
You live in %r. Not sure where that is.
And you have a %r computer. Nice.
""" % (likes, lives, computer)
manj@ubuntu:~ $ python snippet.py Manju
Hi Manju, I'm the snippet.py script
I'd like to ask you a few questions.
Do you like me Manju
> Yes
Where do you live Manju
> San Francisco
what kind of computer do you have?
> Mac

Alright, so you said Yes about liking me.
You live in 'San Francisco'. Not sure where that is.
And you have a 'Mac' computer. Nice.

#!/usr/bin/python

from sys import argv

script, filename = argv
txt = open(filename)
print "here's your file %r" % filename
print txt.read()
print "I'll also aks you to type it again:"
file_again = raw_input(">")
txt_again = open(file_again)
print txt_again.read()

$ python snippet.py rabbit.txt
here's your file 'rabbit.txt'
Run, rabbit run / Dig that hole, forget the sun / And when at last the work is done / Don't sit down / It's time to dig another one

I'll also aks you to type it again:
>rabbit.txt
Run, rabbit run / Dig that hole, forget the sun / And when at last the work is done / Don't sit down / It's time to dig another one

#!/usr/bin/python
# hash / dictionary / associative array
h = {}
print "hash = ", h
h = {1:2, 2:3, 3:4}
print "hash = %r" % h
h[4] = 5
print "hash = %r" % h
print "hash keys ", h.keys()
print "hash values ", h.values()
print "6 in h = ", 6 in h

$ python ./snippet.py
hash =  {}
hash = {1: 2, 2: 3, 3: 4}
hash = {1: 2, 2: 3, 3: 4, 4: 5}
hash keys  [1, 2, 3, 4]
hash values  [2, 3, 4, 5]
6 in h =  False

#!/usr/bin/python

from sys import argv

script, filename = argv
print "We're goign to erase %r" % filename
print "If you don't want that, hit CTRL-C (^C)"
print "If you do want that, hit RETURN"
raw_input("?")
print "Opening the file..."
target = open(filename, 'w')
print "Truncating the file. Goodbye!"
target.truncate()
print "Now I'm going to ask you for three lines"
line1 = raw_input("line 1:")
line2 = raw_input("line 2:")
line3 = raw_input("line 3:")
print "I'm going to write these to the file"
target.write(line1 + "\n")
target.write(line2 + "\n")
target.write(line3 + "\n")
target.close()


We're goign to erase 'yo.txt'
If you don't want that, hit CTRL-C (^C)
If you do want that, hit RETURN
?
Opening the file...
Truncating the file. Goodbye!
Now I'm going to ask you for three lines
line 1:Yo yo
line 2:Yo Yo ma ma
line 3:Yo ma Yo ma
I'm going to write these to the file

#!/usr/bin/python

from sys import argv
from os.path import exists

script, from_file, to_file = argv
print "Copying from %s to %s" % (from_file, to_file)
input = open(from_file)
indata = input.read()
print "The input file is %d bytes long" % len(indata)
print "Does output file exit? %r" % exists(to_file)
print "Ready, hit RETURN to continue, CTRL-C to abort"
raw_input()
output = open(to_file, 'w')
output.write(indata)
print "Alright, all done"
output.close()
input.close()

Copying from yo.txt to mo.txt
The input file is 0 bytes long
Does output file exit? False
Ready, hit RETURN to continue, CTRL-C to abort

Alright, all done

# pydoc file
# pydoc import

#!/usr/bin/python

def print_two(*args):
  arg1, arg2 = args
  print "arg1: %r, arg2: %r" % (arg1, arg2)

def print_two_again(arg1, arg2):
  print "arg1: %r, arg2: %r" % (arg1, arg2)

def print_one(arg1):
  print "arg1: %r" % arg1

def print_none():
  print "I got nothin'"

print_two(1, 2)
print_two_again(1, 2)
print_one(1)
print_none()

$ ./snippet.py
arg1: 1, arg2: 2
arg1: 1, arg2: 2
arg1: 1
I got nothin'

# function definition checklist
1. Did you start your function definition with def?
2. Does your function name have only characters and _ (underscore) characters?
3. Did you put an open parenthesis ( right after the function name?
4. Did you put your arguments after the parenthesis ( separated by commas?
5. Did you make each argument unique (meaning no duplicated names).
6. Did you put a close parenthesis and a colon ): after the arguments?
7. Did you indent all lines of code you want in the function 4 spaces? No more, no less.
8. Did you “end” your function by going back to writing with no indent (dedenting we call it)?

# function call checklist
1. Did you call/use/run this function by typing its name?
2. Did you put ( character after the name to run it?
3. Did you put the values you want into the parenthesis separated by commas?
4. Did you end the function call with a ) character.

#!/usr/bin/python

from sys import argv

script, input_file = argv

def print_all(f):
  print f.read()

def rewind(f):
  f.seek(0)

def print_a_line(line_count, f):
  print line_count, f.readline()

current_file = open(input_file)
print "First, lets print the whole file:\n"
print_all(current_file)
print "Now, lets rewind, kind of like a tape"
rewind(current_file)
print "Let's print three lines:"
current_line = 1
print_a_line(current_line, current_file)
current_line = current_line + 1
print_a_line(current_line, current_file)
current_line = current_line + 1
print_a_line(current_line, current_file)


$ ./snippet.py ./snippet.py
First, lets print the whole file:

#!/usr/bin/python

from sys import argv

script, input_file = argv

def print_all(f):
  print f.read()

def rewind(f):
  f.seek(0)

def print_a_line(line_count, f):
  print line_count, f.readline()

current_file = open(input_file)
print "First, lets print the whole file:\n"
print_all(current_file)
print "Now, lets rewind, kind of like a tape"
rewind(current_file)
print "Let's print three lines:"
current_line = 1
print_a_line(current_line, current_file)
current_line = current_line + 1
print_a_line(current_line, current_file)
current_line = current_line + 1
print_a_line(current_line, current_file)

# vim: ts=2 sw=2 et

Now, lets rewind, kind of like a tape
Let's print three lines:
1 #!/usr/bin/python

2 

3 from sys import argv

